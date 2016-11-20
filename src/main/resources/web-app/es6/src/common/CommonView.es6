'use strict';

class CommonView {
    static initLanguageInLocalStorage(data) {
        localStorage.language = data.language;
    };

    static initSchemaInLocalStorage(data) {
        localStorage.schema = data.schema;
    };
    
    static updateHash(data) {
        window.location.hash = data.hash;
    };

}

/*                    S.D.G.                    */
