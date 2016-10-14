package com.liyuncong.learn.simulatekeyboardmouse.winring0;

import java.util.concurrent.ExecutorService;


public class ShutdownHookUtils {

    public static void hook(final ExecutorService executor, final boolean now) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {

                if (executor != null) {
                    if (now) {
                        executor.shutdownNow();
                    } else {
                        executor.shutdown();
                    }
                }

            }
        }));
    }

    public static void hook(Runnable runnable) {
        Runtime.getRuntime().addShutdownHook(new Thread(runnable));
    }

}
