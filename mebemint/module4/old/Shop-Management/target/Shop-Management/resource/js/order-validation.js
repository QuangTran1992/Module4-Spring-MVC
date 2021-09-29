$(function() {
    $(".needs-validation").validate({
        rules: {
            onfocusout: false,
            onkeyup: false,
            onclick: false,
            address: {
                required: true

            },
            customerName: {
                number: true

            },
            deliverFee: {
                required: true

            },
            phone: {
                required: true
            },

        },
        messages: {
            address: {
                required: "true"

            },
            customerName: {
                number: "true"

            },
            deliverFee: {
                required: "true"

            },
            phone: {
                required: "true"
            },


        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});
