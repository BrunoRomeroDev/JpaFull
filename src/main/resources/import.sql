create table tab_veiculo (
codigo bigint not null auto_increment,
ano_fabricacao integer,
ano_modelo integer,
fabricante varchar(255),
modelo varchar(255),
valor decimal(19,2),
primary key (codigo)
) ;


insert into tab_veiculo (placa,cidade,fabricante,modelo,ano_fabricacao,ano_modelo,valor)  values ('AAA','Guaru','Fiat','Toro',2020,2020,107000);
insert into tab_veiculo (placa,cidade,fabricante,modelo,ano_fabricacao,ano_modelo,valor)  values ('BBB','sao','Ford','Fiesta',2019,2019,42000);
insert into tab_veiculo (placa,cidade,fabricante,modelo,ano_fabricacao,ano_modelo,valor)  values ('CCC','3333','VW','Gol',2019,2020,35000);
