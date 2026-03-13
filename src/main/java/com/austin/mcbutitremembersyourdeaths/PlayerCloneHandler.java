package com.austin.mcbutitremembersyourdeaths;

import java.util.Optional;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mcbutitremembersyourdeaths")
public class PlayerCloneHandler {

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {

        if (!event.isWasDeath()) return;

        CompoundTag originalData = event.getOriginal().getPersistentData();
        CompoundTag newData = event.getEntity().getPersistentData();

        Optional<CompoundTag> optionalTag = originalData.getCompound("FunnyDeathCounts");

        if (optionalTag.isPresent()) {
            newData.put("FunnyDeathCounts", optionalTag.get());
        }
    }
}