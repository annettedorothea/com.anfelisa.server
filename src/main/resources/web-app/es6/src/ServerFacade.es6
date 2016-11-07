/**
 * Created by annette on 07.01.16.
 */

'use strict';

class ServerFacade {
    reset() {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/reset.php"
            }).done(function () {
                resolve();
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPublicCourses(uuid) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/courses/public?uuid=" + uuid + "&schema=" + App.schema
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Kurse vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPublicLessons(courseId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getLessonsOfPublicCourse.php?&courseid=" + courseId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Lektionen vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPublicTests(lessonId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getTests.php?lessonid=" + lessonId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Tests vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPublicTest(testId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getTest.php?&testid=" + testId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Der Test ist nicht vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPrivateCourses(token) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getMyCourses.php?token=" + token
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Kurse vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPrivateLessons(token, courseId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getMyLessonsOfCourse.php?token=" + token + "&courseid=" + courseId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Lektionen vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPrivateTests(token, lessonId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getMyTests.php?token=" + token + "&lessonid=" + lessonId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Tests vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPrivateTest(token, testId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getMyTest.php?token=" + token + "&testid=" + testId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Test nicht vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadResult(token, resultId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getResult.php?&resultid=" + resultId + "&token=" + token
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Ergebnis nicht vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadTestOfResult(resultId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getTestOfResult.php?&resultid=" + resultId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Test nicht vorhanden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadPersonalMessage(token) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getPersonalMessage.php?token=" + token
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Persönliche Daten konnten nicht geladen werden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadBoxes(token) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getMyBoxes.php?token=" + token
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Vokabel-Boxen konnten nicht geladen werden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadNextCard(token, boxId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getNextCard.php?token=" + token + "&boxId=" + boxId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Nächste Vokabel konnte nicht geladen werden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadTodayCards(token, boxId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/repeatTodaysCards.php?token=" + token + "&boxId=" + boxId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Die Karten konnten nicht geladen werden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    scoreCard(token, id, quality, boxId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/scoreCard.php?token=" + token + "&id=" + id + "&quality=" + quality + "&boxId=" + boxId
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Vokabel konnte nicht gewertet werden.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    saveResult(token, testId, json, points, maxPoints) {
        return new Promise((resolve, reject) => {
            var jsonForPost = {};
            if (json !== undefined) {
                jsonForPost = JSON.parse(JSON.stringify(json));
            }
            jsonForPost["points"] = points;
            jsonForPost["maxPoints"] = maxPoints;
            jsonForPost["testId"] = testId;
            jsonForPost["token"] = token;

            $.post(urlPrefix + "api/saveResult.php", {
                json : jsonForPost
            }, function(data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Antwort vom Server.');
                }
            });
        });
    }

    login(username, password) {
        return new Promise((resolve, reject) => {
            var json = {};
            json["username"] = username;
            json["password"] = password;
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/login.php",
                data: JSON.stringify(json),
                type: "POST",
                contentType: "application/json; charset=utf-8"
            }).done(function (data) {
                if (data !== null) {
                    resolve(data);
                } else {
                    reject('Keine Antwort vom Server.');
                }
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };

    loadStatistics(token, year, month) {
        return new Promise((resolve, reject) => {
            $.ajax({
                dataType: "json",
                url: urlPrefix + "api/getMonthlyStatistics.php?token=" + token + "&year=" + year + "&month=" + month
            }).done(function (data) {
                resolve(data);
            }).fail(function (jqxhr, textStatus, error) {
                reject(error);
            });
        });
    };
}


/*       S.D.G.       */
