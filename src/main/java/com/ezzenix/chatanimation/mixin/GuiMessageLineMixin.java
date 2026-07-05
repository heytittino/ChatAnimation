package com.ezzenix.chatanimation.mixin;

import com.ezzenix.chatanimation.config.ModConfig;
import com.ezzenix.chatanimation.util.TimestampedMessageLine;
import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.client.multiplayer.chat.GuiMessageTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GuiMessage.Line.class)
public class GuiMessageLineMixin implements TimestampedMessageLine {
	@Unique
	private long chatAnimation$addedTime;

	@Override
	public long chatAnimation$getAddedTime() {
		return chatAnimation$addedTime;
	}

	@Override
	public void chatAnimation$setAddedTime(long time) {
		this.chatAnimation$addedTime = time;
	}

	@Inject(method = "<init>", at = @At("TAIL"))
	private void afterInit(CallbackInfo ci) {
		TimestampedMessageLine.of((GuiMessage.Line)(Object)this).chatAnimation$setAddedTime(System.currentTimeMillis());
	}

	@Inject(method = "tag", at = @At("HEAD"), cancellable = true)
    private void injectIndicator(CallbackInfoReturnable<GuiMessageTag> cir) {
        if (ModConfig.removeMessageIndicator) {
			cir.setReturnValue(null);
		}
    }
}
