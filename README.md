# SIS
# Version 1.2:
Chương trình LoginSIS có chức năng gửi gói tin POST mang tham số đăng nhập và sau đó gửi gói tin GET để lấy mã nguồn trang SIS về. Qua đó phân tích bằng JSoup để in ra màn hình tên sinh viên!
Chương trình dùng ngôn ngữ Java, phần mạng dựa trên nền tảng Apache, phân tích dựa trên Jsoup.

# Update
Chuyển về dạng hướng đối tượng, tạo package mới (com.Hactieuho96.SIS), các class mới 

Hướng dẫn download:
- Nhấn vào tap '<> Code' ở góc trên bên trái
- Nhấn vào nút 'Clone or download' màu xanh ở bên phải
- Nếu bạn đã có Github thì nhấn 'Open in Desktop' để kéo về máy của mình
- Nếu bạn chưa có thì nhấn 'Download Zip' để tải về dưới dạng nén, giải nén ra và add vào Eclipse hoặc netBean

Hướng dẫn sử dụng:
- Add project vào Eclipse hoặc netBean
- Build path tất cả thư viện .jar nằm trong thư mục 'Apache lib .jar'
- Chạy file 'Main.java' trong thư mục 'SIS\src\com\Hactieuho96\SIS\main', nhập username, password

Hướng phát triển cho phiên bản tiếp theo:
- Thêm comment, ít nhất 40% src code (mỗi dòng, mỗi hàm, mỗi lớp 1 comment)
- Ẩn mật khẩu khi nhập dạng ******
- Chuyển đổi dạng hiển thị giao diện (GUI)
- Chuyển đổi về dạng hướng đối tượng (chương trình vẫn còn mang tính cấu trúc nhiều)
- Lấy thông tin đăng ký lớp
- Lấy danh sách lớp mở theo thông tin đăng ký
- Tự động đưa ra những thời khóa biểu khả thi
- Tự động đăng ký theo thời khóa biểu mà người dùng lựa chọn
