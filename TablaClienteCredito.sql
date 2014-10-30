CREATE DATABASE Multicomercial;
USE Multicomercial;
DROP DATABASE Multicomercial;

CREATE TABLE Privilegios
(
	Login_Id_Cedula VARCHAR(100) NOT NULL,
	Administracion_Clientes VARCHAR(20),
	Administracion_Inventario VARCHAR(20),
	Administracion_Facturas VARCHAR(20),
	Administracion_Empleados VARCHAR(20),
	Administracion_Cajas VARCHAR(20),
	FOREIGN KEY (Login_Id_Cedula) REFERENCES LogIn(Id_Cedula) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO Privilegios(Login_Id_Cedula,Administracion_Clientes,Administracion_Inventario,Administracion_Facturas,Administracion_Empleados,Administracion_Cajas)
VALUES('206910083','true','true','true','true','true');
select*from Privilegios;
DROP TABLE Privilegios;

CREATE TABLE LogIn
(
	Id_Cedula VARCHAR(100) PRIMARY KEY NOT NULL,
	Nombre VARCHAR(500) NOT NULL,
	Apellidos VARCHAR(500) NOT NULL,
	Fecha_Nacimiento DATETIME NOT NULL,
	Telefono VARCHAR(500),
	Celular VARCHAR(500),
	Edad VARCHAR(500),
	Sexo VARCHAR(500),
	Nombre_Usuario VARCHAR(500) NOT NULL,
	Contrasenna VARCHAR(500) NOT NULL,
	Dir_Foto_Perfil VARCHAR(500) NOT NULL,
	Email VARCHAR (500),
	Fecha_Creacion DATETIME NOT NULL,
	Fecha_Modificacion DATETIME,
	Creado_Por VARCHAR(500) NOT NULL,
	Modificado_Por VARCHAR(500),
	Deártamento_Id_Departamento VARCHAR(50) NOT NULL,
	FOREIGN KEY (Deártamento_Id_Departamento) REFERENCES Departamento(Id_Nombre_Departamento) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO LogIn (Deártamento_Id_Departamento,Id_Cedula,Nombre,Apellidos,Fecha_Nacimiento,Telefono,Celular,Edad,Sexo,Nombre_Usuario,Contrasenna,Dir_Foto_Perfil,Email,Fecha_Creacion,Fecha_Modificacion,Creado_Por,Modificado_Por)
VALUES('Administración','206910083','Ignacio','Valerio Vega','1991-08-28','','85897154','23','Masculino','Nacho','1','C:\\Carpeta Temporal\\206910083.jpg','ivalerio2222@hotmail.com','2014-02-12','2014-02-12','Uriel Valerio Vega','');
DELETE FROM login WHERE Id_Cedula='206910083';
SELECT * FROM login;
DROP TABLE login;

CREATE TABLE Departamento(
	Id_Nombre_Departamento VARCHAR(50) PRIMARY KEY NOT NULL,
	creado_Por VARCHAR(50) NOT NULL,
	fecha_Creacion DATETIME NOT NULL,
	modificado_Por VARCHAR(50),
	fecha_Modificado DATETIME
);
DROP TABLE Departamento;
SELECT * FROM Departamento;
INSERT INTO Departamento(Id_Nombre_Departamento,creado_Por,fecha_Creacion,modificado_Por,fecha_Modificado)
VALUES('Administración','Ignacio Valerio Lara','2011-10-08','','2011-10-08');

USE Multicomercial;
CREATE TABLE Tipo_Cliente
(
	Id_Tipo_Cliente VARCHAR(20) PRIMARY KEY NOT NULL
);
DROP TABLE Tipo_Cliente;
INSERT INTO Tipo_Cliente(Id_Tipo_Cliente)
VALUES('Crédito');
SELECT * FROM Tipo_Cliente;

CREATE TABLE Cliente_Contado
(
	Id_Cliente VARCHAR(20) PRIMARY KEY NOT NULL,
	Nombre VARCHAR(20),
	Apellidos VARCHAR(20),
	Direccion VARCHAR(20),
	Telefono VARCHAR(20),
	Celular VARCHAR(20),
	Tipo_Cliente_Id_Tipo_Cliente VARCHAR(20) NOT NULL,
	FOREIGN KEY (Tipo_Cliente_Id_Tipo_Cliente) REFERENCES Tipo_Cliente(Id_Tipo_Cliente) ON UPDATE CASCADE ON DELETE CASCADE
);
DROP TABLE Cliente_Contado;
CREATE TABLE Area_Credito
(
	Id_Registro VARCHAR(20) NOT NULL PRIMARY KEY,
	Cliente_Credito_Id_Cedula VARCHAR(20) NOT NULL,
	Monto_Acreditado FLOAT NOT NULL,
	Monto_Actual FLOAT NOT NULL,
	Periodo_Pago VARCHAR(20) NOT NULL,
	Fecha_Inicio_Credito DATETIME,
	FOREIGN KEY (Cliente_Credito_Id_Cedula) REFERENCES Cliente_Credito(Id_Cedula) ON UPDATE CASCADE ON DELETE CASCADE
);
DROP TABLE Area_Credito;
SELECT * FROM area_credito;
CREATE TABLE Cliente_Credito
(
	Id_Cedula VARCHAR (50) PRIMARY KEY,
	Tipo_Cliente_Id_Tipo_Cliente VARCHAR(20) NOT NULL,
	Estado_Cliente VARCHAR (50) NOT NULL,
	Nombre VARCHAR (50) NOT NULL,
	Apellidos VARCHAR (50) NOT NULL,
	Direccion VARCHAR(50) NOT NULL,
	Telefono VARCHAR (50),
	Celular VARCHAR(50),
	Fcha_Creacion DATETIME NOT NULL,
	Fecha_Modificacion DATETIME,
	Modificado_Por VARCHAR(50),
	Creado_Por VARCHAR (50) NOT NULL,
	FOREIGN KEY (Tipo_Cliente_Id_Tipo_Cliente) REFERENCES Tipo_Cliente(Id_Tipo_Cliente) ON UPDATE CASCADE ON DELETE CASCADE
);
SELECT*FROM Cliente_Credito;
INSERT INTO Cliente_Credito (Id_Cedula,Tipo_Cliente_Id_Tipo_Cliente,Estado_Cliente,Nombre,Apellidos,Direccion,Telefono,Celular,Fecha_Creacion,Fecha_Modificacion,Modificado_Por,Creado_Por)
VALUES('Q','Crédito','Habilitado','q','q','q','q','q','2012-12-12','2012-12-12','Uriel','Ignacio');
DROP TABLE Cliente_Credito;

CREATE TABLE Facturacion
(
	Id_Factura INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Tipo_Pago VARCHAR(20) NOT NULL,
	Nombre VARCHAR(20),
    Cedula VARCHAR(50),
	Telefono VARCHAR(50),
	Apellidos VARCHAR(20),
	Fecha_Emision VARCHAR(50) NOT NULL,
	Vendido_por VARCHAR (50) NOT NULL,
	Sub_Total VARCHAR(50) NOT NULL,
	IVA VARCHAR(20) NOT NULL,
	Total VARCHAR(50) NOT NULL,
	Descuento VARCHAR(50),
	Observacion TEXT
);
DROP TABLE FACTURACION;
SELECT * FROM FACTURACION;
INSERT INTO FACTURACION (Tipo_Pago,Nombre,Cedula,Telefono,Fecha_Emision,Vendido_por,Sub_Total,IVA,Total,Descuento,Observacion)
VALUES('Contado','Ignacio','206910083','85897154','23/3/2014','Uriel Valerio Vega','3500','0','3500','0.0','0');

CREATE TABLE Productos_Asociados
(
	id_Codigo_Producto VARCHAR(50) PRIMARY KEY NOT NULL,
	Factura_Id_Facturacion INTEGER NOT NULL,
	Descripcion VARCHAR(50) NOT NULL,
	Cantidad INTEGER NOT NULL,
	Precio_Unitario DOUBLE NOT NULL,
	Precio_Total DOUBLE NOT NULL,
	FOREIGN KEY (Factura_Id_Facturacion) REFERENCES Facturacion(Id_Factura) ON UPDATE CASCADE ON DELETE CASCADE
);
DROP TABLE Productos_Asociados;
SELECT * FROM Productos_Asociados;
USE Multicomercial;
CREATE TABLE Inventario
(
	Id_Producto VARCHAR(100) PRIMARY KEY NOT NULL,
	Nombre VARCHAR(900) NOT NULL,
	Marca VARCHAR(900) not null,
	Descripcion VARCHAR(3000) not null,
	Precio_Compra FLOAT not null,
	Precio_Venta FLOAT not null,
	Existencia VARCHAR(10) not null,
	Cantidad INTEGER NOT NULL,
	fecha_entrada VARCHAR(50) NOT NULL
);
INSERT INTO inventario(id_producto,Nombre,Marca,Descripcion,Precio_Compra,Precio_Venta,Existencia,Cantidad,fecha_entrada)
VALUES('75034239','Pasta Dental','Colgate','Pasta Colgate Con Calcio',1550,1950,'true',10,'214-03-24');
SELECT * FROM Inventario;
DROP TABLE Inventario;

Select * from login;
select max(Id_Cedula) from login;
select min(Id_Cedula) from login;
select sum(Id_Cedula) from login;
Select * from login where sexo = 'Masculino' and nombre = 'José';
select * from login order by nombre; 
select * from login order by nombre asc;
select * from login order by nombre desc;
select Count (Id_Cedula) from login;
select avg (Id_Cedula) from login;

CREATE TABLE Planilla
(
	id_NumeroPlanilla integer primary key,
	id_NumeroRegistro integer not null,
	salarioMensual integer not null,
	CONSTRAINT fk_id_NumeroRegistro FOREIGN KEY(id_NumeroRegistro) REFERENCES EMPLEADOS(id_NumeroRegistro)
);
insert into Planilla (id_NumeroPlanilla,id_NumeroRegistro,salarioMensual)
value('324','443','2500000');
drop table Planilla;
select * from Planilla;


CREATE TABLE Productos_Vendidos
(
	Nombre_Cliente VARCHAR(20) NOT NULL,
	Marca VARCHAR(20) NOT NULL,
	Descripcion VARCHAR(20) NOT NULL,
	Nombre VARCHAR(20) NOT NULL,
	Precio_Unitario VARCHAR(20) NOT NULL,
	Total VARCHAR(20) NOT NULL,
	Cantidad VARCHAR(20) NOT NULL,
	Sub_Total VARCHAR(20) NOT NULL,
	IVA VARCHAR(20) NOT NULL,
	Fecha_Compra DATETIME NOT NULL,
	Facturacion_Id_Factura VARCHAR(20) NOT NULL,
	Inventario_Id_Producto VARCHAR(20) NOT NULL,
	FOREIGN KEY (Facturacion_Id_Factura) REFERENCES Facturacion(Id_Factura) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (Inventario_Id_Producto) REFERENCES Inventario(Id_Producto) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO Productos_Vendidos(Nombre_Cliente,Marca,Descripcion,Nombre,Precio_Unitario,Total,Cantidad,Sub_Total,IVA,Fecha_compra,Facturacion_Id_Factura,Inventario_Id_Producto)
VALUES('','','','','','','','','','');
DROP TABLE Productos_Comprados;

CREATE TABLE RegistroIncio
(
	ID_HoraInicio Date,
	CodigoEmpleado varchar(4000),
	NombreEmpleado varchar(4000),
	tipoEmpleado varchar (4000),
	constraint pk_ID_HoraInicio primary KEY(ID_HoraInicio)
);

