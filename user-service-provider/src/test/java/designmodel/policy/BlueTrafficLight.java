package designmodel.policy;

public class BlueTrafficLight implements TrafficLight {
    @Override
    public void optLight() {
        System.err.println("绿灯");
    }
}
