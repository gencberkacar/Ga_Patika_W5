import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {

        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Smartphone İşlemleri");
            System.out.println("2 - Notebook İşlemleri");
            System.out.println("3 - Markaları listele");
            System.out.println("4 - Çıkış");

            System.out.print("Seçeneği girin: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performSmartPhoneOperations();
                    break;
                case 2:
                    performNotebookOperations();
                    break;
                case 3:
                    Brand.BrandList();
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }

    public static void performBrandList() {
        while (true) {

            System.out.println("Menüye Dönmek için 1'e basiniz..");


            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }

    public static void performSmartPhoneOperations() {


        while (true) {
            System.out.println("Smartphone İşlemleri");
            System.out.println("1 - Listele");
            System.out.println("2 - Ekle");
            System.out.println("3 - Sil");
            System.out.println("4 - Filtrele");
            System.out.println("5 - Geri");

            System.out.print("Seçeneği girin: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    SmartPhoneOperation.initializeSmartPhones();
                    SmartPhoneOperation.SmartPhoneList();
                    break;
                case 2:
                    SmartPhoneOperation.addSmartPhone();
                    break;
                case 3:
                    SmartPhoneOperation.removeSmartPhoneById();
                    break;
                case 4:
                    SmartPhoneOperation.filterSmartPhone();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }

    public static void performNotebookOperations() {


        while (true) {
            System.out.println("Notebook İşlemleri");
            System.out.println("1 - Listele");
            System.out.println("2 - Ekle");
            System.out.println("3 - Sil");
            System.out.println("4 - Filtrele");
            System.out.println("5 - Geri");

            System.out.print("Seçeneği girin: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    NotebookOperation.initializeNotebooks();
                    NotebookOperation.notebookList();
                    break;
                case 2:
                    NotebookOperation.addNotebook();

                    break;
                case 3:
                    NotebookOperation.removeNotebookById();

                    break;
                case 4:
                    NotebookOperation.filterNotebook();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }
}