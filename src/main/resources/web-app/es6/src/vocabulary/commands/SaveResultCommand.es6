'use strict';

class SaveResultCommand extends AbstractSaveResultCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.language = this.commandParam.language;
            this.httpPost("api/results/save", [], this.commandParam).then(() => {
                this.commandData.outcome = this.resultSaved;
                resolve();
            }, (error) => {
                this.commandData.messageKey = "saveResultFailed";
                this.commandData.error = error;
                this.commandData.outcome = this.error;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
