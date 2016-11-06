'use strict';

class HeaderView {
    static showLogout() {
        $(".logout-pane").show();
    }

    static hideLogout() {
        $(".logout-pane").hide();
    }

    static showLogin() {
        $(".login-pane").show();
    }

    static hideLogin() {
        $(".login-pane").hide();
    }

    static showPersonalMessage(data) {
        $(".hello-message").html("Hi " + data.username + "!");
        $(".goodbye-message").html("Bis bald, " + data.username + "!");
        $(".sum-of-points").html("Du hast insgesamt " + data.sumOfPoints + " Punkte.");
    }

    static renderSumOfPoints(data) {
        $(".sum-of-points").html("Du hast insgesamt " + data.points + " Punkte.");
    }

}

/*                    S.D.G.                    */
