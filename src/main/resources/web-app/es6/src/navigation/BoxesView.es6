'use strict';

class BoxesView {
    static renderBoxes(eventData) {
        $.get('templates/navigation/myBoxesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $(".box-navigation").html(rendered);
        });
    };
    
    static hideBoxes(eventData) {
        $('.box-navigation').empty();
    };
    
}

/*                    S.D.G.                    */
