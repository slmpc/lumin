package com.github.lumin.modules;

import com.github.lumin.Lumin;
import com.github.lumin.settings.AbstractSetting;
import com.github.lumin.settings.impl.*;
import com.github.lumin.settings.impl.*;
import com.github.lumin.utils.i18n.TranslateComponent;
import net.neoforged.neoforge.common.NeoForge;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModule {

    public TranslateComponent name;
    public Category category;
    public int keyBind;

    private boolean enabled;
    private final ArrayList<AbstractSetting<?>> settings = new ArrayList<>();

    public AbstractModule(String nameKey, Category category) {
        this.name = new TranslateComponent("modules", nameKey);
        this.category = category;
    }

    public void toggle() {
        enabled = !enabled;

        if (enabled) {
            // Will throw an exception when the module doesn't have any listeners
            try {
                NeoForge.EVENT_BUS.register(this);
            } catch (Exception ignored) {}

            Lumin.LOGGER.info("{} has been enabled", name.suffix());
        } else {
            try {
                NeoForge.EVENT_BUS.unregister(this);
            } catch (Exception ignored) {}

            Lumin.LOGGER.info("{} has been disabled", name.suffix());
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        if (enabled != this.enabled) {
            toggle();
        }
    }

    /**** Settings ****/

    private <T extends AbstractSetting<?>> T addSetting(T setting) {
        settings.add(setting);
        return setting;
    }

    public List<AbstractSetting<?>> getSettings() {
        return settings.stream().toList();
    }

    // --- Bool Setting ---
    protected BoolSetting boolSetting(String name, boolean defaultValue, AbstractSetting.Dependency dependency) {
        return addSetting(new BoolSetting(this, name, defaultValue, dependency));
    }

    protected BoolSetting boolSetting(String name, boolean defaultValue) {
        return addSetting(new BoolSetting(this, name, defaultValue));
    }

    // --- Color Setting ---
    protected ColorSetting colorSetting(String name, Color defaultValue, AbstractSetting.Dependency dependency) {
        return addSetting(new ColorSetting(this, name, defaultValue, dependency));
    }

    protected ColorSetting colorSetting(String name, Color defaultValue) {
        return addSetting(new ColorSetting(this, name, defaultValue));
    }

    // --- Enum Setting ---
    protected <E extends Enum<E>> EnumSetting<E> enumSetting(String name, E defaultValue, E[] modes, AbstractSetting.Dependency dependency) {
        return addSetting(new EnumSetting<>(this, name, defaultValue, modes, dependency));
    }

    protected <E extends Enum<E>> EnumSetting<E> enumSetting(String name, E defaultValue, E[] modes) {
        return addSetting(new EnumSetting<>(this, name, defaultValue, modes));
    }

    // --- Int Setting ---
    protected IntSetting intSetting(String name, int defaultValue, int min, int max, int step, AbstractSetting.Dependency dependency) {
        return addSetting(new IntSetting(this, name, defaultValue, min, max, step, dependency));
    }

    protected IntSetting intSetting(String name, int defaultValue, int min, int max, int step) {
        return addSetting(new IntSetting(this, name, defaultValue, min, max, step));
    }

    // --- String Setting ---
    protected StringSetting stringSetting(String name, String defaultValue, AbstractSetting.Dependency dependency) {
        return addSetting(new StringSetting(this, name, defaultValue, dependency));
    }

    protected StringSetting stringSetting(String name, String defaultValue) {
        return addSetting(new StringSetting(this, name, defaultValue));
    }

}
