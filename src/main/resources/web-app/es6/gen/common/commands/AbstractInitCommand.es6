'use strict';

class AbstractInitCommand extends Command {
    constructor(commandParam) {
        super(commandParam, "InitCommand");
        this.publicCourses = "publicCourses";
        this.publicLessons = "publicLessons";
        this.publicTests = "publicTests";
        this.publicTest = "publicTest";
        this.privateCourses = "privateCourses";
        this.privateLessons = "privateLessons";
        this.privateTests = "privateTests";
        this.privateTest = "privateTest";
        this.result = "result";
        this.box = "box";
        this.statistics = "statistics";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.publicCourses:
        	promises.push(new TriggerAction(new ReadPublicCoursesAction(this.commandData)).publish());
        	break;
        case this.publicLessons:
        	promises.push(new TriggerAction(new ReadPublicLessonsAction(this.commandData)).publish());
        	break;
        case this.publicTests:
        	promises.push(new TriggerAction(new ReadPublicTestsAction(this.commandData)).publish());
        	break;
        case this.publicTest:
        	promises.push(new TriggerAction(new ReadPublicTestAction(this.commandData)).publish());
        	break;
        case this.privateCourses:
        	break;
        case this.privateLessons:
        	break;
        case this.privateTests:
        	break;
        case this.privateTest:
        	break;
        case this.result:
        	break;
        case this.box:
        	break;
        case this.statistics:
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
