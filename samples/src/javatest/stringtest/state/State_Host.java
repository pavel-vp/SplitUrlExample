package javatest.stringtest.state;

/**
 * Created by pasha on 07.02.18.
 */
public class State_Host extends State_Base {
    public State_Host(ISplitStateManager stateManager) {
        super(stateManager);
    }

    @Override
    public String doParseHost() {
        String url= stateManager.getUrl();
        int position = stateManager.getLastPosition() + 3;
        int positionNext = url.indexOf(":", position);
        if (positionNext < 0) {
            positionNext = url.indexOf("/", position);
        }
        if (position < 0) {
            throw new IllegalArgumentException();
        }
        String result = url.substring(position, positionNext);
        if ("".equals(result)) {
            throw new IllegalArgumentException();
        }
        stateManager.changeStateToNext(positionNext);
        return result;
    }
}
