'use strict';

class LogoutCommand extends AbstractLogoutCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.outcome = this.successfulLogout;
			resolve();
        });
    }
}

/*       S.D.G.       */
