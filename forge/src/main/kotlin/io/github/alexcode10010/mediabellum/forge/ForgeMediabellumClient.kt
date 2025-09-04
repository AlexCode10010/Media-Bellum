package io.github.alexcode10010.mediabellum.forge

import io.github.alexcode10010.mediabellum.MediabellumClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeMediabellumClient {
    fun init(event: FMLClientSetupEvent) {
        MediabellumClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> MediabellumClient.getConfigScreen(parent) }
        }
    }
}
