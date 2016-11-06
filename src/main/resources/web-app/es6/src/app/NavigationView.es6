'use strict';

class NavigationView {
    static hideBoxes(data) {
        $('.box-navigation').empty();
    };

    static renderPublicCoursesNavigation(data) {
        $.get('templates/publicCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };

    static renderPublicLessonsNavigation(data) {
        $.get('templates/publicLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };

    static renderPublicTestsNavigation(data) {
        $.get('templates/publicTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };

    static renderPublicTestNavigation(data) {
        $("ul.nav li").removeClass("active");
        $("ul.nav li.test_" + data.testId).addClass("active");
    };

    static renderBoxes(data) {
        $.get('templates/myBoxesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $(".box-navigation").html(rendered);
            if (data.selectedBoxId !== undefined) {
                $("ul.nav li").removeClass("active");
                $("ul.nav li.box_" + data.selectedBoxId).addClass("active");
            }
        });
    }

    static renderPrivateCoursesNavigation(data) {
        $.get('templates/myCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    }

    static renderPrivateLessonsNavigation(data) {
        $("ul.nav li").removeClass("active");
        $.get('templates/myLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    }

    static renderPrivateTestsNavigation(data) {
        $.get('templates/myTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    }

    static renderPrivateTestNavigation(data) {
        $("ul.nav li").removeClass("active");
        $("ul.nav li.test_" + data.testId).addClass("active");
    }

    static renderPrivateResultOfTestNavigation(data) {
        $("ul.nav li").removeClass("active");
        $("ul.nav li.result_" + data.resultId).addClass("active");
    }



}

/*                    S.D.G.                    */
