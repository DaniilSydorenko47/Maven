package HW31;

import java.util.ArrayList;

public class WeatherStation {
    private ArrayList<Observer> subscribers = new ArrayList<>();

    public void add(Observer observer){
        subscribers.add(observer);
    }
    public void remove(Observer observer){
        subscribers.remove(observer);
    }
    public void notifySubscribers(int message){
        for(Observer observer : subscribers){
            observer.update(message);
        }
    }
}
