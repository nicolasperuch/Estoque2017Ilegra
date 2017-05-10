create table mydb.item(
	id_item int primary key auto_increment,
	nome varchar(30),
    quantidade int,
    preco_compra double,
    preco_venda double
)

create table mydb.venda(
	id_venda int primary key auto_increment,
	quantidade int,
	fk_item int,
    foreign key(fk_item) references mydb.item (id_item)
);
  