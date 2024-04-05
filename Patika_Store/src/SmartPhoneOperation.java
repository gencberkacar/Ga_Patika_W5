import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhoneOperation {

    static List<SmartPhone> smartPhones = new ArrayList<>();

    public static void initializeSmartPhones() {
        smartPhones.add(new SmartPhone(1, "SAMSUNG GALAXY A51", "3199.0 TL", "Samsung", 128, 6.5, 6, 4000, "Siyah", 32));
        smartPhones.add(new SmartPhone(2, "iPhone 11 64 GB", "7379.0 TL", "Apple", 64, 6.1, 6, 3046, "Mavi", 5));
        smartPhones.add(new SmartPhone(3, "Redmi Note 10 Pro 8GB", "4012.0 TL", "Xiaomi", 128, 6.5, 12, 4000, "Beyaz", 35));
    }

    public static void SmartPhoneList() {

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-27s | %-10s | %-10s | %-9s | %-9s | %-9s | %-10s | %-10s | %-7s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (SmartPhone i : smartPhones) {
            System.out.format("| %-2d | %-27s | %-10s | %-10s | %-9d | %-9.1f | %-9d | %-10d | %-10d | %-7s |\n",
                    i.getId(), i.getName(), i.getPrice(), i.getBrand(), i.getStorage(), i.getScreenSize(), i.getCamera(),
                    i.getBatteryPower(), i.getRam(), i.getColor());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }


    public static void addSmartPhone() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yeni bir smartphone eklemek için aşağıdaki bilgileri girin:");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Enter tuşu için tampon temizleme
        if (isIdAlreadyUsed(id)) {
            System.out.println("Bu ID zaten kullanılıyor. Lütfen başka bir ID girin.");
            return;
        }
        System.out.print("Ürün Adı: ");
        String name = scanner.nextLine();

        System.out.print("Fiyat: ");
        String price = scanner.nextLine();

        System.out.print("Marka: ");
        String brand = scanner.nextLine();

        System.out.print("Depolama: ");
        int storage = scanner.nextInt();

        System.out.print("Ekran: ");
        double screenSize = scanner.nextDouble();

        System.out.print("RAM: ");
        int ram = scanner.nextInt();

        System.out.print("Pil: ");
        int batteryPower = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Renk: ");
        String color = scanner.nextLine();

        System.out.print("Kamera: ");
        int camera = scanner.nextInt();

        SmartPhone newSmartPhone = new SmartPhone(id, name, price, brand, storage, screenSize, ram, batteryPower, color, camera);

        smartPhones.add(newSmartPhone);

        System.out.println("Yeni smartphone başarıyla eklendi.");
        SmartPhoneList();
    }

    public static void removeSmartPhoneById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Silmek istediğiniz smartphone ID'sini girin: ");
        int id = scanner.nextInt();

        SmartPhone removedSmartPhone = null;

        for (SmartPhone smartPhone : smartPhones) {
            if (smartPhone.getId() == id) {
                removedSmartPhone = smartPhone;
                break;
            }
        }

        if (removedSmartPhone != null) {
            smartPhones.remove(removedSmartPhone);
            System.out.println("ID " + id + " olan smartphone başarıyla silindi.");
        } else {
            System.out.println("ID " + id + " ile eşleşen bir smartphone bulunamadı.");
        }


        SmartPhoneList();
    }

    public static void filterSmartPhone() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Filtreleme seçeneğini seçin:");
        System.out.println("1 - ID'ye Göre Filtrele");
        System.out.println("2 - Markaya Göre Filtrele");
        System.out.print("Seçeneği girin (1 veya 2): ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                filterSmartPhoneById();
                break;
            case 2:

                filterSmartPhonesByBrand();
                break;
            default:
                System.out.println("Geçersiz seçenek. Lütfen 1 veya 2 girin.");
                break;
        }
    }

    public static void filterSmartPhoneById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filtrelemek istediğiniz SmartPhone ID'sini girin: ");
        int id = scanner.nextInt();
        boolean found = false;


        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-27s | %-10s | %-10s | %-9s | %-9s | %-9s | %-10s | %-10s | %-7s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (SmartPhone smartPhone : smartPhones) {
            if (smartPhone.getId() == id) {
                found = true;
                // ID'ye göre eşleşen SmartPhone'u tablo şeklinde ekrana bastır
                System.out.format("| %-2d | %-27s | %-10s | %-10s | %-9d | %-9.1f | %-9d | %-10d | %-10d | %-7s |\n",
                        smartPhone.getId(), smartPhone.getName(), smartPhone.getPrice(), smartPhone.getBrand(),
                        smartPhone.getStorage(), smartPhone.getScreenSize(), smartPhone.getCamera(),
                        smartPhone.getBatteryPower(), smartPhone.getRam(), smartPhone.getColor());
                break;
            }
        }

        if (!found) {
            System.out.println("ID " + id + " ile eşleşen SmartPhone bulunamadı.");
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }


    public static List<SmartPhone> filterSmartPhonesByBrand() {
        List<SmartPhone> filteredPhones = new ArrayList<>();

        // Kullanıcıdan marka adını al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filtrelemek istediğiniz Marka'yı girin: ");
        String brandToFilter = scanner.nextLine();

        for (SmartPhone phone : smartPhones) {
            if (phone.getBrand().equalsIgnoreCase(brandToFilter)) {
                filteredPhones.add(phone);
            }
        }


        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-27s | %-10s | %-10s | %-9s | %-9s | %-9s | %-10s | %-10s | %-7s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (SmartPhone i : filteredPhones) {
            System.out.format("| %-2d | %-27s | %-10s | %-10s | %-9d | %-9.1f | %-9d | %-10d | %-10d | %-7s |\n",
                    i.getId(), i.getName(), i.getPrice(), i.getBrand(), i.getStorage(), i.getScreenSize(), i.getCamera(),
                    i.getBatteryPower(), i.getRam(), i.getColor());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        return filteredPhones;
    }

    public static boolean isIdAlreadyUsed(int id) {
        for (SmartPhone smartphone : smartPhones) {
            if (smartphone.getId() == id) {
                return true;
            }
        }
        return false;
    }

}