$(document).ready(function() {

    $.ajax({
        url: "/captcha/renew/listAll",
        type: 'POST',
        contentType:'application/json;charset=UTF-8',
        dataType:'json',
        cache:true,
        success: function(data){

            $("tbody").find("tr:first").after('');
            var items = "";
            $.each(data, function (index,Info) {
                items += (" <tr> "+
                    "<td  style='width: 150px;'>"+Info['itemName']+"</td>" +
                    "<td  style='width: 150px;'>"+Info['itemDescribe']+"</td>"+
                    "<td  style='width: 150px;'>Stream: "+Info['streamLimit']+"</td>" +
                    "<td  class='h100 bg' style='width: 300px;'><div class='fl pic18'><span class='shiba' id='pricepack0'>"+Info['itemPrice']+"</span><span class='shiba1'>RMB</span></div>"+
                    "<div class='fl mt13'>"+
                    // "<div class='fl wx'> <a href='javascript:void(0)' id='paypackwx0' name='paybuttonwx' attrid='b8b54512cf804ef0b0c55925f52c4c65'>Wechat</a> </div>"+
                    "<div class='fl zfb'> <a href='javascript:void(0)' itemid='"+Info['id']+"' id='paypack0' name='paybutton' attrid='b8b54512cf804ef0b0c55925f52c4c65'>Alipay</a> </div>"+
                    "</div> </td> </tr><br>");
            })
            $("tbody").find("tr:first").after(items)

        }
    });


});