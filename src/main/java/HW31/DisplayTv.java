package HW31;

public class DisplayTv implements Observer{
    @Override
    public void update(int temperature) {
        System.out.println("Температура сьгодні: " + temperature + " градусів за цельсієм, яка була надіслана на телевізор");
    }
}
