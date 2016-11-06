'use strict';

class CommonView {

    static setToken(data) {
        localStorage.token = data.token;
        localStorage.username = data.username;
        localStorage.password = data.password;
    }

    static resetToken() {
        localStorage.removeItem("token");
        localStorage.removeItem("username");
        localStorage.removeItem("password");
    }

    static updateSelection(data) {
        App.commonView.selection = data.selection;
        var selection = data.selection;
        var hashString = selection.context;
        if (selection.context === 'public' || selection.context === 'private') {
            if (selection.selectedCourse !== undefined) {
                hashString += '/' + selection.selectedCourse;
                if (selection.selectedLesson !== undefined) {
                    hashString += '/' + selection.selectedLesson;
                    if (selection.selectedTest !== undefined) {
                        hashString += '/' + selection.selectedTest;
                        if (selection.selectedResult !== undefined) {
                            hashString += '/' + selection.selectedResult;
                        }
                    }
                }
            }
        } else if (selection.context === 'box') {
            hashString += '/' + selection.selectedBox;
        }
        window.location.hash = hashString;
    }
    
}

/*                    S.D.G.                    */
