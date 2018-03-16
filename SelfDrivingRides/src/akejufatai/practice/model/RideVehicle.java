package akejufatai.practice.model;

/**
 * Created by AKEJU  FATAI on 2018-03-02.
 */
public class RideVehicle {

    private Ride ride;
    private Vehicle vehicle;

    public RideVehicle(Ride ride, Vehicle vehicle){
        this.ride = ride;
        this.vehicle = vehicle;
    }

    public Ride getRide() {
        return ride;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
