'use strict';

class ContentView {
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

    static renderPublicCoursesContentPane(data) {
        $.get('templates/contentTemplate1.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    };

    static renderPublicLessonsContentPane(data) {
        $.get('templates/contentTemplate2.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    };

    static renderPublicTestsContentPane(data) {
        $.get('templates/contentTemplate3.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    };

    static renderPublicTestContentPane(data) {
        $(".content-pane").html(data.content);
        // TODO remove again!
        enableDrag();
    }

    static renderPrivateLessonsContentPane(data) {
        $.get('templates/contentTemplate2.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    }

    static renderPrivateTestsContentPane(data) {
        $.get('templates/contentTemplate3.mst', function(template) {
            var rendered = Mustache.render(template, data);
            $('.content-pane').html(rendered);
        });
    }

    static renderPrivateTestContentPane(data) {
        $(".content-pane").html(data.content);
        //enableDrag();
    }

    static renderResultJson(data) {
        var jsonString = data.json;
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
                    "Du hast " + jsonObject["points"] + " von maximal "
                    + jsonObject["maxPoints"] + " Punkten erreicht.");
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
    }

    static correctTest() {
        var allClickTexts = jQuery(".clickText");
        var points = 0;
        var maxPoints = 0;
        var json = {};

        for (var i = 0; i < allClickTexts.length; i++) {
            var clickTextId = allClickTexts[i].id;
            var solution = jQuery("#" + clickTextId).next().html();
            var answer = jQuery("#" + clickTextId).html();
            json["" + clickTextId] = answer;
            if (solution == answer) {
                jQuery("#" + clickTextId).addClass("correct");
                points++;
            } else {
                jQuery("#" + clickTextId).addClass("false");
                jQuery("#" + clickTextId).append(
                    ' <i class="fa fa-question-circle" data-toggle="tooltip" title="'
                    + solution + '"></i>');
                jQuery('[data-toggle="tooltip"]').tooltip();
                points--;
            }
            maxPoints++;
            jQuery("#" + clickTextId).prop("onclick", null);
        }

        var allCompletionTexts = jQuery(".completionText");
        for (var i = 0; i < allCompletionTexts.length; i++) {
            var completionTextId = allCompletionTexts[i].id;
            var solution = jQuery("#" + completionTextId).next().html();
            var answer = jQuery("#" + completionTextId).val().trim();
            json["" + completionTextId] = answer;
            if (solution == answer) {
                jQuery("#" + completionTextId).addClass("correct");
                points++;
            } else {
                jQuery("#" + completionTextId).addClass("false");
                jQuery("#" + completionTextId).after(
                    ' <i class="fa fa-question-circle" data-toggle="tooltip" title="'
                    + solution + '" data-action="click"></i>');
                jQuery('[data-toggle="tooltip"]').tooltip();
            }
            maxPoints++;
            jQuery("#" + completionTextId).attr('readonly', 'readonly');
        }

        var allSingleChoices = jQuery(".singleChoice");
        var currentGroup = "";
        var groupCorrect;
        var precedingChoiceId;
        for (var i = 0; i < allSingleChoices.length; i++) {
            var singleChoiceId = allSingleChoices[i].id;
            if (!jQuery("#" + singleChoiceId).hasClass(currentGroup)) {
                if (groupCorrect) {
                    jQuery("#" + precedingChoiceId).parent().addClass("correct");
                } else {
                    jQuery("#" + precedingChoiceId).parent().addClass("false");
                }
                currentGroup = "group" + singleChoiceId;
                groupCorrect = true;
            }
            var solution = jQuery("#" + singleChoiceId).next().html();
            if (solution == "correct") {
                jQuery("#" + singleChoiceId).addClass("mcCorrect");
                if (jQuery("#" + singleChoiceId).hasClass("selectedItem")) {
                    json["" + singleChoiceId] = "selected";
                    points++;
                } else {
                    groupCorrect = false;
                    json["" + singleChoiceId] = "notSelected";
                }
                maxPoints++;
            } else {
                jQuery("#" + singleChoiceId).addClass("mcFalse");
                if (jQuery("#" + singleChoiceId).hasClass("selectedItem")) {
                    json["" + singleChoiceId] = "selected";
                    groupCorrect = false;
                } else {
                    json["" + singleChoiceId] = "notSelected";
                }
            }
            jQuery("#" + singleChoiceId).prop("onclick", null);
            precedingChoiceId = singleChoiceId;
        }
        if (groupCorrect) {
            jQuery("#" + precedingChoiceId).parent().addClass("correct");
        } else {
            jQuery("#" + precedingChoiceId).parent().addClass("false");
        }

        var allMultipleChoices = jQuery(".multipleChoice");
        for (var i = 0; i < allMultipleChoices.length; i++) {
            var multipleChoiceId = allMultipleChoices[i].id;
            if (!jQuery("#" + multipleChoiceId).hasClass(currentGroup)) {
                if (groupCorrect) {
                    jQuery("#" + precedingChoiceId).parent().addClass("correct");
                } else {
                    jQuery("#" + precedingChoiceId).parent().addClass("false");
                }
                currentGroup = "group" + multipleChoiceId;
                groupCorrect = true;
            }
            var solution = jQuery("#" + multipleChoiceId).next().html();
            json["" + multipleChoiceId] = answer;
            if (solution == "correct") {
                jQuery("#" + multipleChoiceId).addClass("mcCorrect");
                if (jQuery("#" + multipleChoiceId).hasClass("selectedItem")) {
                    points++;
                    json["" + multipleChoiceId] = "selected";
                } else {
                    points--;
                    groupCorrect = false;
                    json["" + multipleChoiceId] = "notSelected";
                }
            } else {
                jQuery("#" + multipleChoiceId).addClass("mcFalse");
                if (jQuery("#" + multipleChoiceId).hasClass("selectedItem")) {
                    json["" + multipleChoiceId] = "selected";
                    groupCorrect = false;
                    points--;
                } else {
                    points++;
                    json["" + multipleChoiceId] = "notSelected";
                }
            }
            maxPoints++;
            jQuery("#" + multipleChoiceId).prop("onclick", null);
            precedingChoiceId = multipleChoiceId;
        }
        if (groupCorrect) {
            jQuery("#" + precedingChoiceId).parent().addClass("correct");
        } else {
            jQuery("#" + precedingChoiceId).parent().addClass("false");
        }

        var allDropAreas = jQuery(".dropArea");
        for (var i = 0; i < allDropAreas.length; i++) {
            var dropAreaId = allDropAreas[i].id;
            jQuery("#" + dropAreaId).addClass("correct");
        }
        var allDragElements = jQuery(".dragElement");
        for (var i = 0; i < allDragElements.length; i++) {
            var dragElementId = allDragElements[i].id;
            var solution = jQuery("#" + dragElementId).children(".solution").html();
            var answer = jQuery("#" + dragElementId).children(".answer").html();
            $("#" + dragElementId).appendTo("#" + answer + "DropArea");
            $("#" + dragElementId).css("left", "");
            $("#" + dragElementId).css("top", "");
            $("#" + dragElementId).css("z-index", "");

            json["" + dragElementId] = answer;
            if (solution == answer) {
                jQuery("#" + dragElementId).addClass("correct");
                points++;
            } else {
                jQuery("#" + dragElementId).addClass("false");
                jQuery("#" + dragElementId).append(
                    ' <i class="fa fa-question-circle" data-toggle="tooltip" title="'
                    + solution + '" data-action="click"></i>');
                jQuery('[data-toggle="tooltip"]').tooltip();
                points--;
            }
            jQuery("#" + dragElementId).draggable('destroy')
            if ((navigator.userAgent.match(/iPhone/i))
                || (navigator.userAgent.match(/iPod/i))
                || (navigator.userAgent.match(/iPad/i))) {
                $("span.dragElement").bind('touchstart', function () {
                });
                $("span.dragElement").bind('touchend', function () {
                });
            }
            maxPoints++;
        }

        jQuery(".tip").addClass('visibleTip');
        jQuery(".tip").removeClass('tip');

        if (points < 0) {
            points = 0;
        }

        jQuery('#correctParagraph').html(
            "Du hast " + points + " von " + maxPoints + " Punkten erreicht.");

        jQuery('#correctButton').remove();
        json["points"] = points;
        json["maxPoints"] = maxPoints;
        json["testid"] = App.commonView.selection.selectedTest;
        json["token"] = localStorage.token;
    }


}

/*                    S.D.G.                    */
