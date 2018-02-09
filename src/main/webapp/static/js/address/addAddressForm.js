$('#addressForm').submit(function (e) {
    var url = "/address/addAddress";
    $.ajax({
        type: "POST",
        url: url,
        data: $("#addressForm").serialize(),
        success: function (data) {
            window.location = data;
            // alert(data); // show response from the php script.
        }
    })
    e.preventDefault();
})