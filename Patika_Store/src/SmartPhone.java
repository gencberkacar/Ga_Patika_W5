import java.util.ArrayList;
import java.util.List;

public class SmartPhone extends Product {
    private int batteryPower;
    private String color;
    private int camera;

    public SmartPhone(int id, String name, String price, String brand, int storage, double screenSize, int ram, int batteryPower, String color, int camera) {
        super(id, name, price, brand, storage, screenSize, ram);
        this.batteryPower = batteryPower;
        this.color = color;
        this.camera = camera;
    }


    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }
}