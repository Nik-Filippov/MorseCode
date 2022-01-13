// Translator.java - Translator class.
// N.Filippov
// 2.7.20
package com.credible.tools.MorseCode.ui;

import java.util.ArrayList;

public class Translator {
    private static ArrayList<SymbolPair> morseList;
    private static ArrayList<SymbolPair> morseListShort;

    public Translator() {
        morseList = new ArrayList<>();
        morseList.add(new SymbolPair("A", ". _   "));
        morseList.add(new SymbolPair("B", "_ . . .   "));
        morseList.add(new SymbolPair("C", "_ . _ .   "));
        morseList.add(new SymbolPair("D", "_ . .   "));
        morseList.add(new SymbolPair("E", ".   "));
        morseList.add(new SymbolPair("F", ". . _ .   "));
        morseList.add(new SymbolPair("G", "_ _ .   "));
        morseList.add(new SymbolPair("H", ". . . .   "));
        morseList.add(new SymbolPair("I", ". .   "));
        morseList.add(new SymbolPair("J", ". _ _ _   "));
        morseList.add(new SymbolPair("K", "_ . _   "));
        morseList.add(new SymbolPair("L", ". _ . .   "));
        morseList.add(new SymbolPair("M", "_ _   "));
        morseList.add(new SymbolPair("N", "_ .   "));
        morseList.add(new SymbolPair("O", "_ _ _   "));
        morseList.add(new SymbolPair("P", ". _ _ .   "));
        morseList.add(new SymbolPair("Q", "_ _ . _   "));
        morseList.add(new SymbolPair("R", ". _ .   "));
        morseList.add(new SymbolPair("S", ". . .   "));
        morseList.add(new SymbolPair("T", "_   "));
        morseList.add(new SymbolPair("U", ". . _   "));
        morseList.add(new SymbolPair("V", ". . . _   "));
        morseList.add(new SymbolPair("W", ". _ _    "));
        morseList.add(new SymbolPair("X", "_ . . _   "));
        morseList.add(new SymbolPair("Y", "_ . _ _   "));
        morseList.add(new SymbolPair("Z", "_ _ . .   "));
        morseList.add(new SymbolPair("1", ". _ _ _ _   "));
        morseList.add(new SymbolPair("2", ". . _ _ _   "));
        morseList.add(new SymbolPair("3", ". . . _ _   "));
        morseList.add(new SymbolPair("4", ". . . . _   "));
        morseList.add(new SymbolPair("5", ". . . . .   "));
        morseList.add(new SymbolPair("6", "_ . . . .   "));
        morseList.add(new SymbolPair("7", "_ _ . . .   "));
        morseList.add(new SymbolPair("8", "_ _ _ . .   "));
        morseList.add(new SymbolPair("9", "_ _ _ _ .   "));
        morseList.add(new SymbolPair("0", "_ _ _ _ _   "));

        morseListShort = new ArrayList<>();
        morseListShort.add(new SymbolPair("A", ". _"));
        morseListShort.add(new SymbolPair("B", "_ . . ."));
        morseListShort.add(new SymbolPair("C", "_ . _ ."));
        morseListShort.add(new SymbolPair("D", "_ . ."));
        morseListShort.add(new SymbolPair("E", "."));
        morseListShort.add(new SymbolPair("F", ". . _ ."));
        morseListShort.add(new SymbolPair("G", "_ _ ."));
        morseListShort.add(new SymbolPair("H", ". . . ."));
        morseListShort.add(new SymbolPair("I", ". ."));
        morseListShort.add(new SymbolPair("J", ". _ _ _"));
        morseListShort.add(new SymbolPair("K", "_ . _"));
        morseListShort.add(new SymbolPair("L", ". _ . ."));
        morseListShort.add(new SymbolPair("M", "_ _"));
        morseListShort.add(new SymbolPair("N", "_ ."));
        morseListShort.add(new SymbolPair("O", "_ _ _"));
        morseListShort.add(new SymbolPair("P", ". _ _ ."));
        morseListShort.add(new SymbolPair("Q", "_ _ . _"));
        morseListShort.add(new SymbolPair("R", ". _ ."));
        morseListShort.add(new SymbolPair("S", ". . ."));
        morseListShort.add(new SymbolPair("T", "_"));
        morseListShort.add(new SymbolPair("U", ". . _"));
        morseListShort.add(new SymbolPair("V", ". . . _"));
        morseListShort.add(new SymbolPair("W", ". _ _"));
        morseListShort.add(new SymbolPair("X", "_ . . _"));
        morseListShort.add(new SymbolPair("Y", "_ . _ _"));
        morseListShort.add(new SymbolPair("Z", "_ _ . ."));
        morseListShort.add(new SymbolPair("1", ". _ _ _ _"));
        morseListShort.add(new SymbolPair("2", ". . _ _ _"));
        morseListShort.add(new SymbolPair("3", ". . . _ _"));
        morseListShort.add(new SymbolPair("4", ". . . . _"));
        morseListShort.add(new SymbolPair("5", ". . . . ."));
        morseListShort.add(new SymbolPair("6", "_ . . . ."));
        morseListShort.add(new SymbolPair("7", "_ _ . . ."));
        morseListShort.add(new SymbolPair("8", "_ _ _ . ."));
        morseListShort.add(new SymbolPair("9", "_ _ _ _ ."));
        morseListShort.add(new SymbolPair("0", "_ _ _ _ _"));
    }

