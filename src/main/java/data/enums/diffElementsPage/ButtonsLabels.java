package data.enums.diffElementsPage;

public enum ButtonsLabels {

    BUTTON1_LABEL("Default Button");

    private String buttonName;

    ButtonsLabels(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
