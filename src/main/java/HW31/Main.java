package HW31;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer observer1 = new DisplayPhone();
        Observer observer2 = new DisplayTv();
        station.add(observer1);
        station.add(observer2);
        station.notifySubscribers(28);
    }
}
