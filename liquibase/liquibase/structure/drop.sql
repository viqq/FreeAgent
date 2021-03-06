ALTER TABLE USER DROP INDEX IN_USER;
ALTER TABLE SPORT DROP INDEX IN_SPORT;
ALTER TABLE SCHEDULE DROP INDEX IN_SCHEDULE;
ALTER TABLE SKILL DROP INDEX IN_SKILL;
ALTER TABLE DAY DROP INDEX IN_DAY;
ALTER TABLE WEEKDAY DROP INDEX IN_WEEKDAY;
ALTER TABLE MESSAGE DROP INDEX IN_MESSAGE;

DROP TABLE IF EXISTS USER_SPORT;
DROP TABLE IF EXISTS USER_FAVORITE;
DROP TABLE IF EXISTS WEEKDAY;
DROP TABLE IF EXISTS MESSAGE;
DROP TABLE IF EXISTS SPORT;
DROP TABLE IF EXISTS DAY;
DROP TABLE IF EXISTS SCHEDULE;
DROP TABLE IF EXISTS SKILL;
DROP TABLE IF EXISTS USER;
