package fr.ubordeaux.miage.s7.todolist.model.state;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;

public class RecordState extends State {
    private static RecordState instance = new RecordState();
    @Override
    public States getType() {
        return States.RECORD_STATE;
    }
    public static State getInstance() {
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
}
