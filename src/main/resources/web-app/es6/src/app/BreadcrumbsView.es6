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
        $.get('templates/breadcrumbsTemplate1.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });
    }

    static renderPrivateLessonsBreadcrumbs(data) {
        $.get('templates/breadcrumbsTemplate2.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });
    }

    static renderPrivateTestsBreadcrumbs(data) {
        $.get('templates/breadcrumbsTemplate3.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });
    }


}

/*                    S.D.G.                    */
