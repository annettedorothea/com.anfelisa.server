'use strict';

class HeaderView {
    static renderLogin(eventData) {
        $.get('templates/common/login.mst', function(template) {
            var rendered = Mustache.render(template, eventData);
            $('.login-logout-pane').html(rendered);
        });
    };
    
    static renderLogout(eventData) {
        $.get('templates/common/logout.mst', function(template) {
            var rendered = Mustache.render(template, eventData);
            $('.login-logout-pane').html(rendered);
        });
    };
    
}

/*                    S.D.G.                    */
