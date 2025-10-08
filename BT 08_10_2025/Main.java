import java.util.ArrayList;
import java.util.List;

// ----- Lớp Product -----
abstract class Product {
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + price + " VND";
    }
}

// ----- ElectronicProduct -----
class ElectronicProduct extends Product {
    private String imei;
    private int warranty;

    public ElectronicProduct(String id, String name, double price, String imei, int warranty) {
        super(id, name, price);
        this.imei = imei;
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return super.toString() + " | IMEI: " + imei + " | Bảo hành: " + warranty + " tháng";
    }
}

// ----- FoodProduct -----
class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String id, String name, double price, String expirationDate) {
        super(id, name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + " | HSD: " + expirationDate;
    }
}

// ----- Interface PaymentMethod -----
interface PaymentMethod {
    void pay(double amount, String customerName);
}

// ----- Các phương thức thanh toán -----
class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + amount + ". Thanh toán tiền mặt thành công.");
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + amount + ". Thanh toán bằng thẻ tín dụng thành công.");
    }
}

class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + amount + ". Thanh toán bằng Momo thành công.");
    }
}

// ----- Lớp Order -----
class Order {
    private String customerName;
    private List<Product> productList;
    private PaymentMethod paymentMethod;

    public Order(String customerName) {
        this.customerName = customerName;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product p) {
        productList.add(p);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : productList) {
            total += p.getPrice();
        }
        return total;
    }

    public void setPaymentMethod(PaymentMethod pm) {
        this.paymentMethod = pm;
    }

    public void checkout() {
        if (paymentMethod == null) {
            System.out.println("Chưa chọn phương thức thanh toán!");
            return;
        }
        double amount = calculateTotal();
        paymentMethod.pay(amount, customerName);
    }
}

// ----- Lớp Main (chạy chương trình) -----
public class Main {
    public static void main(String[] args) {
        Product p1 = new ElectronicProduct("SP01", "iPhone 15", 25000000, "123456", 12);
        Product p2 = new FoodProduct("SP02", "Bánh quy", 50000, "12/12/2025");

        Order order1 = new Order("Nguyễn Văn A");
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.setPaymentMethod(new CashPayment());
        order1.checkout();

        Order order2 = new Order("Nguyễn Văn B");
        order2.addProduct(p1);
        order2.setPaymentMethod(new MomoPayment());
        order2.checkout();
    }
}
