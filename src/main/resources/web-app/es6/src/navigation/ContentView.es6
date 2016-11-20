'use strict';

class ContentView {
    static renderPublicCourses(data) {
        $.get('templates/contentTemplate1.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
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
    
    static renderResult(data) {
    };
    
    static renderStatistics(data) {
    };
    
}

/*                    S.D.G.                    */
