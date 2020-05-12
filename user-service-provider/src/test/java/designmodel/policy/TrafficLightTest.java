package designmodel.policy;

public class TrafficLightTest {

    public static void main(String[] args) {
        TrafficLight trafficLight = new YellowTrafficLight();
        TrafficLightContext trafficLightContext = new TrafficLightContext(trafficLight);
        trafficLight.optLight();
    }

}
