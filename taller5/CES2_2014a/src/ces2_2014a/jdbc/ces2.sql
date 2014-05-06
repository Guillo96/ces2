DROP TABLE tbl_usuarios cascade;
CREATE TABLE tbl_usuarios(
    id_usuario serial,
    identificacion integer not null,
    nombre varchar(255) not null,
    apellido varchar(255) not null,
    usuario varchar(255) not null,
    clave varchar(255) not null,
    nacimiento date,
    estatura float,
    constraint pk_tbl_usuarios primary key (id_usuario),
    constraint unq_tbl_usuarios_identificacion unique (identificacion),
    constraint unq_tbl_usuarios_usuario unique (usuario)
    
);
