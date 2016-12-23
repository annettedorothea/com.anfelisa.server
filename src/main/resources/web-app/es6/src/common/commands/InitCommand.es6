'use strict';

class InitCommand extends AbstractInitCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.language = this.commandParam.language;
            this.commandData.username = this.commandParam.username;
            this.commandData.schema = this.commandParam.schema;
            if (this.commandParam.username) {
                this.commandData.outcome = this.privateCourses;
            } else {
                this.commandData.outcome = this.publicCourses;
            }
            if (this.commandParam.hash !== undefined) {
                var hashes = this.commandParam.hash.split("/");
                if (this.commandParam.username && hashes[0] === "public") {
                    hashes = [ "private" ];
                }
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
                                        this.commandData.outcome = this.result;
                                    } else {
                                        this.commandData.outcome = this.privateTest;
                                    }
                                } else {
                                    this.commandData.outcome = this.privateTests;
                                }
                            } else {
                                this.commandData.outcome = this.privateLessons;
                            }
                        } else {
                            this.commandData.outcome = this.privateCourses;
                        }
                    } else if (hashes[0] === "box" && hashes[1]) {
                        this.commandData.outcome = this.box;
                        this.commandData.boxId = hashes[1];
                    } else if (hashes[0] === "statistics") {
                        this.commandData.outcome = this.statistics;
                    } else if (hashes[0] === "profile") {
                        if (hashes[1] && hashes[1] === "courses") {
                            this.commandData.outcome = this.profileCourses;
                        } else {
                            this.commandData.outcome = this.profile;
                        }
                    } else {
                        if (hashes[1]) {
                            this.commandData.courseId = hashes[1];
                            if (hashes[2]) {
                                this.commandData.lessonId = hashes[2];
                                if (hashes[3]) {
                                    this.commandData.testId = hashes[3];
                                    this.commandData.outcome = this.publicTest;
                                } else {
                                    this.commandData.outcome = this.publicTests;
                                }
                            } else {
                                this.commandData.outcome = this.publicLessons;
                            }
                        } else {
                            this.commandData.outcome = this.publicCourses;
                        }
                    }
                }
            }
            resolve();
        });
    }
}

/*       S.D.G.       */
