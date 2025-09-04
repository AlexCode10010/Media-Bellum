package io.github.alexcode10010.mediabellum.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.alexcode10010.mediabellum.Mediabellum
import io.github.alexcode10010.mediabellum.networking.MediabellumNetworking
import io.github.alexcode10010.mediabellum.networking.handler.applyOnClient
import io.github.alexcode10010.mediabellum.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface MediabellumMessage

sealed interface MediabellumMessageC2S : MediabellumMessage {
    fun sendToServer() {
        MediabellumNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface MediabellumMessageS2C : MediabellumMessage {
    fun sendToPlayer(player: ServerPlayer) {
        MediabellumNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        MediabellumNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface MediabellumMessageCompanion<T : MediabellumMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Mediabellum.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is MediabellumMessageC2S -> msg.applyOnServer(ctx)
                    else -> Mediabellum.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Mediabellum.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is MediabellumMessageS2C -> msg.applyOnClient(ctx)
                    else -> Mediabellum.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
