package fr.ubordeaux.miage.s7.todolist.model.state;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;

public class ErrorState extends State{
    private static ErrorState instance = new ErrorState();
    private String message;
    @Override
    public States getType() {
        return States.ERROR_STATE;
    }
    public static State getInstance(String paramString) {
        instance.message = paramString;
        return instance;
    }
    @Override
    public void handle(Controller controller, Action action) throws Exception {
        switch (action){
            default:
                throw new Exception();
            case OK_ACTION:
                controller.setCurrentState(InitState.getInstance());
                break;
        }
    }

    public String getErrorMessage() {
    return this.message;
    }
}
