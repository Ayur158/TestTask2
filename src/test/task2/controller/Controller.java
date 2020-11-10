package test.task2.controller;

import test.task2.models.Model;
import test.task2.view.View;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    private Model model;
    private View view;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
    public void acceptCommand() throws IOException, SQLException {
        model.getCommand();
    }
    public void show() throws SQLException {
        model.show();
    }
    public void add() throws IOException, SQLException {
        model.add();
    }
    public void delete() throws IOException, SQLException {
        model.delete();
    }
}
