'use strict';

class NavigationView {
    static renderPublicCourses(data) {
        $.get('templates/publicCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };
    
    static renderPublicLessons(data) {
    };
    
    static renderPublicTests(data) {
    };
    
    static renderPublicTest(data) {
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
