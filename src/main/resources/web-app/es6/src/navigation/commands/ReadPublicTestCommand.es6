'use strict';

class ReadPublicTestCommand extends AbstractReadPublicTestCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.language = this.commandParam.language;
            var queryParams = [];
            queryParams.push({
                key: "testId",
                value: this.commandParam.testId
            });
            this.httpGet("api/tests/single", queryParams).then((data) => {
                this.commandData.data = data;
                this.commandData.outcome = this.ok;
                resolve();
            }, (error) => {
                this.commandData.messageKey = "readPublicTestFailed";
                this.commandData.error = error;
                this.commandData.outcome = this.error;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
