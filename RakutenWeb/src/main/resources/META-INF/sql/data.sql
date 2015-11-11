insert into t_category(id,id_parent,name) values(1, null, 'Books' );
insert into t_category(id,id_parent,name) values(2,1,'Fantastic' );
insert into t_category(id,id_parent,name) values(3,1, 'Drama' );
insert into t_category(id,id_parent,name) values(4, null, 'A' );
insert into t_category(id,id_parent,name) values(5,4, 'AB' );
insert into t_category(id,id_parent,name) values(6,5, 'ABC' );
insert into t_category(id,id_parent,name) values(7,5, 'ABD' );
insert into t_category(id,id_parent,name) values(8,null, 'A1' );
insert into t_category(id,id_parent,name) values(9,null, 'A2' );
insert into t_category(id,id_parent,name) values(10,9, 'A2B2' );

insert into t_product(id, name, description, price, categoryPath, avaliable) values(1,'some t-hsorts','some desc',1.2,6,1)
