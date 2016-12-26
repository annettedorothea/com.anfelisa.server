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

    static renderBox(eventData) {
        if (!eventData.data) {
            eventData.data = {};
        }
        eventData.data.texts = Texts.user;
        $.get('templates/user/box.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };

    static renderCourseToBox(eventData) {
        eventData.data.texts = Texts.user;
        $.get('templates/user/boxAddCourse.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };

}

/*                    S.D.G.                    */
