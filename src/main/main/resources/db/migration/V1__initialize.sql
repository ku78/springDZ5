drop table if exists products cascade;
drop table if exists categories cascade;

create table categories (id bigserial, title varchar(255), primary key(id));
create table products (id bigserial, category_id bigserial, title varchar(255), description varchar(5000), price int, primary key(id), FOREIGN KEY (category_id)  REFERENCES categories(id));
insert into categories (title) values ('Category 1'), ('Category 2'), ('Category 3'), ('Category 4'), ('Category 5');

insert into products
(title, description, price, category_id) values
('Cheese', 'Fresh cheese', 320),
('Cheese', 'Fresh cheese', 320, 1),
('Milk', 'Fresh milk', 80),
('Milk', 'Fresh milk', 80, 2),
('Apples', 'Fresh apples', 80),
('Apples', 'Fresh apples', 80, 3),
('Bread', 'Fresh bread', 30),
('Bread', 'Fresh bread', 30, 4),
('A1', '', 1),
('A1', '', 1, 5),
('A2', '', 2),
('A2', '', 2, 1),
('A3', '', 3),
('A3', '', 3, 2),
('A4', '', 4),
('A4', '', 4, 3),
('A5', '', 5),
('A5', '', 5, 4),
('A6', '', 6),
('A6', '', 6, 5),
('A7', '', 7),
('A7', '', 7, 1),
('A8', '', 8),
('A8', '', 8, 2),
('A9', '', 9),
('A9', '', 9, 3),
('A10', '', 10),
('A10', '', 10, 4),
('A11', '', 11),
('A11', '', 11, 5),
('A12', '', 12),
('A12', '', 12, 1),
('A13', '', 13),
('A13', '', 13, 2),
('A14', '', 14),
('A14', '', 14, 3),
('A15', '', 15),
('A15', '', 15, 4),
('A16', '', 16),
('A16', '', 16, 4),
('A17', '', 17),
('A17', '', 17, 4),
('A18', '', 18),
('A18', '', 18, 4),
('A19', '', 19),
('A19', '', 19, 1),
('A20', '', 20);
('A20', '', 20, 2);