import java.util.Scanner;

public class swalayanTiny {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Pelanggan p = new Pelanggan("5630052007", "Muthya", 2000000, "3030");

        System.out.print("Masukkan nomor pelanggan: ");
        String nomor = input.nextLine();

        System.out.print("Masukkan PIN: ");
        String pin = input.nextLine();

        if (p.autentikasi(nomor, pin)) {
            System.out.println("1. Top Up");
            System.out.println("2. Pembelian");
            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();

            System.out.print("Masukkan jumlah: ");
            double jumlah = input.nextDouble();

            if (pilih == 1) {
                p.topUp(jumlah);
            } else if (pilih == 2) {
                p.pembelian(jumlah);
            } else {
                System.out.println("Menu tidak tersedia.");
            }
        }

        input.close();
    }
}