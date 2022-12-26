package fr.ubordeaux.miage.s7.todolist.controller;

import fr.ubordeaux.miage.s7.todolist.model.state.Action;
import fr.ubordeaux.miage.s7.todolist.model.Model;
//import fr.ubordeaux.miage.s7.todolist.model.TaskFactory;
import fr.ubordeaux.miage.s7.todolist.view.View;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import fr.ubordeaux.miage.s7.todolist.model.TaskCategory;

public class UIEventHandler implements EventHandler<Event> {

	private Model model;
	private View view;
	private Controller controller;

	public UIEventHandler(Controller controller) {
		this.controller = controller;
		this.model = controller.model;
		this.view = controller.view;
	}

	@Override
	public void handle(Event event) {
		/*
		 * On récupère l'objet qui a émis cet événement. Selon cet identifiant, on
		 * modifie le modèle en conséquence.
		 * 
		 */

		String id = null;

		Object source = event.getSource();
		if (source instanceof MenuItem) {
			id = ((MenuItem) source).getId();
			//controller.setCurrentState(controller.getCurrentState());


		} else if (source instanceof Button) {
			id = ((Button) source).getId();

		} else if (source instanceof ListView) {
			System.err.println("**** ListView: " + view.dialog_ressources());
			//model.setTopics(view.dialog_ressources());

		} else {
			System.err.println("**** Error: unexpected case: " + source.getClass().getName());
		}

		try {
			if (id != null) {
				//affiche la fenetre d'edition en fonction de l'id de l'element cliqué

				//view.showModalWindow(id);
				switch(id){
					case "menuItem1":
						this.model.setTaskFactory(TaskCategory.URGENCE_VITALE);
						this.controller.getCurrentState().handle(this.controller, Action.SELECT_ACTION);
						break;
					case "menuItem2":
						this.model.setTaskFactory(TaskCategory.CONSULTATION_MEDICALE);
						this.controller.getCurrentState().handle(this.controller,Action.SELECT_ACTION);
						break;
					case "menuItem3":
						this.model.setTaskFactory(TaskCategory.EXAMEN);
						this.controller.getCurrentState().handle(this.controller,Action.SELECT_ACTION);
						break;
					case "dialog_ok_btn":
						this.controller.getCurrentState().handle(this.controller,Action.RECORD_ACTION);
						break;
					case "dialog_cancel_btn":
						this.controller.getCurrentState().handle(this.controller,Action.CANCEL_ACTION);
						break;
					case "dialog_error_ok_btn":
						this.controller.getCurrentState().handle(this.controller,Action.OK_ACTION);
						break;
					case "proceed_btn":
						this.controller.getCurrentState().handle(this.controller,Action.PROCEED_ACTION);
						break;

					default:
						System.err.println("Erreur :"+ id);
				}
			}
			model.notifyAllObservers();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
