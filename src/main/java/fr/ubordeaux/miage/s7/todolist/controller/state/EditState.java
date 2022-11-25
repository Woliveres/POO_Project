package fr.ubordeaux.miage.s7.todolist.controller.state;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;

public class EditState extends State {
    private static EditState instance = new EditState();
    @Override
    public States getType() {
        return States.EDIT_STATE;
    }
    public static State getInstance() {
        return instance;
    }
    @Override
    public void handle(Controller controller, Action action) throws Exception {
        switch (action){
            case CANCEL_ACTION:
                controller.setCurrentState(InitState.getInstance());
                break;
            case RECORD_ACTION:
                controller.setCurrentState(RecordState.getInstance());
                break;
            default :
                throw new Exception("");
        }
    }
}
