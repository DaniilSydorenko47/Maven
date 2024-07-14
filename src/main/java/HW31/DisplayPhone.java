package HW31;

public class DisplayPhone implements Observer{

    @Override
    public void update(int temperature) {
        System.out.println("Температура сьгодні: " + temperature + " градусів за цельсієм; надіслано на телефон");
    }
}
