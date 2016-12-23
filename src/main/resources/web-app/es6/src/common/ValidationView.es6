'use strict';

class ValidationView {
    static fieldEmpty(eventData) {
        $("#" + eventData.id + "Div").addClass("has-error");
        $("#" + eventData.id + "Div .error").hide();
        $("#" + eventData.id + "Div .notEmpty").show();
    };
    
    static fieldNotEmpty(eventData) {
        $("#" + eventData.id + "Div").removeClass("has-error");
        $("#" + eventData.id + "Div .notEmpty").hide();
    };
    
}

/*                    S.D.G.                    */
