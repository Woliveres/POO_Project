package fr.ubordeaux.miage.s7.todolist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;
import fr.ubordeaux.miage.s7.todolist.controller.IController;
import fr.ubordeaux.miage.s7.todolist.model.state.InitState;
import fr.ubordeaux.miage.s7.todolist.model.state.State;
import javafx.collections.ObservableList;

public class Model implements Observable {

	// Liste de priorité de tâches
	private PriorityQueue<Task> tasks;

	// L'état du modèle influencera ces observateurs.
	// Il n'y a qu'un seul observateur pour l'instant: la vue
	private TaskFactory taskFactory;
	private State currentState = InitState.getInstance();
	private List<IController> observers;
	private Task nextTask;
	private Task currentTask;

	private ObservableList<String> topics;

	/*
	 * Constructeur du modèle
	 */
	public Model() {
		// On initialise la liste des observateurs
		observers = new ArrayList<IController>();

		// On initialise la liste des tâches en indiquant
		// - La capacité initiale de 31 (elle augmentera automatiquement si besoin)
		// - La comparaison appliquée entre deux tâches
		tasks = new PriorityQueue<Task>(new TaskComparator<Task>());
		tasks.add(new TaskExamenMedicale(List.of(new String[]{"bonjour", "je suis william", "j'ai 35 ans"})));

	}
	public void push(Task paramTask) throws Exception {
	    if (!this.tasks.add(paramTask)) {
		     throw new TaskException(TaskExceptionCode.ALREADY_EXISTS);
		}
	}

	public void pop() throws Exception {
		 this.currentTask = this.tasks.poll();
	}

	@Override
	public void attach(IController observer) {
		this.observers.add(observer);
	}

	@Override
	public void notifyAllObservers() throws Exception {
		for (IController iController : this.observers) {
			iController.update(this);
		}
	}
	public Task getCurrentTask() {
	  return this.currentTask;
 	}

	public void setNextTask(Task paramTask) {
		 this.nextTask = paramTask;
	}
	public List<String> getTaskDescriptions() {
		Vector<String> vector = new Vector();
		for (Task task : this.tasks) {
			vector.add(task.description());
		}
		return vector;
	}
    public TaskFactory getTaskFactory() {
    	return this.taskFactory;
	}

 	 public void setTaskFactory(TaskCategory paramTaskCategory) {
	   this.taskFactory = new TaskFactory(paramTaskCategory);
  	 }

 	public void setTopics(ObservableList<String> paramObservableList) {
  		 this.topics = paramObservableList;
	}

	 public ObservableList<String> getTopics() {
	 	 return this.topics;
	 }

	 public Task getNextTask() {
	    return this.nextTask;
	 }

	 public State getCurrentState() {
	    return this.currentState;
	 }

	 public void setCurrentState(State paramState) {
		 this.currentState = paramState;
	 }
}




