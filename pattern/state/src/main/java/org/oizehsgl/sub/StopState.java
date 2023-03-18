package org.oizehsgl.sub;

/**
 * stopState
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class StopState extends AbstractState {


    public StopState(Context context) {
        super(context);
    }

    @Override
    public void doAction() {
        System.out.println(this.getClass().getSimpleName());
        context.setState(context.startState);
    }
}
