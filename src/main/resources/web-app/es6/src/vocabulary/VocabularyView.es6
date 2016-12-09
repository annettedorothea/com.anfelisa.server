'use strict';

var Vocabulary = {};
class VocabularyView {


    static wordIsCorrectAndFinished(eventData) {
        Mousetrap.unbind('ctrl+k');
        Mousetrap.unbind('g');
        Mousetrap.unbind('n');
        let active = jQuery(".active");
        active.attr("readonly", "readonly");
        active.addClass("correct");
        jQuery("#" + eventData.id + "_shots").append(
            "<span class='strike'><i class='fa fa-check-circle-o'></i></span>");
        active.addClass("strike");
        let strike = jQuery('input.strike');
        strike.removeClass("active");
        strike.removeClass("correct");
        strike.attr("disabled", "disabled");
        VocabularyView.updateTestState(eventData);
    };
    
    static wordIsCorrectAndNotFinished(eventData) {
        Mousetrap.unbind('ctrl+k');
        Mousetrap.unbind('g');
        Mousetrap.unbind('n');
        let active = jQuery(".active");
        active.attr("readonly", "readonly");
        active.addClass("correct");
        jQuery("#" + eventData.id + "_shots").append(
            "<span class='strike'><i class='fa fa-check-circle-o'></i></span>");
        VocabularyView.updateTestState(eventData);
    };
    
    static wordIsNotCorrect(eventData) {
        Mousetrap.unbind('ctrl+k');
        Mousetrap.unbind('g');
        Mousetrap.unbind('n');
        let active = jQuery(".active");
        active.attr("readonly", "readonly");
        active.addClass("false");
        jQuery("#" + eventData.id + "_shots")
            .append(
                "<span class='offTarget'><i class='fa fa-times-circle-o'></i></span>");
        let solution = jQuery("#" + eventData.id + "_solution");
        solution.html(eventData.solution);
        solution.addClass('displayedSolution');
        VocabularyView.updateTestState(eventData);
    };

    static updateTestState(eventData) {
        Vocabulary.testState.points = eventData.points;
        Vocabulary.testState.strikeCount = eventData.strikeCount;
    };


    static showWord(eventData) {
        Mousetrap.unbind('z');
        jQuery('.active').val(eventData.solution);
        jQuery('#showWord').remove();
        jQuery('#correctParagraph')
            .html(
                "<button id='known' class='btn btn-green' onclick='new RateWordAction({knewIt: true}).apply();'>Gewusst</button>" +
                "<button id='notKnown' class='btn btn-red' onclick='new RateWordAction({knewIt: false}).apply();'>Nicht gewusst</button>");
        Mousetrap.bind('g', function () {
            $("#known").click()
        });
        Mousetrap.bind('n', function () {
            $("#notKnown").click()
        });
    };
    
    static displayNextWordButton(eventData) {
        jQuery('#correctButton').remove();
        jQuery('#correctParagraph').html(
            "<button id='nextButton' class='btn btn-green' onclick='new ShowNextWordOfTestAction().apply()'>Weiter</button>");
        jQuery("#nextButton").focus();
        Mousetrap.bind('ctrl+space', function () {
            $("#nextButton").click()
        });
    };
    
    static displayTestFailed(eventData) {
        jQuery('#correctButton').remove();
        jQuery('#correctParagraph')
            .html(
                "Du bist jetzt auf 0 Punkten. Schau Dir die Vokabeln besser noch einmal an!");
    };
    
    static displayTestFinishedSuccessfully(eventData) {
        jQuery('#correctButton').remove();
        var maxPoints = (3 * Vocabulary.testState.wordCount);
        jQuery('#correctParagraph').html(
            "Du hast " + eventData.points + " von maximal " + maxPoints
            + " Punkten erreicht.");
    };
    
    static showNextWordOfTest(eventData) {
        jQuery('#nextButton').remove();
        Mousetrap.unbind('ctrl+space');
        let active = jQuery('.active');
        active.attr("disabled", "disabled");
        active.val("");
        active.removeClass("correct");
        active.removeClass("false");
        active.removeClass("active");
        let nextRandomIndex = jQuery('#' + eventData.nextRandomIndex);
        nextRandomIndex.addClass("active");
        if (Vocabulary.testState.testMode === "withTyping") {
            jQuery('#correctParagraph').html(
                "<button id='correctButton' class='btn btn-red' onclick='new CorrectWordAction().apply()'>Korrigieren</button>");
            let displayedSolution = jQuery('.displayedSolution');
            displayedSolution.html("");
            displayedSolution.removeClass("displayedSolution");
            nextRandomIndex.removeAttr("readonly");
            nextRandomIndex.removeAttr("disabled");
            nextRandomIndex.focus();
            Mousetrap.bind('ctrl+k', function () {
                $("#correctButton").click()
            });
        } else {
            jQuery('#correctParagraph').html(
                "<button id='showWord' class='btn btn-blue' onclick='new ShowWordAction().apply()'>Zeigen</button>");
            Mousetrap.bind('z', function () {
                $("#showWord").click()
            });
        }
    };
    
    static testStarted(eventData) {
        jQuery('#startButton').remove();
        var vocabulary = jQuery('.vocabulary');
        vocabulary.attr("disabled", "disabled");
        vocabulary.val("");
        let wordCount = (vocabulary).length;
        Vocabulary.testState = {
            wordCount: wordCount,
            strikeCount: 0,
            points: wordCount * 3,
            testMode: eventData.testMode,
            maxPoints: wordCount * 3,
            lastIndices: [],
            nextRandomIndex: function () {
                var random = Math.random();
                var index = Math.floor(random * Vocabulary.testState.wordCount) + 1;
                var indices = [];
                while (indices.length < wordCount) {
                    while (jQuery('#' + index).hasClass("strike")) {
                        random = Math.random();
                        index = Math.floor(random * Vocabulary.testState.wordCount) + 1;
                    }
                    indices.push(index);
                    random = Math.random();
                    index = Math.floor(random * Vocabulary.testState.wordCount) + 1;
                }
                var nextIndex;
                var smallestPositionInLastIndices = -1;
                for(var i=0; i<indices.length; i++) {
                    var currentIndex = indices[i];
                    var positionInLastIndices = Vocabulary.testState.lastIndices.indexOf(currentIndex);
                    if (positionInLastIndices < 0) {
                        nextIndex = currentIndex;
                        break;
                    } else if (smallestPositionInLastIndices === -1 || positionInLastIndices < smallestPositionInLastIndices) {
                        nextIndex = currentIndex;
                        smallestPositionInLastIndices = positionInLastIndices;
                    }
                }
                if (smallestPositionInLastIndices !== -1 && Vocabulary.testState.lastIndices.indexOf(indices[smallestPositionInLastIndices] > -1)) {
                    Vocabulary.testState.lastIndices.splice(smallestPositionInLastIndices, 1);
                }
                Vocabulary.testState.lastIndices.push(nextIndex);
                return nextIndex;
            }
        };
        vocabulary.addClass("mousetrap");
    };
    
}

/*                    S.D.G.                    */
