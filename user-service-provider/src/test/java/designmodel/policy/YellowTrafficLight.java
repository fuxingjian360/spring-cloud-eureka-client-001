package designmodel.policy;

public class YellowTrafficLight implements TrafficLight {
    @Override
    public void optLight() {
        System.err.println("黄灯");
    }
}
