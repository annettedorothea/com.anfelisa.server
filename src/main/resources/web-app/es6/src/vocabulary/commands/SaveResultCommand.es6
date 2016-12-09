'use strict';

class SaveResultCommand extends AbstractSaveResultCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.outcome = this.resultSaved;
			resolve();
        });
    }
}

/*       S.D.G.       */
