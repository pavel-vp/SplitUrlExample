package javatest.stringtest.state;

/**
 * Created by pasha on 07.02.18.
 */
public class State_Port extends State_Base {
    public State_Port(ISplitStateManager stateManager) {
        super(stateManager);
    }

    @Override
    public String doParsePort() {
        String url= stateManager.getUrl();
        int position = stateManager.getLastPosition();
        int positionNew = -1;
        if (":".equals(url.substring(position, position+1))) {
            positionNew = url.indexOf("/", position);
        }
        if (positionNew < 0) {
            positionNew = position;
        }
        stateManager.changeStateToNext(positionNew);
        return url.substring(Math.min(position+1, positionNew), positionNew);
    }
}
