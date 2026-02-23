package com.github.lumin.managers.impl;

import com.github.lumin.modules.AbstractModule;
import com.github.lumin.modules.impl.visual.RenderTest;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private static ModuleManager INSTANCE = null;
    private List<AbstractModule> modules = new ArrayList<>();

    private ModuleManager() {
        initModules();
    }

    public static ModuleManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ModuleManager();
        }
        return INSTANCE;
    }

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = new ModuleManager();
        }
    }

    private void initModules() {
        modules = List.of(
                /* VISUAL */
                RenderTest.getInstance()
        );
    }

    public void onKeyPress(int keyCode) {
        for (final var module : modules) {
            if (module.keyBind == keyCode) module.toggle();
        }
    }

}
