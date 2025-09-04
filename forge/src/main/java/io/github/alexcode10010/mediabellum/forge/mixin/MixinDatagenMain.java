package io.github.alexcode10010.mediabellum.forge.mixin;

import io.github.alexcode10010.mediabellum.Mediabellum;
import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

// scuffed workaround for https://github.com/architectury/architectury-loom/issues/189
@Mixin(net.minecraft.data.Main.class)
public class MixinDatagenMain {
    @WrapMethod(method = "main", remap = false)
    private static void mediabellum$systemExitAfterDatagenFinishes(String[] strings, Operation<Void> original) {
        try {
            original.call((Object) strings);
        } catch (Throwable throwable) {
            Mediabellum.LOGGER.error("Datagen failed!", throwable);
            System.exit(1);
        }
        Mediabellum.LOGGER.info("Datagen succeeded, terminating.");
        System.exit(0);
    }
}
