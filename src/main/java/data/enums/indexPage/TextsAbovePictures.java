package data.enums.indexPage;

import java.util.ArrayList;
import java.util.List;

public enum TextsAbovePictures {

    ABOVE_TEXTS("EPAM FRAMEWORK WISHES…",
            "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET" +
                    " DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT" +
                    " ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM" +
                    " DOLORE EU FUGIAT NULLA PARIATUR.");

    private List<String> texts = new ArrayList<String>();

    TextsAbovePictures(String text1, String text2) {
        texts.add(text1);
        texts.add(text2);
    }

    public List<String> getTexts() {
        return texts;
    }
}
