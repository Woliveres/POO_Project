package fr.ubordeaux.miage.s7.todolist.model;

import fr.ubordeaux.miage.s7.todolist.controller.Controller;

import java.util.List;
import java.util.Vector;

public class TaskFactory {
    private TaskCategory taskCategory;

    public TaskFactory(TaskCategory paramTaskCategory) {
        this.taskCategory = paramTaskCategory;
        this.topics = new Vector<>();
    }

    private List<String> topics;

    public Task createTask() {
        switch (this.taskCategory) {
            case URGENCE_VITALE:
                return (Task) new TaskUrgenceVitale(this.topics);
            case URGENCE_MEDICALE:
                //pas sur du cast
                return (Task) new TaskUrgenceMedicale(this.topics);
            case CONSULTATION_MEDICALE:
                return (Task) new TaskConsultationMedicale(this.topics);
            case EXAMEN:
                return (Task) new TaskExamenMedicale(this.topics);
        }
        return null;
    }

    public String name() {
        return this.taskCategory.name();
    }

    public void addTopic(String paramString) {
        this.topics.add(paramString);
    }
}
