'use strict';

class ShowWordAction extends AbstractShowWordAction {

    initActionData() {
        this.actionData.solution = jQuery(".active").next().html();
    }

}

/*       S.D.G.       */
