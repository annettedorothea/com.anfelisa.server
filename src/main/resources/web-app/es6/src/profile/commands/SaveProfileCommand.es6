'use strict';

class SaveProfileCommand extends AbstractSaveProfileCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.language = this.commandParam.language;
            if (!this.commandParam.email || !this.commandParam.name || !this.commandParam.prename) {
                this.commandData.messageKey = "dataInvalid";
                this.commandData.outcome = this.dataInvalid;
                resolve();
            } else {
                this.httpPut("api/users/update", [], this.commandParam).then(() => {
                    this.commandData.outcome = this.saved;
                    this.commandData.hash = "profile";
                    resolve();
                }, (error) => {
                    this.commandData.messageKey = "saveProfileFailed";
                    this.commandData.error = error;
                    this.commandData.outcome = this.error;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
