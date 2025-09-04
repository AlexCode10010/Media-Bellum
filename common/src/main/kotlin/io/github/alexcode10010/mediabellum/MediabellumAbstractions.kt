@file:JvmName("MediabellumAbstractions")

package io.github.alexcode10010.mediabellum

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.alexcode10010.mediabellum.registry.MediabellumRegistrar

fun initRegistries(vararg registries: MediabellumRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: MediabellumRegistrar<T>) {
    throw AssertionError()
}
