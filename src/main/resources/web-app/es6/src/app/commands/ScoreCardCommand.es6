'use strict';

class ScoreCardCommand extends AbstractScoreCardCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                App.serverFacade.scoreCard(this.commandParam.token, this.commandParam.id, this.commandParam.quality, this.commandParam.boxId).then((data) => {
                    this.commandData = {};
                    this.commandData.points = data;
                    this.commandData.id = this.commandParam.id;
                    this.commandData.quality = this.commandParam.quality;
                    this.commandData.token = this.commandParam.token;
                    this.commandData.boxId = this.commandParam.boxId;
                    this.commandData.outcome = this.cardScored;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die Vokabel konnte nicht gewertet werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
