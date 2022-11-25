package fr.ubordeaux.miage.s7.todolist.model;

import java.util.List;

public class TaskConsultationMedicale extends Task{

    public TaskConsultationMedicale(List<String> topics) {
        super(topics);
        this.taskCategory=TaskCategory.CONSULTATION_MEDICALE;
    }
    private static final String DESCRIPTION = "Consultation médical";
    public String description() {
        return super.description() + DESCRIPTION;
    }
}
