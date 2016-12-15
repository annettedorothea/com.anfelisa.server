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
    
    static renderPrivateLessons(eventData) {
        $.get('templates/contentTemplate2.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPrivateTests(eventData) {
        $.get('templates/contentTemplate3.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
        });
    };
    
    static renderPrivateTest(eventData) {
        $(".content-pane").html(eventData.data.html);
        //enableDrag();
    };
    
    static renderResult(eventData) {
        var jsonString = eventData.data.json;
        if (jsonString != null && jsonString.length > 0) {
            var jsonObject = JSON.parse(jsonString);
            if ((jQuery(".vocabulary")).length > 0) {
                for (var i in jsonObject) {
                    var value = jsonObject[i];
                    if (jQuery("#" + i).hasClass('vocabulary')) {
                        jQuery("#" + i).addClass("strike");
                        jQuery("#" + i).attr("disabled", "disabled");
                        for (var j = 0; j < value.length; j++) {
                            if (value[j] == '1') {
                                jQuery("#" + i + "_shots")
                                    .append(
                                        "<span class='strike'><i class='fa fa-check-circle-o'></i></span>");
                            } else {
                                jQuery("#" + i + "_shots")
                                    .append(
                                        "<span class='offTarget'><i class='fa fa-times-circle-o'></i></span>");
                            }
                        }
                    }
                }
                jQuery('#correctParagraph').html(
                    "Du hast " + eventData.data.points + " von maximal "
                    + eventData.data.maxPoints + " Punkten erreicht.");
            } else if ((jQuery("#questionOverviewList")).length > 0) {
                alert('questionOverviewList');
                for (var i = 1; i <= jsonObject["maxPoints"]; i++) {
                    $("#" + i).addClass("show");
                    $("#" + i).removeClass("hide");
                    $("#" + i + " button").remove();
                    var j = 0;
                    var value = jsonObject[i + ""];
                    jQuery("#" + i + " i").each(function () {
                        jQuery(this).prop("onclick", null);
                        var v = value.charAt(j);
                        if (v == 1) {
                            jQuery(this).removeClass("fa fa-circle-o");
                            jQuery(this).addClass("fa fa-check-circle-o");
                            jQuery(this).addClass("correct");
                            $("#" + i + "_icon").removeClass("fa fa-circle-o");
                            $("#" + i + "_icon").addClass("fa fa-check-circle-o");
                            $("#" + i + "_icon").addClass("correct");
                        } else if (v == 2) {
                            jQuery(this).removeClass("fa fa-circle-o");
                            jQuery(this).addClass("fa fa-times-circle-o");
                            jQuery(this).addClass("false");
                            $("#" + i + "_icon").removeClass("fa fa-circle-o");
                            $("#" + i + "_icon").addClass("fa fa-times-circle-o");
                            $("#" + i + "_icon").addClass("false");
                        }
                        j++;
                    });
                }
                jQuery('#resultDiv').html(
                    "Du hast " + jsonObject["points"] + " von maximal "
                    + jsonObject["maxPoints"] + " Punkten erreicht.");
            } else if ((jQuery(".ccard")).length > 0) {
                $(".line").removeClass("invisible");
                $(".word").removeClass("invisible");
                jQuery('#correctParagraph').html(
                    "Du hast " + jsonObject["points"] + " von maximal "
                    + jsonObject["maxPoints"] + " Punkten erreicht.");
            } else {
                for (var i in jsonObject) {
                    var value = jsonObject[i];
                    if (jQuery("#" + i).hasClass('clickText')) {
                        jQuery("#" + i).html(value);
                    } else if (jQuery("#" + i).hasClass('completionText')) {
                        jQuery("#" + i).attr('value', value);
                    } else if (jQuery("#" + i).hasClass('singleChoice')) {
                        if (value == "selected") {
                            jQuery("#" + i).addClass("selectedItem");
                        }
                    } else if (jQuery("#" + i).hasClass('multipleChoice')) {
                        if (value == "selected") {
                            jQuery("#" + i).addClass("selectedItem");
                        }
                    } else if (jQuery("#" + i).hasClass('dragElement')) {
                        var splitted = value.split("###");
                        $("#" + i).children('.answer').html(splitted[0]);
                        jQuery("#" + i).css("left", splitted[1]);
                        jQuery("#" + i).css("top", splitted[2]);
                    }
                }
                ContentView.correctTest(false);
            }
        }
    };
    
    static renderStatistics(eventData) {
        if (eventData.data === null) {
            eventData.data = {
                statisticsItemList: []
            };
        }
        $.get('templates/statisticsTemplate.mst', function(template) {
            var rendered = Mustache.render(template, eventData.data);
            $('.content-pane').html(rendered);
            $(".year").val(eventData.data.year);
            $(".month").val(eventData.data.month);
        });
    };
    
    static renderCard(eventData) {
        var data = eventData.data;
        $.get('templates/breadcrumbsTemplateBox.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.breadcrumbs').html(rendered);
        });

        Mousetrap.unbind('q');
        Mousetrap.unbind('a');
        Mousetrap.unbind('y');
        Mousetrap.unbind('w');
        Mousetrap.unbind('s');
        Mousetrap.unbind('x');

        if (data.cardsForToday > 0) {
            $('li.active span.badge').html(data.cardsForToday);
        } else if (data.cardsForToday == 0) {
            $('li.active span.badge').html('');
        }
        if (data.cardsForToday > 0 || /*App.cardView.goOnWithNewCards &&*/ data.newCards > 0) {
            $.get('templates/cardTemplate.mst', function(template) {
                var rendered = Mustache.render(template, data);
                $('.content-pane').html(rendered);
            });
            if (data["content"]["complex"]) {
                Mousetrap.bind('enter', function () {
                    $(".ccard").click()
                });
            } else {
                Mousetrap.bind('enter', function () {
                    $(".card").click()
                });
            }
        } else if (data.newCards > 0 /*&& !App.cardView.goOnWithNewCards*/) {
            let activeItem = $('li.active i.fa');
            activeItem.removeClass('fa-pencil-square-o');
            activeItem.addClass('fa-check-square-o');
            $.get('templates/cardTemplateNewCards.mst', function(template) {
                var rendered = Mustache.render(template, data);
                $('.content-pane').html(rendered);
            });
        } else {
            let activeItem = $('li.active i.fa');
            activeItem.removeClass('fa-pencil-square-o');
            activeItem.addClass('fa-check-square-o');
            $.get('templates/cardTemplateFinished.mst', function(template) {
                var rendered = Mustache.render(template, data);
                $('.content-pane').html(rendered);
            });
        }
        //App.cardView.currentCardId = data.id;
    };

}

/*                    S.D.G.                    */
