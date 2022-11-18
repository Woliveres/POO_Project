module fr.ubordeaux.miage.s7.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.ubordeaux.miage.s7.todolist to javafx.fxml;
    exports fr.ubordeaux.miage.s7.todolist;
}