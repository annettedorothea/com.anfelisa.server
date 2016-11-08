'use strict';

class LoadPublicLessonsCommand extends AbstractLoadPublicLessonsCommand {
    execute() {
        return new Promise((resolve) => {
            App.serverFacade.loadPublicLessons(this.commandParam.uuid, this.commandParam.courseId).then((data) => {
                this.commandData = data;
                var selection = {
                    context: "public",
                    selectedBox: undefined,
                    selectedCourse: this.commandParam.courseId,
                    selectedLesson: undefined,
                    selectedTest: undefined,
                    selectedResult: undefined
                };
                this.commandData.selection = selection;
                this.commandData.outcome = this.publicLessonsLoaded;
                resolve();
            }, (error) => {
                this.commandData.message = "Die Lektionen konnten nicht geladen werden. (" + error + ")";
                this.commandData.outcome = this.serverError;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
