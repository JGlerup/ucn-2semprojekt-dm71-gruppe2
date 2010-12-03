create table location 
	(location_id		int			not null,
	zipcode				int			not null,
	city				varchar(15)	not null,
	primary key (location_id),
	unique(zipcode));

create table frequency 
	(frequency_id		int			not null,
	time				varchar(30)	not null,
	quantity			int			not null,
	date				datetime	not null,
	primary key (frequency_id));

create table car 
	(car_id				int			not null,
	registrationsno		int			not null,
	description			varchar(30)	not null,
	primary key (car_id),
	unique(registrationsno));

create table externalcontact 
	(externalcontact_id	int			not null,
	cbr					int,
	occupation			varchar(30)	not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	primary key (externalcontact_id),
	foreign key (location_id) references location(location_id));

create table client 
	(client_id			int			not null,
	clientno			int			not null,
	description			varchar(50) not null,
	interests			varchar(50) not null,
	health				varchar(50) not null,
	ssn					int			not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	primary key (client_id),
	unique(ssn),
	foreign key (location_id) references location(location_id));

create table employee 
	(employee_id		int			not null,
	employeeno			int			not null,
	managerno			int,
	jobtitle			varchar(30) not null,
	ssn					int			not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	primary key (employee_id),
	unique(employeeno),
	unique(ssn),
	foreign key (managerno) references employee(employeeno),
	foreign key (location_id) references location(location_id));
	
create table medicine 
	(medicine_id		int			not null,
	frequency_id		int			not null,
	externalcontact_id	int			not null,
	client_id			int			not null,
	name				varchar(30)	not null,
	description			varchar(50)	not null,
	date				datetime	not null,
	quantity			int			not null,
	primary key (medicine_id),
	foreign key (frequency_id) references frequency(frequency_id),
	foreign key (externalcontact_id) references externalcontact(externalcontact_id),
	foreign key (client_id) references client(client_id));

create table dailyreport
	(dailyreport_id		int			not null,
	client_id			int			not null,
	employee_id			int			not null,
	text				varchar(8000)not null,
	date				datetime	not null,
	primary key (dailyreport_id),
	foreign key (client_id) references client(client_id),
	foreign key (employee_id) references employee(employee_id));

create table reservation
	(reservation_id		int			not null,
	car_id				int			not null,
	employee_id			int			not null,
	client_id			int			not null,
	startdate			datetime	not null,
	enddate				datetime	not null,
	reservationdate		datetime	not null,
	primary key (reservation_id),
	foreign key (car_id) references car(car_id),
	foreign key (employee_id) references employee(employee_id),
	foreign key (client_id) references client(client_id));

create table externaldocument
	(externaldocument_id int		not null,
	client_id			int			not null,
	text				varchar(8000)not null,
	date				datetime	not null,
	source				varchar(50),
	author				varchar(50),
	primary key (externaldocument_id),
	foreign key (client_id) references client(client_id));

create table milestone
	(milestone_id		int			not null,
	client_id			int			not null,
	text				varchar(8000)not null,
	date				datetime	not null,
	successdate			datetime,
	primary key (milestone_id),
	foreign key (client_id) references client(client_id));

create table errorhandlingmedicine
	(errorhandlingmedicine_id int	not null,
	medicine_id			int			not null,
	client_id			int			not null,
	employee_id			int			not null,
	date				datetime	not null,
	episode				varchar(8000)not null,
	quantity			int			not null,
	primary key (errorhandlingmedicine_id),
	foreign key (medicine_id) references medicine(medicine_id),
	foreign key (client_id) references client(client_id),
	foreign key (employee_id) references employee(employee_id));

create table client_externalcontact
	(client_externalcontact_id int	not null,
	client_id			int			not null,
	externalcontact_id	int			not null,
	primary key (client_externalcontact_id),
	foreign key (client_id) references client(client_id),
	foreign key (externalcontact_id) references externalcontact(externalcontact_id));

create table employee_client
	(employee_client_id int			not null,
	employee_id			int			not null,
	client_id			int			not null,
	primary key (employee_client_id),
	foreign key (employee_id) references employee(employee_id)
	foreign key (client_id) references client(client_id));