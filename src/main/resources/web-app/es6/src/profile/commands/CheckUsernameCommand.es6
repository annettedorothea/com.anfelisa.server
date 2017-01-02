'use strict';

class CheckUsernameCommand extends AbstractCheckUsernameCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.language = this.commandParam.language;
            var queryParams = [];
            queryParams.push({
                key: "username",
                value: this.commandParam.username
            });
            this.httpGet("api/users/username", queryParams).then((data) => {
                if (data.available === true) {
                    this.commandData.outcome = this.available;
                } else {
                    this.commandData.outcome = this.notAvailable;
                }
                resolve();
            }, (error) => {
                this.commandData.messageKey = "checkUsernameFailed";
                this.commandData.error = error;
                this.commandData.outcome = this.error;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
