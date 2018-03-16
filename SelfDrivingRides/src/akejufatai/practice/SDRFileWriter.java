package akejufatai.practice;

import akejufatai.practice.model.VehicleCollection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by AKEJU  FATAI on 2018-03-01.
 */
public class SDRFileWriter {

    private static final String outputFileName = "output.txt";

    public static void execute(VehicleCollection vehicleCollection){

        File file = new File(outputFileName);

        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            if(!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsolutePath(),false);
            bw = new BufferedWriter(fw);

            for(int vehicleIndex = 0; vehicleIndex < vehicleCollection.count(); vehicleIndex++){
                bw.write(vehicleCollection.get(vehicleIndex).toString()+ "\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(bw != null) bw.close();
                if(fw != null) fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

}
