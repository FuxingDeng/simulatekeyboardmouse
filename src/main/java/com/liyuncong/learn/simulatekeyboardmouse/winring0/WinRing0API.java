package com.liyuncong.learn.simulatekeyboardmouse.winring0;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public class WinRing0API {

    public static final int CONTROL_PORT = 0x64;
    public static final int DATA_PORT = 0x60;

    static{
        if(!initializeWinRing0()){
            throw new ExceptionInInitializerError("Cannot Initialize the WinRing0");
        }
        int dllStatus = getDllStatus();
        if (dllStatus != 0) {
            throw new ExceptionInInitializerError("WinRing0 dll status wrong: " + dllStatus);
        }
        ShutdownHookUtils.hook(new Runnable() {

            @Override
            public void run() {
                try {
                    deinitializeOls();
                } catch (Exception e) {
                }
            }
        });
    }

    public static boolean initializeWinRing0() {
        return CWinRing0.INSTANCE.InitializeOls();
    }

    public interface CWinRing0 extends Library{
        CWinRing0 INSTANCE = (CWinRing0) Native.loadLibrary("WinRing0",CWinRing0.class);

        boolean InitializeOls();

        int GetDllStatus();

        boolean ReadIoPortByteEx(int portAddr, Pointer pPortVal);
        boolean ReadIoPortDwordEx(int portAddr, Pointer pPortVal);
        boolean WriteIoPortByteEx(int portAddr, int pPortVal);
        boolean WriteIoPortDwordEx(int portAddr, int pPortVal);

        void DeinitializeOls();
    }

    public static void kbcWait4IBE() throws Exception{
        int val=0;
        do {
            PointerByReference pointerByReference = new PointerByReference();
            Memory mymem = new Memory(8);
            pointerByReference.setPointer(mymem);
            Pointer pointer = pointerByReference.getPointer();
            if(!readIoPortByteEx(CONTROL_PORT,pointer)){
                throw new WinIOException("KBCWait4IBE: Cannot get the Port");
            }
            val = pointer.getInt(0);
        } while ((0x2&val)>0);
    }

    public static int getDllStatus() {
        return CWinRing0.INSTANCE.GetDllStatus();
    }

    public static boolean writeIoPortDwordEx(int portAddr, int pPortVal) {
        return CWinRing0.INSTANCE.WriteIoPortDwordEx(portAddr, pPortVal);
    }

    public static boolean writeIoPortByteEx(int portAddr, int pPortVal) {
        return CWinRing0.INSTANCE.WriteIoPortByteEx(portAddr, pPortVal);
    }

    public static void deinitializeOls() {
        CWinRing0.INSTANCE.DeinitializeOls();
    }

    public static boolean readIoPortDwordEx(int portAddr, Pointer pPortVal) {
        return CWinRing0.INSTANCE.ReadIoPortDwordEx(portAddr, pPortVal);
    }

    public static boolean readIoPortByteEx(int portAddr, Pointer pPortVal) {
        return CWinRing0.INSTANCE.ReadIoPortByteEx(portAddr, pPortVal);
    }


}
