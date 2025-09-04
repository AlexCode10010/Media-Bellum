@file:JvmName("MediabellumAbstractionsImpl")

package io.github.alexcode10010.mediabellum.forge

import io.github.alexcode10010.mediabellum.registry.MediabellumRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: MediabellumRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
