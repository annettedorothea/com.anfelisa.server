'use strict';

class ErrorView {
    static renderServerError(data) {
        $.get('texts/errors_' + data.language + '.json', function(texts) {
            data.message = texts[data.messageKey];
            $.get('templates/serverErrorTemplate.mst', function(template) {
                var rendered = Mustache.render(template, data);
                $('.notifications').html(rendered);
            });
            window.setTimeout(function () {
                $(".notifications div").fadeOut("slow", function () {
                    $(".notifications").empty();
                });
            }, 3000);
        });

    };
    
    static renderError(data) {
        $.get('templates/errorTemplate.mst', function(template) {
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
