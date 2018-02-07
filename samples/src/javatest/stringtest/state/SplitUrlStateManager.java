package javatest.stringtest.state;

/**
 * Main StateManager class.
 * Store all possible states and do the transition between them.
 *
 * Created by pasha on 07.02.18.
 */
public class SplitUrlStateManager implements ISplitStateManager {

    private int lastPosition = -1;

    private String url;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public int getLastPosition() {
        return lastPosition;
    }

    @Override
    public void changeStateToNext(int newLastPosition) {
        this.lastPosition = newLastPosition;
        if (state == STATE_SCHEME) {
            state = STATE_HOST;
        } else
            if (state == STATE_HOST) {
                state = STATE_PORT;
            } else
                if (state == STATE_PORT) {
                    state = STATE_PATH;
                } else
                if (state == STATE_PATH) {
                    state = STATE_PARAMS;
                } else
                if (state == STATE_PARAMS) {
                    state = null;
                }
    }

    final ISplitUrlState STATE_SCHEME = new State_Scheme(this);
    final ISplitUrlState STATE_HOST = new State_Host(this);
    final ISplitUrlState STATE_PORT = new State_Port(this);
    final ISplitUrlState STATE_PATH = new State_Path(this);
    final ISplitUrlState STATE_PARAMS = new State_Params(this);

    public ISplitUrlState getState() {
        return state;
    }

    private ISplitUrlState state;


    /**
     * Main method that runs state machine througt the states to parse URL.
     *
     * @param url
     * @return
     */
    public String[] splitUrlByState(String url) {
        if (url == null) {
            throw new IllegalArgumentException();
        }
        // starting state
        state = STATE_SCHEME;
        this.url = url;
        // run parsing
        String scheme = state.doParseScheme();
        String host = state.doParseHost();
        String port = state.doParsePort();
        String path = state.doParsePath();
        String params = state.doParseParams();

        return new String[] {scheme, host, port, path, params};
    }

}
