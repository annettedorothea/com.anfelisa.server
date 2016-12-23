'use strict';

class UserInfoView {
    static renderUserInfo(eventData) {
        eventData.data.texts = Texts.user;
        $.get('templates/user/profile.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderCourseSelection(eventData) {
        eventData.data.texts = Texts.user;
        $.get('templates/user/courses.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };

}

/*                    S.D.G.                    */
