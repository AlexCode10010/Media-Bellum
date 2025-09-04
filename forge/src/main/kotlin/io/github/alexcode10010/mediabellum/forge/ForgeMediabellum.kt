package io.github.alexcode10010.mediabellum.forge

import dev.architectury.platform.forge.EventBuses
import io.github.alexcode10010.mediabellum.Mediabellum
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Mediabellum.MODID)
class MediabellumForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Mediabellum.MODID, this)
            addListener(ForgeMediabellumClient::init)
            addListener(::gatherData)
        }
        Mediabellum.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
