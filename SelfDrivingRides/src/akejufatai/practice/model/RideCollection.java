package akejufatai.practice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by AKEJU  FATAI on 2018-03-01.
 */
public class RideCollection {

    private List<Ride> content;

    public RideCollection(){

        content = new ArrayList<>();

    }

    public RideCollection(int count){

        content = new ArrayList<>(count);

    }

    public void add(Ride ride){
        content.add(ride);
    }

    public void remove(Ride ride){
        content.remove(ride);
    }

    public void remove(int index){
        content.remove(index);
    }

    public Ride get(int index){
        return content.get(index);
    }

    public int count(){
        return content.size();
    }

    public RideCollection getTop(int maxCount){
        if(maxCount < content.size()){
            RideCollection r = new RideCollection(maxCount);
            for(int index = 0; index < maxCount; index++){
                r.add(content.get(index));
            }
            return r;
        }
        return this;
    }

    public void sort(){

        Collections.sort(content);

    }

}
