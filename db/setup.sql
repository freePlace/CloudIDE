USE cloud_ide;
DELETE FROM project;
DELETE FROM user_account;
DELETE FROM user;
DELETE FROM role;
DELETE FROM programming_language_programming_language_keyword;
DELETE FROM programming_language_keyword;
DELETE FROM programming_language;
DELETE FROM logging_event;
DELETE FROM logging_type;

INSERT INTO logging_type VALUES(1,'ERROR');
INSERT INTO logging_type VALUES(2,'DEBUG');

INSERT INTO role(id_role, name) VALUES(1,'ROLE_ADMIN');
INSERT INTO role(id_role, name) VALUES(2,'ROLE_USER');

INSERT INTO user(id_user, first_name, login, password, id_role) VALUES(1, 'dev','dev','dev',1);

INSERT INTO user_account(id_user_account, account_non_expired, account_non_locked,
credentials_non_expired, enabled, id_user)
VALUES(1, 1, 1, 1, 1, 1);

INSERT INTO programming_language(id_programming_language, name) VALUES(1, 'Java');

INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(1,'abstract');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(2,'assert');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(3,'boolean');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(4,'break');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(5,'byte');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(6,'case');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(7,'catch');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(8,'char');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(9,'class');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(10,'const');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(11,'continue');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(12,'default');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(13,'do');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(14,'double');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(15,'else');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(16,'enum');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(17,'extends');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(18,'final');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(19,'finally');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(20,'float');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(21,'for');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(22,'goto');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(23,'if');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(24,'implements');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(25,'import');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(26,'instanceof');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(27,'int');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(28,'interface');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(29,'long');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(30,'native');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(31,'new');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(32,'package');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(33,'private');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(34,'protected');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(35,'public');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(36,'return');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(37,'short');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(38,'static');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(39,'strictfp');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(40,'super');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(41,'switch');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(42,'synchronized');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(43,'this');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(44,'throw');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(45,'throws');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(46,'transient');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(47,'try');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(48,'void');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(49,'volatile');
INSERT INTO programming_language_keyword(id_programming_language_keyword, name) VALUES(50,'while');

INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,1);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,2);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,3);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,4);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,5);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,6);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,7);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,8);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,9);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,10);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,11);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,12);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,13);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,14);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,15);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,16);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,17);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,18);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,19);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,20);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,21);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,22);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,23);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,24);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,25);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,26);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,27);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,28);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,29);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,30);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,31);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,32);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,33);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,34);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,35);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,36);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,37);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,38);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,39);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,40);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,41);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,42);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,43);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,44);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,45);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,46);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,47);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,48);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,49);
INSERT INTO programming_language_programming_language_keyword
    (id_programming_language, id_programming_language_keyword) VALUES(1,50);
    