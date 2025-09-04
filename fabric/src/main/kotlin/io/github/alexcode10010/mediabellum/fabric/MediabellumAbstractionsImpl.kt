@file:JvmName("MediabellumAbstractionsImpl")

package io.github.alexcode10010.mediabellum.fabric

import io.github.alexcode10010.mediabellum.registry.MediabellumRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: MediabellumRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
