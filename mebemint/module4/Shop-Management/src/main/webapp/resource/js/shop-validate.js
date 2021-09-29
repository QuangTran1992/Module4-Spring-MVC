$(document).ready(function (){
    $(".need-validate").validate({
        rules:{
            onfocusout  : false,
            onkeyup: false,
            onclick:false,
            address: {
                required: true
            },
            phone:{
                required: true
            },

        },
        messages : {
            address: {
                required: "Yeu cau nhap dia chi"
            },

            phone : {
                required: "Nhap so dien thoai"
            }
        },
        submitHandler : function (form){
            form.submit();
        }
    });
});
