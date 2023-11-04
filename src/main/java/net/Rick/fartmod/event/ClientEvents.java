package net.Rick.fartmod.event;

import net.Rick.fartmod.fartmod;
import net.Rick.fartmod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class ClientEvents {
    // Define an array of SoundEvent names for your fart sounds
    private static final String[] FART_SOUND_NAMES = {
            "fartmod:fart1",
            "fartmod:fart2",
            "fartmod:fart3",
            "fartmod:fart4",
            "fartmod:fart5"
    };

    @Mod.EventBusSubscriber(modid = fartmod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.FART_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("You Farted"));

                System.out.println("Fart button clicked."); // Debugging message

                // Select a random fart sound event
                Random random = new Random();
                int randomIndex = random.nextInt(FART_SOUND_NAMES.length);
                String randomFartSoundName = FART_SOUND_NAMES[randomIndex];

                System.out.println("Random fart sound: " + randomFartSoundName); // Debugging message

                // Get the sound event from the registry
                SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(randomFartSoundName));
                if (soundEvent != null) {
                    System.out.println("Playing sound: " + randomFartSoundName); // Debugging message
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0F));
                } else {
                    System.out.println("Sound event not found: " + randomFartSoundName); // Debugging message
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = fartmod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.FART_KEY);
        }
    }
}
