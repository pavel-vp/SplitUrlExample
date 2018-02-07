package javatest.stringtest.state;

/**
 * Callback interface to StateManager
 *
 * Created by pasha on 07.02.18.
 */
public interface ISplitStateManager {
    String getUrl();
    int getLastPosition();
    void changeStateToNext(int newLastPosition);
}
