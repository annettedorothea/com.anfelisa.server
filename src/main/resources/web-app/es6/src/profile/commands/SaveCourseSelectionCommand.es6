'use strict';

class SaveCourseSelectionCommand extends AbstractSaveCourseSelectionCommand {
    execute() {
        return new Promise((resolve) => {
            this.httpPost("api/users/courses", [], this.commandParam).then(() => {
                this.commandData.outcome = this.saved;
                this.commandData.hash = "profile";
                resolve();
            }, (error) => {
                this.commandData.messageKey = "addCoursesFailed";
                this.commandData.error = error;
                this.commandData.outcome = this.error;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
