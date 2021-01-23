package com.rebane2001.livemessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import static net.minecraftforge.client.settings.KeyConflictContext.IN_GAME;

@Mod.EventBusSubscriber(modid = Livemessage.MOD_ID)
public class EventHandler {

    public static KeyBinding[] keyBindings;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public static void onEvent(InputEvent.KeyInputEvent event)
    {
        if (keyBindings[0].isPressed())
            Minecraft.getMinecraft().player.openGui(Livemessage.instance,0,Minecraft.getMinecraft().world,0,0,0);
    }


    public static void initKeys(){
        keyBindings = new KeyBinding[1];

        keyBindings[0] = new KeyBinding("Open Livemessage GUI", IN_GAME, KeyModifier.CONTROL, Keyboard.KEY_T, "Livemessage");

        for (int i = 0; i < keyBindings.length; ++i)
        {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }
    }

}