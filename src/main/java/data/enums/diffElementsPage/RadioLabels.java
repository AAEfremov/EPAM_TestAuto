package data.enums.diffElementsPage;

import java.util.ArrayList;
import java.util.List;

public enum RadioLabels {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen"),
    RADIO_LABELS("Gold", "Silver", "Bronze", "Selen");


    private List<String> radioLabels = new ArrayList<String>();
    private String label;

    RadioLabels(String label1, String label2, String label3, String label4) {
        radioLabels.add(label1);
        radioLabels.add(label2);
        radioLabels.add(label3);
        radioLabels.add(label4);
    }

    RadioLabels(String label) {
        this.label = label;
    }

    public List<String> getRadioLabels() {
        return radioLabels;
    }

    public String getLabel() {
        return label;
    }

    public String getMetalTag() {
        return "metal";
    }
}
