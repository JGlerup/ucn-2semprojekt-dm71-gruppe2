use dm71_2
create table location 
	(location_id		int			PRIMARY KEY IDENTITY,
	zipcode				int			not null,
	city				varchar(100)not null,
	unique(zipcode));

create table frequency 
	(frequency_id		int			PRIMARY KEY IDENTITY,
	time_per_day		int			not null,
	quantity_each_time	int			not null,
	description_usage	varchar(200)not null,
	date				date);

create table car 
	(car_id				int			PRIMARY KEY IDENTITY,
	registrationsno		varchar(30)	not null,
	description			varchar(30)	not null,
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
	clientno			varchar(15)	not null,
	description			varchar(50) not null,
	interests			varchar(50) not null,
	health				varchar(50) not null,
	ssn					varchar(11)	not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	start_date			date		not null,
	in_use				varchar(3)	not null,
	stop_date			date,
	unique(ssn),
	foreign key (location_id) references location(location_id));

create table employee 
	(employee_id		int			PRIMARY KEY IDENTITY,
	employeeno			varchar(15)	not null,
	password			varchar(15) not null,
	managerno			varchar(15),
	jobtitle			varchar(30) not null,
	crud_client			varchar(3)	not null,
	crud_employee		varchar(3)	not null,
	crud_medicine		varchar(3)	not null,
	crud_car			varchar(3)	not null,
	ssn					varchar(11)	not null,
	firstname			varchar(15)	not null,
	middlename			varchar(15),
	lastname			varchar(15)	not null,
	address				varchar(30)	not null,
	location_id			int			not null,
	phoneno				int,
	email				varchar(50),
	start_date			date		not null,
	in_use				varchar(3)	not null,
	stop_date			date,
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
	date				date		not null,
	quantity			int			not null,
	foreign key (frequency_id) references frequency(frequency_id),
	foreign key (externalcontact_id) references externalcontact(externalcontact_id),
	foreign key (client_id) references client(client_id));

create table dailyreport
	(dailyreport_id		int			PRIMARY KEY IDENTITY,
	client_id			int			not null,
	employee_id			int			not null,
	text				varchar(max)not null,
	date				datetime	not null,
	foreign key (client_id) references client(client_id),
	foreign key (employee_id) references employee(employee_id));

create table reservation
	(reservation_id		int			PRIMARY KEY IDENTITY,
	car_id				int			not null,
	employee_id			int			not null,
	client_id			int			not null,
	startdate			date		not null,
	enddate				date		not null,
	reservationdate		date		not null,
	foreign key (car_id) references car(car_id),
	foreign key (employee_id) references employee(employee_id),
	foreign key (client_id) references client(client_id));

create table externaldocument
	(externaldocument_id int		PRIMARY KEY IDENTITY,
	client_id			int			not null,
	text				varchar(max)not null,
	date				date		not null,
	source				varchar(50),
	author				varchar(50),
	foreign key (client_id) references client(client_id));

create table milestone
	(milestone_id		int			PRIMARY KEY IDENTITY,
	client_id			int			not null,
	text				varchar(max)not null,
	date				date		not null,
	successdate			date,
	foreign key (client_id) references client(client_id));

create table errorhandlingmedicine
	(errorhandlingmedicine_id int	PRIMARY KEY IDENTITY,
	medicine_id			int			not null,
	client_id			int			not null,
	employee_id			int			not null,
	date				date		not null,
	episode				varchar(max)not null,
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