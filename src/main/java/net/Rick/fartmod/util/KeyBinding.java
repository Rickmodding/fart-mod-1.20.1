package net.Rick.fartmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_FARTMOD = "key.category.fartmod.fartmod";
    public static final String KEY_FART = "key.fartmod.fart";

    public static final KeyMapping FART_KEY = new KeyMapping(KEY_FART, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_FARTMOD);
}