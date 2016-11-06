'use strict';

class LoadNextCardCommand extends AbstractLoadNextCardCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadNextCard(this.commandParam.token, this.commandParam.boxId).then((data) => {
                    this.commandData = data;
                    this.commandData.boxId = this.commandParam.boxId;
                    var selection = {
                        context: "box",
                        selectedBox: this.commandParam.boxId,
                        selectedCourse: undefined,
                        selectedLesson: undefined,
                        selectedTest: undefined,
                        selectedResult: undefined
                    };
                    this.commandData.selection = selection;
                    this.commandData.outcome = this.nextCardLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die nächste Vokabel konnte nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
