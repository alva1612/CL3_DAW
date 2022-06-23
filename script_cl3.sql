create database DB_GUILLEN;
use DB_GUILLEN;
create table tb_carreras 
(
idcarrera int primary key,
descripcion varchar(20)
);

create table tb_reserva
(
codigo int auto_increment primary key,
nombre varchar(20),
apellido varchar(20),
idcarrera int,
fchregistro date,
 FOREIGN KEY (idcarrera) REFERENCES tb_carreras(idcarrera)
);

INSERT INTO `DB_GUILLEN`.`tb_carreras` (`idcarrera`, `descripcion`) VALUES ('1', 'Computacion');
INSERT INTO `DB_GUILLEN`.`tb_carreras` (`idcarrera`, `descripcion`) VALUES ('2', 'Diseño');
INSERT INTO `DB_GUILLEN`.`tb_carreras` (`idcarrera`, `descripcion`) VALUES ('3', 'Enfermeria');
INSERT INTO `DB_GUILLEN`.`tb_carreras` (`idcarrera`, `descripcion`) VALUES ('4', 'Traduccion');
INSERT INTO `DB_GUILLEN`.`tb_carreras` (`idcarrera`, `descripcion`) VALUES ('5', 'Profesor');

INSERT INTO `DB_GUILLEN`.`tb_reserva` (`nombre`, `apellido`, `idcarrera`, `fchregistro`) VALUES ('Alvaro', 'Guillen', '1', '2022-03-19');
INSERT INTO `DB_GUILLEN`.`tb_reserva` (`nombre`, `apellido`, `idcarrera`, `fchregistro`) VALUES ('Luis', 'Matias', '2', '2022-03-10');
INSERT INTO `DB_GUILLEN`.`tb_reserva` (`nombre`, `apellido`, `idcarrera`, `fchregistro`) VALUES ('Angie', 'Ataupillco', '3', '2022-03-07');
INSERT INTO `DB_GUILLEN`.`tb_reserva` (`nombre`, `apellido`, `idcarrera`, `fchregistro`) VALUES ('Stephanie', 'Villafranca', '4', '2021-07-30');
INSERT INTO `DB_GUILLEN`.`tb_reserva` (`nombre`, `apellido`, `idcarrera`, `fchregistro`) VALUES ('Maryuri', 'Torres', '5', '2021-07-05');

select*from tb_reserva inner join tb_carreras on tb_reserva.idcarrera = tb_carreras.idcarrera;

