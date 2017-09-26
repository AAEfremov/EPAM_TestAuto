package data.enums.rightSection;

import java.util.ArrayList;
import java.util.List;

public enum InfoPanelHeaders {

    INFO_PANEL_HEADERS("Log", "Result");

    private List<String> headers = new ArrayList<String>();

    InfoPanelHeaders(String header1, String header2) {

        headers.add(header1);
        headers.add(header2);
    }

    public List<String> getHeaders() {
        return headers;
    }
}
