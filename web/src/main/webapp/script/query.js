function ajaxQueryFunction(){
    $.get("/respsignals", function (response) {
        console.log("fetch gone")
        $.each(response, function(sensor, state){
            console.log("response get")
            $('#sensor').append(`${sensor} ${state}`);
        })
    })
}

ajaxQueryFunction();

setInterval(ajaxQueryFunction, 10_000);
