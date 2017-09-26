package data.enums.DatesPage;

public enum SliderHandles {

    LEFT_HANDLE(0),
    RIGHT_HANDLE(1);

    private Integer handle;

    SliderHandles(Integer handle) {
        this.handle = handle;
    }

    public Integer getHandle() {
        return handle;
    }
}
