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

INSERT INTO t_users_permissions(user_id, permission_id) VALUES
            (2,1),
            (3,1),
            (4,1),
            (1,2),
            (1,1);

INSERT INTO t_apartaments(title) VALUES
         ('Hotel'),
         ('Квариты'),
         ('Виллы'),
         ('Курортные отели');

INSERT INTO t_bookings(time, uslugi_model_id) VALUES
            ('2023-08-01 01:52:00',3),
            ('2023-10-04 22:04:00',1);

INSERT INTO t_comments(comment, post_date, hotel_id) VALUES
            ('«My favorite hotel. Convenient location close to the old town and the railway station. Incredibly
comfortable bed, stunning design, delicious brekfast»','2023-08-07 10:52:33',1),
            ('«Very clean and classy . Friendly staff, food amazing breakfast to lovely to eat , a picture of colour.',
             '2023-08-07 10:53:06',1),
             ('God service, clean rooms, excellent location','2023-08-07 11:04:08',1);

INSERT INTO t_hotels(description, name, price, rating, text, city, address) VALUES
            ('All rooms at Captain Cook Hotel offer beautiful views of the Chugach Mountains or the Cook Strait.
              The carpeted rooms are decorated in bright colours. All rooms have a refrigerator and free Wi-Fi.',
             'The Hotel Captain','600','9,0','This all-suite hotel is located in downtown Anchorage, 7 blocks from the
              Anchorage Museum. It features 4 restaurants, a conference center and 15 shops.The hotel''s spacious rooms are
              discoverable with detection and cable channels.','Anchorage','939 West 5th Avenue, Анкоридж, AK 99501'),

            ('Rooms at the Hilton Head Marriott Resort feature floor-to-ceiling windows. The beds come with orthopedic
            mattresses and duvets. A coffee maker and a small fridge are included. Bathrobes and free Bath
            and Body Works toiletries are provided in the bathroom.','Hilton Anchorage Hotel','700','8,0',
             'Guests looking to work out can play on one of the 25 tennis courts or burn calories at the fitness centre.
              In addition, golf lessons are offered.The Blue Restaurant serves local cuisine.','Anchorage',
             '255 E 3rd Avenue,Анкоридж, AK 99501'),

            ('Boasting a shared lounge and a bar, Aloft Anchorage is situated in Anchorage, 2.8 km from Sullivan
            Arena and 3.9 km from Dena ina Civic Convention Center. Featuring a 24-hour front desk, this property
            also provides guests with a sun terrace. ce.','E Central Hotel Downtown','400','7,8',
            'Guests at the hotel can enjoy an American or a vegetarian breakfast.At Aloft Anchorage guests are welcome
            to take advantage of a hot tub. You can play billiards at the accommodation.','Los-Angeles',
             '500 S 12th Avenue, Los Angeles,LA 85401');

INSERT INTO t_service(service_name, has_options) VALUES
            ('Breakfast',true),
            ('Fitness Center',true),
            ('Parking',false),
            ('Swimming Pool', false);

INSERT INTO t_villa(description, name, price) VALUES
            ('wer','ssss','3333'),
            ('fefv','cded','2222');



