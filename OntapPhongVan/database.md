## 1. Join trong SQL
- INNER JOIN (Hoặc JOIN)
- LEFT OUTER JOIN (Hoặc LEFT JOIN)
- RIGHT OUTER JOIN (Hoặc RIGHT JOIN)
- FULL OUTER JOIN (Hoặc OUTER JOIN)
- Ví Dụ Cấu Trúc Câu Lệnh:
    ```SQL
    Select * from lanptp.khach_hang as KH Join lanptp.order_kh as OD on KH.MaKH= OD.MaKH
    ```
    + Trong đó: 
        +   lanptp :tên data    
        +   khach_hang: table trái
        +   order_kh:  table phải

## 2. Cấu trúc câu lệnh Select trong SQL
- Cú pháp câu lệnh SELECT:
    ```SQL
    SELECT <tên cột | biểu thức> [ ,…]<br>
    [ FROM <tên bảng> [ ,…] ]<br>
    [ WHERE <điều kiện logic trên dòng / bộ> ]<br>
    [GROUP BY <các thuộc tính gom nhóm> ]<br>
    [HAVING <điều kiện logic gom nhóm> ]<br>
    [ ORDER BY <các thuộc tính sắp xếp> ]<br>
    ```