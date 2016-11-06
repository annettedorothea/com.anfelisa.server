'use strict';

class RepeatTodaysCardsCommand extends AbstractRepeatTodaysCardsCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadTodayCards(this.commandParam.token, this.commandParam.boxId).then((data) => {
                    this.commandData.cards = data;
                    var selection = {
                        context: "box",
                        selectedBox: this.commandParam.boxId,
                        selectedCourse: undefined,
                        selectedLesson: undefined,
                        selectedTest: undefined,
                        selectedResult: undefined
                    };
                    this.commandData.selection = selection;
                    this.commandData.boxId = this.commandParam.boxId;
                    this.commandData.outcome = this.todaysCardsLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die Karten konnten nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
