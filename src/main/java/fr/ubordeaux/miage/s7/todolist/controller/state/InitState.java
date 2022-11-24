package fr.ubordeaux.miage.s7.todolist.controller.state;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;

public class InitState extends State{
    @Override
    public States getType() {
        return States.INIT_STATE;
    }

    @Override
    public void handle(Controller controller, Action action) throws Exception {
        switch (action){
            case SELECT_ACTION:
                //faire un singleton pour ne pas le créer dans tout les cas
                //controller.setCurrentState(new EditState);
        }
    }
}
