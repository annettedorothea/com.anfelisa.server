'use strict';

class LoadPrivateLessonsCommand extends AbstractLoadPrivateLessonsCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadPrivateLessons(this.commandParam.token, this.commandParam.courseId).then((data) => {
                    this.commandData = data;
                    var selection = {
                        context: "private",
                        selectedBox: undefined,
                        selectedCourse: this.commandParam.courseId,
                        selectedLesson: undefined,
                        selectedTest: undefined,
                        selectedResult: undefined
                    };
                    this.commandData.selection = selection;
                    this.commandData.outcome = this.privateLessonsLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die Lektionen konnten nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
