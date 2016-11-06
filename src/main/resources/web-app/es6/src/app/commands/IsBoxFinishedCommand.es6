'use strict';

class IsBoxFinishedCommand extends AbstractIsBoxFinishedCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.index < this.commandParam.length) {
                this.commandData.outcome = this.notFinished
            } else {
                this.commandData.outcome = this.finished;
            }
            resolve();
        });
    }
}

/*       S.D.G.       */
