package com.liyuncong.learn.simulatekeyboardmouse.winring0;

public class WinIOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WinIOException() {
        super();
    }

    public WinIOException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WinIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public WinIOException(String message) {
        super(message);
    }

    public WinIOException(Throwable cause) {
        super(cause);
    }

}
