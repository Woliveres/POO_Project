package fr.ubordeaux.miage.s7.todolist.model;

import java.util.List;
import java.util.PriorityQueue;

public  class TaskUrgenceVitale extends Task{

    public TaskUrgenceVitale(List<String> topics) {

        super(topics);
        //comment attacher la catégorie
        //taskCategory= new TaskCategory(Priority.HIGH);

    }
}
