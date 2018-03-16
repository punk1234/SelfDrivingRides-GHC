package akejufatai.practice.model;

/**
 * Created by AKEJU  FATAI on 2018-03-02.
 */
public class SDRObject {

    private Map map;
    private int perBonusRide;
    private int steps;

    public SDRObject(Map map, int perBonusRide, int steps){
        this.map = map;
        this.perBonusRide = perBonusRide;
        this.steps = steps;
    }

    public Map getMap() {
        return map;
    }

    public int getPerBonusRide() {
        return perBonusRide;
    }

    public int getSteps() {
        return steps;
    }
}
