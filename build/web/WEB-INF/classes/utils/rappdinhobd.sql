
create table estado(
id_estado int not null auto_increment,
nome_estado varchar(50) not null ,
sigla_estado varchar (2) not null,
PRIMARY KEY pk_estado (id_estado)
)DEFAULT CHARSET = utf8;

create table cidade(
id_cidade int not null auto_increment,
nome_cidade varchar(50) not null,
id_estado int not null,
PRIMARY KEY pk_cidade (id_cidade),
CONSTRAINT fk_estado FOREIGN KEY (id_estado) references estado (id_estado)
)DEFAULT CHARSET = utf8;

create table pessoa(
id_pessoa int not null auto_increment,
nome_pessoa varchar(50) not null,
email_pessoa varchar(50) not null unique,
senha_pessoa varchar(50) not null,
cpf_pessoa varchar (14) not null unique,
telefone_pessoa varchar(14) not null,
endereco_pessoa varchar(100) not null,
tipo_pessoa varchar (10) not null,
id_cidade int not null,
PRIMARY KEY pk_pessoa (id_pessoa),
CONSTRAINT fk_cidade FOREIGN KEY (id_cidade) references cidade (id_cidade)
)DEFAULT CHARSET = utf8;

create table contratante(
id_contratante int not null auto_increment,
foto_contratante blob,
id_pessoa int not null,
PRIMARY KEY pk_contratante (id_contratante),
CONSTRAINT fk_pessoa FOREIGN KEY (id_pessoa) references pessoa (id_pessoa)
)DEFAULT CHARSET = utf8;

create table administrador(
id_administrador int not null auto_increment,
rg_administrador varchar(11) not null unique,
id_pessoa int not null,
PRIMARY KEY pk_administrador (id_administrador),
CONSTRAINT fk_pessoa_administrador FOREIGN KEY  (id_pessoa) references pessoa (id_pessoa)
)DEFAULT CHARSET = utf8;

create table contratado(
id_contratado int not null auto_increment,
foto_contratado blob,
cnh_contratado varchar(11),
id_pessoa  int not null,
PRIMARY KEY pk_contratado (id_contratado),
CONSTRAINT fk_pessoa_contratado FOREIGN KEY (id_pessoa) references pessoa (id_pessoa)
)DEFAULT CHARSET = utf8;

create table veiculo(
id_veiculo int not null auto_increment,
nome_veiculo varchar(50) not null,
renavam_veiculo varchar (9) not null unique,
tipo_veiculo varchar (100),
id_contratado int not null,
PRIMARY KEY pk_veiculo (id_veiculo),
CONSTRAINT fk_contratado_veiculo FOREIGN KEY (id_contratado) references contratado (id_contratado)
)DEFAULT CHARSET = utf8;

create table rota(
id_rota int not null auto_increment,
nome_rota varchar(50) not null,
lat_saida_rota decimal (10,8) not null,
lng_saida_rota decimal (11,8) not null,
lat_chegada_rota decimal (10,8) not null,
lng_chegada_rota decimal (11,8) not null,
status_rota varchar(1),
id_contratado int not null,
PRIMARY KEY pk_rota (id_rota),
CONSTRAINT fk_contratado_rota FOREIGN KEY (id_contratado) references contratado (id_contratado)
)DEFAULT CHARSET = utf8;

create table produto(
id_produto int not null auto_increment,
nome_produto varchar(50) not null,
descricao_produto text,
foto_produto blob,
id_contratante int,
id_contratado int,
PRIMARY KEY pk_produto (id_produto),
CONSTRAINT fk_contratante_produto FOREIGN KEY (id_contratante) references contratante (id_contratante),
CONSTRAINT fk_contratado_produto FOREIGN KEY (id_contratado) references contratado (id_contratado)
)DEFAULT CHARSET = utf8;

create table pedido(
id_pedido int not null auto_increment,
data_pedido date not null,
lat_destino_pedido decimal (10,8) not null,
lng_destino_pedido decimal (11,8) not null,
status_pedido varchar (10) not null,
id_contratado int not null,
id_contratante int not null,
id_produto int not null,
id_rota int not null,
PRIMARY KEY pk_pedido (id_pedido),
CONSTRAINT fk_contratado_pedido FOREIGN KEY (id_contratado) references contratado (id_contratado),
CONSTRAINT fk_produto_pedido FOREIGN KEY (id_produto) references produto (id_produto),
CONSTRAINT fk_contratante_pedido FOREIGN KEY (id_contratante) references contratante (id_contratante),
CONSTRAINT fk_rota_pedido FOREIGN KEY (id_rota) references rota (id_rota)
)DEFAULT CHARSET = utf8;

create table entrega(
id_entrega int not null auto_increment,
data_entrega date not null,
status_entrega varchar (10) not null,
id_contratado int not null,
id_pedido int not null,
id_rota int not null,
PRIMARY KEY pk_entrega (id_entrega),
CONSTRAINT fk_contratado_entrega FOREIGN KEY (id_contratado) references contratado (id_contratado),
CONSTRAINT fk_pedido_entrega FOREIGN KEY (id_pedido) references pedido (id_pedido),
CONSTRAINT fk_rota_entrega FOREIGN KEY (id_rota) references rota (id_rota)
)DEFAULT CHARSET = utf8;
