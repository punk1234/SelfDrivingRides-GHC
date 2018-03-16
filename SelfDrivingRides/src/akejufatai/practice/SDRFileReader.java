package akejufatai.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import akejufatai.practice.model.*;

/**
 * Created by AKEJU  FATAI on 2018-03-01.
 */
public class SDRFileReader {

    // private static final String fileName = "./input/a_example.in";
    // private static final String fileName = "./input/b_should_be_easy.in";
    // private static final String fileName = "./input/c_no_hurry.in";
    private static final String fileName = "./input/d_metropolis.in";
    // private static final String fileName = "./input/e_high_bonus.in";

    private static final String space = " ";

    public static SDRObject execute(){

        File sdrFile = new File(fileName);
        if(sdrFile.exists()){

            try{
                Scanner input = new Scanner(sdrFile);

                String firstLine = input.nextLine();
                String[] firstLineSplit = firstLine.split(space);

                int r = toInt(firstLineSplit[0]);
                int c = toInt(firstLineSplit[1]);
                int f = toInt(firstLineSplit[2]);
                int n = toInt(firstLineSplit[3]);
                int b = toInt(firstLineSplit[4]);
                int t = toInt(firstLineSplit[5]);

                RideCollection rideCollection = new RideCollection(n);

                /****************Generate rides***********************/
                for(int index = 0; index < n; index++){
                    String line = input.nextLine();
                    String[] lineSplit = line.split(space);
                    int sx = toInt(lineSplit[0]);
                    int sy = toInt(lineSplit[1]);
                    int ex = toInt(lineSplit[2]);
                    int ey = toInt(lineSplit[3]);
                    int s = toInt(lineSplit[4]);
                    int lf = toInt(lineSplit[5]);

                    Intersection startIntersection = new Intersection(sx,sy);
                    Intersection endIntersection = new Intersection(ex,ey);

                    Ride ride = new Ride(index,startIntersection,endIntersection,s,lf);
                    rideCollection.add(ride);
                }

                /****************Generate vehicles***********************/
                VehicleCollection vehicleCollection = new VehicleCollection(f);
                for(int index = 0; index < f; index++){
                    Vehicle vehicle = new Vehicle(index+1);
                    vehicleCollection.set(index,vehicle);
                }

                Map map = new Map(r,c,vehicleCollection,rideCollection);

                return new SDRObject(map,b,t);

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(StringIndexOutOfBoundsException e){
                e.printStackTrace();
            }

        }

        return null;

    }

    private static int toInt(String value){

        return Integer.parseInt(value);

    }

}
