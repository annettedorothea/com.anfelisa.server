'use strict';

class Command {
    constructor(commandParam, commandName) {
        this.commandParam = JSON.parse(JSON.stringify(commandParam));
        this.commandName = commandName;
        this.commandData = {};
    }

    execute() {
        throw "no execute method defined for " + this.commandName;
    }
    publishEvents() {
        throw "no publishEvents method defined for " + this.commandName;
    }

    executeCommand() {
        return new Promise((resolve, reject) => {
            if (ACEController.execution !== ACEController.REPLAY) {
                this.execute().then(() => {
                    ACEController.addItemToTimeLine({command: this});
                    this.publishEvents().then(() => {
                        ACEController.applyNextActions();
                        resolve();
                    }, (error) => {
                        reject(error + " when publishing events of command " + this.commandName);
                    });
                }, (error) => {
                    reject(error + " when executing command " + this.commandName);
                });
            } else {
                var timelineCommand = ACEController.getCommandByUuid(this.commandParam.uuid);
                this.commandData = timelineCommand.commandData;
                ACEController.addItemToTimeLine({command: this});
                this.publishEvents().then(() => {
                    setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
                    resolve();
                }, (error) => {
                    reject(error + " when publishing events of command " + this.commandName);
                });
            }
        });
    }
}

/*       S.D.G.       */

