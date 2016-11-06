'use strict';

class LoginCommand extends AbstractLoginCommand {
    execute() {
        return new Promise((resolve) => {
            App.serverFacade.login(this.commandParam.username, this.commandParam.password).then((data) => {
                if (data["token"] === null) {
                    this.commandData.message = "Anmeldung schlug fehl. (Falscher Butzername oder falsches Passwort.)";
                    this.commandData.outcome = this.loginFailed;
                } else {
                    this.commandData.token = data["token"];
                    this.commandData.username = this.commandParam.username;
                    this.commandData.password = this.commandParam.password;
                    this.commandData.sumOfPoints = data["sumOfPoints"];
                    this.commandData.defaultMonth = true; // for LoadStatistics
                    this.commandData.outcome = this.successfulLogin;
                }
                resolve();
            }, (error) => {
                this.commandData.message = "Anmeldung schlug fehl. (" + error + ")";
                this.commandData.outcome = this.loginFailed;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
