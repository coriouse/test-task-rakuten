
create table t_product(
	id INT PRIMARY KEY,
   	name VARCHAR(255), 
   	description VARCHAR(255), 
   	price FLOAT,
	categoryPath INT, 
	avaliable INT,
   	);
   	
create table t_category(
	id INT PRIMARY KEY,
	id_parent INT,
	name VARCHAR(255),
);   	

   	