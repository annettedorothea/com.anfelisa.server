'use strict';

class LoadPrivateTestsSilentlyCommand extends AbstractLoadPrivateTestsSilentlyCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadPrivateTests(this.commandParam.token, this.commandParam.lessonId).then((data) => {
                    this.commandData = data;
                    var selection = {
                        context: "private",
                        selectedBox: undefined,
                        selectedCourse: data.courseid,
                        selectedLesson: this.commandParam.lessonId,
                        selectedTest: undefined,
                        selectedResult: undefined
                    };
                    this.commandData.selection = selection;
                    this.commandData.silently = this.commandParam.silently;
                    this.commandData.outcome = this.privateTestsSilentlyLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die Tests konnten nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
