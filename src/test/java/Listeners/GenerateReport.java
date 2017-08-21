package Listeners;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chitrang natu on 21/12/15.
 */
public class GenerateReport {
    public static void GenerateMasterthoughtReport(){
        try{
            String RootDir = System.getProperty("user.dir");
            File reportOutputDirectory = new File("target/Masterthought");
            File folder = new File("target/cucumber-parallel");
            File[] listOfFiles = folder.listFiles();
            String buildNumber = "1";
            String projectName = "cucumberProject";
            boolean runWithJenkins = false;
            boolean parallelTesting = true;
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    //System.out.println("File " + listOfFiles[i].getName());
                    list.add("target/cucumber-parallel/" + listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }


            Configuration configuration = new Configuration(reportOutputDirectory, projectName);

            configuration.setParallelTesting(parallelTesting);
            configuration.setRunWithJenkins(runWithJenkins);
            configuration.setBuildNumber(buildNumber);
//
//            boolean skippedFails = true;
//            boolean pendingFails = true;
//            boolean undefinedFails = true;
//            boolean missingFails = true;
//            boolean flashCharts = true;

//            boolean highCharts = false;

//            boolean artifactsEnabled = false;
//            String artifactConfig = "";

            ReportBuilder reportBuilder = new ReportBuilder(list,configuration);

            reportBuilder.generateReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
