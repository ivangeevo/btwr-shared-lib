package org.btwr.shared_library.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class BTWRSL_LangGenerator extends FabricLanguageProvider {

    public BTWRSL_LangGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        addConfigEntries(translationBuilder);
    }

    protected void addConfigEntries(TranslationBuilder tb) {
        // Config
        addConfigTitle("config", "BTWR: Shared Library Config", tb);
        addConfigCategory("penalties", "Penalties", tb);
        addConfigEntry("hunger_override", "Hunger Display Override", tb);
        addConfigEntry("render_x", "X Offset", tb);
        addConfigEntry("render_y", "Y Offset", tb);
        addConfigEntry("draw_margin", "Draw Margin", tb);
        addConfigEntry("draw_mode", "Draw Mode", tb);
        addConfigTooltip("hunger_override",
                "Forces the penalty display to think the hunger\n" +
                        "bar is being rendered. Does nothing\n" +
                        "if the hunger bar is actually rendered.", tb);
        addConfigTooltip("render_x",
                "Horizontally offsets the penalty rendering by the given amount", tb);
        addConfigTooltip("render_y",
                "Vertically offsets the penalty rendering by the given amount", tb);
        addConfigTooltip("draw_margin",
                "Padding to add when drawing penalties to the screen.\n" +
                        "Has no effect when draw mode is \"BTW\"", tb);
        addConfigTooltip("draw_mode",
                "Determines how penalties are drawn to the screen.\n" +
                        "\"BTW\" emulates Better Than Wolves rendering", tb);
        addConfigAnchor("BTW", "BTW", tb);
        addConfigAnchor("BOTTOM_RIGHT", "Bottom Right", tb);
        addConfigAnchor("TOP_RIGHT", "Top Right", tb);
        addConfigAnchor("BOTTOM_LEFT", "Bottom Left", tb);
        addConfigAnchor("TOP_LEFT", "Top Left", tb);
    }

    protected void addTagName(TagKey<?> tagKey, String value, TranslationBuilder tb) {
        tb.add(tagKey, value);
    }

    protected void addConfigTitle(String key, String value, TranslationBuilder tb) {
        tb.add("title.btwrsl." + key, value);
    }

    protected void addConfigCategory(String key, String value, TranslationBuilder tb) {
        tb.add("title.btwrsl.category" + key, value);
    }

    protected void addConfigEntry(String key, String value, TranslationBuilder tb) {
        tb.add("config.btwrsl." + key, value);
    }

    protected void addConfigTooltip(String key, String value, TranslationBuilder tb) {
        tb.add("config.btwrsl.tooltip." + key, value);
    }

    protected void addConfigAnchor(String key, String value, TranslationBuilder tb) {
        tb.add("config.btwrsl.draw_mode.anchor." + key, value);
    }

}