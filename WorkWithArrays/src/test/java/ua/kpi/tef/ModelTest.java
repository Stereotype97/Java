package ua.kpi.tef;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Dima Skorobogatskii on 12.03.2017.
 */
public class ModelTest {

    Model model = new Model();

    String result;
    int[] args;
    int[] intervalBounds;

    /**First test -- correctly work*/
    @Test
    public void firstTestMakeStringResultOfWork() {

        args = new int[]{1, 4, 3, 1, 5, 80, 142};
        model.setValuesFromCmd(args);

        model.distributeValuesOfArray();
        result = model.getResultOfProgramsWork();
        assertEquals(result,
                "Interval 1(-100; 0) - 0\n" +
                        "Interval 2(0; 20) - 5\n" +
                        "Interval 3(20; 50) - 0\n" +
                        "Interval 4(50; 100) - 1\n" +
                        "Not belong to the interval: 1");
    }

    /**Second test -- changed intervals values*/
    @Test
    public void secondTestMakeStringResultOfWork() {

        args = new int[]{1, -4, 23, 3, 0, -80, 42, 423};
        intervalBounds = new int[]{-10, 0, 10, 20, 50};
        model.setValuesFromCmd(args);
        model.setIntervalsValues(intervalBounds);

        model.distributeValuesOfArray();
        result = model.getResultOfProgramsWork();
        assertEquals(result,
                "Interval 1(-10; 0) - 1\n" +
                        "Interval 2(0; 10) - 2\n" +
                        "Interval 3(10; 20) - 0\n" +
                        "Interval 4(20; 50) - 2\n" +
                        "Not belong to the interval: 3");
    }

}
