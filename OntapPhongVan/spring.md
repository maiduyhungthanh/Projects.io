## 1. Mô hình MVC là gì? Mô tả luồng đi của ứng dụng MVC
- mô hinh MVC: M = Model, C = Controller, V = View
- Luồng xử lý trong của mô hình MVC :
    + Khi một yêu cầu của từ máy khách (Client) gửi đến Server. Thì bị Controller trong MVC chặn lại để xem đó là URL request hay sự kiện.
    + Sau đó, Controller xử lý input của user rồi giao tiếp với Model trong MVC.
    + Model chuẩn bị data và gửi lại cho Controller.
    + Cuối cùng, khi xử lý xong yêu cầu thì Controller gửi dữ liệu trở lại View và hiển thị cho người dùng trên trình duyệt.
## 2. @Controller
## 3. Session và Cookie
- Cookie
    + Cookie được lưu trữ trên trình duyệt của người dùng	
    + Dữ liệu cookie được lưu trữ ở phía client.	     
    + Dữ liệu cookie dễ dàng sửa đổi hoặc đánh cắp khi chúng được lưu trữ ở phía client.	
    + Dữ liệu cookie có sẵn trong trình duyệt đến khi expired.

- Session
    + Session không được lưu trữ trên trình duyệt.
    + Dữ liệu session được lưu trữ ở phía server.
    + Dữ liệu session không dễ dàng sửa đổi vì chúng được lưu trữ ở phía máy chủ.
    + Sau khi đóng trình duyệt sẽ hết phiên làm việc (session)
