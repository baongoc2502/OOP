import java.util.*;

class TaiKhoan {
    private String soTaiKhoan;
    private String tenChuTaiKhoan;
    private double soDu;
    private static double laiSuatNam = 0.06; // 6%/năm

    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double soTien) {
        if (soTien > 0) soDu += soTien;
    }

    public boolean rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            return true;
        }
        return false;
    }

    public void tinhLaiMotThang() {
        double lai = soDu * (laiSuatNam / 12);
        soDu += lai;
    }

    public void hienThi() {
        System.out.printf("STK: %s, Chủ TK: %s, Số dư: %.2f\n", soTaiKhoan, tenChuTaiKhoan, soDu);
    }

    public double getSoDu() {
        return soDu;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        ArrayList<TaiKhoan> ds = new ArrayList<>();
        ds.add(new TaiKhoan("001", "Nguyen Van A", 5000000));
        ds.add(new TaiKhoan("002", "Tran Thi B", 3000000));
        ds.add(new TaiKhoan("003", "Le Van C", 7000000));

        // Nạp tiền, rút tiền, tính lãi
        ds.get(0).napTien(1000000); // A nạp 1 triệu
        ds.get(1).rutTien(500000);  // B rút 500k
        ds.get(2).tinhLaiMotThang(); // C tính lãi 1 tháng

        // Hiển thị danh sách tài khoản
        System.out.println("Danh sách tài khoản:");
        for (TaiKhoan tk : ds) {
            tk.hienThi();
        }

        // Sắp xếp theo số dư giảm dần
        ds.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));

        System.out.println("\nDanh sách tài khoản (sắp xếp theo số dư giảm dần):");
        for (TaiKhoan tk : ds) {
            tk.hienThi();
        }

        // Tìm kiếm theo số tài khoản
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập số tài khoản cần tìm: ");
        String stkTim = sc.nextLine();
        boolean timThay = false;
        for (TaiKhoan tk : ds) {
            if (tk.getSoTaiKhoan().equals(stkTim)) {
                tk.hienThi();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }
}