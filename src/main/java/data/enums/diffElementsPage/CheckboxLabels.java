package data.enums.diffElementsPage;

import java.util.ArrayList;
import java.util.List;

public enum CheckboxLabels {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    CHECKBOX_LABELS("Water", "Earth", "Wind", "Fire");


    private List<String> checkboxLabels = new ArrayList<String>();
    private String label;

    CheckboxLabels(String label1, String label2, String label3, String label4) {
        checkboxLabels.add(label1);
        checkboxLabels.add(label2);
        checkboxLabels.add(label3);
        checkboxLabels.add(label4);
    }

    CheckboxLabels(String label) {
        this.label = label;
    }

    public List<String> getCheckboxLabels() {
        return checkboxLabels;
    }

    public String getLabel() {
        return label;
    }
}
