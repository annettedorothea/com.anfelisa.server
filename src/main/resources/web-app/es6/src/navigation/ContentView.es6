'use strict';

class ContentView {
    static renderPublicCourses(data) {
        $.get('templates/contentTemplate1.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPublicLessons(data) {
        $.get('templates/contentTemplate2.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPublicTests(data) {
        $.get('templates/contentTemplate3.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPublicTest(data) {
        $(".content-pane").html(data.content);
        //enableDrag();
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
        if (data.statistics === null) {
            data.statistics = {
                items: []
            };
        }
        $.get('templates/statisticsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data.statistics);
            $('.content-pane').html(rendered);
            $(".year").val(data.year);
            $(".month").val(data.month);
        });
    };
    
}

/*                    S.D.G.                    */
