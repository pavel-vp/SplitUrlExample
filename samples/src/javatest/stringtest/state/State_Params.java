package javatest.stringtest.state;

/**
 * Created by pasha on 07.02.18.
 */
public class State_Params extends State_Base {
    public State_Params(ISplitStateManager stateManager) {
        super(stateManager);
    }

    @Override
    public String doParseParams() {
        String url= stateManager.getUrl();
        int position = stateManager.getLastPosition();
        int newPosition = url.length();
        String result = url.substring(Math.min(position+1, url.length()), newPosition);
        stateManager.changeStateToNext(newPosition);
        return result;
    }
}
