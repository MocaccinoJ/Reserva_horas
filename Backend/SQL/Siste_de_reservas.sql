CREATE DATABASE reserva_de_horas
USE reserva_de_horas

--TABLA DE ADMINISTRADORES!!!!!!!!!!!!!

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('administradores'))
BEGIN;
    DROP TABLE [administradores];
END;
GO

CREATE TABLE [administradores] (
	[id] INT IDENTITY(1,1) PRIMARY KEY,
    [nombre] VARCHAR(255),
    [correo] VARCHAR(255),
    [contrasenha] VARCHAR(255),

);
GO

INSERT INTO administradores([nombre],[correo],[contrasenha]) 
VALUES('Jessamine Y. Sparks','tellus@aneque.co.uk','SYX44DUT0KX'),
      ('Raya K. Wells','a.sollicitudin.orci@feugiat.ca','UTM78IZE3WY'),
	  ('Craig N. Curtis','Proin@duiquisaccumsan.net','VEG81NMY0BY'),
	  ('Wylie C. Bright','lorem.ipsum.sodales@miDuisrisus.edu','KXO88MNH6GH'),
	  ('Pamela V. Banks','molestie@Suspendissealiquet.com','DTX98RJV0RT'),
	  ('Abbot S. Edwards','Proin.eget.odio@vitae.ca','DVN75XNC5AW'),
	  ('Honorato L. Wade','orci.lobortis.augue@inmagna.org','KLO23SEC1BP'),
	  ('Thaddeus U. Romero','nunc.sed.libero@molestiedapibus.com','DTN86MFI9PD'),
	  ('Hamilton B. Duncan','id.libero@PhasellusnullaInteger.edu','BDR87MRW0VB'),
	  ('September G. Lewis','nulla@facilisis.co.uk','DEC95DBL3CJ');

SELECT * FROM administradores 

--TABLA DE USUARIOS!!!!!!!!!!!!

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('usuarios'))
BEGIN;
    DROP TABLE [usuarios];
END;
GO

CREATE TABLE [usuarios] (
	id INT IDENTITY(1,1) PRIMARY KEY,
    [nombre] VARCHAR(255),
    [correo] VARCHAR(255),
    [contrasenha] VARCHAR(255),
);
GO

INSERT INTO usuarios([nombre],[correo],[contrasenha]) 
VALUES('Hanna I. Santiago','fermentum.convallis@semNullainterdum.ca','HFC44EAS5QF'),
	  ('Yen E. Ayers','porttitor@ametconsectetueradipiscing.com','FQY62LSQ0HI'),
	  ('Noel K. Norton','risus@magnaSedeu.ca','UGQ78WOA2MX'),
	  ('Emerson M. Downs','sollicitudin.adipiscing.ligula@nibhQuisquenonummy.org','QHQ83KML7FZ'),
	  ('Mufutau N. Wiley','vitae@elit.ca','BWE40ZLO5RC'),
	  ('Stone N. Suarez','magna@Phasellus.co.uk','DNK32YTI7RD'),
	  ('Katell V. Green','iaculis@eu.org','IUG03NGH1XC'),
	  ('Erasmus P. Forbes','eu.dui.Cum@aultriciesadipiscing.net','TRV68HNQ0TF'),
	  ('Keegan Q. Blackwell','mauris.sagittis.placerat@utipsum.net','HRR52UGR8VO'),
	  ('Kyle A. Randolph','dis.parturient@aliquetliberoInteger.com','IQO01ALE9BJ');

SELECT * FROM usuarios


--TABLA DE RESERVA DE HORAS!!!!!!!!!!!!!

SELECT GETDATE (); /*OBTIENE LA FECHA Y HORA DEL SISTEMA*/

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('reserva'))
BEGIN;
    DROP TABLE [reserva];
END;
GO
--CAMBIAR LAS LLAVES DE RESERVA!!!!!!!!!!!
CREATE TABLE [reserva] (
	id INT IDENTITY(1,1) PRIMARY KEY,
	fecha DATE,
	hora VARCHAR(25),
	id_u INT,
	servicio VARCHAR (25),
	ubicacion_f VARCHAR (150),
	estado VARCHAR (150),
	id_a INT,
	FOREIGN KEY (id_u) REFERENCES usuarios (id),
	FOREIGN KEY (ubicacion_f) REFERENCES farmacias (ubicacion),
	FOREIGN KEY (id_a) REFERENCES administradores (id)
    );
GO

INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('1/8/2020', '15:00','1','Venta','Bernardo','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('12/23/2020', '17:45','2','Post Venta','Bernardito','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('1/3/2020', '14:00','3','Venta','Bernar','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('10/18/2020', '13:00','4','Venta','Ñoño','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('6/27/2020', '10:45','5','Post Venta','Ñuña','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('12/12/2020', '15:45','6','Venta','Ñuñita','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('9/25/2020', '12:00','7','Post Venta','Maipo','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('3/29/2020', '14:00','8','Post Venta','Maipú','Sin confirmar');
INSERT INTO reserva ([fecha],[hora],[id_u],[servicio],[ubicacion_f],[estado]) VALUES ('7/14/2020', '9:45','9','Post Venta','Moscú','Sin confirmar');



 select * from reserva where id_u = '1'

IF EXISTS(SELECT 1 FROM sys.tables WHERE object_id = OBJECT_ID('farmacias'))
BEGIN;
	DROP TABLE [farmacias];
END;
GO

CREATE TABLE [farmacias] (
	franquicia VARCHAR (150),
	ubicacion VARCHAR (150) PRIMARY KEY ,
	comuna varchar (150),
	);
GO
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Cruz Verde', 'Bernardo','San Bernardo');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Ahumada', 'Bernardito','San Bernardo');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Salcobrand', 'Bernar', 'San Bernardo');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Cruz Verde', 'Ñoño', 'Ñuñoa');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Ahumada', 'Ñuña', 'Ñuñoa');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Salcobrand', 'Ñuñita', 'Ñuñoa');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Cruz Verde', 'Maipo', 'Maipú');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Ahumada', 'Maipú', 'Maipú');
INSERT INTO farmacias ([franquicia],[ubicacion],[comuna]) VALUES ('Salcobrand', 'Moscú', 'Maipú');

SELECT * FROM reserva
SELECT * FROM farmacias