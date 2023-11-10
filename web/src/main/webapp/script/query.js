function ajaxQueryFunction(){
    const block = document.getElementById("block");
    block.innerHTML = "";
    $.get("/respsignals", function (response) {
        $.each(response, function(sensor, state){
            if (state === "t") state = '1';
            if (state === 'f') state = '0';
            $('#block').append(`<div class="sensor" id="sensor">
                                    <div class="title">
                                        ${sensor}
                                    </div> 
                                    <div class="content">
                                        ${state}
                                    </div> 
                                </div>`);
        })
    })
}

ajaxQueryFunction();

setInterval(ajaxQueryFunction, 10_000);

