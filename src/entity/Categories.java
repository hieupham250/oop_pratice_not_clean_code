package entity;
import java.util.Scanner;

public class Categories implements IApp {
    private static int count = 1;
    private int categoryId;
    private String categoryName;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {
        this.categoryId = count++;
    }

    public Categories(String categoryName, int priority, String description, boolean status) {
        this.categoryId = count++;
        this.categoryName = categoryName;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên danh mục (6-50 ký tự): ");
        categoryName = scanner.nextLine();
        System.out.print("Nhập độ ưu tiên: ");
        priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mô tả danh mục: ");
        description = scanner.nextLine();
        System.out.print("Trạng thái danh mục (true/false): ");
        status = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Tên danh mục: " + categoryName);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động"));
        System.out.println("----------------------------------------------------------");
    }
}