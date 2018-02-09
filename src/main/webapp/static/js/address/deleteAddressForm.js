$('.deleteButton').click(function () {
    var url = $(this).attr("href");
    $.ajax({
        type: "GET",
        url: url,
        success: function (data) {
            window.location = data;
            // alert(data); // show response from the php script.
        }
    })
})