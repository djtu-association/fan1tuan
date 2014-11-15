/**
 * Created by JOE on 13-12-16.
 */
/**
 * top cart rec
 */
$('document').ready(function(){

    //important
    var togCartIndex = 1;
    var contentIndex = 1;
    var contentArr = $('div.CartContent');
    var loop = 12;
    var times = parseInt(contentArr.length/loop); //共有6组卡片,内容可切换的次数
    var isClickNext = false;

    //changeabled config
    var toggleSpeed = 200;
    var toggleTime = 5000;//5秒
    var toggleNextSpeed = 200;//下一张牌的切换速度

    var stLoop = setInterval(function(){
        if(isClickNext){
            isClickNext = false;
            return;
        }
        toggleCart();//执行切牌
    },toggleTime);


    function toggleCart(){
        if(togCartIndex++%2 == 1 ){
            //first
            $('#togCart1_1').animate({bottom: "-=105px"}, toggleSpeed);
            toggleCartContent(1);
            $('#togCart1_2').animate({bottom: "+=105px"}, toggleSpeed);
            $('#togCart1_1').removeClass().addClass("palette palette-turquoise togCart");
            $('#togCart1_2').removeClass().addClass("palette palette-green-sea togCart");
            setTimeout(function(){
                //second
                $('#togCart2_1').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(2);
                $('#togCart2_2').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart2_1').removeClass().addClass("palette palette-sun-flower togCart");
                $('#togCart2_2').removeClass().addClass("palette palette-orange togCart");
            },toggleNextSpeed);
            setTimeout(function(){
                //third
                $('#togCart3_1').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(3);
                $('#togCart3_2').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart3_1').removeClass().addClass("palette palette-peter-river togCart");
                $('#togCart3_2').removeClass().addClass("palette palette-belize-hole togCart");
            },toggleNextSpeed*2);
            setTimeout(function(){
                //fourth
                $('#togCart4_1').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(4);
                $('#togCart4_2').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart4_1').removeClass().addClass("palette palette-alizarin togCart");
                $('#togCart4_2').removeClass().addClass("palette palette-pomegranate togCart");
            },toggleNextSpeed*3);
            setTimeout(function(){
                //fifth
                $('#togCart5_1').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(5);
                $('#togCart5_2').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart5_1').removeClass().addClass("palette palette-amethyst togCart");
                $('#togCart5_2').removeClass().addClass("palette palette-wisteria togCart");
            },toggleNextSpeed*4);
            setTimeout(function(){
                //sixth
                $('#togCart6_1').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(6);
                $('#togCart6_2').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart6_1').removeClass().addClass("palette palette-carrot togCart");
                $('#togCart6_2').removeClass().addClass("palette palette-pumpkin togCart");
            },toggleNextSpeed*5);
        }else{
            //first
            $('#togCart1_2').animate({bottom: "-=105px"}, toggleSpeed);
            toggleCartContent(1);
            $('#togCart1_1').animate({bottom: "+=105px"}, toggleSpeed);
            $('#togCart1_1').removeClass().addClass("palette palette-green-sea togCart");
            $('#togCart1_2').removeClass().addClass("palette palette-turquoise togCart");

            setTimeout(function(){
                //second
                $('#togCart2_2').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(2);
                $('#togCart2_1').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart2_1').removeClass().addClass("palette palette-orange togCart");
                $('#togCart2_2').removeClass().addClass("palette palette-sun-flower togCart");
            },toggleNextSpeed);
            setTimeout(function(){
                //third
                $('#togCart3_2').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(3);
                $('#togCart3_1').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart3_1').removeClass().addClass("palette palette-belize-hole togCart");
                $('#togCart3_2').removeClass().addClass("palette palette-peter-river togCart");
            },toggleNextSpeed*2);
            setTimeout(function(){
                //fourth
                $('#togCart4_2').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(4);
                $('#togCart4_1').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart4_1').removeClass().addClass("palette palette-pomegranate togCart");
                $('#togCart4_2').removeClass().addClass("palette palette-alizarin togCart");
            },toggleNextSpeed*3);
            setTimeout(function(){
                //fifth
                $('#togCart5_2').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(5);
                $('#togCart5_1').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart5_1').removeClass().addClass("palette palette-wisteria togCart");
                $('#togCart5_2').removeClass().addClass("palette palette-amethyst togCart");
            },toggleNextSpeed*4);
            setTimeout(function(){
                //sixth
                $('#togCart6_2').animate({bottom: "-=105px"}, toggleSpeed);
                toggleCartContent(6);
                $('#togCart6_1').animate({bottom: "+=105px"}, toggleSpeed);
                $('#togCart6_1').removeClass().addClass("palette palette-pumpkin togCart");
                $('#togCart6_2').removeClass().addClass("palette palette-carrot togCart");
            },toggleNextSpeed*5);
        }
    }

    //卡牌内容切换
    function toggleCartContent(key){

        loop = 12;
        if(contentIndex >= times){
            loop = 0;
        }

        switch (key){
            case 1:
                $("#togCart1_1").html(contentArr[contentIndex*loop+0].innerHTML);
                $("#togCart1_2").html(contentArr[contentIndex*loop+1].innerHTML);
                break;
            case 2:
                $("#togCart2_1").html(contentArr[contentIndex*loop+2].innerHTML);
                $("#togCart2_2").html(contentArr[contentIndex*loop+3].innerHTML);
                break;
            case 3:
                $("#togCart3_1").html(contentArr[contentIndex*loop+4].innerHTML);
                $("#togCart3_2").html(contentArr[contentIndex*loop+5].innerHTML);
                break;
            case 4:
                $("#togCart4_1").html(contentArr[contentIndex*loop+6].innerHTML);
                $("#togCart4_2").html(contentArr[contentIndex*loop+7].innerHTML);
                break;
            case 5:
                $("#togCart5_1").html(contentArr[contentIndex*loop+8].innerHTML);
                $("#togCart5_2").html(contentArr[contentIndex*loop+9].innerHTML);
                break;
            case 6:
                $("#togCart6_1").html(contentArr[contentIndex*loop+10].innerHTML);
                $("#togCart6_2").html(contentArr[contentIndex*loop+11].innerHTML);
                break;
        }

        if(key == 6){
            if(contentIndex  >= times){
                contentIndex=1;
            }else{
                contentIndex++;
            }
        }
    }

    //手动换一组
    $('#nextContents').click(function(){
        toggleCart();
        isClickNext = true;
    });



});