package com.talhanation.smallships.forge;

import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.forge.client.ClientInitializer;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.forge.ModEntityTypesImpl;
import com.talhanation.smallships.world.inventory.forge.ModMenuTypesImpl;
import com.talhanation.smallships.world.item.forge.ModItemsImpl;
import com.talhanation.smallships.world.sound.forge.ModSoundTypesImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SmallshipsMod.MOD_ID)
public class SmallshipsModForge {
    public SmallshipsModForge() {
        SmallshipsMod.init();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);

        ModEntityTypesImpl.ENTITY_TYPES.register(modEventBus);
        ModMenuTypesImpl.MENU_TYPES.register(modEventBus);
        ModItemsImpl.ITEMS.register(modEventBus);
        ModSoundTypesImpl.SOUND_EVENTS.register(modEventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientInitializer::new);
    }

    private void setup(FMLCommonSetupEvent event) {
        ModPackets.registerPackets();
    }
}