package com.talhanation.smallships.world.sound;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.sounds.SoundEvent;

public class ModSoundTypes {
    public static final SoundEvent SAIL_MOVE = getSoundType("sail_move");
    public static final SoundEvent SAIL_PULL = getSoundType("sail_pull");
    public static final SoundEvent CANNON_SHOT = getSoundType("cannon_shot");
    public static final SoundEvent SHIP_HIT = getSoundType("ship_hit");

    @ExpectPlatform
    public static SoundEvent getSoundType(String id) {
        throw new AssertionError();
    }
}
