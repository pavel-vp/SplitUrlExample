package javatest.stringtest.state;

/**
 * Created by pasha on 07.02.18.
 */
public class State_Scheme extends State_Base {

    public State_Scheme(ISplitStateManager stateManager) {
        super(stateManager);
    }

    @Override
    public String doParseScheme() {
        String url= stateManager.getUrl();
        int position = url.indexOf("://");
        String result = url.substring(0, position);
        stateManager.changeStateToNext(position);
        return result;
    }
}
