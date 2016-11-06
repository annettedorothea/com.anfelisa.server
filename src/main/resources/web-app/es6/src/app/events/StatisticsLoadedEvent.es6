'use strict';

class StatisticsLoadedEvent extends AbstractStatisticsLoadedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
        if (this.eventData.statistics && this.eventData.statistics.items) {
            for(var i=0; i<this.eventData.statistics.items.length; i++) {
                var item = this.eventData.statistics.items[i];
                if (item.maxpoints && item.points != undefined) {
                    item.rate = Math.round((item.points / item.maxpoints) * 100) + " %";
                }
            }
        }
    }
}

/*       S.D.G.       */
