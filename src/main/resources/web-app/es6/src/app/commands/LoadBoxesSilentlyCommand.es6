'use strict';

class LoadBoxesSilentlyCommand extends AbstractLoadBoxesSilentlyCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadBoxes(this.commandParam.token).then((data) => {
                    this.commandData = data;
                    var selection = {
                        context: "box",
                        selectedBox: undefined,
                        selectedCourse: undefined,
                        selectedLesson: undefined,
                        selectedTest: undefined,
                        selectedResult: undefined
                    };
                    this.commandData.selection = selection;
                    this.commandData.selectedBoxId = this.commandParam.selectedBoxId;
                    this.commandData.outcome = this.boxSilentlyLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die Vokabel-Boxen konnten nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
