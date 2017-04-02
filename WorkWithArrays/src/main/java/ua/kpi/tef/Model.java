package ua.kpi.tef;

/**
 * Program logic
 */

public class Model {

    /**Program logic*/
    private int[] valuesFromCmd;
    private int[] intervalsValues = new int[]{-100, 0, 20, 50, 100};
    private int[] countElementsOnInterval = new int[intervalsValues.length - 1];
    private int notBelongToInterval;

    private String resultOfProgramsWork;

    public void setValuesFromCmd(int[] array) {
        valuesFromCmd = array;
    }

    public int[] getValuesFromCmd() {
        return valuesFromCmd;
    }

    public void setCountElementsOnInterval(int[] array) {
        countElementsOnInterval = array;
    }

    public int[] getCountElementsOnInterval() {
        return countElementsOnInterval;
    }

    public void setIntervalsValues(int[] array){
        intervalsValues = array;
    }

    public int[] getIntervalsValues() {
        return intervalsValues;
    }

    public int getNotBelongToInterval() {
        return notBelongToInterval;
    }

    public void setNotBelongToInterval(int notBelongToInterval) {
        this.notBelongToInterval = notBelongToInterval;
    }

    public String getResultOfProgramsWork(){
        return resultOfProgramsWork;
    }

    public void setResultOfProgramsWork(String result){
        resultOfProgramsWork = result;
    }

    /**
     * Main task of WorkWithArrays
     *Distribute values of array depending on the its accessory to certain interval.
     */
    public void distributeValuesOfArray(){

            int[] intervalBounds = getIntervalsValues();
            int[] distributingValues = getValuesFromCmd();
            int[] distributedCount = new int[intervalBounds.length - 1];
            int unallocatedValues = distributingValues.length;

            for (int i = 0; i < distributingValues.length; i++) {

                for (int j = 0; j < intervalBounds.length - 1; j++) {
                    int leftLimit = intervalBounds[j], rightLimit = intervalBounds[j + 1];
                    if (distributingValues[i] > leftLimit && distributingValues[i] < rightLimit)
                        distributedCount[j]++;
                }
            }

            for (int i = 0; i < distributedCount.length; i++) {
                unallocatedValues -= distributedCount[i];
            }

            setCountElementsOnInterval(distributedCount);
            setNotBelongToInterval(unallocatedValues);
            makeStringResultOfWork();
    }

    /**Return string-distribution of elements of array depending on the different intervals*/
    private String makeStringResultForInterval(int numberOfInterval, int lLimit, int rLimit, int countElements){
        return ("Interval " + numberOfInterval + '(' + lLimit + "; "
                + rLimit + ')' + " - " + countElements + "\n");
    }

    /**Return string-result of all program's work to private field resultOfProgramsWork of Model*/
    private void makeStringResultOfWork(){
        StringBuffer resultOfWork = new StringBuffer();
        for (int i = 0; i < getIntervalsValues().length - 1; i++) {
            resultOfWork.append(makeStringResultForInterval(i + 1, getIntervalsValues()[i],
                    getIntervalsValues()[i + 1], getCountElementsOnInterval()[i]));
        }
        resultOfWork.append("Not belong to the interval: " + getNotBelongToInterval());

       setResultOfProgramsWork(resultOfWork.toString());
    }
}