use dm71_2
create table location 
	(location_id		int			PRIMARY KEY IDENTITY,
	zipcode				int			not null,
	city				varchar(15)	not null,
	unique(zipcode));

create table frequency 
	(frequency_id		int			PRIMARY KEY IDENTITY,
	time				varchar(30)	not null,
	quantity			int			not null,
	date				datetime	not null,
	);

create table car 
	(car_id				int			not null,
	registrationsno		int			not null,
	description			varchar(30)	not null,
	primary key (car_id),
	unique(registrationsno));

create table externalcontact 
	(externalcontact_id	int			PRIMARY KEY IDENTITY,
	cbr					varchar(20),
	occupation			varchar(30)	not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	foreign key (location_id) references location(location_id));

create table client 
	(client_id			int			PRIMARY KEY IDENTITY,
	clientno			int			not null,
	description			varchar(50) not null,
	interests			varchar(50) not null,
	health				varchar(50) not null,
	ssn					varchar(11)			not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	unique(ssn),
	foreign key (location_id) references location(location_id));

create table employee 
	(employee_id		int			PRIMARY KEY IDENTITY,
	employeeno			varchar(15)	not null,
	password			varchar(15) not null,
	managerno			varchar(15),
	jobtitle			varchar(30) not null,
	ssn					varchar(11)			not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	unique(employeeno),
	unique(ssn),
	foreign key (managerno) references employee(employeeno),
	foreign key (location_id) references location(location_id));
	
create table medicine 
	(medicine_id		int			PRIMARY KEY IDENTITY,
	frequency_id		int			not null,
	externalcontact_id	int			not null,
	client_id			int			not null,
	name				varchar(30)	not null,
	description			varchar(50)	not null,
	date				datetime	not null,
	quantity			int			not null,
	foreign key (frequency_id) references frequency(frequency_id),
	foreign key (externalcontact_id) references externalcontact(externalcontact_id),
	foreign key (client_id) references client(client_id));

create table dailyreport
	(dailyreport_id		int			PRIMARY KEY IDENTITY,
	client_id			int			not null,
	employee_id			int			not null,
	text				varchar(8000)not null,
	date				datetime	not null,
	foreign key (client_id) references client(client_id),
	foreign key (employee_id) references employee(employee_id));

create table reservation
	(reservation_id		int			PRIMARY KEY IDENTITY,
	car_id				int			not null,
	employee_id			int			not null,
	client_id			int			not null,
	startdate			datetime	not null,
	enddate				datetime	not null,
	reservationdate		datetime	not null,
	foreign key (car_id) references car(car_id),
	foreign key (employee_id) references employee(employee_id),
	foreign key (client_id) references client(client_id));

create table externaldocument
	(externaldocument_id int		PRIMARY KEY IDENTITY,
	client_id			int			not null,
	text				varchar(8000)not null,
	date				datetime	not null,
	source				varchar(50),
	author				varchar(50),
	foreign key (client_id) references client(client_id));

create table milestone
	(milestone_id		int			PRIMARY KEY IDENTITY,
	client_id			int			not null,
	text				varchar(8000)not null,
	date				datetime	not null,
	successdate			datetime,
	foreign key (client_id) references client(client_id));

create table errorhandlingmedicine
	(errorhandlingmedicine_id int	PRIMARY KEY IDENTITY,
	medicine_id			int			not null,
	client_id			int			not null,
	employee_id			int			not null,
	date				datetime	not null,
	episode				varchar(8000)not null,
	quantity			int			not null,
	foreign key (medicine_id) references medicine(medicine_id),
	foreign key (client_id) references client(client_id),
	foreign key (employee_id) references employee(employee_id));

create table client_externalcontact
	(client_externalcontact_id int	PRIMARY KEY IDENTITY,
	client_id			int			not null,
	externalcontact_id	int			not null,
	foreign key (client_id) references client(client_id),
	foreign key (externalcontact_id) references externalcontact(externalcontact_id));

create table employee_client
	(employee_client_id int			PRIMARY KEY IDENTITY,
	employee_id			int			not null,
	client_id			int			not null,
	foreign key (employee_id) references employee(employee_id),
	foreign key (client_id) references client(client_id));