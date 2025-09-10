class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    // Hàm khởi tạo
    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    // Tính chu vi
    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    // Tính diện tích
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    // Hiển thị thông tin hình chữ nhật
    public void hienThi() {
        System.out.println("Hình chữ nhật: chiều dài = " + chieuDai +
                           ", chiều rộng = " + chieuRong +
                           ", chu vi = " + tinhChuVi() +
                           ", diện tích = " + tinhDienTich());
    }
}

public class Bai1 {
    public static void main(String[] args) {
        // Tạo và hiển thị thông tin các hình chữ nhật
        HinhChuNhat hcn1 = new HinhChuNhat(5, 3);
        HinhChuNhat hcn2 = new HinhChuNhat(7.5, 2.5);
        HinhChuNhat hcn3 = new HinhChuNhat(4, 4);

        hcn1.hienThi();
        hcn2.hienThi();
        hcn3.hienThi();
    }
}