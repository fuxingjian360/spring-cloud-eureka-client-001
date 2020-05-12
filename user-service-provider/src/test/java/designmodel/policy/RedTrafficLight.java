package designmodel.policy;

public class RedTrafficLight implements TrafficLight{
    @Override
    public void optLight() {
        System.err.println("红灯");
    }
}
