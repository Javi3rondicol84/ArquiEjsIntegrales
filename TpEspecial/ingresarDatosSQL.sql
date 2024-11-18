CREATE DATABASE IF NOT EXISTS paradams;
CREATE DATABASE IF NOT EXISTS usuarioms;
CREATE DATABASE IF NOT EXISTS monopatinms;
CREATE DATABASE IF NOT EXISTS viajems;
CREATE DATABASE IF NOT EXISTS administradorms;

INSERT INTO viaje (id_viaje, fecha_ini, fecha_fin, hora_inicio, hora_fin, id_monopatin, kilometros, parada, pausa, precio, tarifa_extra, tiempo_pausado)
VALUES
    (1, '2024-11-10', '2024-11-10', '10:00:00', '10:30:00', '101A', 12.5, '40.7128,-74.0060', false, 100, 0, '00:00:00'),
    (2, '2024-11-11', '2024-11-11', '12:00:00', '12:45:00', '102B', 10.0, '34.0522,-118.2437', true, 100, 0, '00:10:00'),
    (3, '2024-11-12', '2024-11-12', '09:15:00', '09:45:00', '103C', 8.3, '51.5074,-0.1278', false, 100, 0, '00:00:00'),
    (4, '2024-11-13', '2024-11-13', '14:30:00', '15:00:00', '104D', 20.2, '48.8566,2.3522', false, 100, 0, '00:00:00'),
    (5, '2024-11-14', '2024-11-14', '16:00:00', '16:30:00', '105E', 15.0, '40.7306,-73.9352', true, 100, 50, '00:25:00'),
    (6, '2024-12-17', '2024-12-17', '17:00:00', '15:00:00', '102B', 33.0, '34.0522,-118.2437', true, 100, 50, '00:22:00'),
    (7, '2024-11-16', '2024-11-16', '10:00:00', '10:45:00', '102B', 12.0, '34.0522,-118.2437', false, 100, 0, '00:10:00'),
    (8, '2024-11-17', '2024-11-17', '14:00:00', '14:30:00', '103C', 9.5, '51.5074,-0.1278', true, 100, 0, '00:08:00'),
    (9, '2024-11-18', '2024-11-18', '16:00:00', '16:30:00', '104D', 22.0, '48.8566,2.3522', false, 100, 0, '00:12:00'),
    (10, '2024-11-19', '2024-11-19', '18:00:00', '18:30:00', '105E', 17.0, '40.7306,-73.9352', true, 100, 50, '00:20:00'),
    (11, '2024-12-12', '2024-12-12', '14:00:00', '14:30:00', '106F', 11.3, '40.785091,-73.968285', true, 100, 0, '00:05:00');

INSERT INTO parada (idparada, id_monopatin, nombreparada)
VALUES
    (1, '101A', '40.7128,-74.0060'),
    (2, '102B', '34.0522,-118.2437'),
    (3, '103C', '51.5074,-0.1278'),
    (4, '104D', '48.8566,2.3522'),
    (5, '105E', '40.7306,-73.9352');

INSERT INTO monopatin (id_monopatin, encendido, gps, habilitado, id_viaje, kilometros_recorridos, tiempo_de_uso)
VALUES
    ('101A', true, '40.7128,-74.0060', true, 1, 12.5, '00:30:00'),
    ('102B', false, '34.0522,-118.2437', true, 2, 10.0, '00:45:00'),
    ('103C', true, '51.5074,-0.1278', true, 3, 8.3, '00:30:00'),
    ('104D', false, '48.8566,2.3522', true, 4, 20.2, '00:30:00'),
    ('105E', true, '40.7306,-73.9352', false, 5, 15.0, '00:30:00');

INSERT INTO usuario (id_usuario, apellido, email, gps, nombre, numero_telefonico)
VALUES
    (1, 'Gonzalez', 'gonzalez@example.com', '40.7138,-74.0070', 'Juan', 123490),
    (2, 'Lopez', 'lopez@example.com', '34.0532,-118.2450', 'Maria', 255901),
    (3, 'Martinez', 'martinez@example.com', '51.5084,-0.1280', 'Carlos', 345632),
    (4, 'Perez', 'perez@example.com', '48.8572,2.3530', 'Ana', 450123),
    (5, 'Rodriguez', 'rodriguez@example.com', '40.7320,-73.9365', 'Pedro', 561234);

INSERT INTO cuenta (id_cuenta, creditos, fecha_de_creacion, habilitada)
VALUES
    (1, 1000.0, '2024-11-10', true),
    (2, 1500.0, '2024-11-11', true),
    (3, 2000.0, '2024-11-12', true),
    (4, 1200.0, '2024-11-13', true),
    (5, 800.0, '2024-11-14', true);

INSERT INTO cuenta_usuarios (cuentas_id_cuenta, usuarios_id_usuario)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (4, 1),
    (4, 3),
    (5, 2);