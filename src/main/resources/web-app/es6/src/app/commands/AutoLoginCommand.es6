'use strict';

class AutoLoginCommand extends AbstractAutoLoginCommand {
    execute() {
        return new Promise((resolve) => {
            App.serverFacade.login(this.commandParam.username, this.commandParam.password).then((data) => {
                if (data["token"] === null) {
                    this.commandData.message = "Anmeldung schlug fehl. (Falscher Butzername oder falsches Passwort.)";
                    this.commandData.outcome = this.autoLoginFailed;
                } else {
                    this.commandData.token = data["token"];
                    this.commandData.username = this.commandParam.username;
                    this.commandData.password = this.commandParam.password;
                    this.commandData.sumOfPoints = data["sumOfPoints"];
                    this.commandData.outcome = this.successfulAutoLogin;
                }
                resolve();
            }, (error) => {
                this.commandData.message = "Anmeldung schlug fehl. (Falscher Butzername oder falsches Passwort.)";
                this.commandData.outcome = this.autoLoginFailed;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
