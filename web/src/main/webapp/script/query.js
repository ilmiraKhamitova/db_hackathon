function ajaxQueryFunction(){
    $.get("/respsignals", function (response) {
        console.log("get")
        $.each(response, function(sensor, state){
            console.log("each")
            console.log(response)
            $('#sensor').append(`${sensor} ${state}`);
        })
    })
}

ajaxQueryFunction();

setInterval(ajaxQueryFunction, 10_000);
