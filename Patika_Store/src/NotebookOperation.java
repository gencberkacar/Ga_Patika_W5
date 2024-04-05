import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotebookOperation {
    static List<Notebook> notebooks = new ArrayList<>();

    public static void initializeNotebooks() {
        notebooks.add(new Notebook(1, "HUAWEI Matebook 14", "7000.0 TL", "Huawei", 512, 14.0, 16));
        notebooks.add(new Notebook(2, "LENOVO V14 IGL", "3699.0 TL", "Lenovo", 1024, 14.0, 8));
        notebooks.add(new Notebook(3, "ASUS Tuf Gaming", "8199.0 TL", "Asus", 2048, 15.6, 32));
        notebooks.add(new Notebook(4, "Casper Nirvana X400", "3499.0 TL", "Casper", 1024, 15.6, 16));
        notebooks.add(new Notebook(5, "HP Victus", "1022.0 TL", "HP", 5012, 16, 64));
        notebooks.add(new Notebook(6, "Monster Tulpar T7", "8122.0 TL", "Monster", 1024, 16, 64));
    }

    public static void notebookList() {
        // Tablo başlığını bastır
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-27s | %-10s | %-10s | %-9s | %-6s | %-9s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook i : notebooks) {
            System.out.format("| %-2d | %-27s | %-10s | %-10s | %-9d | %-6.1f | %-9d |\n",
                    i.getId(), i.getName(), i.getPrice(), i.getBrand(), i.getStorage(), i.getScreenSize(), i.getRam());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }


    public static void addNotebook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yeni bir notebook eklemek için aşağıdaki bilgileri girin:");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // ID'nin benzersiz olduğunu kontrol et
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

        Notebook newNotebook = new Notebook(id, name, price, brand, storage, screenSize, ram);

        notebooks.add(newNotebook);

        System.out.println("Yeni notebook başarıyla eklendi.");
    }

    // Verilen ID'nin zaten kullanılıp kullanılmadığını kontrol et
    public static boolean isIdAlreadyUsed(int id) {
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void removeNotebookById() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Silmek istediğiniz notebook'un ID'sini girin: ");
        int id = scanner.nextInt();

        Notebook removedNotebook = null;

        for (Notebook notebook : notebooks) {
            if (notebook.getId() == id) {
                removedNotebook = notebook;
                break;
            }
        }

        if (removedNotebook != null) {
            notebooks.remove(removedNotebook);
            System.out.println("ID " + id + " olan notebook başarıyla silindi.");
        } else {
            System.out.println("ID " + id + " ile eşleşen bir notebook bulunamadı.");
        }

    }

    public static void filterNotebook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Filtreleme seçeneğini seçin:");
        System.out.println("1 - ID'ye Göre Filtrele");
        System.out.println("2 - Markaya Göre Filtrele");
        System.out.print("Seçeneği girin (1 veya 2): ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                filterNotebookById();
                break;
            case 2:
                filterNotebooksByBrand();
                break;
            default:
                System.out.println("Geçersiz seçenek. Lütfen 1 veya 2 girin.");
                break;
        }
    }

    public static void filterNotebookById() {
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filtrelemek istediğiniz Notebook ID'sini girin: ");
        int id = scanner.nextInt();


        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-27s | %-10s | %-10s | %-9s | %-6s | %-9s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook notebook : notebooks) {
            if (notebook.getId() == id) {
                found = true;
                // ID'ye göre eşleşen Notebook'u tablo şeklinde ekrana bastırın
                System.out.format("| %-2d | %-27s | %-10s | %-10s | %-9d | %-6.1f | %-9d |\n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(),
                        notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
                break;
            }
        }

        if (!found) {
            System.out.println("ID " + id + " ile eşleşen Notebook bulunamadı.");
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void filterNotebooksByBrand() {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        // Kullanıcıdan marka adını al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filtrelemek istediğiniz Marka'yı girin: ");
        String brandToFilter = scanner.nextLine();

        for (Notebook notebook : notebooks) {
            if (notebook.getBrand().equalsIgnoreCase(brandToFilter)) {
                filteredNotebooks.add(notebook);
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-27s | %-10s | %-10s | %-9s | %-6s | %-9s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook notebook : filteredNotebooks) {
            System.out.format("| %-2d | %-27s | %-10s | %-10s | %-9d | %-6.1f | %-9d |\n",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(),
                    notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }
}