package com.ezzenix.chatanimation.util;

import net.minecraft.client.multiplayer.chat.GuiMessage;

public interface TimestampedMessageLine {
	long chatAnimation$getAddedTime();
	void chatAnimation$setAddedTime(long time);

	static TimestampedMessageLine of(GuiMessage.Line line) {
		return (TimestampedMessageLine)((Object)line);
	}

	static float age(GuiMessage.Line line) {
		return System.currentTimeMillis() - of(line).chatAnimation$getAddedTime();
	}
}
