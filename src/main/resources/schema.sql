CREATE DATABASE IF NOT EXISTS doex;
USE doex;

CREATE TABLE IF NOT EXISTS userType (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        typeName VARCHAR(50) NOT NULL UNIQUE,
                                        typeValue int NOT NULL UNIQUE);

CREATE TABLE IF NOT EXISTS industry (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        industryName VARCHAR(50) NOT NULL UNIQUE);

CREATE TABLE IF NOT EXISTS job (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   jobName VARCHAR(50) NOT NULL UNIQUE,
                                   industryId INT,
                                   FOREIGN KEY (industryId) REFERENCES industry(id));

CREATE TABLE IF NOT EXISTS user (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    userName VARCHAR(50) NOT NULL UNIQUE,
                                    password VARCHAR(50) NOT NULL,
                                    userTypeId INT NOT NULL DEFAULT 3,
                                    FOREIGN KEY (userTypeId) REFERENCES userType(id),
                                    industryId int,
                                    FOREIGN KEY (industryId) REFERENCES industry(id),
                                    jobId int,
                                    FOREIGN KEY (jobId) REFERENCES job(id),
                                    questionNum INT default 0,
                                    createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    `avatar` text,
                                    `signature` text
);

create table if not exists achieve (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       achieveName VARCHAR(50) NOT NULL,
                                       achieveUrl VARCHAR(50)
);

create table if not exists userAchieve (
                                           userId INT NOT NULL,
                                           FOREIGN KEY (userId) REFERENCES user(id),
                                           achieveId INT NOT NULL,
                                           FOREIGN KEY (achieveId) REFERENCES achieve(id)
);

create table if not exists exercise (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        industryId INT not null,
                                        FOREIGN KEY (industryId) REFERENCES industry(id),
                                        jobId INT NOT NULL,
                                        FOREIGN KEY (jobId) REFERENCES job(id),
                                        exerciseContent longtext,
                                        exerciseAnswer longtext,
                                        ownerId INT NOT NULL,
                                        FOREIGN KEY (ownerId) REFERENCES user(id)
);

create table if not exists history (
                                       userId INT NOT NULL,
                                       FOREIGN KEY (userId) REFERENCES user(id),
                                       exerciseId INT NOT NULL,
                                       FOREIGN KEY (exerciseId) REFERENCES exercise(id)
);

create table if not exists collection (
                                          userId INT NOT NULL,
                                          FOREIGN KEY (userId) REFERENCES user(id),
                                          exerciseId INT NOT NULL,
                                          FOREIGN KEY (exerciseId) REFERENCES exercise(id)
);
INSERT INTO userType (id, typeName, typeValue) VALUES
                                                   (1, 'admin', 111),
                                                   (2,'commiter', 011),
                                                   (3,'user', 001);
INSERT INTO USER (id, userName, password, userTypeId) VALUES (1, 'admin', '5878bd76022e2a8de6d611696a13b32e', 1);
INSERT INTO USER (id, userName, password, userTypeId) VALUES (2, 'test1', '5a105e8b9d40e1329780d62ea2265d8a', 1);
select * from userType;