/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Student
 * Created: Jan 22, 2019
 */

INSERT INTO clients (id, name, surname) VALUES
 (1, 'Dan', 'Danilescu'),
 (2, 'George', 'Georgescu'),
 (3, 'Ilie', 'Iliescu'),
 (4, 'Andrei', 'Andrievschi');

INSERT INTO vehicles (id, brand, model) VALUES
 (1, 'Dacia', 'Logan'),
 (2, 'Toyota', 'Avensis'),
 (3, 'Hyundai', 'Santa-fe'),
 (4, 'Mercedes', 's200');

INSERT INTO rent_history (id, days, id_client, id_vehicle) VALUES
 (1, 3, 1, 1),
 (2, 10, 1, 1),
 (3, 4, 1, 2),
 (4, 5, 2, 3),
 (5, 6, 2, 4),
 (6, 7, 3, 1),
 (7, 8, 3, 2),
 (8, 9, 4, 3),
 (9, 10, 4, 4);


