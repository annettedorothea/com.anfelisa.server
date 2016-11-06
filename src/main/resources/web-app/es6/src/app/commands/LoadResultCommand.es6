'use strict';

class LoadResultCommand extends AbstractLoadResultCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.loadResult(this.commandParam.token, this.commandParam.resultId).then((data) => {
                    this.commandData.json = data["json"];
                    this.commandData.outcome = this.resultLoaded;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Das Ergebnis konnte nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
