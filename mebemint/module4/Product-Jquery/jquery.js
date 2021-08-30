class Product {
  constructor(name, brand) {
    this.name = name;
    this.brand = brand;
  }
}

let productList = [
  new Product("Iphone 11 Pro-max", "Iphone"),
  new Product("Iphone 12 Pro-max", "Iphone"),
  new Product("IUltra20", "Samsung"),
];

let brands = ["IPhone", "SamSung", "XiaoMi", "Vertu"];

function showProduct() {
  // $(".table tbody").empty();
  // productList = productList.sort(function(a,b){
  //   return b.id - a.id;
  // }
  $.each(brands, (i, item) => {
    $("#brand").append(`
    <option value="${item}">${item}</option>
      `);
  });

  $.each(productList, (index, item) => {
    $(".table tbody").append(`
                <tr>
                    <th scope="row">${index + 1}</th>
                    <td class="prodName">${item.name}</td>
                    <td class="prodBrand">${item.brand}</td>
                    <td><a href="javascript:;" class="btn btn-outline-success edit" onclick = "select(${index})">Edit</a></td>
                    <td><a href="javascript:;" class="btn btn-outline-danger" onclick = "remove(${index})">Delete</a></td>
                </tr>
            `);
  });
}

function addProduct() {
  let name = $("#name").val();
  let brand = $("#brand").find(":selected").val();
  if (name == "" || brand == "") {
    Swal.fire({
      icon: "error",
      title: "Oops...",
      text: "Something went wrong!",
      footer: '<a href="">Why do I have this issue?</a>',
    });
  } else {
    Swal.fire({
      position: "top-end",
      icon: "success",
      title: "Your work has been saved",
      showConfirmButton: false,
      timer: 1500,
    });
    product = new Product(name, brand);
    productList.push(product);
    cleardata();
    $(".table tbody").append(`
                <tr>
                    <th scope="row">${productList.length}</th>
                    <td class="prodName">${name}</td>
                    <td class="prodBrand">${brand}</td>
                    <td><a href="javascript:;" class="btn btn-outline-success edit" id="show" onclick="select(${
                      productList.length - 1
                    })">Edit</a></td>
                    <td><a href="javascript:;" class="btn btn-outline-danger" onclick="remove(${
                      productList.length - 1
                    })">Delete</a></td>
                </tr>
            `);
  }
}
function remove(index) {
  Swal.fire({
    title: "Are you sure?",
    text: "You won't be able to revert this!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085D6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Yes, delete it!",
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire("Deleted!", "Your file has been deleted.", "success");
      productList.splice(index, 1);
    }
  });
}

function select(id) {
  $("#update").removeClass("d-none");
  $("#submit").addClass("d-none");
  $("#cancel").prop("disabled", false);
  // document.getElementById("name").value = productList[id].name;
  // document.getElementById("brand").value = productList[id].brand;
  // alert(productList[id].brand);
  // document.getElementById("brand").value = productList[id].brand;
  $.each(productList, (index, item) => {
    if (id == index) {
      $('input[name="productID"]').val(item.id);
      $('input[name="name"]').val(item.name);
      // $("#brand").val(item.brand).change();
      let brandName = productList[id].brand;

      $("#brand option:selected").text(brandName);
    }
  });
}

function cancel() {
  $("#update").addClass("d-none");
  $("#submit").removeClass("d-none");
  $("#cancel").prop("disabled", true);
  cleardata();
}

function cleardata() {
  document.getElementById("name").value = "";
}

$(document).ready(function () {
  showProduct();
});
