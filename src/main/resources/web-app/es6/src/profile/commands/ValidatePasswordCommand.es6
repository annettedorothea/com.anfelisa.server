'use strict';

class ValidatePasswordCommand extends AbstractValidatePasswordCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.newPassword != this.commandParam.passwordRepetition) {
                this.commandData.outcome = this.mismatch;
            } else {
                this.commandData.outcome = this.ok;
            }
            resolve();
        });
    }
}

/*       S.D.G.       */
