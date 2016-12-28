'use strict';

class ReallyDeleteDialogView {
    static displayRemoveCourseFromUserDialog(eventData) {
        bootbox.confirm(Texts.user.reallyRemoveCourseFromUser, function(result) {
            if (result === true) {
                new RemoveCourseAction( {'courseId' : eventData.courseId} ).apply();
            } else {
                new CloseAllDialogsAction().apply();
            }
        });
    };
    
    static displayDeleteBoxDialog(eventData) {
        bootbox.confirm(Texts.user.reallyDeleteBox, function(result) {
            if (result === true) {
                new DeleteBoxAction( {'boxId' : eventData.boxId} ).apply();
            } else {
                new CloseAllDialogsAction().apply();
            }
        });
    };

}

/*                    S.D.G.                    */
