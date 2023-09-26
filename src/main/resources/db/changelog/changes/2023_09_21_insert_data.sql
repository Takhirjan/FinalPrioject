INSERT INTO t_permission(role)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');

INSERT INTO t_users(email, full_name, password)
VALUES ('takhirjon22@mail.ru','Takhirzhan','$2a$12$WAD5UwuXy1uWMq9hWGdsteEADQVBfeb0FIq3FeVP4spjPFSLo8DF6'),
   ('amina_b@gmail.com','Amina','$2a$12$Ni8jBquyFP/aLd4rQzEGrOobiE0REtxxonGkWNYNaGN45a9zUp3J2'),
        ('alexteacheredu02@gmail.com','Alex','$2a$12$Ni8jBquyFP/aLd4rQzEGrOobiE0REtxxonGkWNYNaGN45a9zUp3J2'),
           ('kazybektalgat15@gmail.com','Kazybek','$2a$12$f.9GUmwRvkXBOPmji6H8YOTrgY29QBbbLd.8VW6weku3DJ1./FVFK'),
            ('ta@mail.ru','java','$2a$10$z0inPY/0I3vZaL8a8fAxeulKuyOlBqwZ3Z6M34lbJg.i1RQLvNLFu');

INSERT INTO t_users_permissions(users_id, permissions_id) VALUES
            (2,1),
            (3,1),
            (4,1),
            (1,2),
            (1,1);