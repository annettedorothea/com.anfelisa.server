'use strict';

class NavigationView {
    static renderPublicCourses(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/publicCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicLessons(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/publicLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicTests(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/publicTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicTest(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/publicTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
            $("ul.nav li").removeClass("active");
            $("ul.nav li.test_" + eventData.data.testId).addClass("active");
        });
    };
    
    static renderPrivateCourses(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/privateCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPrivateLessons(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/privateLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPrivateTests(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/privateTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
            $("ul.nav li").removeClass("active");
            $("ul.nav li.test_" + eventData.data.testId).addClass("active");
        });
    };
    
    static renderPrivateTest(eventData) {
        eventData.data.texts = Texts.common;
        $.get('templates/navigation/privateTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
            $("ul.nav li").removeClass("active");
            $("ul.nav li.test_" + eventData.data.testId).addClass("active");
        });
    };
    
}

/*                    S.D.G.                    */
