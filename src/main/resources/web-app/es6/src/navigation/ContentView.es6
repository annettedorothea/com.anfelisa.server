'use strict';

class ContentView {
    static renderPublicCourses(eventData) {
        $.get('templates/contentTemplate1.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPublicLessons(eventData) {
        $.get('templates/contentTemplate2.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPublicTests(eventData) {
        $.get('templates/contentTemplate3.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPublicTest(eventData) {
        $(".content-pane").html(eventData.data.html);
        //enableDrag();
    };
    
    static renderPrivateCourses(eventData) {
    };
    
    static renderPrivateLessons(eventData) {
    };
    
    static renderPrivateTests(eventData) {
    };
    
    static renderPrivateTest(eventData) {
    };
    
    static renderResult(eventData) {
    };
    
    static renderStatistics(eventData) {
        if (data.statistics === null) {
            data.statistics = {
                items: []
            };
        }
        $.get('templates/statisticsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data.statistics);
            $('.content-pane').html(rendered);
            $(".year").val(eventData.data.year);
            $(".month").val(eventData.data.month);
        });
    };
    
}

/*                    S.D.G.                    */
