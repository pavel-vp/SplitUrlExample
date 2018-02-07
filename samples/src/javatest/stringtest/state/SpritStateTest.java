package javatest.stringtest.state;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Just tests
 *
 * Created by pasha on 07.02.18.
 */
public class SpritStateTest {

    SplitUrlStateManager sm;

    @Before
    public void setUp() {
        sm = new SplitUrlStateManager();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSplitState_null() {
        String[] res = sm.splitUrlByState(null);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testSplitState_url1() {
        String url = "ftp://host:port/path?params";
        String[] res = sm.splitUrlByState(url);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testSplitState_url2() {
        String url = "ftp://host:port/pathparams";
        String[] res = sm.splitUrlByState(url);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testSplitState_url3() {
        String url = "ftp://hostport/pathparams";
        String[] res = sm.splitUrlByState(url);
        System.out.println(Arrays.toString(res));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSplitState_url4() {
        String url = "ftp://:port/pathparams";
        String[] res = sm.splitUrlByState(url);
        System.out.println(Arrays.toString(res));
    }
}
