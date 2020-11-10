package test.task2.view;

import test.task2.controller.Controller;

import java.io.IOException;
import java.sql.SQLException;


public class View {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void init () throws IOException, SQLException {
        System.out.println("Hello this is app to work with students database :");
        controller.acceptCommand();
    }
}
