'use strict';

class Command {
    constructor(commandParam, commandName) {
        this.commandParam = JSON.parse(JSON.stringify(commandParam));
        this.commandName = commandName;
        this.commandData = {};
    }

    execute() {
        throw "no execute method defined for " + this.commandName;
    }
    publishEvents() {
        throw "no publishEvents method defined for " + this.commandName;
    }

    executeCommand() {
        return new Promise((resolve, reject) => {
            if (ACEController.execution !== ACEController.REPLAY) {
                this.execute().then(() => {
                    ACEController.addItemToTimeLine({command: this});
                    this.publishEvents().then(() => {
                        ACEController.applyNextActions();
                        resolve();
                    }, (error) => {
                        reject(error + " when publishing events of command " + this.commandName);
                    });
                }, (error) => {
                    reject(error + " when executing command " + this.commandName);
                });
            } else {
                var timelineCommand = ACEController.getCommandByUuid(this.commandParam.uuid);
                this.commandData = timelineCommand.commandData;
                ACEController.addItemToTimeLine({command: this});
                this.publishEvents().then(() => {
                    setTimeout(ACEController.applyNextActions, ACEController.pauseInMillis);
                    resolve();
                }, (error) => {
                    reject(error + " when publishing events of command " + this.commandName);
                });
            }
        });
    }

    httpGet(url, queryParams) {
        this.addUuidToQueryParams(queryParams);
        this.addSchemaToQueryParams(queryParams);
        return new Promise((resolve, reject) => {
            $.ajax({
                url: urlPrefix + url + this.queryParamString(queryParams),
                type: 'get',
                username: this.usernameString(),
                password: this.commandParam.password,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                success: function (data) {
                    resolve(data);
                },
                error: function (jqxhr, textStatus, error) {
                    if (jqxhr.status === 401) {
                        reject(this.httpUnauthorized);
                    } else {
                        reject(this.httpServerError);
                    }
                }
            });
        });
    }

    httpPost(url, queryParams, data) {
        this.addUuidToQueryParams(queryParams);
        this.addSchemaToQueryParams(queryParams);
        this.addUuidToData(data);
        this.addSchemaToData(data);
        return new Promise((resolve, reject) => {
            $.ajax({
                url: urlPrefix + url + this.queryParamString(queryParams),
                type: 'post',
                data: JSON.stringify(data),
                username: this.usernameString(),
                password: this.commandParam.password,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                success: function () {
                    resolve();
                },
                error: function (jqxhr, textStatus, error) {
                    if (jqxhr.status === 401) {
                        reject(this.httpUnauthorized);
                    } else {
                        reject(this.httpServerError);
                    }
                }
            });
        });
    }

    httpPut(url, queryParams, data) {
        this.addUuidToQueryParams(queryParams);
        this.addSchemaToQueryParams(queryParams);
        this.addUuidToData(data);
        this.addSchemaToData(data);
        return new Promise((resolve, reject) => {
            $.ajax({
                url: urlPrefix + url + this.queryParamString(queryParams),
                type: 'put',
                data: JSON.stringify(data),
                username: this.usernameString(),
                password: this.commandParam.password,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                success: function () {
                    resolve();
                },
                error: function (jqxhr, textStatus, error) {
                    if (jqxhr.status === 401) {
                        reject(this.httpUnauthorized);
                    } else {
                        reject(this.httpServerError);
                    }
                }
            });
        });
    }

    httpDelete(url, queryParams, data) {
        this.addUuidToQueryParams(queryParams);
        this.addSchemaToQueryParams(queryParams);
        this.addUuidToData(data);
        this.addSchemaToData(data);
        return new Promise((resolve, reject) => {
            $.ajax({
                url: urlPrefix + url + this.queryParamString(queryParams),
                type: 'delete',
                data: JSON.stringify(data),
                username: this.usernameString(),
                password: this.commandParam.password,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                success: function () {
                    resolve();
                },
                error: function (jqxhr, textStatus, error) {
                    if (jqxhr.status === 401) {
                        reject(this.httpUnauthorized);
                    } else {
                        reject(this.httpServerError);
                    }
                }
            });
        });
    }

    addUuidToQueryParams(queryParams) {
        if (!queryParams) {
            queryParams = [];
        }
        if (this.commandParam.uuid) {
            queryParams.push({
                uuid: this.commandParam.uuid
            });
        }
    }

    addSchemaToQueryParams(queryParams) {
        if (!queryParams) {
            queryParams = [];
        }
        if (this.commandParam.schema) {
            queryParams.push({
                schema: this.commandParam.schema
            });
        }
    }

    addUuidToData(data) {
        if (!data) {
            data = {};
        }
        if (this.commandParam.uuid) {
            data.uuid = this.commandParam.uuid;
        }
    }

    addSchemaToData(data) {
        if (!data) {
            data = {};
        }
        if (this.commandParam.schema) {
            data.schema = this.commandParam.schema;
        }
    }

    queryParamString(queryParams) {
        var queryString = "";
        if (queryParams && queryParams.length > 0) {
            for (var i = 0; i < queryParams.length; i++) {
                if (url.indexOf('?') === 0 && i === 0) {
                    queryParams += '?'
                } else {
                    queryParams += '&'
                }
                queryParams += queryParams[i].name + "=" + queryParams[i].value;
            }
        }
        return queryString;
    }

    usernameString() {
        var username = undefined;
        if (this.commandParam.schema) {
            username = this.commandParam.schema;
            if (this.commandParam.username) {
                username += "_";
            }
        }
        if (this.commandParam.username) {
            username += this.commandParam.username;
        }
        return username;
    }
    
}

/*       S.D.G.       */

