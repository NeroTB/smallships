package com.talhanation.smallships.forge.client;

import com.talhanation.smallships.SmallShipsMod;

import com.talhanation.smallships.client.ClientInitializer;
import com.talhanation.smallships.client.model.*;
import com.talhanation.smallships.client.option.ModGameOptions;
import com.talhanation.smallships.client.renderer.entity.*;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {
    @SubscribeEvent
    static void init(FMLClientSetupEvent event) {
        ClientInitializer.init();
    }

    @SubscribeEvent
    static void initRegisterRendererRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.CANNON_BALL, CannonBallRenderer::new);

        event.registerEntityRenderer(ModEntityTypes.COG, CogRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.BRIGG, BriggRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GALLEY, GalleyRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.DRAKKAR, DrakkarRenderer::new);
    }

    @SubscribeEvent
    static void initRegisterRendererLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CannonBallModel.LAYER_LOCATION, CannonBallModel::createBodyLayer);

        event.registerLayerDefinition(CogModel.LAYER_LOCATION, CogModel::createBodyLayer);
        event.registerLayerDefinition(BriggModel.LAYER_LOCATION, BriggModel::createBodyLayer);
        event.registerLayerDefinition(GalleyModel.LAYER_LOCATION, GalleyModel::createBodyLayer);
        event.registerLayerDefinition(DrakkarModel.LAYER_LOCATION, DrakkarModel::createBodyLayer);
    }

    @SubscribeEvent
    static void initRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(ModGameOptions.SAIL_KEY);
    }
}
