package io.github.alexcode10010.mediabellum.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.alexcode10010.mediabellum.MediabellumClient

object FabricMediabellumModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(MediabellumClient::getConfigScreen)
}
