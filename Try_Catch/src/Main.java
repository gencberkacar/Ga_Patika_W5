public class Main {
    public static void main(String[] args) {


        int[] dizi = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try {
            int diziIndex = diziOku(dizi, 11);
            System.out.println("Dizi elemanı: " + diziIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dizi boyutunu aştın !");
        }

    }

    public static int diziOku(int[] dizi, int index) {
        try {
            return dizi[index];
        } catch (IndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Hata: Dizinin boyutunu asan deger girdiniz !");
        }

    }
}