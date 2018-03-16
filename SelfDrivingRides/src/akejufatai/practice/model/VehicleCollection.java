package akejufatai.practice.model;

/**
 * Created by AKEJU  FATAI on 2018-03-01.
 */
public class VehicleCollection {

    private Vehicle[] content;

    public VehicleCollection(int count){

        content = new Vehicle[count];

    }

    public void set(int index, Vehicle vehicle){
        content[index] = vehicle;
    }

    public Vehicle get(int index){
        return content[index];
    }

    public int count(){
        return content.length;
    }

}
