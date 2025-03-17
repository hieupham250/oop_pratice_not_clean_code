package entity;
import java.util.Scanner;

public class Product implements IApp {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {}

    public Product(String productId, String productName, float importPrice, float exportPrice, String title, String description, int quantity, int categoryId, int status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm (bắt đầu bằng C, E, T - 5 ký tự): ");
        productId = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm (10-100 ký tự): ");
        productName = scanner.nextLine();
        System.out.print("Nhập giá nhập sản phẩm: ");
        importPrice = scanner.nextFloat();
        System.out.print("Nhập giá xuất sản phẩm (tối thiểu " + (importPrice * INTEREST) + "): ");
        exportPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Nhập tiêu đề sản phẩm: ");
        title = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        description = scanner.nextLine();
        System.out.print("Nhập số lượng sản phẩm: ");
        quantity = scanner.nextInt();
        System.out.print("Nhập mã danh mục: ");
        categoryId = scanner.nextInt();
        System.out.print("Nhập trạng thái sản phẩm (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
        status = scanner.nextInt();
    }

    @Override
    public void displayData() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Trạng thái: " + (status == 0 ? "Hoạt động" : status == 1 ? "Hết hàng" : "Không hoạt động"));
        System.out.println("----------------------------------------------------------");
    }
}