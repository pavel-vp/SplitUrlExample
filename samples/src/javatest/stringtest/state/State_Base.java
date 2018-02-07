package javatest.stringtest.state;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Base root class of states. Need for less boilerplate code in descendants
 *
 * Created by pasha on 07.02.18.
 */
public abstract class State_Base implements ISplitUrlState {

    protected ISplitStateManager stateManager;

    public State_Base(ISplitStateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public String doParseScheme() { throw new NotImplementedException(); }
    @Override
    public String doParseHost() { throw new NotImplementedException(); }
    @Override
    public String doParsePort() { throw new NotImplementedException(); }
    @Override
    public String doParsePath() { throw new NotImplementedException(); }
    @Override
    public String doParseParams() { throw new NotImplementedException(); }
}
