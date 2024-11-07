package de.n8M4.fullbright.mixins;

import de.n8M4.fullbright.Fullbright;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Options.class})
public abstract class FullbrightMixin {
    @Final
    @Shadow
    private OptionInstance<Double> gamma;

    @Inject(
            method = {"gamma"},
            at = {@At("RETURN")},
            cancellable = true
    )
    private void gammadings(CallbackInfoReturnable<OptionInstance<Double>> info) {
        if (Fullbright.fullbright()) {
            if(gamma.get() != 9999d) gamma.set(9999d);
        } else if(gamma.get() == 9999d) gamma.set(1d);
    }
}