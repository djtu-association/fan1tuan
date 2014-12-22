/**
 * Created by lihe9_000 on 2014/12/22.
 */
$("body").off("keypress", "#searchField");
$("body").off("keydown", "#searchField");
$("body").off("keyup", "#searchField");

$("#searchField").keypress(function(event){
    event.preventDefault();
    if (event.which==13) {
        var keyword = $(this).val(),
            baseHref = window.location.protocol+"//"+window.location.hostname+":"+window.location.port;

        window.open(baseHref+"/search/index.f1t?keyword="+keyword);
    }
});