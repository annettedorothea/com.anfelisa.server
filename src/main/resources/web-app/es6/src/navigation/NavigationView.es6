'use strict';

class NavigationView {
    static renderPublicCourses(data) {
        $.get('templates/publicCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicLessons(data) {
        $.get('templates/publicLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data.data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicTests(data) {
        $.get('templates/publicTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicTest(data) {
        $("ul.nav li").removeClass("active");
        $("ul.nav li.test_" + data.testId).addClass("active");
    };
    
    static renderPrivateCourses(data) {
    };
    
    static renderPrivateLessons(data) {
    };
    
    static renderPrivateTests(data) {
    };
    
    static renderPrivateTest(data) {
    };
    
}

/*                    S.D.G.                    */
