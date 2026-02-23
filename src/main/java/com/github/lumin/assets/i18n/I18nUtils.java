package com.github.lumin.assets.i18n;

import com.github.lumin.modules.Category;

public class I18nUtils {

    /****** Categories ******/
    private static final TranslateComponent CATEGORY_COMBAT_COMPONENT
            = TranslateComponent.create("category", "combat");

    private static final TranslateComponent CATEGORY_MOVEMENT_COMPONENT
            = TranslateComponent.create("category", "movement");

    private static final TranslateComponent CATEGORY_MISC_COMPONENT
            = TranslateComponent.create("category", "misc");

    private static final TranslateComponent CATEGORY_VISUAL_COMPONENT
            = TranslateComponent.create("category", "visual");

    private static final TranslateComponent CATEGORY_CLIENT_COMPONENT
            = TranslateComponent.create("category", "client");

    public static TranslateComponent getTranslateComponentFromCategory(Category category) {
        return switch (category) {
            case COMBAT -> CATEGORY_COMBAT_COMPONENT;
            case MOVEMENT -> CATEGORY_MOVEMENT_COMPONENT;
            case MISC -> CATEGORY_MISC_COMPONENT;
            case VISUAL -> CATEGORY_VISUAL_COMPONENT;
            case CLIENT -> CATEGORY_CLIENT_COMPONENT;
        };
    }

}
