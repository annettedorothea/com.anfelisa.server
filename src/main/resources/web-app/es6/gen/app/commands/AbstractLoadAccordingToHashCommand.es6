'use strict';

class AbstractLoadAccordingToHashCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "LoadAccordingToHashCommand");
        this.loadPublicCourses = "loadPublicCourses";
        this.loadPublicLessons = "loadPublicLessons";
        this.loadPublicTests = "loadPublicTests";
        this.loadPublicTest = "loadPublicTest";
        this.loadPrivateCourses = "loadPrivateCourses";
        this.loadPrivateLessons = "loadPrivateLessons";
        this.loadPrivateTests = "loadPrivateTests";
        this.loadPrivateTest = "loadPrivateTest";
        this.loadResult = "loadResult";
        this.loadNextCard = "loadNextCard";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.loadPublicCourses:
        	promises.push(new TriggerAction(new LoadPublicCoursesAction(this.commandData)).publish());
        	break;
        case this.loadPublicLessons:
        	promises.push(new TriggerAction(new LoadPublicLessonsAction(this.commandData)).publish());
        	break;
        case this.loadPublicTests:
        	promises.push(new TriggerAction(new LoadPublicTestsAction(this.commandData)).publish());
        	break;
        case this.loadPublicTest:
        	promises.push(new TriggerAction(new LoadPublicTestsAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadPublicTestAction(this.commandData)).publish());
        	break;
        case this.loadPrivateCourses:
        	promises.push(new TriggerAction(new LoadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadBoxesSilentlyAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadStatisticsAction(this.commandData)).publish());
        	break;
        case this.loadPrivateLessons:
        	promises.push(new TriggerAction(new LoadPrivateLessonsAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadBoxesSilentlyAction(this.commandData)).publish());
        	break;
        case this.loadPrivateTests:
        	promises.push(new TriggerAction(new LoadPrivateTestsAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadBoxesSilentlyAction(this.commandData)).publish());
        	break;
        case this.loadPrivateTest:
        	promises.push(new TriggerAction(new LoadPrivateTestsSilentlyAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadPrivateTestAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadBoxesSilentlyAction(this.commandData)).publish());
        	break;
        case this.loadResult:
        	promises.push(new TriggerAction(new LoadPrivateTestsSilentlyAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadTestOfResultAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadBoxesSilentlyAction(this.commandData)).publish());
        	break;
        case this.loadNextCard:
        	promises.push(new BoxStartedEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new LoadNextCardAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
