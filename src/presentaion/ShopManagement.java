package presentaion;

import entity.Categories;
import entity.Product;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Categories[] categories = new Categories[100];
        Product[] products = new Product[100];
        int categoryCount = 0;
        int productCount = 0;
        boolean exitProgram = true;

        while (exitProgram) {
            System.out.println("\n*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    boolean exitCategory = true;
                    while (exitCategory) {
                        System.out.println("\n********************CATEGORIE MANAGEMENT*********************");
                        System.out.println("1. Danh sách danh mục");
                        System.out.println("2. Thêm mới danh mục");
                        System.out.println("3. Cập nhật danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Tìm kiếm danh mục theo tên");
                        System.out.println("6. Thoát");
                        System.out.print("Chọn chức năng: ");
                        int subChoice1 = scanner.nextInt();
                        scanner.nextLine();
                        switch (subChoice1) {
                            case 1:
                                if (categoryCount == 0) {
                                    System.out.println("Danh sách danh mục trống!");
                                } else {
                                    for (int i = 0; i < categoryCount; i++) {
                                        categories[i].displayData();
                                    }
                                }
                                break;
                            case 2:
                                if (categoryCount < categories.length) {
                                    categories[categoryCount] = new Categories();
                                    categories[categoryCount].inputData(scanner);
                                    categoryCount++;
                                } else {
                                    System.out.println("Danh sách danh mục đã đầy!");
                                }
                                break;
                            case 3:
                                System.out.print("Nhập ID danh mục cần cập nhật: ");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();
                                boolean foundCategory = false;
                                for (int i = 0; i < categoryCount; i++) {
                                    if (categories[i].getCategoryId() == updateId) {
                                        foundCategory = true;
                                        System.out.println("Chọn thông tin cần cập nhật:");
                                        System.out.println("1. Tên danh mục");
                                        System.out.println("2. Độ ưu tiên");
                                        System.out.println("3. Mô tả");
                                        System.out.println("4. Trạng thái");
                                        System.out.print("Nhập lựa chọn: ");
                                        int updateChoice1 = scanner.nextInt();
                                        scanner.nextLine();
                                        switch (updateChoice1) {
                                            case 1:
                                                System.out.print("Nhập tên danh mục mới: ");
                                                categories[i].setCategoryName(scanner.nextLine());
                                                break;
                                            case 2:
                                                System.out.print("Nhập độ ưu tiên mới: ");
                                                categories[i].setPriority(scanner.nextInt());
                                                scanner.nextLine();
                                                break;
                                            case 3:
                                                System.out.print("Nhập mô tả mới: ");
                                                categories[i].setDescription(scanner.nextLine());
                                                break;
                                            case 4:
                                                System.out.print("Nhập trạng thái mới (true/false): ");
                                                categories[i].setStatus(scanner.nextBoolean());
                                                break;
                                            default:
                                                System.out.println("Lựa chọn không hợp lệ!");
                                        }
                                        System.out.println("Cập nhật thành công!");
                                        break;
                                    }
                                }
                                if (!foundCategory) {
                                    System.out.println("Không tìm thấy danh mục với mã đã nhập!");
                                }
                                break;
                            case 4:
                                System.out.print("Nhập ID danh mục cần xóa: ");
                                int deleteId = scanner.nextInt();
                                scanner.nextLine();
                                boolean hasProduct = false;

                                // Kiểm tra xem danh mục có sản phẩm nào không
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getCategoryId() == deleteId) {
                                        hasProduct = true;
                                        break;
                                    }
                                }

                                if (hasProduct) {
                                    System.out.println("Không thể xóa danh mục vì có sản phẩm thuộc danh mục này!");
                                } else {
                                    boolean foundCategoryDelete = false;
                                    for (int i = 0; i < categoryCount; i++) {
                                        if (categories[i].getCategoryId() == deleteId) {
                                            categories[i] = categories[categoryCount - 1];
                                            categoryCount--;
                                            foundCategoryDelete = true;
                                            System.out.println("Xóa danh mục thành công!");
                                            break;
                                        }
                                    }
                                    if (!foundCategoryDelete) {
                                        System.out.println("Không tìm thấy danh mục với ID đã nhập!");
                                    }
                                }
                                break;
                            case 5:
                                System.out.print("Nhập tên danh mục cần tìm: ");
                                String searchName = scanner.nextLine();
                                for (int i = 0; i < categoryCount; i++) {
                                    if (categories[i].getCategoryName().contains(searchName)) {
                                        categories[i].displayData();
                                    }
                                }
                                break;
                            case 6:
                                exitCategory = false;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    }
                    break;
                case 2:
                    boolean exitProduct = true;
                    while (exitProduct) {
                        System.out.println("\n********************PRODUCT MANAGEMENT*********************");
                        System.out.println("1. Danh sách sản phẩm");
                        System.out.println("2. Thêm mới sản phẩm");
                        System.out.println("3. Cập nhật sản phẩm");
                        System.out.println("4. Xóa sản phẩm");
                        System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
                        System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
                        System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
                        System.out.println("8. Bán sản phẩm");
                        System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
                        System.out.println("10. Thoát");
                        System.out.print("Chọn chức năng: ");
                        int subChoice2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (subChoice2) {
                            case 1:
                                if (productCount == 0) {
                                    System.out.println("Danh sách sản phẩm trống!");
                                } else {
                                    for (int i = 0; i < productCount; i++) {
                                        products[i].displayData();
                                    }
                                }
                                break;
                            case 2:
                                if (productCount < products.length) {
                                    products[productCount] = new Product();
                                    products[productCount].inputData(scanner);
                                    productCount++;
                                } else {
                                    System.out.println("Danh sách sản phẩm đã đầy!");
                                }
                                break;
                            case 3:
                                System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                                String updateProductId = scanner.nextLine();
                                boolean foundProduct = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getProductId().equals(updateProductId)) {
                                        foundProduct = true;
                                        System.out.println("Chọn thông tin cần cập nhật:");
                                        System.out.println("1. Tên sản phẩm");
                                        System.out.println("2. Giá nhập");
                                        System.out.println("3. Giá xuất");
                                        System.out.println("4. Tiêu đề");
                                        System.out.println("5. Mô tả");
                                        System.out.println("6. Số lượng");
                                        System.out.println("7. Mã danh mục");
                                        System.out.println("8. Trạng thái");
                                        System.out.print("Nhập lựa chọn: ");
                                        int updateChoice2 = scanner.nextInt();
                                        scanner.nextLine();
                                        switch (updateChoice2) {
                                            case 1:
                                                System.out.print("Nhập tên sản phẩm mới: ");
                                                products[i].setProductName(scanner.nextLine());
                                                break;
                                            case 2:
                                                System.out.print("Nhập giá nhập mới: ");
                                                products[i].setImportPrice(scanner.nextFloat());
                                                scanner.nextLine();
                                                break;
                                            case 3:
                                                System.out.print("Nhập giá xuất mới: ");
                                                products[i].setExportPrice(scanner.nextFloat());
                                                scanner.nextLine();
                                                break;
                                            case 4:
                                                System.out.print("Nhập tiêu đề mới: ");
                                                products[i].setTitle(scanner.nextLine());
                                                break;
                                            case 5:
                                                System.out.print("Nhập mô tả mới: ");
                                                products[i].setTitle(scanner.nextLine());
                                                break;
                                            case 6:
                                                System.out.print("Nhập số lượng mới: ");
                                                products[i].setQuantity(scanner.nextInt());
                                                scanner.nextLine();
                                                break;
                                            case 7:
                                                System.out.print("Nhập mã danh mục mới: ");
                                                products[i].setCategoryId(scanner.nextInt());
                                                scanner.nextLine();
                                                break;
                                            case 8:
                                                System.out.print("Nhập trạng thái mới (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
                                                products[i].setStatus(scanner.nextInt());
                                                scanner.nextLine();
                                                break;
                                            default:
                                                System.out.println("Lựa chọn không hợp lệ!");
                                        }
                                        System.out.println("Cập nhật thành công!");
                                        break;
                                    }
                                }
                                if (!foundProduct) {
                                    System.out.println("Không tìm thấy sản phẩm với mã đã nhập!");
                                }
                                break;
                            case 4:
                                System.out.print("Nhập mã sản phẩm cần xóa: ");
                                String deleteProductId = scanner.nextLine();
                                boolean foundDeleteProduct = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getProductId().equals(deleteProductId)) {
                                        products[i] = products[productCount - 1];
                                        productCount--;
                                        foundDeleteProduct = true;
                                        System.out.println("Xóa sản phẩm thành công!");
                                        break;
                                    }
                                }
                                if (!foundDeleteProduct) {
                                    System.out.println("Không tìm thấy mã sản phẩm cần xóa!");
                                }
                                break;
                            case 5:
                                System.out.print("Nhập tên hoặc tiêu đề sản phẩm cần tìm: ");
                                String searchKeyword = scanner.nextLine();
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getProductName().contains(searchKeyword) || products[i].getTitle().contains(searchKeyword)) {
                                        products[i].displayData();
                                    }
                                }
                                break;
                            case 6:
                                System.out.print("Nhập giá thấp nhất: ");
                                float minPrice = scanner.nextFloat();
                                System.out.print("Nhập giá cao nhất: ");
                                float maxPrice = scanner.nextFloat();
                                scanner.nextLine();
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getExportPrice() >= minPrice && products[i].getExportPrice() <= maxPrice) {
                                        products[i].displayData();
                                    }
                                }
                                break;
                            case 7:
                                for (int i = 0; i < productCount - 1; i++) {
                                    for (int j = i + 1; j < productCount; j++) {
                                        if (products[i].getExportPrice() > products[j].getExportPrice()) {
                                            Product temp = products[i];
                                            products[i] = products[j];
                                            products[j] = temp;
                                        }
                                    }
                                }
                                System.out.println("Sắp xếp thành công! Danh sách sản phẩm sau khi sắp xếp:");
                                for (int i = 0; i < productCount; i++) {
                                    products[i].displayData();
                                }
                                break;
                            case 8:
                                System.out.print("Nhập mã sản phẩm cần bán: ");
                                String sellProductId = scanner.nextLine();
                                System.out.print("Nhập số lượng cần bán: ");
                                int sellQuantity = scanner.nextInt();
                                scanner.nextLine();
                                boolean sold = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getProductId().equals(sellProductId)) {
                                        if (products[i].getQuantity() > 0 && products[i].getQuantity() >= sellQuantity) {
                                            products[i].setQuantity(products[i].getQuantity() - sellQuantity);
                                            System.out.println("Bán sản phẩm thành công!");
                                        } else {
                                            System.out.println("Không đủ hàng trong kho để bán!");
                                        }
                                        sold = true;
                                        break;
                                    }
                                }
                                if (!sold) {
                                    System.out.println("Không tìm thấy sản phẩm!");
                                }
                                break;
                            case 9:
                                System.out.println("Thống kê số lượng sản phẩm theo danh mục:");
                                for (int i = 0; i < categoryCount; i++) {
                                    int count = 0;
                                    for (int j = 0; j < productCount; j++) {
                                        if (products[j].getCategoryId() == categories[i].getCategoryId() && products[j].getQuantity() > 0) {
                                            count += products[j].getQuantity();
                                        }
                                    }
                                    System.out.println("Danh mục: " + categories[i].getCategoryName() + " - Số lượng còn lại: " + count);
                                }
                                break;
                            case 10:
                                exitProduct = false;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình!");
                    exitProgram = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
        scanner.close();
    }
}
