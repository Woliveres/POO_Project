package fr.ubordeaux.miage.s7.todolist.model;

public class TaskException extends Exception{
    private static final long serialVersionUID = 1L;
    private TaskExceptionCode taskCategory;
    public TaskException(TaskExceptionCode code) {
        super(code.toString());
    }
}