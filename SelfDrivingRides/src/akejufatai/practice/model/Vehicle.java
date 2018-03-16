package akejufatai.practice.model;

/**
 * Created by AKEJU  FATAI on 2018-03-01.
 */
public class Vehicle {

    private int id;
    private int x;
    private int y;

    private RideCollection rideCollection;

    public Vehicle(int id){
        this.id = id;
        this.x = 0;
        this.y = 0;
        rideCollection = new RideCollection();
    }

    public int getId(){
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void add(Ride ride){
        rideCollection.add(ride);
    }

    public RideCollection getRides(){
        return rideCollection;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(rideCollection.count());
        sb.append(" ");

        for(int index = 0; index < rideCollection.count(); index++){
            sb.append(rideCollection.get(index).getId());
            sb.append(" ");
        }

        return sb.toString();
    }

}
