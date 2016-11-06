'use strict';

class SaveResultCommand extends AbstractSaveResultCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.saveResult(this.commandParam.token, this.commandParam.testId, this.commandParam.json, this.commandParam.points, this.commandParam.maxPoints).then((data) => {
                    this.commandData.points = data;
                    this.commandData.token = this.commandParam.token;
                    this.commandData.outcome = this.resultSaved;
                    this.commandData.lessonId = App.commonView.selection.selectedLesson;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Der Test konnte nicht gespeichert werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
