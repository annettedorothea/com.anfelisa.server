'use strict';

class EventListenerRegistrationApp {

	static init() {
    	ACEController.registerListener('UserIsLoggedInEvent', HeaderView.showLogout);
    	ACEController.registerListener('UserIsLoggedInEvent', HeaderView.hideLogin);
    	ACEController.registerListener('UserIsLoggedInEvent', HeaderView.showPersonalMessage);
    	ACEController.registerListener('UserIsLoggedInEvent', CommonView.setToken);
    	ACEController.registerListener('UserIsNotLoggedInEvent', NavigationView.hideBoxes);
    	ACEController.registerListener('UserIsNotLoggedInEvent', HeaderView.hideLogout);
    	ACEController.registerListener('UserIsNotLoggedInEvent', HeaderView.showLogin);
    	ACEController.registerListener('UserIsNotLoggedInEvent', CommonView.resetToken);
    	ACEController.registerListener('LoginFailedEvent', MessagesView.renderError);
    	ACEController.registerListener('StatisticsLoadedEvent', ContentView.renderStatistics);
    	ACEController.registerListener('PublicCoursesLoadedEvent', BreadcrumbsView.renderPublicCoursesBreadcrumbs);
    	ACEController.registerListener('PublicCoursesLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('PublicCoursesLoadedEvent', ContentView.renderPublicCoursesContentPane);
    	ACEController.registerListener('PublicCoursesLoadedEvent', NavigationView.renderPublicCoursesNavigation);
    	ACEController.registerListener('PublicLessonsLoadedEvent', NavigationView.renderPublicLessonsNavigation);
    	ACEController.registerListener('PublicLessonsLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('PublicLessonsLoadedEvent', ContentView.renderPublicLessonsContentPane);
    	ACEController.registerListener('PublicLessonsLoadedEvent', BreadcrumbsView.renderPublicLessonsBreadcrumbs);
    	ACEController.registerListener('PublicTestsLoadedEvent', NavigationView.renderPublicTestsNavigation);
    	ACEController.registerListener('PublicTestsLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('PublicTestsLoadedEvent', ContentView.renderPublicTestsContentPane);
    	ACEController.registerListener('PublicTestsLoadedEvent', BreadcrumbsView.renderPublicTestsBreadcrumbs);
    	ACEController.registerListener('PublicTestLoadedEvent', ContentView.renderPublicTestContentPane);
    	ACEController.registerListener('PublicTestLoadedEvent', NavigationView.renderPublicTestNavigation);
    	ACEController.registerListener('PublicTestLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('PrivateCoursesLoadedEvent', NavigationView.renderPrivateCoursesNavigation);
    	ACEController.registerListener('PrivateCoursesLoadedEvent', BreadcrumbsView.renderPrivateCoursesBreadcrumbs);
    	ACEController.registerListener('PrivateCoursesLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('PrivateCoursesSilentlyLoadedEvent', NavigationView.renderPrivateCoursesNavigation);
    	ACEController.registerListener('PrivateLessonsLoadedEvent', NavigationView.renderPrivateLessonsNavigation);
    	ACEController.registerListener('PrivateLessonsLoadedEvent', BreadcrumbsView.renderPrivateLessonsBreadcrumbs);
    	ACEController.registerListener('PrivateLessonsLoadedEvent', ContentView.renderPrivateLessonsContentPane);
    	ACEController.registerListener('PrivateLessonsLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('PrivateTestsLoadedEvent', NavigationView.renderPrivateTestsNavigation);
    	ACEController.registerListener('PrivateTestsLoadedEvent', BreadcrumbsView.renderPrivateTestsBreadcrumbs);
    	ACEController.registerListener('PrivateTestsLoadedEvent', ContentView.renderPrivateTestsContentPane);
    	ACEController.registerListener('PrivateTestsLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('PrivateTestsSilentlyLoadedEvent', NavigationView.renderPrivateTestsNavigation);
    	ACEController.registerListener('PrivateTestsSilentlyLoadedEvent', BreadcrumbsView.renderPrivateTestsBreadcrumbs);
    	ACEController.registerListener('PrivateTestLoadedEvent', NavigationView.renderPrivateTestNavigation);
    	ACEController.registerListener('PrivateTestLoadedEvent', ContentView.renderPrivateTestContentPane);
    	ACEController.registerListener('PrivateTestLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('TestOfResultLoadedEvent', ContentView.renderPrivateTestContentPane);
    	ACEController.registerListener('TestOfResultLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('ResultLoadedEvent', ContentView.renderResultJson);
    	ACEController.registerListener('BoxesSilentlyLoadedEvent', NavigationView.renderBoxes);
    	ACEController.registerListener('NextCardLoadedEvent', CardView.renderNextCard);
    	ACEController.registerListener('NextCardLoadedEvent', CommonView.updateSelection);
    	ACEController.registerListener('GoOnWithNewCardsEvent', CardView.goOnWithNewCards);
    	ACEController.registerListener('ShowWantedEvent', CardView.showWanted);
    	ACEController.registerListener('ShowNextLineEvent', CardView.showNextLine);
    	ACEController.registerListener('ShowNextWordEvent', CardView.showNextWord);
    	ACEController.registerListener('ShowScoreButtonsEvent', CardView.showScoreButtons);
    	ACEController.registerListener('DisplayComplexCardFinishedSuccessfullyEvent', CardView.displayComplexCardFinishedSuccessfully);
    	ACEController.registerListener('ResultSavedEvent', HeaderView.renderSumOfPoints);
    	ACEController.registerListener('WordIsCorrectAndFinishedEvent', VocabularyView.wordIsCorrectAndFinished);
    	ACEController.registerListener('WordIsCorrectAndNotFinishedEvent', VocabularyView.wordIsCorrectAndNotFinished);
    	ACEController.registerListener('WordIsNotCorrectEvent', VocabularyView.wordIsNotCorrect);
    	ACEController.registerListener('DisplayTestFailedEvent', VocabularyView.displayTestFailed);
    	ACEController.registerListener('DisplayTestFinishedSuccessfullyEvent', VocabularyView.displayTestFinishedSuccessfully);
    	ACEController.registerListener('DisplayNextWordButtonEvent', VocabularyView.displayNextWordButton);
    	ACEController.registerListener('ShowNextWordOfTestEvent', VocabularyView.showNextWordOfTest);
    	ACEController.registerListener('ShowWordEvent', VocabularyView.showWord);
    	ACEController.registerListener('TestStartedEvent', VocabularyView.testStarted);
    	ACEController.registerListener('RepeatComplexCardEvent', CardView.repeatComplexCard);
    	ACEController.registerListener('RepeatTodaysCardsEvent', CardView.repeatTodaysCards);
    	ACEController.registerListener('CardScoredEvent', HeaderView.renderSumOfPoints);
    	ACEController.registerListener('BoxStartedEvent', CardView.resetGoOnWithNewCards);
    	ACEController.registerListener('BoxStartedEvent', CardView.initCurrentBoxId);
    	ACEController.registerListener('RenderCardForRepetitionEvent', CardView.renderCardForRepetition);
    	ACEController.registerListener('ServerErrorEvent', MessagesView.renderError);
	}

}

/*       S.D.G.       */
