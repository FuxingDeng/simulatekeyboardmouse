package com.liyuncong.learn.simulatekeyboardmouse.winring0;
import java.util.HashMap;
import java.util.Map;


public class KeyScanCodeMapping {
    /**
     * 一般按键
     */
    public static final Map<String, Integer> keyCodes = new HashMap<String,Integer>();

    /**
     * 按shift之后的按键
     */
    public static final Map<String, Integer> exKeyCodes=new HashMap<String,Integer>();

    static{
        keyCodes.put("a",0x1E);
        keyCodes.put("b",0x30);
        keyCodes.put("c",0x2E);
        keyCodes.put("d",0x20);
        keyCodes.put("e",0x12);
        keyCodes.put("f",0x21);
        keyCodes.put("g",0x22);
        keyCodes.put("h",0x23);
        keyCodes.put("i",0x17);
        keyCodes.put("j",0x24);
        keyCodes.put("k",0x25);
        keyCodes.put("l",0x26);
        keyCodes.put("m",0x32);
        keyCodes.put("n",0x31);
        keyCodes.put("o",0x18);
        keyCodes.put("p",0x19);
        keyCodes.put("q",0x10);
        keyCodes.put("r",0x13);
        keyCodes.put("s",0x1F);
        keyCodes.put("t",0x14);
        keyCodes.put("u",0x16);
        keyCodes.put("v",0x2F);
        keyCodes.put("w",0x11);
        keyCodes.put("x",0x2D);
        keyCodes.put("y",0x15);
        keyCodes.put("z",0x2C);
        keyCodes.put("0",0x0B);
        keyCodes.put("1",0x02);
        keyCodes.put("2",0x03);
        keyCodes.put("3",0x04);
        keyCodes.put("4",0x05);
        keyCodes.put("5",0x06);
        keyCodes.put("6",0x07);
        keyCodes.put("7",0x08);
        keyCodes.put("8",0x09);
        keyCodes.put("9",0x0A);
        keyCodes.put("`",0x29);
        keyCodes.put("-",0x0C);
        keyCodes.put("=",0x0D);
        keyCodes.put("\\",0x2B);
        keyCodes.put("[",0x1A);
        keyCodes.put("]",0x1B);
        keyCodes.put(";",0x27);
        keyCodes.put("'",0x28);
        keyCodes.put(",",0x33);
        keyCodes.put(".",0x34);
        keyCodes.put("/",0x35);
        keyCodes.put(" ",0x39);

        exKeyCodes.put("A",0x1E);
        exKeyCodes.put("B",0x30);
        exKeyCodes.put("C",0x2E);
        exKeyCodes.put("D",0x20);
        exKeyCodes.put("E",0x12);
        exKeyCodes.put("F",0x21);
        exKeyCodes.put("G",0x22);
        exKeyCodes.put("H",0x23);
        exKeyCodes.put("I",0x17);
        exKeyCodes.put("J",0x24);
        exKeyCodes.put("K",0x25);
        exKeyCodes.put("L",0x26);
        exKeyCodes.put("M",0x32);
        exKeyCodes.put("N",0x31);
        exKeyCodes.put("O",0x18);
        exKeyCodes.put("P",0x19);
        exKeyCodes.put("Q",0x10);
        exKeyCodes.put("R",0x13);
        exKeyCodes.put("S",0x1F);
        exKeyCodes.put("T",0x14);
        exKeyCodes.put("U",0x16);
        exKeyCodes.put("V",0x2F);
        exKeyCodes.put("W",0x11);
        exKeyCodes.put("X",0x2D);
        exKeyCodes.put("Y",0x15);
        exKeyCodes.put("Z",0x2C);
        exKeyCodes.put(")",0x0B);
        exKeyCodes.put("!",0x02);
        exKeyCodes.put("@",0x03);
        exKeyCodes.put("#",0x04);
        exKeyCodes.put("$",0x05);
        exKeyCodes.put("%",0x06);
        exKeyCodes.put("^",0x07);
        exKeyCodes.put("&",0x08);
        exKeyCodes.put("*",0x09);
        exKeyCodes.put("(",0x0A);
        exKeyCodes.put("~",0x29);
        exKeyCodes.put("_",0x0C);
        exKeyCodes.put("+",0x0D);
        exKeyCodes.put("|",0x2B);
        exKeyCodes.put("{",0x1A);
        exKeyCodes.put("}",0x1B);
        exKeyCodes.put(":",0x27);
        exKeyCodes.put("\"",0x28);
        exKeyCodes.put("<",0x33);
        exKeyCodes.put(">",0x34);
        exKeyCodes.put("?",0x35);

        // backspace键
        keyCodes.put("←", 0x0E);
    }
}
