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
        this.profile = "profile";
        this.profileCourses = "profileCourses";
        this.profileBoxCreate = "profileBoxCreate";
        this.profileBoxEdit = "profileBoxEdit";
        this.profileCourseAdd = "profileCourseAdd";
    }

    publishEvents() {
    	let promises = [];
    	
        switch (this.commandData.outcome) {
        case this.publicCourses:
        	promises.push(new UserIsNotLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPublicCoursesAction(this.commandData)).publish());
        	break;
        case this.publicLessons:
        	promises.push(new UserIsNotLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPublicLessonsAction(this.commandData)).publish());
        	break;
        case this.publicTests:
        	promises.push(new UserIsNotLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPublicTestsAction(this.commandData)).publish());
        	break;
        case this.publicTest:
        	promises.push(new UserIsNotLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPublicTestAction(this.commandData)).publish());
        	break;
        case this.privateCourses:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadStatisticsAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	break;
        case this.privateLessons:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateLessonsAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	break;
        case this.privateTests:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateTestsAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	break;
        case this.privateTest:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateTestAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	break;
        case this.result:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadResultAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	break;
        case this.box:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadNextCardAction(this.commandData)).publish());
        	break;
        case this.profile:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new OpenProfileAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	break;
        case this.profileCourses:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new OpenCourseSelectionAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	break;
        case this.profileBoxCreate:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new OpenBoxCreationAction(this.commandData)).publish());
        	break;
        case this.profileBoxEdit:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadBoxAction(this.commandData)).publish());
        	break;
        case this.profileCourseAdd:
        	promises.push(new UserIsLoggedInEvent(this.commandData).publish());
        	promises.push(new InitOKEvent(this.commandData).publish());
        	promises.push(new TriggerAction(new ReadPrivateCoursesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new ReadBoxesAction(this.commandData)).publish());
        	promises.push(new TriggerAction(new LoadCoursesAction(this.commandData)).publish());
        	break;
    	default:
    		throw 'unhandled outcome: ' + this.commandData.outcome;
    	}
    	return Promise.all(promises);
    }
}

/*       S.D.G.       */
