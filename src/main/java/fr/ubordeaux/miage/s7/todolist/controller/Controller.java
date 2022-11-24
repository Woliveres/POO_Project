package fr.ubordeaux.miage.s7.todolist.controller;

import fr.ubordeaux.miage.s7.todolist.controller.state.*;
import fr.ubordeaux.miage.s7.todolist.model.*;
import fr.ubordeaux.miage.s7.todolist.view.*;
import javafx.stage.Stage;

/*
 * Le contrôleur compose le modèle et la vue
 * 
 * On construit un lien de type observeur 
 * entre les éléments interactifs de la vue 
 * (boutons, zone de texte, etc) et le contrôleur (les ***EventHandler)
 * 
 * On construit un second lien de type observeur
 * entre le contrôleur et la vue. La vue doit être mise à jour automatiquement
 * par l'envoi de message update ci-dessous.
 * 	
*/
public class Controller implements IController {
	Model model;
	View view;
	private State previousState;
	private State currentState;

	public Controller(Stage stage) throws Exception {
		currentState = new InitState();
		model = new Model();
		view = new View(stage);
		view.init(this);
		view.show();
		view.setStateLabel(currentState.toString());
		model.attach(this);
		model.notifyAllObservers();
	}

	// Envoie des messages à la vue
	// pour que celle-ci soit conforme au modèle
	public void update(Observable observable) throws Exception {
		
		Model modelTodoList = (Model) observable;
	
		view.setStateLabel("currentState: " + this.currentState);

		switch (currentState.getType()) {

			default:

				break;

		}

	}

	public State getCurrentState() {
		return this.currentState;
	}

	public void setCurrentState(State currentState) {
		this.previousState = this.currentState;
		this.currentState = currentState;
	}

}
