public class Pelanggan {
    private String nomorPelanggan;
    private String nama;
    private double saldo;
    private String pin;
    private int salahLogin = 0;
    private boolean blokir = false;

    public Pelanggan(String nomorPelanggan, String nama, double saldo, String pin) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.saldo = saldo;
        this.pin = pin;
    }

    public boolean autentikasi(String nomor, String pinInput) {
        if (blokir) {
            System.out.println("Akun diblokir.");
            return false;
        }

        if (nomor.equals(nomorPelanggan) && pinInput.equals(pin)) {
            salahLogin = 0;
            return true;
        } else {
            salahLogin++;
            System.out.println("PIN atau nomor pelanggan salah!");

            if (salahLogin >= 3) {
                blokir = true;
                System.out.println("Akun diblokir karena 3x kesalahan.");
            }
            return false;
        }
    }

    public void topUp(double jumlah) {
        saldo += jumlah;
        System.out.println("Top up berhasil.");
        System.out.println("Saldo sekarang: " + saldo);
    }

    public void pembelian(double jumlah) {
        double cashback = 0;
        String jenis = nomorPelanggan.substring(0, 2);

        if (saldo - jumlah < 10000) {
            System.out.println("Transaksi gagal. Saldo minimal harus 10000.");
            return;
        }

        if (jenis.equals("38")) {
            if (jumlah > 1000000) {
                cashback = jumlah * 0.05;
            }
        } 
        else if (jenis.equals("56")) {
            if (jumlah > 1000000) {
                cashback = jumlah * 0.07;
            } else {
                cashback = jumlah * 0.02;
            }
        } 
        else if (jenis.equals("74")) {
            if (jumlah > 1000000) {
                cashback = jumlah * 0.10;
            } else {
                cashback = jumlah * 0.05;
            }
        }

        saldo = saldo - jumlah + cashback;

        System.out.println("Pembelian berhasil.");
        System.out.println("Cashback: " + cashback);
        System.out.println("Saldo sekarang: " + saldo);
    }
}