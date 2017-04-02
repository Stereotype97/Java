package ua.kpi.tef;

import ua.kpi.tef.controller.Controller;
import ua.kpi.tef.model.entity.Model;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUserRecord();

    }
}
