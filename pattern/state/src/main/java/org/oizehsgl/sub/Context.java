package org.oizehsgl.sub;

/**
 * context
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class Context implements State {

    private State state;

    public State stopState = new StopState(this);
    public State startState = new StartState(this);

    public Context() {
        this.state = startState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public void doAction() {
        this.state.doAction();
    }
}