    public String tranToMorse(String a) {
        morseList.add(new SymbolPair(" ", "       "));
        for (int i = 0; i < morseList.size(); i++) {
            if (a.equalsIgnoreCase(morseList.get(i).getEnglish()))
                return morseList.get(i).getMorse();
        }
        return "";
/*
        if (a.equalsIgnoreCase("A"))
            return ". _   ";
        else if (a.equalsIgnoreCase("B"))
            return "_ . . .   ";
        else if (a.equalsIgnoreCase("C"))
            return "_ . _ .   ";
        else if (a.equalsIgnoreCase("D"))
            return "_ . .   ";
        else if (a.equalsIgnoreCase("E"))
            return ".   ";
        else if (a.equalsIgnoreCase("F"))
            return ". . _ .   ";
        else if (a.equalsIgnoreCase("G"))
            return "_ _ .   ";
        else if (a.equalsIgnoreCase("H"))
            return ". . . .   ";
        else if (a.equalsIgnoreCase("I"))
            return ". .   ";
        else if (a.equalsIgnoreCase("J"))
            return ". _ _ _   ";
        else if (a.equalsIgnoreCase("K"))
            return "_ . _   ";
        else if (a.equalsIgnoreCase("L"))
            return ". _ . .   ";
        else if (a.equalsIgnoreCase("M"))
            return "_ _   ";
        else if (a.equalsIgnoreCase("N"))
            return "_ .   ";
        else if (a.equalsIgnoreCase("O"))
            return "_ _ _   ";
        else if (a.equalsIgnoreCase("P"))
            return ". _ _ .   ";
        else if (a.equalsIgnoreCase("Q"))
            return "_ _ . _   ";
        else if (a.equalsIgnoreCase("R"))
            return ". _ .   ";
        else if (a.equalsIgnoreCase("S"))
            return ". . .   ";
        else if (a.equalsIgnoreCase("T"))
            return "_   ";
        else if (a.equalsIgnoreCase("U"))
            return ". . _   ";
        else if (a.equalsIgnoreCase("V"))
            return ". . . _   ";
        else if (a.equalsIgnoreCase("W"))
            return ". _ _   ";
        else if (a.equalsIgnoreCase("X"))
            return "_ . . _   ";
        else if (a.equalsIgnoreCase("Y"))
            return "_ . _ _   ";
        else if (a.equalsIgnoreCase("Z"))
            return "_ _ . .   ";
        else if (a.equalsIgnoreCase("0"))
            return "_ _ _ _ _   ";
        else if (a.equalsIgnoreCase("1"))
            return ". _ _ _ _   ";
        else if (a.equalsIgnoreCase("2"))
            return ". . _ _ _   ";
        else if (a.equalsIgnoreCase("3"))
            return ". . . _ _   ";
        else if (a.equalsIgnoreCase("4"))
            return ". . . . _   ";
        else if (a.equalsIgnoreCase("5"))
            return ". . . . .   ";
        else if (a.equalsIgnoreCase("6"))
            return "_ . . . .   ";
        else if (a.equalsIgnoreCase("7"))
            return "_ _ . . .   ";
        else if (a.equalsIgnoreCase("8"))
            return "_ _ _ . .   ";
        else if (a.equalsIgnoreCase("9"))
            return "_ _ _ _ .   ";
        else if (a.equalsIgnoreCase(" "))
            return "       ";
        else
            return "";
            */
    }

