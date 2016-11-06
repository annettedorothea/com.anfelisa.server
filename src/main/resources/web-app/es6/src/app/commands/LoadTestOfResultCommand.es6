'use strict';

class LoadTestOfResultCommand extends AbstractLoadTestOfResultCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadTestOfResult(this.commandParam.resultId).then((data) => {
                    var content = data["html"];
                    content = content.replace(/\\/g, '');
                    this.commandData.content = content;

                    this.commandData.resultId = this.commandParam.resultId;
                    var selection = {
                        context: "private",
                        selectedBox: undefined,
                        selectedCourse: data.courseid,
                        selectedLesson: data.lessonid,
                        selectedTest: data.id,
                        selectedResult: this.commandData.resultId
                    };
                    this.commandData.selection = selection;
                    this.commandData.outcome = this.testOfResultLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Das Ergebnis konnte nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
