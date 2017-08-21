package Listeners;

import org.testng.IExecutionListener;
/**
 * Created by chitrang on 19/07/17.
 */
public class TestNGExecutionListener implements IExecutionListener {

    public void onExecutionStart() {
        System.out.println("TestNG is staring the execution");
    }

    public void onExecutionFinish() {
        System.out.println("Generating the Masterthought Report");
        GenerateReport.GenerateMasterthoughtReport();
        System.out.println("TestNG has finished, the execution");
    }
}

