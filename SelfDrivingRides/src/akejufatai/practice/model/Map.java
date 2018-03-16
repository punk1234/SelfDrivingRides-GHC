package akejufatai.practice.model;

/**
 * Created by AKEJU  FATAI on 2018-03-01.
 */
public class Map {

    private int rows;
    private int columns;

    private VehicleCollection vehicleCollection;
    private RideCollection rideCollection;

    public Map(int rows, int columns, VehicleCollection vehicleCollection, RideCollection rideCollection){
        this.rows = rows;
        this.columns = columns;
        this.vehicleCollection = vehicleCollection;
        this.rideCollection = rideCollection;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public VehicleCollection getVehicleCollection() {
        return vehicleCollection;
    }

    public RideCollection getRideCollection() {
        return rideCollection;
    }
}
