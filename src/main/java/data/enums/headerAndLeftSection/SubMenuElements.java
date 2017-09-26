package data.enums.headerAndLeftSection;

import java.util.ArrayList;
import java.util.List;

public enum SubMenuElements {

    SUB_MENU_ELEMENTS("Home", "Contact form", "Service", "Support", "Dates", "Complex Table", "Simple Table",
            "Table with pages", "Different elements", "Metals & Colors");

    private List<String> names = new ArrayList<String>();

    SubMenuElements(String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9, String name10) {

        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);
        names.add(name6);
        names.add(name7);
        names.add(name8);
        names.add(name9);
        names.add(name10);
    }

    public List<String> getNames() {
        return names;
    }
}
