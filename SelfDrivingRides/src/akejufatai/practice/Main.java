package akejufatai.practice;

import akejufatai.practice.model.SDRObject;
import akejufatai.practice.model.VehicleCollection;

public class Main {

    public static void main(String[] args) {

        // write your code here

        SDRObject sdrObject = SDRFileReader.execute();

        VehicleCollection vehicleCollection = SDRSimulator.run(sdrObject);

        SDRFileWriter.execute(vehicleCollection);

    }
}
