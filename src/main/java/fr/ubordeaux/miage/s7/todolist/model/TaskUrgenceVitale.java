package fr.ubordeaux.miage.s7.todolist.model;

import java.util.List;
import java.util.PriorityQueue;

public  class TaskUrgenceVitale extends Task{

    public TaskUrgenceVitale(List<String> topics) {

        super(topics);
        this.taskCategory= TaskCategory.URGENCE_VITALE;

    }
    private static final String DESCRIPTION = "Urgence vitale";
    public String description() {
        return super.description() + DESCRIPTION;
    }
}
