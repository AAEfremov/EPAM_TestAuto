package data.enums.indexPage;

import java.util.ArrayList;
import java.util.List;

public enum TextsUnderPictures {

    UNDER_TEXTS("To include good practices\nand ideas from successful\nEPAM projec", "To be flexible and\ncustomizable",
            "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private List<String> texts = new ArrayList<String>();

    TextsUnderPictures(String text1, String text2, String text3, String text4) {
        texts.add(text1);
        texts.add(text2);
        texts.add(text3);
        texts.add(text4);
    }

    public List<String> getTexts() {
        return texts;
    }

}
