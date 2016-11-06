'use strict';

class LoadPublicTestsCommand extends AbstractLoadPublicTestsCommand {
    execute() {
        return new Promise((resolve) => {
            App.serverFacade.loadPublicTests(this.commandParam.lessonId).then((data) => {
                this.commandData = data;
                var selection = {
                    context : "public",
                    selectedBox : undefined,
                    selectedCourse : data.courseid,
                    selectedLesson : this.commandParam.lessonId,
                    selectedTest : undefined,
                    selectedResult : undefined
                };
                this.commandData.selection = selection;
                this.commandData.outcome = this.publicTestsLoaded;
                resolve();
            }, (error) => {
                this.commandData.message = "Die Tests konnten nicht geladen werden. (" + error + ")";
                this.commandData.outcome = this.serverError;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
