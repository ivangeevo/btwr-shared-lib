package org.btwr.shared_library;

import org.btwr.api.api.registry.RepairRecipeBlockedRegistry;
import org.btwr.shared_library.api.item.ProgressiveCraftingItem;
import net.fabricmc.api.ModInitializer;
import org.btwr.shared_library.recipe.BTWRSLRecipes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BTWRSLMod implements ModInitializer {

    public static final String MOD_ID = "btwr_sl";
    public static final String MOD_NAME = "BTWR: Shared Library";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        BTWRSLRecipes.register();

        // Block progressive crafting items recipes for all repair type recipes
        RepairRecipeBlockedRegistry.registerClass(ProgressiveCraftingItem.class, RepairRecipeBlockedRegistry.BlockType.ALL);
    }

}