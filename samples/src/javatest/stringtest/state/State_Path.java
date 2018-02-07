package javatest.stringtest.state;

/**
 * Created by pasha on 07.02.18.
 */
public class State_Path extends State_Base {
    public State_Path(ISplitStateManager stateManager) {
        super(stateManager);
    }

    @Override
    public String doParsePath() {
        String url= stateManager.getUrl();
        int position = stateManager.getLastPosition();
        int newPosition = url.indexOf("?", position);
        if (newPosition < 0) {
            newPosition = url.length();
        }
        stateManager.changeStateToNext(newPosition);
        String result = url.substring(position+1, newPosition);
        return result;
    }
}
