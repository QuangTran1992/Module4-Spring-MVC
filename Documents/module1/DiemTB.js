let Diemvatly;
let Diemoahoc;
let Diemsinhhoc;

Diemvatly = prompt("nhap diem ly");
Diemoahoc = prompt("nhap diem hoa");
Diemsinhhoc = prompt("nhap diem sinh");

let DTB =
  (parseFloat(Diemvatly) + parseFloat(Diemoahoc) + parseFloat(Diemsinhhoc)) / 3;

alert("DTB la :" + DTB);
