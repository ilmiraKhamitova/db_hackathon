window.setInterval(function(){
    ajaxQueryFunction();
}, 10_000);

function ajaxQueryFunction(){
    $.get("/respsignals", function (response) {
        $.each(response, function(sensor, state){
            $('#sensor').append(`${sensor} ${state}`);
        })
    })
}
