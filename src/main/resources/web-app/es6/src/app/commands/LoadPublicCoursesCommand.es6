'use strict';

class LoadPublicCoursesCommand extends AbstractLoadPublicCoursesCommand {
    execute() {
        return new Promise((resolve) => {
            this.httpGet("api/courses/public").then((data) => {
                this.commandData = data;
                var selection = {
                    context: "public",
                    selectedBox: undefined,
                    selectedCourse: undefined,
                    selectedLesson: undefined,
                    selectedTest: undefined,
                    selectedResult: undefined
                };
                this.commandData.selection = selection;
                this.commandData.outcome = this.publicCoursesLoaded;
                resolve();
            }, (error) => {
                this.commandData.message = "Die Kurse konnten nicht geladen werden. (" + error + ")";
                this.commandData.outcome = this.serverError;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
