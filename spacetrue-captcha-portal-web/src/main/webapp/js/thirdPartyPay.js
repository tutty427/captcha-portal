$(function(){
    var bizContent  = $(input[name='biz_content']).val();
    $.ajax({
        url: "/captcha/payment/getPageContent",
        type: 'POST',
        data:{itemDTO:bizContent},
        contentType:'application/json;charset=UTF-8',
        dataType:'html',
        cache:true,
        success: function(data){
            if(!data){
                window.location.href = '/captcha/toCenter'
            }
            $("body").empty();
            $("body").html(data);

        }
    });
})