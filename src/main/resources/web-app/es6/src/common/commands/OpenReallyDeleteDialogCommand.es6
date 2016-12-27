'use strict';

class OpenReallyDeleteDialogCommand extends AbstractOpenReallyDeleteDialogCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData = this.commandParam;
            this.commandData.outcome = this.commandParam.dialog;
			resolve();
        });
    }
}

/*       S.D.G.       */
