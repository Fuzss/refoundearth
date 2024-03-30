package fuzs.refoundearth.init;

import fuzs.puzzleslib.api.init.v3.GameRulesFactory;
import net.minecraft.world.level.GameRules;

public class ModGameRules {
    public static final GameRules.Key<GameRules.BooleanValue> MUD_SOURCE_CONVERSION = GameRulesFactory.INSTANCE.register(
            "mudSourceConversion",
            GameRules.Category.UPDATES,
            GameRulesFactory.INSTANCE.createBooleanRule(true)
    );

    public static void touch() {

    }
}
