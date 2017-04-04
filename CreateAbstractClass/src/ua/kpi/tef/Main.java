package ua.kpi.tef;

import ua.kpi.tef.controller.Controller;
import ua.kpi.tef.model.entity.Model;
import ua.kpi.tef.view.View;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);
        controller.processUserRecord();
    }
}
