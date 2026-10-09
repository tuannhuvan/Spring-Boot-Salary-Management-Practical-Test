# 💼 Spring Boot Salary Management System

[![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.1%2B-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Database](https://img.shields.io/badge/Database-MySQL-blue.svg)](https://www.mysql.com/)
[![Frontend](https://img.shields.io/badge/Frontend-Thymeleaf%20%7C%20Bootstrap%205-blueviolet.svg)](https://www.thymeleaf.org/)
[![License](https://img.shields.io/badge/FPT--Aptech-IASF%20Exam-red.svg)](https://aptech.fpt.edu.vn/)

Hệ thống **Quản lý Lương Nhân viên (Salary Management System)** là ứng dụng Web doanh nghiệp xây dựng trên nền tảng **Spring Boot Framework** theo kiến trúc MVC 3 lớp. Dự án phục vụ bài thi thực hành **IASF (Intergraphic Application using Spring Framework)** dành cho học viên FPT-Aptech.

---

## 🌟 Chức năng Chính (Core Features)

* ➕ **Thêm mới Nhân viên (Create User):** Nhập Tên, Tuổi, Lương với kiểm tra ràng buộc tự động và thông báo thành công.
* 📋 **Hiển thị Danh sách (Read Users):** Bảng quản lý danh sách nhân viên trực quan với thiết kế chuẩn Responsive.
* ✏️ **Cập nhật Nhân viên (Update User):** Tải thông tin ngược lên Form khi bấm `Edit`, cập nhật lại dữ liệu an toàn.
* 🗑️ **Xóa Nhân viên (Delete User):** Xóa bản ghi khỏi cơ sở dữ liệu với hộp thoại xác nhận.
* 🔍 **Tìm kiếm Nhân viên (Search User):** Lọc nhân viên theo tên từ ô tìm kiếm real-time.
* 🛡️ **Kiểm tra Ràng buộc Trùng tên (Unique Name Rule):** Ngăn chặn tạo mới/cập nhật trùng tên nhân viên và hiển thị thông báo lỗi mẫu đỏ chuẩn SRS:  
  `Error while creating User: Unable to create. A User with name [Name] already exist.`
* 🔄 **Reset Form Trực quan (jQuery Action):** Xóa trắng Form và đưa các trường nhập về trạng thái ban đầu chỉ với 1 cú click.

---

## 📊 Cấu trúc Điểm Đánh giá Bài thi (15.0 Điểm)

| STT | Hạng Mục Chấm Điểm | Nội Dung Chi Tiết | Điểm Tối Đa |
| :---: | :--- | :--- | :---: |
| **01** | **Cấu trúc & Entity** | Xây dựng Entity `User` (ID, Name, Age, Salary) & Package chuẩn MVC | **1.0 Điểm** |
| **02** | **Data Validation** | Kiểm tra dữ liệu rỗng, số âm và ràng buộc trùng tên nhân viên | **2.0 Điểm** |
| **03** | **Tìm kiếm (Search)** | Xử lý route lọc nhân viên theo từ khóa tên | **3.0 Điểm** |
| **04** | **Thao tác CRUD** | Hoàn thiện đủ 4 chức năng Create, Read, Update, Delete | **6.0 Điểm** |
| **05** | **Tích hợp View Engine** | Giao diện Thymeleaf + Bootstrap 5 + jQuery Reset Form | **3.0 Điểm** |
| **--** | **TỔNG ĐIỂM** | | **15.0 / 15.0** |

---

## 🏗️ Kiến trúc & Công nghệ Sử dụng

* **Backend Framework:** Spring Boot 3.x (Spring Web MVC, Spring Data JPA)
* **Programming Language:** Java 17
* **Database & ORM:** MySQL 8.x / H2 In-Memory DB (Hibernate 6.x)
* **Frontend View Engine:** Thymeleaf, Bootstrap 5.3 CDN, FontAwesome 6.4, jQuery 3.6
* **Build Tool:** Apache Maven

---

## 📂 Cấu trúc Dự án (Project Structure)

```
SalaryManagementPracticalTest/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── fpt/
    │   │           └── aptech/
    │   │               └── salarymanagement/
    │   │                   ├── SalaryManagementApplication.java
    │   │                   ├── controller/
    │   │                   │   └── UserController.java
    │   │                   ├── entity/
    │   │                   │   └── User.java
    │   │                   ├── repository/
    │   │                   │   └── UserRepository.java
    │   │                   └── service/
    │   │                       ├── UserService.java
    │   │                       └── impl/
    │   │                           └── UserServiceImpl.java
    │   └── resources/
    │       ├── application.properties
    │       └── templates/
    │           └── index.html
```

---

## 🚀 Hướng Dẫn Khởi Chạy (Getting Started)

### 1. Yêu cầu Tiền đề (Prerequisites)
* **JDK 17** hoặc cao hơn.
* **MySQL Server** (Khuyên dùng MySQL 8.0+).
* **Maven 3.8+** (hoặc dùng Maven Wrapper `mvnw` đi kèm).

### 2. Cấu hình CSDL (`application.properties`)
Mở file [`src/main/resources/application.properties`](file:///d:/06.Works/FPT-Aptech/Springboot/SalaryManagementPracticalTest/SalaryManagementPracticalTest/src/main/resources/application.properties) và chỉnh sửa thông tin kết nối MySQL:

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/salary_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

### 3. Lệnh Khởi chạy Dự án

```bash
# Clone dự án từ GitHub
git clone https://github.com/tuannhuvan/Spring-Boot-Salary-Management-Practical-Test.git
cd Spring-Boot-Salary-Management-Practical-Test

# Biên dịch dự án
./mvnw clean compile

# Khởi chạy ứng dụng
./mvnw spring-boot:run
```

Sau khi ứng dụng khởi chạy thành công, truy cập đường dẫn: **`http://localhost:8080`**

---

## 🔗 Danh sách Endpoint API / Controller Routes

| Method | Endpoint | Mô tả |
| :---: | :--- | :--- |
| `GET` | `/` hoặc `/users` | Trang chủ: Render form nhập liệu và danh sách nhân viên |
| `GET` | `/?keyword={name}` | Tìm kiếm nhân viên theo tên |
| `POST` | `/users/save` | Thêm mới nhân viên |
| `GET` | `/users/edit/{id}` | Lấy thông tin nhân viên nạp lên Form để sửa |
| `POST` | `/users/update` | Lưu thông tin nhân viên sau khi sửa |
| `GET` | `/users/delete/{id}` | Xóa nhân viên theo ID |

---

## 📝 License & Copyright

Bản quyền bài thi thực hành thuộc về **FPT-Aptech IASF Examination Board**.
