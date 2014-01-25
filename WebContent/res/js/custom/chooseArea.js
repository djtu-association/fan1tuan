/**
 * Created by JOE on 13-12-7.
 */



$('document').ready(function(){




    jQuery.fn.shake = function(intShakes /*Amount of shakes*/, intDistance /*Shake distance*/, intDuration /*Time duration*/) {
        this.each(function() {
            var jqNode = $(this);
            jqNode.css({position: 'relative'});
        for (var x=1; x<=intShakes; x++) {
            jqNode.animate({ left: (intDistance * -1) },(((intDuration / intShakes) / 4)))
                .animate({ left: intDistance },((intDuration/intShakes)/2))
                .animate({ left: 0 },(((intDuration/intShakes)/4)));
            }
        });
        return this;
    }
    $('.palette').shake(2,10,400);

    $('.palette').mouseover(function(){
        $(this).shake(2,10,400);
    });

});