package com.b1n_ry.yigd.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "com/beansgalaxy/backpacks/compat/TrinketsRegistry$1")
public class BeansBackpacksTrinketMixin {
    // TODO: Test if this is still required. Either I forgot to remove it, or it's actually important
    @Inject(method = "getDropRule", at = @At("HEAD"), cancellable = true)
    private void changeDropRule(ItemStack stack, SlotReference slot, LivingEntity entity, CallbackInfoReturnable<TrinketEnums.DropRule> cir) {
        cir.setReturnValue(TrinketEnums.DropRule.DEFAULT);
    }
}
