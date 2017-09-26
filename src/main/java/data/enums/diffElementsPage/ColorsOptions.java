package data.enums.diffElementsPage;

import java.util.ArrayList;
import java.util.List;

public enum ColorsOptions {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    COLORS_OPTIONS("Red", "Green", "Blue", "Yellow");

    private List<String> colors = new ArrayList<String>();
    private String color;

    ColorsOptions(String color1, String color2, String color3, String color4) {
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);
        colors.add(color4);
    }

    ColorsOptions(String color) {
        this.color = color;
    }

    public List<String> getColors() {
        return colors;
    }

    public String getColor() {
        return color;
    }

    public String getColorTag() {
        return "Colors";
    }
}
