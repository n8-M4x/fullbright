package de.n8M4.fullbright;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Fullbright.MODID)
public class Fullbright {
    public static boolean fullbright = true;

    public static boolean fullbright() {
        if(FULLBRIGHT_KEY.consumeClick()) fullbright = !fullbright;
        return fullbright;
    }

    public static final String MODID = "fullbright";
    public static final KeyMapping FULLBRIGHT_KEY = new KeyMapping("Fullbright", InputConstants.KEY_H, "key.categories.movement");

    @SubscribeEvent
    public static void onRegisterKeybinds(RegisterKeyMappingsEvent e) {
        e.register(FULLBRIGHT_KEY);
    }

    public Fullbright() {
        FMLJavaModLoadingContext.get().getModEventBus().register(Fullbright.class);
    }
}