package fr.ubordeaux.miage.s7.todolist.model.state;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;

public class ProceedState extends State {
    private static ProceedState instance = new ProceedState();
    @Override
    public States getType() {
        return States.PROCEED_STATE;
    }
    public static State getInstance() {
        return instance;
    }
    @Override
    public void handle(Controller controller, Action action) throws Exception {
        switch (action){
            case OK_ACTION:
                controller.setCurrentState(InitState.getInstance());
                break;
            case ERROR_ACTION:
                controller.setCurrentState(ErrorState.getInstance("Error proceed_state"));
            default:


        }
    }
}
