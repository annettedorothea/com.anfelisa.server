'use strict';

class FillBoxWithCardsCommand extends AbstractFillBoxWithCardsCommand {
    execute() {
        return new Promise((resolve) => {
            var data = {
                boxIds: [ this.commandParam.boxId ]
            };
            this.httpPost("api/box/fill", [], data).then(() => {
                this.commandData.outcome = this.filled;
                this.commandData.hash = "profile";
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
