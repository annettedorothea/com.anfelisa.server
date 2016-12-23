'use strict';

class BreadcrumbsView {
    static renderPublicCoursesBreadcrumbs(eventData) {
        $.get('templates/breadcrumbs/breadcrumbsTemplate1Public.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPublicLessonsBreadcrumbs(eventData) {
        $.get('templates/breadcrumbs/breadcrumbsTemplate2Public.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPublicTestsBreadcrumbs(eventData) {
        $.get('templates/breadcrumbs/breadcrumbsTemplate3Public.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPrivateCoursesBreadcrumbs(eventData) {
        $.get('templates/breadcrumbs/breadcrumbsTemplate1.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPrivateLessonsBreadcrumbs(eventData) {
        $.get('templates/breadcrumbs/breadcrumbsTemplate2.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPrivateTestsBreadcrumbs(eventData) {
        $.get('templates/breadcrumbs/breadcrumbsTemplate3.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
}

/*                    S.D.G.                    */
