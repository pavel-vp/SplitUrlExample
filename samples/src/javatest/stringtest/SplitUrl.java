package javatest.stringtest;

import javatest.stringtest.regexp.SplitUrlRegExp;
import javatest.stringtest.state.SplitUrlStateManager;

import java.util.Calendar;

/**
 * Created by pasha on 07.02.18.
 */
public class SplitUrl {
    public static void main(String[] args) {
        String url = args[0];
        long timeStamp = Calendar.getInstance().getTimeInMillis();
        String[] result = null;
        for (int i = 0;i<10000;++i) {
            result = SplitUrlRegExp.splitUrlRegexp(url);
        }
        long timeRegexp = Calendar.getInstance().getTimeInMillis() - timeStamp;

        timeStamp = Calendar.getInstance().getTimeInMillis();
        SplitUrlStateManager sm = new SplitUrlStateManager();
        for (int i = 0;i<10000;++i) {
            result = sm.splitUrlByState(url);
        }
        long timeState = Calendar.getInstance().getTimeInMillis() - timeStamp;
        for (String s : result) {
                if (s != null) {
                    System.out.println(s);
                }
        }
        System.out.println("Regexp: " + timeRegexp + "ms");
        System.out.println("State: " + timeState + "ms");
    }
}
