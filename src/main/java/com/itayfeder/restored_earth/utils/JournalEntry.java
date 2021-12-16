package com.itayfeder.restored_earth.utils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class JournalEntry {
    public EntityType type;
    public int size;
    public EntityType family;
    public Item egg;

    public JournalEntry(EntityType type, int size, EntityType family, Item egg) {
        this.type = type;
        this.size = size;
        this.family = family;
        this.egg = egg;
    }
}
