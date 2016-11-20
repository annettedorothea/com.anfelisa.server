'use strict';

class BreadcrumbsView {
    static renderPublicCoursesBreadcrumbs(data) {
        $.get('templates/breadcrumbsTemplate1Public.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });
    };
    
    static renderPublicLessonsBreadcrumbs(data) {
    };
    
    static renderPublicTestsBreadcrumbs(data) {
    };
    
    static renderPrivateCoursesBreadcrumbs(data) {
    };
    
    static renderPrivateLessonsBreadcrumbs(data) {
    };
    
    static renderPrivateTestsBreadcrumbs(data) {
    };
    
}

/*                    S.D.G.                    */
