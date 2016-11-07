/**
 * Created by annette on 07.01.16.
 */

'use strict';

const serverError = "serverError";

var App = undefined;
function initApp() {

    ACEController.init();
    EventListenerRegistrationApp.init();
    App = {
        serverFacade: new ServerFacade(),
        commonView: new CommonView(),
        headerView: new HeaderView(),
        messagesView: new MessagesView(),
        contentView: new ContentView(),
        vocubularyView: new VocabularyView(),
        cardView: new CardView(),
        completeReplay: function() {
        },
        schema: "anfelisa"
    };
    if (!window.urlPrefix) {
        window.urlPrefix = "http://localhost:8080/";
    }
    new InitAppAction().apply();
}

initApp();

ACEController.verificationCleanupFunction = function (key, value) {
    if (key === 'timestamp' || key === 'token' || key === 'nextRandomIndex' || key === 'id' || key === 'next' || key === 'last' || key === 'date' || key === 'day' || key === 'month' || key === 'year') {
        return undefined;
    } else {
        return value;
    }
};

/*       S.D.G.       */
