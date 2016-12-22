'use strict';

class TestView {
    static renderResult(eventData) {
        jQuery('#correctParagraph').html(
            "Du hast " + eventData.points + " von maximal "
            + eventData.maxPoints + " Punkten erreicht.");
    };
    
}

/*                    S.D.G.                    */
