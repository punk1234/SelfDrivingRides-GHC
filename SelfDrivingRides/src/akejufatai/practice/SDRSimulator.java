package akejufatai.practice;

import akejufatai.practice.model.*;

/**
 * Created by AKEJU  FATAI on 2018-03-02.
 */
public class SDRSimulator {

    private static final int topRides = 100;
    private static int perBonusRide;
    private static int steps;

    public static VehicleCollection run(SDRObject sdrObject){

        Map map = sdrObject.getMap();
        perBonusRide = sdrObject.getPerBonusRide();
        steps = sdrObject.getSteps();

        Integer time = 0;

        VehicleCollection vc = map.getVehicleCollection();
        RideCollection rc = map.getRideCollection();
        // rc.sort();

        final Vehicle tv = new Vehicle(0);

        int vehicleIndex = 0;
        while(true){

            Vehicle vehicle = vc.get(vehicleIndex);
            RideResultObject vRRO = getRideResultObject(vehicle,rc,time);

            if(vehicleIndex < vc.count()){
                RideResultObject tvRRO = getRideResultObject(tv,rc,time);

                if(vRRO.getValue() >= tvRRO.getValue()){
                    int nextTime = makeRide(vehicle,vRRO.getRide(),time);
                    if(nextTime == time){
                        break;
                    }
                    vehicle.add(vRRO.getRide());
                    rc.remove(vRRO.getRide());
                }
                else{
                    if((vehicleIndex+1) < vc.count()){
                        vehicleIndex++;
                    }
                    Vehicle nextVehicle = vc.get(vehicleIndex);
                    int nextTime = makeRide(nextVehicle,tvRRO.getRide(),time);
                    if(nextTime == time){
                        break;
                    }
                    nextVehicle.add(tvRRO.getRide());
                    rc.remove(tvRRO.getRide());
                }
            }
            else{
                int nextTime = makeRide(vehicle,vRRO.getRide(),time);
                if(nextTime == time){
                    break;
                }
                vehicle.add(vRRO.getRide());
                rc.remove(vRRO.getRide());
            }

            eliminateExpiredRides(rc,time);

            if(rc.count() == 0){
                break;
            }

        }

        return vc;

    }

    public static RideResultObject getRideResultObject(Vehicle vehicle, RideCollection rideCollection, int time){

        RideCollection topRideCollection = rideCollection.getTop(topRides);

        double maxValue = Integer.MIN_VALUE;
        Ride r = null;

        for(int rideIndex = 0; rideIndex < topRideCollection.count(); rideIndex++){
            Ride ride = topRideCollection.get(rideIndex);

            double currentValue = getValue(ride,vehicle,time);
            if(currentValue > maxValue){
                maxValue = currentValue;
                r = ride;
            }

        }

        if(r == null){
            return null;
        }

        return new RideResultObject(r,maxValue);

    }

    private static void eliminateExpiredRides(RideCollection rideCollection, int time){

        int index = 0;
        while(index < rideCollection.count()){
            Ride ride = rideCollection.get(index);
            if(ride.getLatestFinish() <= time){
                rideCollection.remove(index);
                continue;
            }
            index++;
        }

    }



    private static Integer makeRide(Vehicle vehicle, Ride ride, Integer time){
        int distanceFromVehicleToStartPoint = getDistance(ride.getStart().getX(),ride.getStart().getY(),vehicle.getX(),vehicle.getY());
        int rideDistance = ride.getDistance();
        int wait = 0;

        int timeAtStartPoint = time + distanceFromVehicleToStartPoint;
        if(timeAtStartPoint <= ride.getEarliestStart()){
            wait = ride.getEarliestStart() - timeAtStartPoint;
        }

        int usedTime = distanceFromVehicleToStartPoint + wait + rideDistance;
        int nextTime = time + usedTime;

        if(nextTime > steps){
            return time;
        }

        time = nextTime;
        vehicle.setX(ride.getEnd().getX());
        vehicle.setY(ride.getEnd().getY());
        return time;
    }

    public static RideVehicle getNextRideVehiclePair(RideCollection rideCollection, VehicleCollection vehicleCollection, int time){

        RideCollection topRideCollection = rideCollection.getTop(topRides);

        double maxValue = Integer.MIN_VALUE;
        Ride r = null;
        Vehicle v = null;

        for(int rideIndex = 0; rideIndex < topRideCollection.count(); rideIndex++){
            Ride ride = topRideCollection.get(rideIndex);
            for(int vehicleIndex = 0; vehicleIndex < vehicleCollection.count(); vehicleIndex++){
                Vehicle vehicle = vehicleCollection.get(vehicleIndex);
                double currentValue = getValue(ride,vehicle,time);
                if(currentValue > maxValue){
                    maxValue = currentValue;
                    r = ride;
                    v = vehicle;
                }
            }
        }

        if(r == null && v == null){
            return null;
        }

        return new RideVehicle(r,v);

    }

    public static double getValue(Ride ride, Vehicle vehicle, int time){
        int distanceFromVehicleToStartPoint = getDistance(ride.getStart().getX(),ride.getStart().getY(),vehicle.getX(),vehicle.getY());
        int rideDistance = ride.getDistance();
        int distanceFromVehicleToEndPoint = distanceFromVehicleToStartPoint + rideDistance;

        if((time + distanceFromVehicleToEndPoint) > ride.getLatestFinish()){
            return Integer.MIN_VALUE;
        }

        int wait = 0;
        int bonus = 0;

        int timeAtStartPoint = time + distanceFromVehicleToStartPoint;
        if(timeAtStartPoint <= ride.getEarliestStart()){
            wait = ride.getEarliestStart() - timeAtStartPoint;
            bonus = perBonusRide;
        }

        int value = - distanceFromVehicleToStartPoint - wait + bonus + rideDistance;
        return value;

    }

    public static int getDistance(int x1, int y1, int x2, int y2){

        int width = Math.abs(x1 - x2);
        int height = Math.abs(y1 - y2);
        int distance = width + height;

        return distance;

    }

}
