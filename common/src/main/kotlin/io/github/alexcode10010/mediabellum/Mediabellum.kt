package io.github.alexcode10010.mediabellum

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.alexcode10010.mediabellum.config.MediabellumConfig
import io.github.alexcode10010.mediabellum.networking.MediabellumNetworking
import io.github.alexcode10010.mediabellum.registry.MediabellumActions

object Mediabellum {
    const val MODID = "mediabellum"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        MediabellumConfig.init()
        initRegistries(
            MediabellumActions,
        )
        MediabellumNetworking.init()
    }
}
