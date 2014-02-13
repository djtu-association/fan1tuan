$(function() {
    var brow=$.browser;
    var miniOffset = 12;
    if(brow.msie) {miniOffset=30;}
    if(brow.mozilla) {miniOffset=30;}
    if(brow.safari) {miniOffset=12;}
    if(brow.opera) {miniOffset=12;}
    if(brow.chrome) {miniOffset=30;}
    //alert(miniOffset);
    //alert(bInfo);

    
    
    $( ".datepicker" ).datepicker();

    $("select").selectpicker({style: 'btn btn-info', menuStyle: 'dropdown-primary'});

    $(".add-order-filter").live("click", function(event){
        event.preventDefault();
        var order_filter = $(".order-filter");
        order_filter.toggleClass("sr-only");
        if(!order_filter.hasClass("sr-only")){
            $(this).html("精简筛选条件<i class='glyphicon glyphicon-circle-arrow-up'></i>");
        }else{
            $(this).html("更多筛选条件<i class='glyphicon glyphicon-circle-arrow-down'></i>");
        }
    });

    $(".add-comments-filter").live("click", function(event){
        event.preventDefault();
        var comments_filter = $(".comments-filter");
        comments_filter.toggleClass("sr-only");
        if(!comments_filter.hasClass("sr-only")){
            $(this).html("精简筛选条件<i class='glyphicon glyphicon-circle-arrow-up'></i>");
        }else{
            $(this).html("更多筛选条件<i class='glyphicon glyphicon-circle-arrow-down'></i>");
        }
    });

    $(".nav-link").click(function(event){
        event.preventDefault();

        
        //上一个导航按钮与其控制的domId
        var lastDom = $("a[class='nav-link s-active']");
        var lastId = lastDom.attr("data-id");
        //当前导航按钮与其控制的domId
        var me = $(this);
        var domId = me.attr("data-id");
        if(lastId==domId){
            return;
        }

        window.location.hash = "#"+domId;
        
        var mainContainer = $("#main_container");

        //两个控制区
        var lastContentDom =  $("div[data-mapped="+lastId+"]");
        var currentContentDom = $("div[data-mapped="+domId+"]");

        me.addClass("s-active");
        lastDom.removeClass("s-active");

        var topOffset = $(document).scrollTop();
        lastContentDom.attr("style","width:"+lastContentDom.width()+"px;height:"+lastContentDom.height()+"px;z-index: 300;left:"+lastContentDom.offset().left+"px;top:"+(lastContentDom.offset().top-topOffset+miniOffset)+"px;position:fixed;");
        //alert(lastContentDom.offset().top-topOffset);
        lastContentDom.animate({
            left:"800",
            opacity : "0"
        },330, function(){
            lastContentDom.attr("style","");
            lastContentDom.addClass("sr-only");
            if(domId=="comments"){
                mainContainer.css("background-color","ghostwhite");
            }else{
                mainContainer.css("background-color","white");
            }
            currentContentDom.removeClass("sr-only");
            currentContentDom.attr("style","width:"+currentContentDom.width()+"px;height:"+currentContentDom.height()+"px;z-index: 300;left:-500px;top:"+(currentContentDom.offset().top-topOffset+miniOffset)+"px;position:fixed;opacity:0");

            currentContentDom.animate({
                left:"+=500",
                opacity:1
            },250,function(){
                //alert("stop");
                currentContentDom.attr("style","width:"+currentContentDom.width()+"px;height:"+currentContentDom.height()+"px;z-index: 300;left:-500px;top:"+(currentContentDom.offset().top-topOffset+miniOffset)+"px;");
            });

        });
    });

    $("div[data-toggle=tooltip]").tooltip();


    $("div[data-toggle=tooltip]").click(function(){
        if($(this).children($(".switch-animate")).hasClass("switch-off")){
            $("#receiver").removeAttr("disabled");
            $("#receiver-cellphone").removeAttr("disabled");
        }else{
            $("#receiver").attr("disabled",true);
            $("#receiver-cellphone").attr("disabled",true);
        }
        $("#receiver").toggleClass("flat");
        $("#receiver-cellphone").toggleClass("flat");
    });
    
    
    /**
     * js全部加载好后执行切换tab的操作
     */
    var hash = window.location.hash;
    if(hash.length>1){
    	hash = hash.substring(1);
    	$("a[class*=nav-link][data-id="+hash+"]").click();
    }

});