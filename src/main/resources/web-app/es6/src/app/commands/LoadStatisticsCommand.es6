'use strict';

class LoadStatisticsCommand extends AbstractLoadStatisticsCommand {
    execute() {
        return new Promise((resolve) => {
            if (this.commandParam.token === undefined) {
                this.commandData.outcome = this.userNotLoggedIn;
                resolve();
            } else {
                this.commandData.year = this.commandParam.year;
                this.commandData.month = this.commandParam.month;
                App.serverFacade.loadStatistics(this.commandParam.token, this.commandParam.year, this.commandParam.month).then((data) => {
                    this.commandData.outcome = this.statisticsLoaded;
                    if (data !== null && data.items !== null) {
                        var lastTimestamp = "";
                        for (var i = 0; i < data.items.length; i++) {
                            var item = data.items[i];
                            if (item.type === "test") {
                                item.isBox = false;
                            } else {
                                item.isBox = true;
                            }
                            item.index = i + 1;
                            if (lastTimestamp !== item.timestamp) {
                                lastTimestamp = item.timestamp;
                                var year = lastTimestamp.substring(0, 4);
                                var month = lastTimestamp.substring(5, 7)
                                var day = lastTimestamp.substring(8, 10)
                                item.date = day + "." + month + "." + year;
                                item.day = day;
                            }
                        }
                    }
                    this.commandData.statistics = data;
                    resolve();
                }, (error) => {
                    this.commandData.message = "Die Monats-Statistik konnte nicht geladen werden. (" + error + ")";
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */
