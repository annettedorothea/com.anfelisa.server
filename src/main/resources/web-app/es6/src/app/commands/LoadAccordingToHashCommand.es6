'use strict';

class LoadAccordingToHashCommand extends AbstractLoadAccordingToHashCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.outcome = this.loadPublicCourses;
            if (this.commandParam.hash !== undefined) {
                var hashes = this.commandParam.hash.split("/");
                if (hashes[0]) {
                    if (hashes[0] === "private") {
                        if (hashes[1]) {
                            this.commandData.courseId = hashes[1];
                            if (hashes[2]) {
                                this.commandData.lessonId = hashes[2];
                                if (hashes[3]) {
                                    this.commandData.testId = hashes[3];
                                    if (hashes[4]) {
                                        this.commandData.resultId = hashes[4];
                                        this.commandData.outcome = this.loadResult;
                                    } else {
                                        this.commandData.outcome = this.loadPrivateTest;
                                    }
                                } else {
                                    this.commandData.outcome = this.loadPrivateTests;
                                }
                            } else {
                                this.commandData.outcome = this.loadPrivateLessons;
                            }
                        } else {
                            this.commandData.outcome = this.loadPrivateCourses;
                        }
                    } else if (hashes[0] === "box" && hashes[1]) {
                        this.commandData.outcome = this.loadNextCard;
                        this.commandData.boxId = hashes[1];
                    } else {
                        if (this.commandParam.userIsLoggedIn) {
                            this.commandData.outcome = this.loadPrivateCourses;
                        } else if (hashes[1]) {
                            this.commandData.courseId = hashes[1];
                            if (hashes[2]) {
                                this.commandData.lessonId = hashes[2];
                                if (hashes[3]) {
                                    this.commandData.testId = hashes[3];
                                    this.commandData.outcome = this.loadPublicTest;
                                } else {
                                    this.commandData.outcome = this.loadPublicTests;
                                }
                            } else {
                                this.commandData.outcome = this.loadPublicLessons;
                            }
                        } else {
                            this.commandData.outcome = this.loadPublicCourses;
                        }
                    }
                }
            }
            resolve();
        });
    }
}

/*       S.D.G.       */
