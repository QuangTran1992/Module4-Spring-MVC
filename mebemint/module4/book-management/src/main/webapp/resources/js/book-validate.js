$(function() {
    $(".need-validate").validate({
        rules: {
            onfocusout: false,
            onkeyup: false,
            onclick: false,
            name: {
                required : true,
            },
            country: {
                required: true,
            },
            area: {
                required: true,


            },
            population: {
                required: true,
                minlength: 3,
                maxlength: 10
            }, gdp: {
                required: true,
                minlength: 3,
                maxlength: 5
            },

        },
        messages: {
            name: {
                required: "Không được bỏ trống"
            },
            country:{
                required: "Không được bỏ trống",

            },
            area: {
                required: "Không được bỏ trống",


            },
            population: {
                required: "Không được bỏ trống",
                minlength: "Dân số ít nhất là 100 người",
                maxlength: "dân số nhiều nhất là 1 tỷ người"

            },gdp: {
                required: "Không được bỏ trống",
                minlength: "GDP ít nhất là 100$ ",
                maxlength: "GDP nhiều nhất là 100000$"

            },

        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});