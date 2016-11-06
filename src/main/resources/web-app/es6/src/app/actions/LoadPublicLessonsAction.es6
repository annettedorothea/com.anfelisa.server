'use strict';

class LoadPublicLessonsAction extends AbstractLoadPublicLessonsAction {

    initActionData() {
        this.actionData.courseId = this.actionParam.courseId;
    }
}

/*       S.D.G.       */
