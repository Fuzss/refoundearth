package fuzs.refoundearth.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.refoundearth.init.ModEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeTagProvider extends AbstractTagProvider<EntityType<?>> {

    public ModEntityTypeTagProvider(DataProviderContext context) {
        super(Registries.ENTITY_TYPE, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.add(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(ModEntityTypes.TROPICAL_SLIME.value());
        this.add(EntityTypeTags.SKELETONS).add(ModEntityTypes.SKELETON_WOLF.value(), ModEntityTypes.BONE_SPIDER.value());
    }
}
