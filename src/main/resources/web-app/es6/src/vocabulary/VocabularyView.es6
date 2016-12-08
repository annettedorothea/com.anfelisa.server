'use strict';

var Vocabulary = {};
class VocabularyView {


    static wordIsCorrectAndFinished(eventData) {
    };
    
    static wordIsCorrectAndNotFinished(eventData) {
    };
    
    static wordIsNotCorrect(eventData) {
    };
    
    static showWord(eventData) {
    };
    
    static goOnWithNextWord(eventData) {
    };
    
    static updateTestState(eventData) {
    };
    
    static displayNextWordButton(eventData) {
    };
    
    static displayTestFailed(eventData) {
    };
    
    static displayTestFinishedSuccessfully(eventData) {
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
