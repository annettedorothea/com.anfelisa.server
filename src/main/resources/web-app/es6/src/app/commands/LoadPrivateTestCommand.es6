'use strict';

class LoadPrivateTestCommand extends AbstractLoadPrivateTestCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadPrivateTest(this.commandParam.token, this.commandParam.testId).then((data) => {
                    this.commandData = data;
                    var content = data["html"];
                    content = content.replace(/\\/g, '');
                    this.commandData.content = content;
                    this.commandData.testId = this.commandParam.testId;
                    var selection = {
                        context: "private",
                        selectedBox: undefined,
                        selectedCourse: data.courseid,
                        selectedLesson: data.lessonid,
                        selectedTest: this.commandParam.testId,
                        selectedResult: undefined
                    };
                    this.commandData.selection = selection;
                    this.commandData.outcome = this.privateTestLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Der Test konnte nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
