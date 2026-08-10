package com.ezzenix.chatanimation.config;

import com.ezzenix.chatanimation.ChatAnimation;
import com.ezzenix.emlib.config.EmConfig;

@EmConfig.Config(title = ChatAnimation.MOD_NAME)
public class ModConfig extends EmConfig {
	@Comment
	public static Comment _messages;
	@Entry
	public static boolean enableMessageAnimation = true;
	@Entry(min=10, max=800, isSlider=true, suffix="ms")
	public static int fadeTimeMessage = 150;
	@Entry
	public static boolean removeMessageIndicator = true;
	@Entry
	public static boolean enableOpacity = true;

	@Comment
	public static Comment _input;
	@Entry
	public static boolean enableTextFieldAnimation = true;
	@Entry(min=10, max=800, isSlider=true, suffix="ms")
	public static int fadeTimeTextField = 170;

}
