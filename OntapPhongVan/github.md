## 1. Git Fork
- Git Fork là một thao tác copy Repository từ 1 github khác về github của mình.Và bản copy này là độc lập,chỉnh sửa kho chứa code này sẽ không ảnh hưởng đến kho chứa gốc.Có thể liên hệ với Repository Gốc thông qua PullRequests
- Git Clone là một thao tác copy kho chứa Repository trên githib về máy local của mình
- Git Branch là một thao tác tạo nhánh phụ kế thừa toàn bộ code và lịch sử của nhánh chính. Vi dụ: "git branch nhanh_phu"
## 2. Sự khác nhau giữa "pull request" và "branch"?
- Branch là 1 nhánh của Kho code, khi nhánh này thay đổi,chỉnh sửa code và muốn báo cho nhánh Chính về sự thay đổi,chỉnh sửa thì sẽ tạo Pull Request.Khi ở nhánh chính thấy sự thay đổi này phù hợp sẽ Merger Pull Request để cập nhập thay đổi cho nhánh Chính
## 3. Sự khác nhau giữa "git pull" and "git fetch"?
- 2 lệnh này sự dụng khi repository trên trang github cập nhập dự liệu nhưng repository ở trên máy local thì chưa được cập nhập
- lúc đấy chúng ta sẽ sử dụng lệnh "git pull = git fetch origin + git merger origin/master
## 4. Làm thế nào để revert previous commit trong git?
- Chúng ta có 2 cách để quay lại commit cũ

    + Xóa commit mới nhất và quay về commit gần nhất
```github
git reset HEAD~1
```

* Cập nhập commit mới có nội dung y chang commit cũ gần nhất
```github
git revert HEAD~1
```
## 5. Khi nào nên sử dụng "git stash"?
- git stash là một thao tác khi gặp trường hợp code thay đổi so với lần commit gần nhất và lập trình viên muốn xử lý các vấn đề phát sinh trước commit gần nhất
    + Git stash save  
    + Git stash list
    + Git stash apply
    + Git stash pop
    + Git stash show
    + Git stash branch <name>
    + Git stash clear
    + Git stash drop
## 6. Khi nào bạn sử dụng "git rebase" thay vì "git merge"?
- git rebase 
