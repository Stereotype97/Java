package ua.kpi.tef;

/**
 * Create 06.03.2017 by Dima Skorobogatskii
 * method main()
 */

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser(args);
    }
}
