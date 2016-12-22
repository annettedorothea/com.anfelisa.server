'use strict';

class CommonView {
    static initLanguageInLocalStorage(data) {
        localStorage.language = data.language;
    };

    static initSchemaInLocalStorage(data) {
        localStorage.schema = data.schema;
    };
    
    static initUserInLocalStorage(data) {
        localStorage.username = data.username;
        localStorage.password = data.password;
    };

    static removeUserFromLocalStorage(data) {
        localStorage.removeItem("username");
        localStorage.removeItem("password");
    };

    static updateHash(data) {
        window.location.hash = data.hash;
    };

}

/*                    S.D.G.                    */
