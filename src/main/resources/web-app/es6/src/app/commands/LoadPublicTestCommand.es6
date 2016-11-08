'use strict';

class LoadPublicTestCommand extends AbstractLoadPublicTestCommand {
    execute() {
        return new Promise((resolve) => {
            App.serverFacade.loadPublicTest(this.commandParam.uuid, this.commandParam.testId).then((data) => {
                var content = data["html"];
                content = content.replace(/\\/g, '');
                this.commandData.content = content;
                this.commandData.testId = this.commandParam.testId;
                var selection = {
                    context : "public",
                    selectedBox : undefined,
                    selectedCourse : data.courseid,
                    selectedLesson : data.lessonid,
                    selectedTest : this.commandParam.testId,
                    selectedResult : undefined
                };
                this.commandData.selection = selection;
                this.commandData.outcome = this.publicTestLoaded;
                resolve();
            }, (error) => {
                this.commandData.message = "Der Test konnte nicht geladen werden. (" + error + ")";
                this.commandData.outcome = this.serverError;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
