package test.task2;

import test.task2.controller.Controller;
import test.task2.models.Model;
import test.task2.view.View;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();
        view.setController(controller);
        controller.setModel(model);
        controller.setView(view);
        view.init();
    }
}
