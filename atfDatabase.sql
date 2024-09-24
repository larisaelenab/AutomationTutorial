-- Create the database
CREATE DATABASE IF NOT EXISTS AutomationTutorialDB;

-- Use the database
USE AutomationTutorialDB;

-- Create the table with the required columns
CREATE TABLE WebTable (
    idWebTable INT NOT NULL AUTO_INCREMENT,
    firstNameValue VARCHAR(100),
    lastNameValue VARCHAR(100),
    emailValue VARCHAR(100),
    ageValue INT,
    salaryValue BIGINT,
    departmentValue VARCHAR(100),
    editsalaryValue BIGINT,
    editdepartmentValue VARCHAR(100),
    PRIMARY KEY (idWebTable)
);

CREATE TABLE PracticeForm (
    idPracticeForm INT NOT NULL AUTO_INCREMENT,
    firstNameValue VARCHAR(255),
    lastNameValue VARCHAR(255),
    emailValue VARCHAR(255),
    genderValue VARCHAR(255),
    userNumberValue VARCHAR(255),
    chooseDayValue VARCHAR(255),
    subjectValue VARCHAR(255),
    activitatiValue VARCHAR(255),
    terminatiePath VARCHAR(255),
    userAddressValue VARCHAR(255),
    stateinputValue VARCHAR(255),
    cityinputValue VARCHAR(255),
    PRIMARY KEY (idPracticeForm)
);

select * from WebTable;
