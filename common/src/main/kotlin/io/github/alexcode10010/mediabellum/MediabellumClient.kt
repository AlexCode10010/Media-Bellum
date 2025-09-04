package io.github.alexcode10010.mediabellum

import io.github.alexcode10010.mediabellum.config.MediabellumConfig
import io.github.alexcode10010.mediabellum.config.MediabellumConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object MediabellumClient {
    fun init() {
        MediabellumConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
