package fr.ubordeaux.miage.s7.todolist.model;

import java.util.List;

public class TaskUrgenceMedicale extends Task{
    public TaskUrgenceMedicale(List<String> topics) {
        super(topics);
        this.taskCategory=TaskCategory.URGENCE_MEDICALE;
    }
    private static final String DESCRIPTION = "Urgence médical";
    public String description() {
        return super.description() + DESCRIPTION;
    }
}
