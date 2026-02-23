package com.github.lumin.modules;

import com.github.lumin.assets.i18n.TranslateComponent;

public enum Category {

    COMBAT("combat"),
    MOVEMENT("movement"),
    MISC("misc"),
    VISUAL("visual"),
    CLIENT("client");

    public final TranslateComponent name;
    
    Category(String nameKey) {
        name = TranslateComponent.create("category", nameKey);
    }

}
