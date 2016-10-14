package com.liyuncong.learn.simulatekeyboardmouse.winring0;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RegexUtil {

    public static String singleExtract(String content, String regex, int groupIndex) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(groupIndex);
        }
        return null;
    }

    public static String singleExtract(String content, Pattern pattern, int groupIndex) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(groupIndex);
        }
        return null;
    }

    public static List<String> multiExtract(String content, String regex, int groupIndex) {
        if (StringUtils.isEmpty(content)) {
            return new ArrayList<String>();
        }
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            list.add(matcher.group(groupIndex));
        }
        return list;
    }

    public static String[] multiExtract(String content, String regex, int groupIndex, int arrayLength) {
        if (StringUtils.isEmpty(content)) {
            return new String[] {};
        }
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        String[] array = new String[arrayLength];
        int i = 0;
        while (matcher.find()) {
            array[i] = matcher.group(groupIndex);
            i++;
            if (i >= arrayLength)
                break;
        }
        return array;
    }

    public static MatchResult singleExtractToMatchResult(String content, String regex) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.toMatchResult();
        }
        return null;
    }

    public static List<MatchResult> multiExtractToMatchResult(String content, String regex) {
        if (StringUtils.isEmpty(content)) {
            return new ArrayList<MatchResult>();
        }
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        List<MatchResult> matchResults = new ArrayList<MatchResult>();
        while (matcher.find()) {
            matchResults.add(matcher.toMatchResult());
        }
        return matchResults;
    }

    public static List<MatchResult> multiExtractToMatchResult(String content, Pattern pattern) {
        if (StringUtils.isEmpty(content)) {
            return new ArrayList<MatchResult>();
        }
        Matcher matcher = pattern.matcher(content);
        List<MatchResult> matchResults = new ArrayList<MatchResult>();
        while (matcher.find()) {
            matchResults.add(matcher.toMatchResult());
        }
        return matchResults;
    }

    public static boolean match(String content, String regex) {
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        return matcher.find();
    }

    public static boolean match(String content, Pattern pattern) {
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        Matcher matcher = pattern.matcher(content);
        return matcher.find();
    }


}
