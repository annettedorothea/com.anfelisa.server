'use strict';

class BreadcrumbsView {
    static renderPublicCoursesBreadcrumbs(data) {
        $.get('templates/breadcrumbsTemplate1Public.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPublicLessonsBreadcrumbs(data) {
        $.get('templates/breadcrumbsTemplate2Public.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPublicTestsBreadcrumbs(data) {
        $.get('templates/breadcrumbsTemplate3Public.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPrivateCoursesBreadcrumbs(data) {
    };
    
    static renderPrivateLessonsBreadcrumbs(data) {
    };
    
    static renderPrivateTestsBreadcrumbs(data) {
    };
    
}

/*                    S.D.G.                    */
