CREATE TABLE Employees(
    id IDENTITY,
    first_name varchar(20),
    last_name varchar(25),
    job_id varchar (10),
    salary float,
    department_id int
);

CREATE TABLE Jobs(
    job_id IDENTITY,
    job_title varchar(20),
    min_salary float,
    max_salary float
);

