'use strict';

class InitAppCommand extends AbstractInitAppCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.username && this.commandParam.password) {
                this.commandData.username = this.commandParam.username;
                this.commandData.password = this.commandParam.password;
                this.commandData.hash = this.commandParam.hash;
                this.commandData.outcome = this.autoLogin;
            } else {
                this.commandData.hash = this.commandParam.hash;
                this.commandData.outcome = this.userIsNotLoggedIn;
            }
            resolve();
        });
    }
}

/*       S.D.G.       */
