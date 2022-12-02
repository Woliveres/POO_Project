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

		ErrorState errorState;
		Task task;
		Model modelTodoList = (Model) observable;
	
		this.view.setStateLabel("currentState: " + this.currentState);

		System.out.print(getCurrentState().getType().ordinal());

		switch (currentState.getType()) {

			case INIT_STATE:
				this.view.hideModalWindow();
				this.view.hideModalMessageWindow();
				this.view.disableMenu_btn(false);
				if(model.getTaskDescriptions().size()>0){
					this.view.disableProceed_btn(false);
					this.view.setTextTodo_ta(model.getTaskDescriptions());
				}else {
					this.view.disableProceed_btn(true);
				}
				return;
			case ERROR_STATE:
				errorState = (ErrorState)this.model.getCurrentState();
				this.view.showModalMessageWindow("Erreur", errorState.getErrorMessage());
				return;

			case EDIT_STATE:
				//this.view.hideModalWindow();
				this.view.disableMenu_btn(true);
				this.view.disableProceed_btn(true);
				this.view.showModalWindow(this.model.getTaskFactory().name());
				return;

			case RECORD_STATE:
				this.view.hideModalWindow();
				this.view.disableMenu_btn(false);
				if(model.getTopics() != null){
					for (String str : model.getTopics()){
						this.model.getTaskFactory().addTopic(str);
					}
				}
				task = this.model.getTaskFactory().createTask();
				this.model.push(task);
				this.view.showModalMessageWindow("Message", "Enregistrée : " + task.description());
				return;

			case PROCEED_STATE:
				this.model.pop();
				this.view.setTextTodo_ta(model.getTaskDescriptions());
				this.view.showModalMessageWindow("Tâche en cours de traitement :", this.model.getCurrentTask().description());
				this.view.hideModalWindow();
				this.view.disableMenu_btn(false);
				return;

			default:
				break;
		}
		this.view.showModalMessageWindow("Erreur", "Erreur java");

	}

	public State getCurrentState() {
		return this.currentState;
	}

	public void setCurrentState(State currentState) {
		this.previousState = this.currentState;
		this.currentState = currentState;
	}

}
