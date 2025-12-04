DROP TABLE IF EXISTS "loan" CASCADE;
DROP TABLE IF EXISTS "copy" CASCADE;
DROP TABLE IF EXISTS "reservation" CASCADE;
DROP TABLE IF EXISTS "account" CASCADE;
DROP TABLE IF EXISTS "book";

CREATE TABLE "book"
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    author      VARCHAR(255) NOT NULL,
    isbn10      VARCHAR(255) NOT NULL,
    isbn13      VARCHAR(255) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE "account"
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    roles    VARCHAR(255) NOT NULL
);

CREATE TABLE "copy"
(
    id        SERIAL PRIMARY KEY,
    condition VARCHAR(255) NOT NULL,
    book_id   INT,
    FOREIGN KEY (book_id) REFERENCES "book" (id)
);

CREATE TABLE "loan"
(
    id          SERIAL PRIMARY KEY,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    return_date TIMESTAMP,
    copy_id     INT,
    account_id  INT,
    FOREIGN KEY (copy_id) REFERENCES "copy" (id),
    FOREIGN KEY (account_id) REFERENCES "account" (id)
);

CREATE TABLE "reservation"
(
    id          SERIAL PRIMARY KEY,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    book_id     INT,
    account_id  INT,
    FOREIGN KEY (book_id) REFERENCES "book" (id),
    FOREIGN KEY (account_id) REFERENCES "account" (id)
);

INSERT INTO "book" (id, title, author, isbn10, isbn13, create_date)
VALUES (1,
        'Design patterns: Elements of Reusable Object-Oriented Software',
        'Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides',
        '0201633612',
        '978-0201633610',
        NOW());

INSERT INTO "book" (id, title, author, isbn10, isbn13, create_date)
VALUES (2,
        'Scrum: The Art of Doing Twice the Work in Half the Time',
        'Jeff Sutherland',
        '038534645X',
        '978-0385346450',
        NOW());

INSERT INTO "book" (id, title, author, isbn10, isbn13, create_date)
VALUES (3,
        'Head First Java: A Brain-Friendly Guide',
        'Kathy Sierra, Bert Bates, Trisha Gee',
        '1491910771',
        '978-1491910771',
        NOW());

INSERT INTO "account" (id, username, password, email, roles)
VALUES (1, 'ben', '$2a$10$tjgah.EJO7t0D.DTcrUySeLhwU5aKmW5UMJCBImVt/E4vhTqzlbtK', 'ben@workingtalent.nl', 'TRAINER');

INSERT INTO "account" (id, username, password, email, roles)
VALUES (2, 'boy', '$2a$10$tjgah.EJO7t0D.DTcrUySeLhwU5aKmW5UMJCBImVt/E4vhTqzlbtK', 'boy@workingtalent.nl', 'TRAINEE');

INSERT INTO "account" (id, username, password, email, roles)
VALUES (3, 'kees', '$2a$10$tjgah.EJO7t0D.DTcrUySeLhwU5aKmW5UMJCBImVt/E4vhTqzlbtK', 'kees@workingtalent.nl', 'TRAINER,TRAINEE');

INSERT INTO "copy" (id, condition, book_id)
VALUES (1, 'NEW', 1);

INSERT INTO "copy" (id, condition, book_id)
VALUES (2, 'NEW', 2);

INSERT INTO "copy" (id, condition, book_id)
VALUES (3, 'NEW', 3);

INSERT INTO "loan" (id, create_date, copy_id, account_id)
VALUES (1, NOW(), 1, 1);

INSERT INTO "loan" (id, create_date, copy_id, account_id)
VALUES (2, NOW(), 2, 1);

INSERT INTO "loan" (id, create_date, copy_id, account_id)
VALUES (3, NOW(), 3, 2);

INSERT INTO "reservation" (id, create_date, book_id, account_id)
VALUES (1, NOW(), 1, 1);

INSERT INTO "reservation" (id, create_date, book_id, account_id)
VALUES (2, NOW(), 2, 2);