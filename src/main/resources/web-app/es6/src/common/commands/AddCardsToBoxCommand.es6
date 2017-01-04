'use strict';

class AddCardsToBoxCommand extends AbstractAddCardsToBoxCommand {
    execute() {
        return new Promise((resolve) => {
            var data = {
                boxIds: this.commandParam.boxIds
            };
            this.httpPost("api/box/fill", [], data).then(() => {
                this.commandData.outcome = this.added;
                this.commandData.hash = this.commandParam.hash + "/" + this.commandParam.resultId;
                resolve();
            }, (error) => {
                this.commandData.messageKey = "fillBoxWithCardsFailed";
                this.commandData.error = error;
                this.commandData.outcome = this.error;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
