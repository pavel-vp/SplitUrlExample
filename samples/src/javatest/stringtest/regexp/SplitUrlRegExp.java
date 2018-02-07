package javatest.stringtest.regexp;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pasha on 07.02.18.
 */
public class SplitUrlRegExp {

    // A regexp pattern
    private static Pattern pattern = Pattern.compile("(.*)://([^:^/]*)(:\\d*)?/([^?#]*)(\\?([^#]*)?)?");

    private static boolean isEmptyOrNull(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        return false;
    }

    private static void checkGoodURL(String scheme, String host, String path) {
        if (isEmptyOrNull(scheme) || isEmptyOrNull(host) || isEmptyOrNull(path) ) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method which do the regexp parse of the URL
     * @param url
     * @return
     */
    public static String[] splitUrlRegexp(String url) {

        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {

            String scheme = matcher.group(1);
            String host = matcher.group(2);
            String port = matcher.group(3);
            port = port != null && port.startsWith(":") ? port.substring(1) : port;
            String path = matcher.group(4);
            String params = matcher.group(5);
            params = params != null && params.startsWith("?") ? params.substring(1) : params;
            checkGoodURL(scheme, host, path);
            return new String[] {scheme, host, port, path, params};
        }
        throw new IllegalArgumentException();
    }



    @Test
    public void testSplitREG() {
        String t= "ftp://host:22222/papappa";
        String[] res = splitUrlRegexp(t);
        System.out.println(Arrays.toString(res));

    }
}
