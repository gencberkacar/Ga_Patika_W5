public class Product {

    private int id;
    private String name;
    private String price;
    private String brand;
    private int storage;
    private double screenSize;
    private int ram;

    public Product(int id, String name, String price, String brand, int storage, double screenSize, int ram) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}