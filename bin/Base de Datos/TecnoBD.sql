DROP DATABASE IF EXISTS TecnoStore;

create database TecnoStore;

use TecnoStore;

CREATE TABLE tb_Registro(
codigo  int   auto_increment primary key,
nombre varchar(50) not null,
apellido varchar(50)not null,
email VARCHAR(255) UNIQUE,
clave    varchar(50) not null,
telefono  varchar(9) not null
);

create table categoria(
idcategoria	varchar(15) not null primary key,
nombre_categoria varchar(50)
);

create table estados(
idestado    varchar(15) not null primary key,
nombre_estado varchar(15)
);

create table marca(
idmarca    varchar(15) not null primary key,
nombre_marca varchar(15)
);

CREATE TABLE productos ( 
id INT not null AUTO_INCREMENT PRIMARY KEY, 
codigo_producto VARCHAR(100),
nombre_producto VARCHAR(100),
descripcion VARCHAR(100),
idcategoria varchar(15),
marca VARCHAR(50),
precio DECIMAL(10, 2), 
stock int,
idestado varchar(15),
idmarca    varchar(15),
foreign key (idmarca) references marca(idmarca),
foreign key (idcategoria) references categoria(idcategoria),
foreign key (idestado) references estados(idestado)
 );
 
CREATE TABLE tb_genero (
id_genero VARCHAR(10) NOT NULL PRIMARY KEY,
des_genero VARCHAR(60)
);

CREATE TABLE tb_cargo (
id_cargo VARCHAR(10) NOT NULL PRIMARY KEY,
des_cargo VARCHAR(60)
);

CREATE TABLE tb_empleados (
id_empleado INT AUTO_INCREMENT PRIMARY KEY,
nom_empleado VARCHAR(80) NOT NULL,
telefono_empleado VARCHAR(15),
id_genero VARCHAR(10),
id_cargo VARCHAR(10),
fecha_contratacion DATE,
fecha_terminacion DATE,
salario_empleado DECIMAL(10, 2),
FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero),
FOREIGN KEY (id_cargo) REFERENCES tb_cargo(id_cargo)
);

insert into tb_genero values('GEN01' , 'MASCULINO');
insert into tb_genero values('GEN02' , 'FEMENINO');
insert into tb_genero values('GEN03' , '39 TIPOS DE GAYS');


insert into tb_cargo values('CARGO01' , 'Gerente de Ventas en Línea');
insert into tb_cargo values('CARGO02' , 'Desarrollador Web');
insert into tb_cargo values('CARGO03' , 'Analista de Datos ');
insert into tb_cargo values('CARGO04' , 'Gerente de Logística');
insert into tb_cargo values('CARGO05' , 'Especialista en Atención al Cliente');
insert into tb_cargo values('CARGO06' , 'Director de Marketing Digital');

insert into categoria values('CAT01' , 'PLACA MADRE');
insert into categoria values('CAT02' , 'MONITOR');
insert into categoria values('CAT03' , 'MEMORIA RAM');
insert into categoria values('CAT04' , 'CASE');
insert into categoria values('CAT05' , 'FUENTE DE PODER');
insert into categoria values('CAT06' , 'PROCESADOR');
insert into categoria values('CAT07' , 'TARJETA DE VIDEO');
insert into categoria values('CAT08' , 'ALMACENAMIENTO');
insert into categoria values('CAT09' , 'TECLADO');
insert into categoria values('CAT10' , 'MOUSE');
insert into categoria values('CAT11' , 'AURICULARES');
insert into categoria values('CAT12' , 'CAMARA');
insert into categoria values('CAT13' , 'LAPTOP');

insert into estados values('EST01' , 'Disponible');
insert into estados values('EST02' , 'Agotado');
insert into estados values('EST03' , 'Oferta');
insert into estados values('EST04' , 'Preventa');


insert into marca values('MARCA01' , 'AMD');
insert into marca values('MARCA02' , 'INTEL');
insert into marca values('MARCA03' , 'MSI');
insert into marca values('MARCA04' , 'REDRAGON');
insert into marca values('MARCA05' , 'LOGITECH');
insert into marca values('MARCA06' , 'LG');
insert into marca values('MARCA07' , 'SAMSUNG');
insert into marca values('MARCA08' , 'NVIDIA');
insert into marca values('MARCA09' , 'ACER');
insert into marca values('MARCA10' , 'ASROCK');
insert into marca values('MARCA11' , 'ASUS');
insert into marca values('MARCA12' , 'DELL');
insert into marca values('MARCA13' , 'GIGABYTE');
insert into marca values('MARCA14' , 'CORSAIR');
insert into marca values('MARCA15' , 'EVGA');
insert into marca values('MARCA16' , 'LENOVO');
insert into marca values('MARCA17' , 'G.SKILL');
insert into marca values('MARCA18' , 'KINGSTON');
insert into marca values('MARCA19' , 'COOLER MASTER');
insert into marca values('MARCA20' , 'THERMALTAKE');
insert into marca values('MARCA21' , 'SEA SONIC');
insert into marca values('MARCA22' , 'PNY');
insert into marca values('MARCA23' , 'WESTERN DIGITAL');
insert into marca values('MARCA24' , 'MICROSOFT');
insert into marca values('MARCA25' , 'HYPERX');
insert into marca values('MARCA26' , 'HALION');
insert into marca values('MARCA27' , 'TEROS');

INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado ,idmarca) VALUES ('PLACA01', 'ROG STRIX B650E - F GAMING', 'AMD Socket AM5 para procesadores de escritorio AMD Ryzen™ serie 7000*', 'CAT01', 'ASUS', 1257.99	, 5, 'EST01' ,'MARCA11');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('PLACA02', 'Z790 GAMING X AX', 'Inalámbrica: Intel® Wi -Fi 6E AX210 (PCB rev. 1.0) - BLUETOOTH 5.3', 'CAT01', 'GIGABYTE', 1199.25, 2, 'EST02','MARCA13');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('PLACA03', 'ROG STRIX Z790-A GAMING', 'Pentium® Gold y Celeron® Compatible con la tecnología Intel®', 'CAT01', 'ASUS', 2099.99	, 3, 'EST03','MARCA11');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('PROCE01', 'CORE i5-13400F', 'Cache 20MB, Hasta 4.6 Ghz.', 'CAT06', 'INTEL', 953.39, 1, 'EST01','MARCA02');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('PROCE02', 'RYZEN 7 5700X', '3.4GHz Reloj de aumento máx. Hasta 4.6GHz	', 'CAT06', 'AMD', 729.15, 5, 'EST01' ,'MARCA01');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('PROCE03', 'CORE I7-11700F', 'Caché inteligente Intel® de 16 MB', 'CAT06', 'INTEL', 1180.73, 1, 'EST02','MARCA02');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('MONITOR01', 'SUPER ULTRA WIDE CURVO', '5120x1440', 'CAT02', 'SAMSUNG', 3676.36, 2, 'EST01','MARCA07');  
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('MONITOR02', 'ROG STRIX XG27AQMR', '27" FAST IPS, QHD 2K, 300Hz, 1ms, G-Sync compatible', 'CAT02', 'ASUS', 2929.99	, 4	, 'EST01','MARCA11');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('MONITOR03', 'IPS 24MK430H', '23.8" IPS, FHD, 5MS, 75HZ, AMD FREESYNC', 'CAT02', 'LG', 392.99, 8, 'EST03','MARCA06');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('RAM01', 'TRIDENT Z5 RGB', '64GB (32x2) DDR5 5600 MHZ, CL28', 'CAT03', 'G.SKILL', 1120.99, 3, 'EST01','MARCA17');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('RAM02', 'DELTA TUF GAMING ALLIANCE RGB', '32GB (2x16) 2666MHZ', 'CAT03', 'T-FORCE', 523.99, 8, 'EST01','MARCA11');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('RAM03', 'FURY RENEGADE RGB', '16GB DDR5 6400 MHZ', 'CAT03', 'KINGSTON ', 358.99, 2, 'EST02','MARCA18');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('CASE01', 'COSMOS C700M', 'WHITE, V/TEMPLADO, ARGB', 'CAT04', 'COOLER MASTER', 2395.55, 2, 'EST01','MARCA19');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('CASE02', 'ROG HYPERION GR701', 'V/TEMPLADO, ARGB', 'CAT04', 'ASUS ', 1975.99, 4, 'EST01','MARCA11');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('CASE03', 'AH T600', 'BLANCO, V/TEMPLADO', 'CAT04', 'THERMALTAKE', 1098.99, 1, 'EST02','MARCA20');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('FUENTE01', 'PRIME 1000', '80+ GOLD MODULAR 1000 W', 'CAT05', 'SEASONIC ', 1043.99, 3, 'EST01','MARCA21');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('FUENTE02', 'CM V1300 PLATINO', '80 PLUS PLATINUM FULL MODULAR 1300W', 'CAT05', 'COOLER MASTER', 887.99, 4, 'EST01','MARCA19');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('FUENTE03', '750 B5', '80 PLUS BRONZE FULL MODULAR, 750W', 'CAT05', 'EVGA ', 409.99, 8, 'EST02','MARCA15');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('GRAFICA01', 'GEFORCE NVIDIA RTX 4070', 'EAGLE OC 12GB GDDR6X', 'CAT07', 'GIGABYTE', 2938.99, 8, 'EST01','MARCA13');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('GRAFICA02', 'GEFORCE NVIDIA RTX 4070', 'GAMING X TRIO 12GB GDDR6X', 'CAT07', 'MSI', 2909.99, 8, 'EST01','MARCA03');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('GRAFICA03', 'GEFORCE NVIDIA GTX 1650', '4GB GDDR6, DUAL FAN', 'CAT07', 'PNY', 733.99, 8, 'EST02','MARCA21');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('ALMACENAMIENTO01', 'WESTERN DIGITAL PURPURA', 'PRO SURVEILLANCE 12TB', 'CAT08', 'WESTERN DIGITAL', 1021.99, 1, 'EST01','MARCA23');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('ALMACENAMIENTO02', 'FURY RENEGADE', '2TB M.2 PCIe 4.0 NVME', 'CAT08', 'KINGSTON', 736.99, 3, 'EST01','MARCA18');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('ALMACENAMIENTO03', 'CS3030', '500GB M,2 PCIe NVME', 'CAT08', 'PNY ', 162.99, 5, 'EST02','MARCA22');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('TECLADO01', 'LOGITECH G213', 'PRODIGY RGB', 'CAT09', 'LOGITECH', 195.99, 6, 'EST01','MARCA05');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('TECLADO02', 'TRIGGER Z', 'CHERRY MX CM', 'CAT09', 'COOLER MASTER', 472.99, 12, 'EST01','MARCA19');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('TECLADO03', 'SIGNATURE K650', 'INALAMBRICO/BT', 'CAT09', 'LOGITECH', 147.99, 9, 'EST02','MARCA05');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('MOUSE01', 'LIFT VERTICAL', 'INALAMBRICO/BT LIFT VERTICAL ERGONOMIC WHITE', 'CAT10', 'LOGITECH', 245.99, 23, 'EST01','MARCA05');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('MOUSE02', 'SOURIS', 'BLUETOOTH 2.4 Ghz', 'CAT10', 'MICROSOFT ', 59.99, 12, 'EST02','MARCA24');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('MOUSE03', 'G502 X', 'MOUSE GAMING G502 X PLUS WHITE', 'CAT10', 'LOGITECH', 514.99, 10, 'EST01','MARCA05');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('AURICULAR01', 'G735', 'INALAMBRICO/BT, RGB, WHITE', 'CAT11', 'LOGITECH', 771.99, 3, 'EST03','MARCA05');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('AURICULAR02', 'CLOUD ALPHA', 'Circumaural, cerrado por la parte trasera', 'CAT11', 'HYPERX', 241.99, 6, 'EST01','MARCA25');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('AURICULAR03', 'T-30', 'Estéreo con Micrófono', 'CAT11', 'HALION', 14.76, 18, 'EST02','MARCA26');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('CAMARA01', 'C920S', '1080p / 30fps - 720p / 30fps', 'CAT12', 'LOGITECH', 292.99, 4, 'EST01','MARCA05');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('CAMARA02', 'B2B BRIO ', 'CAMARA WEB B2B BRIO ULTRA HD 4K', 'CAT12', 'LOGITECH', 510.99, 5, 'EST01','MARCA05');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('CAMARA03', 'TE-9070', '1920*1080 30fps, formato MP4', 'CAT12', 'TEROS', 49.99, 7, 'EST02','MARCA27');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('LAPTOP01', 'V15 G2-ITL', 'Ci7-1065G7, 16GB DDR4, SSD 512GB, 15.6" FHD', 'CAT13', 'LENOVO', 2471.99, 8, 'EST01','MARCA16');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('LAPTOP02', 'V15 G2-ALC', 'AMD R7-5700U, 8GB RAM, HDD 1TB + SSD 256GB, 15.6" FHD', 'CAT13', 'LENOVO', 2092.99, 1, 'EST01','MARCA16');
INSERT INTO productos (codigo_producto, nombre_producto, descripcion, idcategoria, marca, precio, stock, idestado,idmarca) VALUES ('LAPTOP03', 'VOSTRO 3400', 'INTEL Ci5-1135G7, 4GB DDR4, HDD 1TB, 14" HD', 'CAT13', 'DELL', 1579.99, 4, 'EST02','MARCA12');

-- select * from productos;
-- select * from categoria;
-- select * from marca;
-- select * from estados;
-- select * from tb_Registro;
select * from tb_empleados;
select * from tb_genero;
select * from tb_cargo;



-- drop table productos;
-- drop table marca;
-- drop table categoria;
-- drop table estados;


