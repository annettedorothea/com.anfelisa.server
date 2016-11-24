'use strict';

class BreadcrumbsView {
    static renderPublicCoursesBreadcrumbs(eventData) {
        $.get('templates/breadcrumbsTemplate1Public.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPublicLessonsBreadcrumbs(eventData) {
        $.get('templates/breadcrumbsTemplate2Public.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPublicTestsBreadcrumbs(eventData) {
        $.get('templates/breadcrumbsTemplate3Public.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPrivateCoursesBreadcrumbs(eventData) {
    };
    
    static renderPrivateLessonsBreadcrumbs(eventData) {
    };
    
    static renderPrivateTestsBreadcrumbs(eventData) {
    };
    
}

/*                    S.D.G.                    */
