package com.liyuncong.learn.simulatekeyboardmouse.winring0;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.google.common.base.Preconditions;

public class CommonUtils {

    private static String serverAddress = null;

    private CommonUtils() {
    }

    public static String base64(byte[] byts) {
        return new BASE64Encoder().encode(byts).replaceAll("\r", "").replaceAll("\n", "");
    }

    public static byte[] unbase64(String base64Str) {
        try {
            return new BASE64Decoder().decodeBuffer(base64Str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String encodeUrl(String url, String encode) {
        List<String> cnVals = RegexUtil.multiExtract(url, "([\u4e00-\u9fa5]+)", 1);
        if (cnVals != null && !cnVals.isEmpty()) {// 奇了个怪, 有时候只能编码一部分中文
            for (String cnVal : cnVals) {
                try {
                    url = url.replace(cnVal, URLEncoder.encode(cnVal, encode));
                } catch (UnsupportedEncodingException e) {
                    url = url.replace(cnVal, "");
                }
            }
        }
        List<String> emptyVals = RegexUtil.multiExtract(url, "([\\s　]+)", 1);
        if (emptyVals != null && !emptyVals.isEmpty()) {
            for (String emptyVal : emptyVals) {
                try {
                    url = url.replace(emptyVal, URLEncoder.encode(emptyVal, encode));
                } catch (UnsupportedEncodingException e) {
                    url = url.replace(emptyVal, "");
                }
            }
        }
        return url;
    }

    /**
     * 线程休眠
     * @author gebing
     * @date 2016年6月30日
     * @param timeUnit
     * @param slp
     */
    public static void thSleep(TimeUnit timeUnit, long slp) {
        try {
            TimeUnit.MILLISECONDS.sleep(TimeUnit.MILLISECONDS.convert(slp, timeUnit));
        } catch (Exception e) {
        }
    }

    public static String serverAddress() {
        if (serverAddress == null) {
            synchronized (CommonUtils.class) {
                if (serverAddress == null) {
                    serverAddress = System.getProperty("server.address");
                    if (StringUtils.isBlank(serverAddress)) {
                        serverAddress = System.getenv("server.address");
                    }
                }
            }
        }
        Preconditions.checkArgument(StringUtils.isNotBlank(serverAddress) && serverAddress.matches("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\:[0-9]+$"), "在启动之前需要设置环境变量: set server.address=ip:port, (server.address是指当前服务的ip与端口, ip必须是调用方能访问到的地址)");
        return serverAddress;
    }

    /**
     * 杀死驱动相关的所有进程
     * @param IEDriverServer.exe, chromedriver.exe
     * @author gebing
     * @date 2016年6月21日
     */
    public static void clearDriverProcess(String driverExe) {
        Process killProcess = null;
        try {
            killProcess = new ProcessBuilder().command("cmd.exe", "/c", "taskkill /F /T /IM " + driverExe).redirectErrorStream(true).start();
            killProcess.waitFor();
        } catch (Exception e) {
            // do nothing ignore it
        } finally {
            if (killProcess != null) {
                killProcess.destroy();
            }
        }
    }

    public static String randomString(int count) {
        return RandomStringUtils.random(count, "QWERTYUIOPASDFGHJKLZXCVBNM,.;[]=-+_!`~1234567890@#$%^&*()qwertyuiopasdfghjklzxcvbnm<>?/");
    }

    public static String randomNormalLetters(int count) {
        return RandomStringUtils.random(count, "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm");
    }

}
