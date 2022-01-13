package com.credible.tools.MorseCode.ui;

public class SymbolPair {
    private String morse, english;
    public SymbolPair(String s1, String s2){
        english = s1;
        morse = s2;
    }

    public String getEnglish() {
        return english;
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }
}
