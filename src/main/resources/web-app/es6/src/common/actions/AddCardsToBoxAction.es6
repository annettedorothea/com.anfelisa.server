'use strict';

class AddCardsToBoxAction extends AbstractAddCardsToBoxAction {

    captureActionParam() {
		this.actionParam.username = localStorage.username;
		this.actionParam.password = localStorage.password;
		this.actionParam.schema = localStorage.schema;
        this.actionParam.hash = window.location.hash.substring(1);
    }

    initActionData() {
		this.actionData.username = this.actionParam.username;
		this.actionData.password = this.actionParam.password;
		this.actionData.schema = this.actionParam.schema;
		this.actionData.resultId = this.actionParam.resultId;
		this.actionData.boxIds = this.actionParam.boxIds;
        this.actionData.hash = this.actionParam.hash;
    }

    releaseActionParam() {
		localStorage.username = this.actionParam.username;
		localStorage.password = this.actionParam.password;
		localStorage.schema = this.actionParam.schema;
    }
}

/*       S.D.G.       */
