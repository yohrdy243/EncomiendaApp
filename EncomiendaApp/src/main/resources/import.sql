INSERT INTO categoria (costo,peso_maximo,peso_minimo,tipo_categoria) VALUES  (8,5,0,'A')
INSERT INTO categoria (costo,peso_maximo,peso_minimo,tipo_categoria) VALUES  (12,12,6,'B')
INSERT INTO categoria (costo,peso_maximo,peso_minimo,tipo_categoria) VALUES  (30,21,13,'C')
INSERT INTO categoria (costo,peso_maximo,peso_minimo,tipo_categoria) VALUES  (80,30,22,'D')
INSERT INTO categoria (costo,peso_maximo,peso_minimo,tipo_categoria) VALUES  (135,150,31,'E')

INSERT INTO sucursal (codigo,direccion,nombre) VALUES('TRUJ-1','Av. Húsares de Junín 690','Trujillo')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('AMZN-1','AV. America Sur 2570','Amazonas')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('CAXA-1','Av. Amazonas 1650','Cajamarca')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('ANCH-1','AV. Ucayali 234','Ancash')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('CHLY-1','Av. Paseo de la República 3101','Chiclayo')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('CLLO-1','Av. Perú N° 1350','Callao')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('LIMA-1','Av.  Micaela Bastidas 314','Lima')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('JNIN-1','Daniel A. Carrión N° 196 2do. Piso','Junin')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('AYCH-1','Av. Salaverry 1610','Ayacucho')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('ARMC-1','Av. Hermann Gmeiner Nº 155','Apurimac')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('CUSC-1','Calle los Faiques N° 189','Cusco')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('ARQP-1','Av. Bolognesi 195','Arequipa')
INSERT INTO sucursal (codigo,direccion,nombre) VALUES('HCVL-1','Portal Municipal Nº44','Huancavelica')


INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('4', '1', '12');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('4', '12', '1');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('2', '12', '11');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('2', '11', '12');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('9', '11', '1');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('9', '1', '11');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('4', '13', '12');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('4', '12', '13');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('2', '11', '13');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('2', '13', '11');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('8', '13', '1');
INSERT INTO ruta (precio, ruta_sucursal_emisor_fk, ruta_sucursal_receptor_fk) VALUES ('8', '1', '13');


INSERT INTO cliente (apellidos, correo, dni, nombres, telefono,habilitado) VALUES ('Escobar', 'gescobm16@gmail.com', '74356279', 'Gustavo', '968747296',1);
INSERT INTO cliente (apellidos, correo, dni, nombres, telefono,habilitado)VALUES ('Guevara', 'yorhdy234@gmail.com', '71802349', 'Yohrdy', '943506975',1);
INSERT INTO cliente (apellidos, correo, dni, nombres, telefono,habilitado)VALUES ('Fernandez', 'lexar@gmail.com', '7241882', 'Cesar', '945105605',1);
INSERT INTO cliente (apellidos, correo, dni, nombres, telefono,habilitado)VALUES ('Garcia', 'mau@gmail.com', '10654421', 'Mauro', '980620260',1);
INSERT INTO cliente (apellidos, correo, dni, nombres, telefono,habilitado)VALUES ('Coaquira', 'bleiser@gmail.com', '15566220', 'Paolo', '995452621',1);
INSERT INTO cliente (apellidos, correo, dni, nombres, telefono,habilitado)VALUES ('Otiniano', 'mrweirdo@gmail.com', '56321420', 'Alejandro', '9757784451',1);

INSERT INTO orden_de_envio(id_orden_de_envio,clave,codigo,fecha_envio,precio_categoria,precio_total,precio_transporte,orden_cliente_emisor_fk,orden_cliente_receptor_fk,orden_ruta_fk) VALUES (1,'lb','Truj1','2020-10-28',50,62,12,1,3,1);
INSERT INTO orden_de_envio(id_orden_de_envio,clave,codigo,fecha_envio,precio_categoria,precio_total,precio_transporte,orden_cliente_emisor_fk,orden_cliente_receptor_fk,orden_ruta_fk) VALUES (2,'7v','Cusc2','2020-10-28',50,77,27,3,2,5);
INSERT INTO orden_de_envio(id_orden_de_envio,clave,codigo,fecha_envio,precio_categoria,precio_total,precio_transporte,orden_cliente_emisor_fk,orden_cliente_receptor_fk,orden_ruta_fk) VALUES (3,'2x','Areq3','2020-10-28',62,70,8,5,4,3);

INSERT INTO paquete(id_paquete,codigo,descripcion,estado,fragilidad,peso,precio_paquete,paquete_categoria_fk,orden_paquetes_fk) VALUES (1,'PA-1','Paquete 1',1,1,5,12,1,1);
INSERT INTO paquete(id_paquete,codigo,descripcion,estado,fragilidad,peso,precio_paquete,paquete_categoria_fk,orden_paquetes_fk) VALUES (2,'PA-2','Paquete 2',1,1,4,10,1,1);
INSERT INTO paquete(id_paquete,codigo,descripcion,estado,fragilidad,peso,precio_paquete,paquete_categoria_fk,orden_paquetes_fk) VALUES (3,'PB-3','Paquete 3',1,0,11,21,2,1);
INSERT INTO paquete(id_paquete,codigo,descripcion,estado,fragilidad,peso,precio_paquete,paquete_categoria_fk,orden_paquetes_fk) VALUES (4,'PB-4','Paquete 4',1,1,10,18,2,2);
INSERT INTO paquete(id_paquete,codigo,descripcion,estado,fragilidad,peso,precio_paquete,paquete_categoria_fk,orden_paquetes_fk) VALUES (5,'PC-5','Paquete 5',1,0,18,45,3,2);
INSERT INTO paquete(id_paquete,codigo,descripcion,estado,fragilidad,peso,precio_paquete,paquete_categoria_fk,orden_paquetes_fk) VALUES (6,'PC-6','Paquete 6',1,1,20,51,3,2);
INSERT INTO paquete(id_paquete,codigo,descripcion,estado,fragilidad,peso,precio_paquete,paquete_categoria_fk,orden_paquetes_fk) VALUES (7,'PE-7','Paquete 7',1,1,130,139,5,3);


