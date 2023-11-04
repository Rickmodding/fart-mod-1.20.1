package net.Rick.fartmod.sounds;

import net.Rick.fartmod.fartmod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, fartmod.MOD_ID);


    public static final RegistryObject<SoundEvent> FART1 = registerSoundEvents("sound_block_break");
    public static final RegistryObject<SoundEvent> FART2 = registerSoundEvents("sound_block_step");
    public static final RegistryObject<SoundEvent> FART3 = registerSoundEvents("sound_block_fall");
    public static final RegistryObject<SoundEvent> FART4 = registerSoundEvents("sound_block_place");
    public static final RegistryObject<SoundEvent> FART5 = registerSoundEvents("sound_block_hit");



    public static final ForgeSoundType FARTS_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.FART1, ModSounds.FART2, ModSounds.FART3,
            ModSounds.FART4, ModSounds.FART5);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(fartmod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
