$('#updateAddressForm').submit(function (e) {
    var url = "/address/getUpdateAddressAjax";
    $.ajax({
        type: "POST",
        url: url,
        data: $("#updateAddressForm").serialize(),
        success: function (data) {
            window.location = data;
            // alert(data); // show response from the php script.
        }

    })
    e.preventDefault();
})