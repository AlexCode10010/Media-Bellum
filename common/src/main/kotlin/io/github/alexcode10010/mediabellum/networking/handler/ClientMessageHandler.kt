package io.github.alexcode10010.mediabellum.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.alexcode10010.mediabellum.config.MediabellumConfig
import io.github.alexcode10010.mediabellum.networking.msg.*

fun MediabellumMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            MediabellumConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
