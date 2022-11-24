package fr.ubordeaux.miage.s7.todolist.controller;

import fr.ubordeaux.miage.s7.todolist.model.Model;
import fr.ubordeaux.miage.s7.todolist.view.View;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

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
			id = ((MenuItem) source).getText();
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
				System.out.println("*** unimplemented case:  UIEventHandler.java(52)");
				//affiche la fenetre d'edition en fonction de l'id de l'element cliqué

				//view.showModalWindow(id);
			}
			model.notifyAllObservers();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
