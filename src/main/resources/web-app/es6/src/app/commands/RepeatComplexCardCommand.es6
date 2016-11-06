'use strict';

class RepeatComplexCardCommand extends AbstractRepeatComplexCardCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.outcome = this.repeatComplexCard;
			resolve();
        });
    }
}

/*       S.D.G.       */
