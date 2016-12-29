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

    static renderPasswordChange(eventData) {
        eventData.texts = Texts.user;
        $.get('templates/user/changePassword.mst', function(template) {
            var rendered = Mustache.render(template, eventData);
            $('.content-pane').html(rendered);
        });
    };

    static passwordOK(eventData) {
        $("#passwordRepetitionDiv").removeClass("has-error");
        $("#passwordRepetitionDiv .passwordMismatch").hide();
    };

    static passwordMismatch(eventData) {
        $("#passwordRepetitionDiv").addClass("has-error");
        $("#passwordRepetitionDiv .error").hide();
        $("#passwordRepetitionDiv .passwordMismatch").show();
    };

}

/*                    S.D.G.                    */
