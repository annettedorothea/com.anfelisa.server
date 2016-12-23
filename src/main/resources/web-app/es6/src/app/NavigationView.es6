'use strict';

class NavigationView {
    static hideBoxes(data) {
        $('.box-navigation').empty();
    };

    static renderPublicCoursesNavigation(data) {
        $.get('templates/navigation/publicCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };

    static renderPublicLessonsNavigation(data) {
        $.get('templates/navigation/publicLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };

    static renderPublicTestsNavigation(data) {
        $.get('templates/navigation/publicTestsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    };

    static renderPublicTestNavigation(data) {
        $("ul.nav li").removeClass("active");
        $("ul.nav li.test_" + data.testId).addClass("active");
    };

    static renderBoxes(data) {
        $.get('templates/navigation/myBoxesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $(".box-navigation").html(rendered);
            if (data.selectedBoxId !== undefined) {
                $("ul.nav li").removeClass("active");
                $("ul.nav li.box_" + data.selectedBoxId).addClass("active");
            }
        });
    }

    static renderPrivateCoursesNavigation(data) {
        $.get('templates/navigation/privateCoursesTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    }

    static renderPrivateLessonsNavigation(data) {
        $("ul.nav li").removeClass("active");
        $.get('templates/navigation/privateLessonsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.course-navigation').html(rendered);
        });
    }

    static renderPrivateTestsNavigation(data) {
        $.get('templates/navigation/privateTestsTemplate.mst', function(template) {
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
