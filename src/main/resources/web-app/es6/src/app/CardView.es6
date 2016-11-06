'use strict';

class CardView {
    static showWanted() {
        Mousetrap.unbind('enter');
        $('.wanted-word').show();
    }

    static showNextLine() {
        var nextLine = $(".line.hiddenLine").first();
        nextLine.removeClass("hiddenLine");
        nextLine.children().removeClass("hiddenWord");
    }

    static showNextWord() {
        var nextWord = $(".line.hiddenLine .word.hiddenWord").first();
        nextWord.removeClass("hiddenWord");
        if (nextWord.is(':last-child')) {
            nextWord.parent().removeClass("hiddenLine");
        }
    }

    static showScoreButtons() {
        Mousetrap.unbind('enter');
        Mousetrap.unbind('alt+enter');
        $('.quality-buttons button').removeAttr("disabled");
        Mousetrap.bind('q', function () {
            $(".quality-buttons .btn-green").click()
        });
        Mousetrap.bind('a', function () {
            $(".quality-buttons .btn-blue").click()
        });
        Mousetrap.bind('y', function () {
            $(".quality-buttons .btn-cyan").click()
        });
        Mousetrap.bind('w', function () {
            $(".quality-buttons .btn-orange").click()
        });
        Mousetrap.bind('s', function () {
            $(".quality-buttons .btn-red").click()
        });
        Mousetrap.bind('x', function () {
            $(".quality-buttons .btn-pink").click()
        });

        // in test mode
        var finishCardButton3 = $('#finishCardButton3');
        finishCardButton3.removeAttr("disabled");
        finishCardButton3.removeClass("disabled");
        var finishCardButton2 = $('#finishCardButton2');
        finishCardButton2.removeAttr("disabled");
        finishCardButton2.removeClass("disabled");
        var finishCardButton1 = $('#finishCardButton1');
        finishCardButton1.removeAttr("disabled");
        finishCardButton1.removeClass("disabled");
        var repeatCardButton = $('#repeatCardButton');
        repeatCardButton.removeAttr("disabled");
        repeatCardButton.removeClass("disabled");
        let correctParagraph = $('#correctParagraph');
        correctParagraph.find('button.blueButton').addClass("btn-blue");
        correctParagraph.find('button.greenButton').addClass("btn-green");
        correctParagraph.find('button.orangeButton').addClass("btn-orange");
        correctParagraph.find('button.redButton').addClass("btn-red");
    };

    static goOnWithNewCards() {
        App.cardView.goOnWithNewCards = true;
    }

    static displayComplexCardFinishedSuccessfully(data) {
        App.cardView.testState = {
            points: data.points,
            maxPoints: data.maxPoints
        };
        jQuery('#correctParagraph').html(
            "Du hast " + data.points + " von maximal " + data.maxPoints
            + " Punkten erreicht.");
    }

    static renderNextCard(data) {
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

        if (data.score.cards_for_today > 0) {
            $('li.active span.badge').html(data.score.cards_for_today);
        } else if (data.score.cards_for_today == 0) {
            $('li.active span.badge').html('');
        }
        if (data.score.cards_for_today > 0 || App.cardView.goOnWithNewCards && data.score.new_cards > 0) {
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
        } else if (data.score.new_cards > 0 && !App.cardView.goOnWithNewCards) {
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
        App.cardView.currentCardId = data.id;
    }

    static renderCardForRepetition() {
        $.get('templates/cardRepetitionTemplate.mst', function(template) {
            var rendered = Mustache.render(template, App.cardView.boxRepetitionState.cards[App.cardView.boxRepetitionState.index]);
            $('.content-pane').html(rendered);
            App.cardView.boxRepetitionState.index++;
        });
    }

    static repeatComplexCard() {
        let finishCardButton3 = $("#finishCardButton3");
        finishCardButton3.attr("disabled", "disabled");
        finishCardButton3.addClass("disabled");
        let finishCardButton2 = $("#finishCardButton2");
        finishCardButton2.attr("disabled", "disabled");
        finishCardButton2.addClass("disabled");
        let finishCardButton1 = $("#finishCardButton1");
        finishCardButton1.attr("disabled", "disabled");
        finishCardButton1.addClass("disabled");
        let repeatCardButton = $("#repeatCardButton");
        repeatCardButton.attr("disabled", "disabled");
        repeatCardButton.addClass("disabled");
        let correctParagraph = $('#correctParagraph');
        correctParagraph.find('button.blueButton').removeClass("btn-blue");
        correctParagraph.find('button.greenButton').removeClass("btn-green");
        correctParagraph.find('button.orangeButton').removeClass("btn-orange");
        correctParagraph.find('button.redButton').removeClass("btn-red");

        $(".ccard .line").addClass("hiddenLine");
        $(".ccard .word").addClass("hiddenWord");
    }

    static repeatTodaysCards(data) {
        App.cardView.boxRepetitionState = {
            cards: data.cards,
            index: 0
        };
    }

    static resetGoOnWithNewCards() {
        App.cardView.goOnWithNewCards = false;
    }

    static initCurrentBoxId(data) {
        App.cardView.currentBoxId = data.boxId;
    }



}

/*                    S.D.G.                    */
