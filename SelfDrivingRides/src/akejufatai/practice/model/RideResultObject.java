package akejufatai.practice.model;

/**
 * Created by AKEJU  FATAI on 2018-03-03.
 */
public class RideResultObject {

    private Ride ride;
    private double value;

    public RideResultObject(Ride ride, double value){
        this.ride = ride;
        this.value = value;
    }

    public Ride getRide(){
        return ride;
    }

    public double getValue(){
        return value;
    }

}
