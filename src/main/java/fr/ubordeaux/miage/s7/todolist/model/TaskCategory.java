package fr.ubordeaux.miage.s7.todolist.model;

public enum TaskCategory {

	URGENCE_VITALE(Priority.HIGH),
	//on pourra rajouter urgence médicale
	CONSULTATION_MEDICALE(Priority.MEDIUM),
	EXAMEN(Priority.LOW);

	private Priority priority;

	TaskCategory(Priority priority) {
		this.priority = priority;
	}

	int getPriority() {
		return priority.getValue();
	}
};


