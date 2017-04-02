package ua.kpi.tef;

import java.util.Scanner;

/**
 * Control passing correctly values and realize main task of program
 */
public class Controller {

    /**Fields of class */
    Model model;
    View view;

    /**Constructor-initialization*/
    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**Convert String[] args to one String*/
    private String RecordFromArgsToString(String[] args){

        StringBuffer allParametersCmd = new StringBuffer();

        for (int i = 0; i < args.length; i++) {
            allParametersCmd.append(args[i]);
            allParametersCmd.append(" ");
        }

        return allParametersCmd.toString();
    }

    /**
     * Checking parameters from CMD.
     * Returned false, if parameters were not transferred or are not correctly(not int),
     * else - returned true.
     */
    private boolean cmdParamIsCorrect(String[] args) {
        if (args.length != 0) {

            String allParametersCmd = RecordFromArgsToString(args);

            Scanner sc = new Scanner(allParametersCmd);

            for (int i = 0; i < args.length; i++) {

                if (!sc.hasNextInt()) {
                    model.setResultOfProgramsWork(view.LOOK_ARE_PARAMETERS_CORRECTLY);
                    return false;
                }
                sc.next();
            }
            sc.close();

            return true;
        } else {
            view.printMessage(view.PARAMS_WERE_NOT_TRANSFERRED);
            model.setResultOfProgramsWork(view.PARAMS_WERE_NOT_TRANSFERRED);
            return false;
        }
    }

    private int[] getNumbersTransferredCmd(String[] args){

        int[] numbersFromCmd = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            numbersFromCmd[i] = Integer.parseInt(args[i]);
        }

        return numbersFromCmd;
    }


    public void processUser(String[] args){
        if (cmdParamIsCorrect(args)) {
            model.setValuesFromCmd(getNumbersTransferredCmd(args));
            model.distributeValuesOfArray();
        }
        showResult();
    }

    /**Show distribution on console*/
     void showResult(){
        view.printMessage(view.DISTRIBUTION_OF_ARRAYS_VALUES);
        view.printMessage(model.getResultOfProgramsWork());
    }
}