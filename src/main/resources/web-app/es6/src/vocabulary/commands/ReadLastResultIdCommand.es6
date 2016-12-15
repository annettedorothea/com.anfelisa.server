'use strict';

class ReadLastResultIdCommand extends AbstractReadLastResultIdCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.language = this.commandParam.language;
            this.commandData.hash = this.commandParam.hash;
            var queryParams = [];
            queryParams.push({
                key: "testId",
                value: this.commandParam.testId
            });
            this.httpGet("api/results/last", queryParams).then((data) => {
                this.commandData.data = data;
                this.commandData.outcome = this.resultIdRead;
                this.commandData.hash = this.commandData.hash + "/" + data.resultId;
                resolve();
            }, (error) => {
                this.commandData.messageKey = "readLastResultFailed";
                this.commandData.error = error;
                this.commandData.outcome = this.serverError;
                resolve();
            });
        });
    }
}

/*       S.D.G.       */
