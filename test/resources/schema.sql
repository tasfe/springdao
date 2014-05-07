CREATE TABLE Employees(
    id IDENTITY,
    first_name varchar(20),
    last_name varchar(25),
    job_id varchar (10),
    salary float,
    department_id int
);

CREATE TABLE Locations(
    id IDENTITY,
    street_address varchar(40),
    postal_code varchar(12),
    city varchar(30),
    state_province varchar(25),
    country_id varchar(2)
);

