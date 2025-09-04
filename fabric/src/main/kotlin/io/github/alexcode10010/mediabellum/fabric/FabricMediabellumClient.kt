package io.github.alexcode10010.mediabellum.fabric

import io.github.alexcode10010.mediabellum.MediabellumClient
import net.fabricmc.api.ClientModInitializer

object FabricMediabellumClient : ClientModInitializer {
    override fun onInitializeClient() {
        MediabellumClient.init()
    }
}
