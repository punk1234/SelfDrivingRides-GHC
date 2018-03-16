package akejufatai.practice.model;

/**
 * Created by AKEJU  FATAI on 2018-03-01.
 */
public class Ride implements Comparable<Ride> {

    private int id;
    private Intersection start;
    private Intersection end;
    private int earliestStart;
    private int latestFinish;

    public Ride(int id, Intersection start, Intersection end, int earliestStart, int latestFinish){
        this.id = id;
        this.start = start;
        this.end = end;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public int getId() {
        return id;
    }

    public Intersection getStart() {
        return start;
    }

    public Intersection getEnd() {
        return end;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public int getDistance(){
        int width = Math.abs(start.getX() - end.getX());
        int height = Math.abs(start.getY() - end.getY());
        int distance = width + height;
        return distance;
    }

    @Override
    public int compareTo(Ride o) {
        if(earliestStart < o.getEarliestStart()){
            return -1;
        }
        else if(earliestStart > o.getEarliestStart()){
            return 1;
        }

        return 0;
    }
}
