package ua.kpi.tef;

/**
 * Show message on console
 */
public class View{

    /**String constants*/
    public static final String PARAMS_WERE_NOT_TRANSFERRED = "Parameters were not transferred!";
    public static final String INTERVAL = "Interval ";
    public static final String NOT_BELONG_TO_THE_INTERVAL = "Not belong to the interval: ";
    public static final String DISTRIBUTION_OF_ARRAYS_VALUES = "Distribution of array's values:\n";
    public static final String LOOK_ARE_PARAMETERS_CORRECTLY = "Look, have you passed any parameters or are they correctly?";

    /**Print string message on console*/
    public void printMessage(String message){
        System.out.println(message);
    }

    /**Print reported array*/
    public void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}