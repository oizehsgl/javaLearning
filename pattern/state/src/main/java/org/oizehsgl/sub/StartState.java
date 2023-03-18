package org.oizehsgl.sub;

/**
 * startState
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class StartState extends AbstractState {
    public StartState(Context context) {
        super(context);
    }

    @Override
    public void doAction() {
        System.out.println(this.getClass().getSimpleName());
        context.setState(context.stopState);
    }
}
