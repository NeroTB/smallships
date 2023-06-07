package com.talhanation.smallships.config;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class SmallShipsConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        ForgeConfigSpec.Builder commonConfigBuilder = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder clientConfigBuilder = new ForgeConfigSpec.Builder();
        setupCommonConfig(commonConfigBuilder);
        setupClientConfig(clientConfigBuilder);
        COMMON_SPEC = commonConfigBuilder.build();
        CLIENT_SPEC = clientConfigBuilder.build();
    }

    @ExpectPlatform
    public static void registerConfigs(String modId, ModConfig.Type type, IConfigSpec<?> spec) {
        throw new AssertionError();
    }

    public static class Common {
        public static ForgeConfigSpec.ConfigValue<Integer> schematicVersion;

        public static ForgeConfigSpec.ConfigValue<Integer> shipGeneralSailCooldown;
        public static ForgeConfigSpec.ConfigValue<Double> shipGeneralCollisionDamage;
        public static ForgeConfigSpec.BooleanValue shipGeneralDoItemDrop;
        public static ForgeConfigSpec.ConfigValue<Double> shipGeneralContainerModifier;
        public static ForgeConfigSpec.ConfigValue<Double> shipGeneralPaddlingModifier;

        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeCogMaxHealth;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeCogMaxSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeCogMaxReverseSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeCogMaxRotationSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeCogAcceleration;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeCogRotationAcceleration;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerCogContainerSize;

        public static ForgeConfigSpec.ConfigValue<Integer> shipModifierCogBiome;

        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeBriggMaxHealth;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeBriggMaxSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeBriggMaxReverseSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeBriggMaxRotationSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeBriggAcceleration;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeBriggRotationAcceleration;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerBriggContainerSize;

        public static ForgeConfigSpec.ConfigValue<Integer> shipModifierBriggBiome;

        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeGalleyMaxHealth;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeGalleyMaxSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeGalleyMaxReverseSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeGalleyMaxRotationSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeGalleyAcceleration;
        public static ForgeConfigSpec.ConfigValue<Double> shipAttributeGalleyRotationAcceleration;

        public static ForgeConfigSpec.ConfigValue<Integer> shipContainerGalleyContainerSize;

        public static ForgeConfigSpec.ConfigValue<Integer> shipModifierGalleyBiome;

        public static ForgeConfigSpec.ConfigValue<Double> waterAnimalFleeRadius;
        public static ForgeConfigSpec.ConfigValue<Double> waterAnimalFleeSpeed;
        public static ForgeConfigSpec.ConfigValue<Double> waterAnimalFleeDistance;

        public static ForgeConfigSpec.BooleanValue smallshipsItemGroupEnable;
    }

    public static class Client {
        public static ForgeConfigSpec.BooleanValue shipGeneralCameraZoomEnable;
        public static ForgeConfigSpec.BooleanValue shipGeneralCameraAutoThirdPerson;
        public static ForgeConfigSpec.ConfigValue<Double> shipGeneralCameraZoomMax;
        public static ForgeConfigSpec.ConfigValue<Double> shipGeneralCameraZoomMin;
    }

    private static void setupCommonConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" This holds the schematic version for internal purposes. DO NOT TOUCH!");
        Common.schematicVersion = builder
                .define("schematicVersion", 1);

        builder.comment(" This category holds configs that define ship behaviour.");
        builder.push("Ship");

        builder.comment("This category holds configs that define general ship behaviour.");
        builder.push("General");

        Common.shipGeneralSailCooldown = builder
                .define("shipGeneralSailCooldown", 30);
        Common.shipGeneralCollisionDamage = builder
                .define("shipGeneralCollisionDamage", 7.5D);
        Common.shipGeneralDoItemDrop = builder
                .define("shipGeneralDoItemDrop", true);

        builder.comment("General speed modifier for ships.");
        builder.push("Modifier");

        builder.comment("Maximum speed penalty for a filled container in percent.");
        Common.shipGeneralContainerModifier = builder
                .define("shipGeneralContainerModifier", 10D);

        builder.comment("Speed bonus for a paddle ship while paddling in percent.");
        Common.shipGeneralPaddlingModifier = builder
                .define("shipGeneralPaddlingModifier", 35D);

        builder.pop();

        builder.comment("This category holds configs that define behaviour of fleeing water animals.");
        builder.push("Fleeing Water Animals");

        Common.waterAnimalFleeRadius = builder
                .define("waterAnimalFleeRadius", 15.0D);
        Common.waterAnimalFleeSpeed = builder
                .define("waterAnimalFleeSpeed", 1.5D);
        Common.waterAnimalFleeDistance = builder
                .define("waterAnimalFleeDistance", 10.0D);

        builder.pop();

        builder.pop();



        builder.push("Cog");

        builder.comment("Default attributes for the Cog. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Common.shipAttributeCogMaxHealth = builder
                .define("shipAttributeCogMaxHealth", 300.0D);
        Common.shipAttributeCogMaxSpeed = builder
                .define("shipAttributeCogMaxSpeed", 30.0D);
        Common.shipAttributeCogMaxReverseSpeed = builder
                .define("shipAttributeCogMaxReverseSpeed", 0.1D);
        Common.shipAttributeCogMaxRotationSpeed = builder
                .define("shipAttributeCogMaxRotationSpeed", 4.5D);
        Common.shipAttributeCogAcceleration = builder
                .define("shipAttributeCogAcceleration", 0.015D);
        Common.shipAttributeCogRotationAcceleration = builder
                .define("shipAttributeCogRotationAcceleration", 0.7D);

        builder.pop();

        builder.comment("Default configs for the container of the Cog.");
        builder.push("Container");

        builder.comment("Set container size for the Cog (value must be divisible by 9 and bigger than 0).");
        Common.shipContainerCogContainerSize = builder
                .define("shipContainerCogContainerSize", 108, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Cog specific speed modifier.");
        builder.push("Modifier");

        builder.comment("-1 = none, 0 = cold, 1 = neutral or 2 = warm Biomes");
        Common.shipModifierCogBiome = builder
                .define("shipModifierCogBiome", 0);

        builder.pop();

        builder.pop();



        builder.push("Brigg");

        builder.comment("Default attributes for the Brigg. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Common.shipAttributeBriggMaxHealth = builder
                .define("shipAttributeBriggMaxHealth", 450.0D);
        Common.shipAttributeBriggMaxSpeed = builder
                .define("shipAttributeBriggMaxSpeed", 35.0D);
        Common.shipAttributeBriggMaxReverseSpeed = builder
                .define("shipAttributeBriggMaxReverseSpeed", 0.1D);
        Common.shipAttributeBriggMaxRotationSpeed = builder
                .define("shipAttributeBriggMaxRotationSpeed", 4.0D);
        Common.shipAttributeBriggAcceleration = builder
                .define("shipAttributeBriggAcceleration", 0.015D);
        Common.shipAttributeBriggRotationAcceleration = builder
                .define("shipAttributeBriggRotationAcceleration", 0.55D);

        builder.pop();

        builder.comment("Default configs for the container of the Brigg.");
        builder.push("Container");

        builder.comment("Set container size for the Brigg (value must be divisible by 9 and bigger than 0).");
        Common.shipContainerBriggContainerSize = builder
                .define("shipContainerBriggContainerSize", 162, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Brigg specific speed modifier.");
        builder.push("Modifier");

        builder.comment("-1 = none, 0 = cold, 1 = neutral or 2 = warm Biomes");
        Common.shipModifierBriggBiome = builder
                .define("shipModifierBriggBiome", 0);

        builder.pop();

        builder.pop();



        builder.push("Galley");

        builder.comment("Default attributes for the Galley. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        Common.shipAttributeGalleyMaxHealth = builder
                .define("shipAttributeGalleyMaxHealth", 200.0D);
        Common.shipAttributeGalleyMaxSpeed = builder
                .define("shipAttributeGalleyMaxSpeed", 30.0D);
        Common.shipAttributeGalleyMaxReverseSpeed = builder
                .define("shipAttributeGalleyMaxReverseSpeed", 0.1D);
        Common.shipAttributeGalleyMaxRotationSpeed = builder
                .define("shipAttributeGalleyMaxRotationSpeed", 5.0D);
        Common.shipAttributeGalleyAcceleration = builder
                .define("shipAttributeGalleyAcceleration", 0.015D);
        Common.shipAttributeGalleyRotationAcceleration = builder
                .define("shipAttributeGalleyRotationAcceleration", 1.00D);

        builder.pop();


        builder.comment("Default configs for the container of the Galley.");
        builder.push("Container");

        builder.comment("Set container size for the Galley (value must be divisible by 9 and bigger than 0).");
        Common.shipContainerGalleyContainerSize = builder
                .define("shipContainerGalleyContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Galley specific speed modifier.");
        builder.push("Modifier");

        builder.comment("-1 = none, 0 = cold, 1 = neutral or 2 = warm Biomes");
        Common.shipModifierGalleyBiome = builder
                .define("shipModifierGalleyBiome", 2);

        builder.pop();

        builder.pop();



        builder.pop();
    }

    private static void setupClientConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" This holds the schematic version for internal purposes. DO NOT TOUCH!");
        Common.schematicVersion = builder
                .define("schematicVersion", 1);

        builder.comment(" This category holds configs that define ship behaviour.");
        builder.push("Ship");

        builder.comment("This category holds configs that define general ship behaviour.");
        builder.push("General");

        builder.comment("General camera settings for ships.");
        builder.push("Camera");

        builder.comment("Zoom camera settings for third person view in ships.");
        builder.push("Zoom");

        builder.comment("Generally enable the zooming feature.");
        Client.shipGeneralCameraZoomEnable = builder
                .define("shipGeneralCameraZoomEnable", true);

        builder.comment("Set maximum distance of zoom (value must be smaller than or equal to 50.0).");
        Client.shipGeneralCameraZoomMax = builder
                .define("shipGeneralCameraZoomMax", 20.0D, e -> e instanceof Double d && d <= 50.0D && d >= 1.0D);

        builder.comment("Set minimum distance of zoom (value must be bigger than or equal to 1.0).");
        Client.shipGeneralCameraZoomMin = builder
                .define("shipGeneralCameraZoomMin", 5.0D, e -> e instanceof Double d && d <= 50.0D && d >= 1.0D);

        builder.pop();

        builder.comment("Automatically enable third person camera when entering a ship.");
        Client.shipGeneralCameraAutoThirdPerson = builder
                .define("shipGeneralCameraAutoThirdPerson", true);

        builder.pop();

        builder.pop();

        builder.pop();

        builder.comment(" This category holds configs that define general mod settings.");
        builder.push("General");

        builder.comment("Enable smallships creative tab in the creative inventory (only takes effect after restart).");
        Common.smallshipsItemGroupEnable = builder
                .define("smallshipsItemGroupEnable", false);

        builder.pop();
    }
}