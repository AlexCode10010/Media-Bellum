package io.github.alexcode10010.mediabellum.networking

import dev.architectury.networking.NetworkChannel
import io.github.alexcode10010.mediabellum.Mediabellum
import io.github.alexcode10010.mediabellum.networking.msg.MediabellumMessageCompanion

object MediabellumNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Mediabellum.id("networking_channel"))

    fun init() {
        for (subclass in MediabellumMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
