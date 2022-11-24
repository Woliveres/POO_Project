package fr.ubordeaux.miage.s7.todolist.controller.state;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;

public class EditState extends State {
    @Override
    public States getType() {
        return States.EDIT_STATE;
    }

    @Override
    public void handle(Controller controller, Action action) throws Exception {
        switch (action){
            case CANCEL_ACTION:
                //faire un singleton pour ne pas le créer dans tout les cas
                controller.setCurrentState(new InitState());
                break;
            case RECORD_ACTION:
                //faire un singleton pour ne pas le créer dans tout les cas
                controller.setCurrentState(new RecordState());
                break;
            default :
                throw new Exception("");
        }
    }
}
