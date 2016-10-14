package com.liyuncong.learn.simulatekeyboardmouse.winring0;

import java.util.concurrent.TimeUnit;

public class VirtualKeyBoard2 {

    private static final long SLP_PER_IO = 50;

    private static void sleep(long mills) {
        CommonUtils.thSleep(TimeUnit.MILLISECONDS, mills);
    }

    public static void keyDown(int key) {
        try {
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.CONTROL_PORT, 0xd2);
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.DATA_PORT, 0x60);
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.CONTROL_PORT, 0xd2);
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.DATA_PORT, key);
        } catch (Exception e) {
            throw new WinIOException(e);
        }
    }

    public static void keyUp(int key) {
        try {
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.CONTROL_PORT, 0xd2);
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.DATA_PORT, 0x60);
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.CONTROL_PORT, 0xd2);
            WinRing0API.kbcWait4IBE();
            WinRing0API.writeIoPortByteEx(WinRing0API.DATA_PORT, (key | 0x80));
        } catch (Exception e) {
            throw new WinIOException(e);
        }

    }

    public static void keyPress(int key, long ioSlpMills) {
        if (ioSlpMills <= 0) {
            ioSlpMills = SLP_PER_IO;
        }
        keyDown(key);
        sleep(ioSlpMills);
        keyUp(key);
//        sleep(ioSlpMills);
    }

    public static void keyPress(int key) {
        keyPress(key, SLP_PER_IO);
    }

    public static void keyPressEx(int key, long ioSlpMills) {
        if (ioSlpMills <= 0) {
            ioSlpMills = SLP_PER_IO;
        }
        keyDown(0x2a);// Press Down Shift
        sleep(ioSlpMills);
        keyDown(key);
        sleep(ioSlpMills);
        keyUp(key);
//        sleep(ioSlpMills);
        keyUp(0x2a);// Press Up Shift
//        sleep(ioSlpMills);
    }

    public static void keyPressEx(int key) {
        keyPressEx(key, SLP_PER_IO);
    }

    public static void keyPress(String input) {
        keyPress(input, SLP_PER_IO);
    }

    public static void keyPress(String input, long ioSlpMills) {
        if (input == null || input.length() == 0) {
            return;
        }
        sleep(ioSlpMills);
        Integer keycode;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            keycode = KeyScanCodeMapping.keyCodes.get(Character.toString(c));
            if (keycode != null) {
                keyPress(keycode, ioSlpMills);
            } else {
                keycode = KeyScanCodeMapping.exKeyCodes.get(Character.toString(c));
                if (keycode != null) {
                    keyPressEx(keycode, ioSlpMills);
                } else {
                    throw new WinIOException("Can't press the key [" + c + "]!");
                }
            }
        }
    }
}
