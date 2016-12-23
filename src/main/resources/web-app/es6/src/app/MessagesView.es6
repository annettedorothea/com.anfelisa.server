'use strict';

class MessagesView {
    static renderError(data) {
        $.get('templates/common/errorTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data.message);
            $('.notifications').html(rendered);
        });
        window.setTimeout(function () {
            $(".notifications div").fadeOut("slow", function () {
                $(".notifications").empty();
            });
        }, 3000);
    };
    
}

/*                    S.D.G.                    */
