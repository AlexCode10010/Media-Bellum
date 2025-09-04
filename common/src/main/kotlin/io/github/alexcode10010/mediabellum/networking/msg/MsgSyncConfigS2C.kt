package io.github.alexcode10010.mediabellum.networking.msg

import io.github.alexcode10010.mediabellum.config.MediabellumConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: MediabellumConfig.ServerConfig) : MediabellumMessageS2C {
    companion object : MediabellumMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = MediabellumConfig.ServerConfig.decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
