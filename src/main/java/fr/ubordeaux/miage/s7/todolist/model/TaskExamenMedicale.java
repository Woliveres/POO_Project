package fr.ubordeaux.miage.s7.todolist.model;

import java.util.List;

public class TaskExamenMedicale extends Task {


    public TaskExamenMedicale(List<String> topics) {
        super(topics);
        this.taskCategory=TaskCategory.EXAMEN;
    }
    private static final String DESCRIPTION = "Examen médical";
    public String description() {
         return super.description() + DESCRIPTION;
    }
}
