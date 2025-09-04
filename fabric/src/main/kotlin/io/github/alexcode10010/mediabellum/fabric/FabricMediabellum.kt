package io.github.alexcode10010.mediabellum.fabric

import io.github.alexcode10010.mediabellum.Mediabellum
import net.fabricmc.api.ModInitializer

object FabricMediabellum : ModInitializer {
    override fun onInitialize() {
        Mediabellum.init()
    }
}
