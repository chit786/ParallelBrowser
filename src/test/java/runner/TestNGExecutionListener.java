package runner;

import org.testng.IExecutionListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by amit.rawat on 06/01/16.
 */
public class TestNGExecutionListener implements IExecutionListener {
    private Process p;
    public void onExecutionStart() {

        System.out.println("TestNG is staring the execution");
       // executeCommand("docker run --rm -ti --name zalenium -p 4444:4444 -p 5555:5555     -e DOCKER=1.11     -v /var/run/docker.sock:/var/run/docker.sock     -v /tmp/videos:/home/seluser/videos     --privileged dosel/zalenium start");

    }

    public void onExecutionFinish() {
        System.out.println("Generating the Masterthought Report");
        GenerateReport.GenerateMasterthoughtReport();
        System.out.println("TestNG has finished, the execution");
    }

    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();


        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

    private void killCommand(){

        StringBuffer output = new StringBuffer();


        try {
            p = Runtime.getRuntime().exec("");
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}