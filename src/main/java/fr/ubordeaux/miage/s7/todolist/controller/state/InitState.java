package fr.ubordeaux.miage.s7.todolist.controller.state;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;
import fr.ubordeaux.miage.s7.todolist.model.Model;

public class InitState extends State{

    private static InitState instance = new InitState();
    @Override
    public States getType() {
        return States.INIT_STATE;
    }
    public static State getInstance() {
        return instance;
    }
    @Override
    public void handle(Controller controller, Action action) throws Exception {
        switch (action){
            default:
                throw new Exception();
            case SELECT_ACTION:
                controller.setCurrentState(EditState.getInstance());
                break;
            case PROCEED_ACTION:
                controller.setCurrentState(ProceedState.getInstance());
                break;
        }
    }
}
