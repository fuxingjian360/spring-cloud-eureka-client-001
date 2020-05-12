package designmodel.policy;

public class TrafficLightContext {

    private TrafficLight trafficLight;

    public TrafficLightContext(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void optLight() {
        trafficLight.optLight();
    }
}
