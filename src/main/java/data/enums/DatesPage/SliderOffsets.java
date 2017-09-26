package data.enums.DatesPage;

public enum SliderOffsets {

    LEFT_MIN(-54, "0"),
    LEFT_MAX(300, "100"),
    RIGHT_MIN(-270, "0"),
    RIGHT_MAX(300, "100"),
    VALUE1(-188, "30"),
    VALUE2(-83, "70");

    private Integer offset;
    private String value;

    SliderOffsets(Integer offset, String value) {

        this.offset = offset;
        this.value = value;
    }

    public Integer getOffset() {
        return offset;
    }

    public String getValue() {
        return value;
    }
}
