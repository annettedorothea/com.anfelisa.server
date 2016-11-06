'use strict';

class LoadPrivateCoursesCommand extends AbstractLoadPrivateCoursesCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadPrivateCourses(this.commandParam.token).then((data) => {
                    this.commandData = data;
                    var selection = {
                        context: "private",
                        selectedBox: undefined,
                        selectedCourse: undefined,
                        selectedLesson: undefined,
                        selectedTest: undefined,
                        selectedResult: undefined
                    };
                    this.commandData.selection = selection;
                    this.commandData.outcome = this.privateCoursesLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die Kurse konnten nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
