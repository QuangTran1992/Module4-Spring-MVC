
class App {
    static BASE_URL_SHOP = "http://localhost:8080/api/shops";
    static BASE_URL_ORDER = "http://localhost:8080/api/orders";


    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure you want to delete the selected data ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it !',
            cancelButtonText: 'Cancel',
        })
    }

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }
}

class Province {
    constructor(id,name,customer_id) {
        this.id = id;
        this.name = name;
        this.customer_id = customer_id;
    }
}

class Customer {
    constructor(id, fullName, email, phone, province) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.province = province;
    }
}
