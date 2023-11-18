INSERT INTO student (id, first_name, last_name, email, age) VALUES
                                                                (1, 'Juan', 'Perez', 'perez@gamil.com', 20),
                                                                (2, 'Jose', 'Sejas', 'jose@gamil.com', 20),
                                                                (3, 'Lucio', 'Maldonado', 'lucio@gamil.com', 20),
                                                                (4, 'Ana', 'Alvares', 'ana@gamil.com', 20),
                                                                (5, 'Lucia', 'Lopez', 'lucia@gamil.com', 20);
INSERT INTO student_id_card (id, card_number, student_id) VALUES
                                                              (1, '123456789', 1),
                                                              (2, '123456790', 2),
                                                              (3, '123456791', 3),
                                                              (4, '123456792', 4),
                                                              (5, '123456793', 5);

INSERT INTO enrollment (id, grade, created_at, student_id, course_id) VALUES
                                                                          (1, 60, now(), 1, 0),
                                                                          (2, 71, now(), 2, 0),
                                                                          (3, 80, now(), 3, 0),
                                                                          (4, 100, now(), 4, 0);