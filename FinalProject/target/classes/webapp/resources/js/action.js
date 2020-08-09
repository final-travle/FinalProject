$(function(){
    $(window).scroll(function() {
        // 위아래로 이동하는 버튼
        if ($(this).scrollTop() > 100) {
            $('.udBtns').fadeIn();
        } else {
            $('.udBtns').fadeOut();
        }
        var scrollTop = $(document).scrollTop();

        // 스크롤 따라다니는 채팅 버튼
        $(".chatSec").stop();
        $(".chatSec").animate({"top" : scrollTop - 60 });
    });
    
        
    $(".up").click(function() {
        $('html').animate({scrollTop : 0}, 600);
    });
    $(".down").click(function() {
        $('html').animate({scrollTop : ($('#footer').offset().top)}, 600);
    });
});

// select 시 leftBox 설정
$(function(){
    $(".leftSelBox .city .tit").on("click", function(){
        // alert($(this).text());
        $(".city .spot").hide();
        $(".leftSelBox .city .tit").css({"color":"#666", "font-weight":"normal"});
        $(this).css({"color":"#bd9dec", "font-weight":700}).next(".spot").show();
    });
    $(".leftSelBox .dayNight .tit").on("click", function(){
        // alert($(this).text());
        $(".dayNight .spot").hide();
        $(".leftSelBox .dayNight .tit").css({"color":"#666", "font-weight":"normal"});
        $(this).css({"color":"#bd9dec", "font-weight":700}).next(".spot").show();
    });
});