'use strict';

class HeaderView {
    static renderLogin(eventData) {
        $.get('templates/login.mst', function(template) {
            var rendered = Mustache.render(template, eventData);
            $('.login-logout-pane').html(rendered);
        });
    };
    
    static renderLogout(eventData) {
        $.get('templates/logout.mst', function(template) {
            var rendered = Mustache.render(template, eventData);
            $('.login-logout-pane').html(rendered);
        });
    };
    
}

/*                    S.D.G.                    */
