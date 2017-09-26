package data.enums.headerAndLeftSection;

import java.util.ArrayList;
import java.util.List;

public enum ServiceDropdownElements {

    ELEMENTS_NAMES("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS");

    private List<String> elementsNames = new ArrayList<String>();

    ServiceDropdownElements(String elem1, String elem2, String elem3, String elem4, String elem5, String elem6) {
        elementsNames.add(elem1);
        elementsNames.add(elem2);
        elementsNames.add(elem3);
        elementsNames.add(elem4);
        elementsNames.add(elem5);
        elementsNames.add(elem6);
    }

    public List<String> getElementsNames() {
        return elementsNames;
    }
}
