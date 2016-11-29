'use strict';

class NavigationView {
    static renderPublicCourses(eventData) {
        $.get('templates/publicCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicLessons(eventData) {
        $.get('templates/publicLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicTests(eventData) {
        $.get('templates/publicTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicTest(eventData) {
        $.get('templates/publicTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
            $("ul.nav li").removeClass("active");
            $("ul.nav li.test_" + eventData.data.testId).addClass("active");
        });
    };
    
    static renderPrivateCourses(eventData) {
        $.get('templates/privateCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPrivateLessons(eventData) {
        $.get('templates/privateLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPrivateTests(eventData) {
        $.get('templates/privateTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
            $("ul.nav li").removeClass("active");
            $("ul.nav li.test_" + eventData.data.testId).addClass("active");
        });
    };
    
    static renderPrivateTest(eventData) {
        $.get('templates/privateTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.course-navigation').html(rendered);
            $("ul.nav li").removeClass("active");
            $("ul.nav li.test_" + eventData.data.testId).addClass("active");
        });
    };
    
}

/*                    S.D.G.                    */
