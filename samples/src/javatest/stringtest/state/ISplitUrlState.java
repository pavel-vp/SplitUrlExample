package javatest.stringtest.state;

/**
 * Base interface, describes methods, that all states should implement
 *
 * Created by pasha on 07.02.18.
 */
public interface ISplitUrlState {
    String doParseScheme();
    String doParseHost();
    String doParsePort();
    String doParsePath();
    String doParseParams();
}
