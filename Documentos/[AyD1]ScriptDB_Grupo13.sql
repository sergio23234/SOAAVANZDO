-- Database: proyectoclase

-- GRUPO #13

-- CARLOS EDUARDO TORRES CAAL- 201504240
-- BRAYAN MAURICIO AROCHE BOROR – 201503918
-- KELVIN MANFREDY VASQUEZ GOMEZ - 201212490
-- MYNOR JOEL LOMBARDO MOLINA GUEVARA - 201503392
-- NELSON DANIEL CRUZ ARDIANO - 200915606


-- DROP DATABASE proyectoclase;

CREATE DATABASE proyectoclase
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
-- MODELO RELACIONAL

CREATE TABLE libro (
    id_libro        serial NOT NULL,
    titulo          VARCHAR(50) NOT NULL,
    autor           VARCHAR(50) NOT NULL,
    fecha_edicion   DATE,
    edicion         VARCHAR(50),
    editorial       VARCHAR(50) NOT NULL
);

ALTER TABLE libro ADD CONSTRAINT libro_pk PRIMARY KEY ( id_libro );

CREATE TABLE copia(
    id_copia        SERIAL NOT NULL,
    estado          VARCHAR(50) NOT NULL,
    numero          NUMERIC(4) NOT NULL,
    id_libro           INT NOT NULL
);

ALTER TABLE copia ADD CONSTRAINT copia_pk PRIMARY KEY ( id_copia );

ALTER TABLE copia
    ADD CONSTRAINT copia_id_libro_fk FOREIGN KEY ( id_libro )
		REFERENCES libro ( id_libro );
		
CREATE TABLE facultad (
    id_facultad   serial NOT NULL,
    nombre        VARCHAR(50) NOT NULL
);

ALTER TABLE facultad ADD CONSTRAINT facultad_pk PRIMARY KEY ( id_facultad );

CREATE TABLE carrera (
    id_carrera             serial NOT NULL,
    nombre                 VARCHAR(50) NOT NULL,
    id_facultad   INT NOT NULL
);

ALTER TABLE carrera ADD CONSTRAINT carrera_pk PRIMARY KEY ( id_carrera );

ALTER TABLE carrera
    ADD CONSTRAINT carrera_facultad_fk FOREIGN KEY ( id_facultad )
        REFERENCES facultad ( id_facultad );

CREATE TABLE usuario(
    carnet             NUMERIC(15) NOT NULL,
    nombre                 VARCHAR(50) NOT NULL,
    apellido                 VARCHAR(50) NOT NULL,
    direccion                 VARCHAR(50),
    dpi                 VARCHAR(50) NOT NULL,
    telefono                 NUMERIC(10) NOT NULL,
    fecha_nacimiento    timestamp not null
);

ALTER TABLE USUARIO ADD CONSTRAINT usuario_pk PRIMARY KEY ( carnet );

CREATE TABLE usuario_carrera (
    id_usuario_carrera   serial NOT NULL,
    carnet       NUMERIC(15) NOT NULL,
    id_carrera   INT NOT NULL
);

ALTER TABLE usuario_carrera ADD CONSTRAINT usuario_carrera_pk PRIMARY KEY ( id_usuario_carrera );


ALTER TABLE usuario_carrera
    ADD CONSTRAINT usuario_carrera_carrera_fk FOREIGN KEY ( id_carrera )
        REFERENCES carrera ( id_carrera );

ALTER TABLE usuario_carrera
    ADD CONSTRAINT usuario_carrera_usuario_fk FOREIGN KEY ( carnet )
        REFERENCES usuario ( carnet );

CREATE TABLE prestamo (
    id_prestamo      serial NOT NULL,
    fecha_emision    DATE NOT NULL,
    fecha_expira     DATE NOT NULL,
    carnet   INT NOT NULL
);

ALTER TABLE prestamo ADD CONSTRAINT prestamo_pk PRIMARY KEY ( id_prestamo );

ALTER TABLE prestamo
    ADD CONSTRAINT prestamo_usuario_fk FOREIGN KEY ( carnet )
        REFERENCES usuario ( carnet );
		
CREATE TABLE detalle_prestamo (
    id_detalle_prestamo    serial NOT NULL,
    id_copia         INT NOT NULL,
    id_prestamo   INT NOT NULL
);

ALTER TABLE detalle_prestamo ADD CONSTRAINT detalle_prestamo_pk PRIMARY KEY ( id_detalle_prestamo );

ALTER TABLE detalle_prestamo
    ADD CONSTRAINT detalle_prestamo_libro_fk FOREIGN KEY ( id_copia )
        REFERENCES copia ( id_copia );

ALTER TABLE detalle_prestamo
    ADD CONSTRAINT detalle_prestamo_prestamo_fk FOREIGN KEY ( id_prestamo )
        REFERENCES prestamo ( id_prestamo );