package com.ezzenix.chatanimation;

import com.ezzenix.chatanimation.config.ModConfig;
import com.ezzenix.chatanimation.lib.config.ConfigScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*? if fabric {*/
import net.fabricmc.api.ModInitializer;
/*?}*/

/*? if forge {*/
/*import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.client.ConfigScreenHandler;
*//*?}*/

/*? if neoforge {*/
/*import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
*//*?}*/

/*? if forge {*/
/*@Mod(value = ChatAnimation.MOD_ID)
public class ChatAnimation {
*//*?}*/

/*? if neoforge {*/
/*@Mod(value = ChatAnimation.MOD_ID, dist = Dist.CLIENT)
public class ChatAnimation {
*//*?}*/

/*? if fabric {*/
public class ChatAnimation implements ModInitializer {
/*?}*/

    public static final String MOD_ID = "chatanimation";
    public static final String MOD_NAME = "ChatAnimation";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static void wrap(GuiGraphicsExtractor graphics, float displacement, Runnable runnable) {
		if (displacement != 0) {
			//~ if >=1.21.6 'pushPose' -> 'pushMatrix'
			graphics.pose().pushMatrix();
			//~ if >=1.21.6 '(0, displacement, 0)' -> '(0, displacement)'
			graphics.pose().translate(0, displacement);
		}
		runnable.run();
		if (displacement != 0) {
			//~ if >=1.21.6 'popPose' -> 'popMatrix'
			graphics.pose().popMatrix();
		}
	}

	public static double getOpacityFactor(float age) {
		if (!ModConfig.enableMessageAnimation || !ModConfig.enableOpacity) {
			return 1;
		}
		float fadeTime = (float) ModConfig.fadeTimeMessage;
		if (fadeTime <= 0) return 1;
		return Math.min(age / fadeTime, 1.0F);
	}

	//? if forge {
	/*public ChatAnimation(final FMLJavaModLoadingContext context) {
		ModConfig.init(MOD_ID, ModConfig.class);

		net.minecraftforge.fml.ModLoadingContext.get().registerExtensionPoint(
			ConfigScreenHandler.ConfigScreenFactory.class,
			() -> new ConfigScreenHandler.ConfigScreenFactory((c, parent) -> new ConfigScreen(parent))
		);
	}
    *///? }

	/*? if neoforge {*/
    /*public ChatAnimation(ModContainer container) {
        ModConfig.init(MOD_ID, ModConfig.class);
        container.registerExtensionPoint(IConfigScreenFactory.class, (c, parent) -> new ConfigScreen(parent));
    }
    *//*?}*/

	/*? if fabric {*/
	@Override
	public void onInitialize() {
		ModConfig.init(MOD_ID, ModConfig.class);
	}
	/*?}*/
}
