'use strict';

class LoadStatisticsAction extends AbstractLoadStatisticsAction {

    captureActionParam() {
        this.actionParam.year = $(".year").val();
        this.actionParam.month = $(".month").val();
        if (this.actionParam.year  === undefined || this.actionParam.month === undefined) {
            var now = new Date();
            this.actionParam.year = now.getFullYear();
            this.actionParam.month = now.getMonth() + 1;
        }
    }

    initActionData() {
        this.actionData.token = localStorage.token;
        this.actionData.year = this.actionParam.year ;
        this.actionData.month = this.actionParam.month ;
    }

    releaseActionParam() {
        $(".year").val(this.actionParam.year);
        $(".month").val(this.actionParam.month);
    }
}

/*       S.D.G.       */