    public static String tranToEng(String b) {
        morseListShort.add(new SymbolPair(" ", "*"));
        for (SymbolPair symbolPair : morseListShort) {
            if (b.equalsIgnoreCase(symbolPair.getMorse()))
                return symbolPair.getEnglish();
        }
        return "";
        /*
        if (b.equalsIgnoreCase(". _"))
            return "A";
        else if (b.equalsIgnoreCase("_ . . ."))
            return "B";
        else if (b.equalsIgnoreCase("_ . _ ."))
            return "C";
        else if (b.equalsIgnoreCase("_ . ."))
            return "D";
        else if (b.equalsIgnoreCase("."))
            return "E";
        else if (b.equalsIgnoreCase(". . _ ."))
            return "F";
        else if (b.equalsIgnoreCase("_ _ ."))
            return "G";
        else if (b.equalsIgnoreCase(". . . ."))
            return "H";
        else if (b.equalsIgnoreCase(". ."))
            return "I";
        else if (b.equalsIgnoreCase(". _ _ _"))
            return "J";
        else if (b.equalsIgnoreCase("_ . _"))
            return "K";
        else if (b.equalsIgnoreCase(". _ . ."))
            return "L";
        else if (b.equalsIgnoreCase("_ _"))
            return "M";
        else if (b.equalsIgnoreCase("_ ."))
            return "N";
        else if (b.equalsIgnoreCase("_ _ _"))
            return "O";
        else if (b.equalsIgnoreCase(". _ _ ."))
            return "P";
        else if (b.equalsIgnoreCase("_ _ . _"))
            return "Q";
        else if (b.equalsIgnoreCase(". _ ."))
            return "R";
        else if (b.equalsIgnoreCase(". . ."))
            return "S";
        else if (b.equalsIgnoreCase("_"))
            return "T";
        else if (b.equalsIgnoreCase(". . _"))
            return "U";
        else if (b.equalsIgnoreCase(". . . _"))
            return "V";
        else if (b.equalsIgnoreCase(". _ _"))
            return "W";
        else if (b.equalsIgnoreCase("_ . . _"))
            return "X";
        else if (b.equalsIgnoreCase("_ . _ _"))
            return "Y";
        else if (b.equalsIgnoreCase("_ _ . ."))
            return "Z";
        else if (b.equalsIgnoreCase("*"))
            return " ";
        else if (b.equalsIgnoreCase("_ _ _ _ _"))
            return "0";
        else if (b.equalsIgnoreCase(". _ _ _ _"))
            return "1";
        else if (b.equalsIgnoreCase(". . _ _ _"))
            return "2";
        else if (b.equalsIgnoreCase(". . . _ _"))
            return "3";
        else if (b.equalsIgnoreCase(". . . . _"))
            return "4";
        else if (b.equalsIgnoreCase(". . . . ."))
            return "5";
        else if (b.equalsIgnoreCase("_ . . . ."))
            return "6";
        else if (b.equalsIgnoreCase("_ _ . . ."))
            return "7";
        else if (b.equalsIgnoreCase("_ _ _ . ."))
            return "8";
        else if (b.equalsIgnoreCase("_ _ _ _ ."))
            return "9";
        else
            return "";
         */
    }

    public String tranSentEngToMorse(String a) {
        String input = a, output = "";
        for (int i = 0; i < input.length(); i++) {
            output = output.concat(this.tranToMorse((String.valueOf(input.charAt(i)))));
        }
        return output;
    }

    public String tranSentMorseToEng(String b) {
        String input = b, output = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.contains("       ")) {
                String str1 = input.substring(0, input.indexOf("       ") + 3);
                String str2 = input.substring(input.indexOf("       ") + 4);
                input = str1 + "*" + str2;
            }
        }
        while (input.contains("   ")) {
            String inputChar = input.substring(0, input.indexOf("   "));
            output = output.concat(Translator.tranToEng(inputChar));
            input = input.substring(inputChar.length() + 3);
        }
        return output;
    }

    public static ArrayList<SymbolPair> getMorseList() {
        return morseListShort;
    }
}