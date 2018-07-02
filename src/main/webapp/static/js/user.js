$(function () {
   $.ajax({
       url:"/user/info",
       type:"POST",
       dataType:"json",
       contentType:"application/json",
       data:{},
       success:function (result) {
           $(".user_head_img").attr("src", result.headImage);
           $(".user_name").html(result.realName);
       }
   }) ;
});