insert into user_data (id,username, password , enabled) values (1,'Janek','{noop}janek123', true);
insert into user_data (id,username, password, enabled) values (2,'Borysek','{noop}borys123', true);
insert into user_data (id,username, password , enabled) values (3,'Kasia','{noop}kasia123', true);
insert into user_data (id,username, password, enabled) values (4,'Bartek','{noop}bartek123', true);
insert into user_data (id,username, password , enabled) values (5,'Lotos','{noop}lotos123', true);
insert into user_data (id,username, password, enabled) values (6,'Pola','{noop}pola123', true);
insert into user_data (id,username, password , enabled) values (7,'Pati','{noop}pati123', true);
insert into user_data (id,username, password, enabled) values (8,'Czarek','{noop}czarek123', true);
insert into user_data (id,username, password , enabled) values (9,'Marysia','{noop}marysia123', true);
insert into user_data (id,username, password, enabled) values (10,'Marcin','{noop}marcin123', true);

INSERT INTO USER_ROLE(username, role) values ('Czarek', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('Borysek', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Kasia', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Bartek', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Janek', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Lotos', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Pola', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Pati', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Marysia', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('Marcin', 'ROLE_USER');

insert into user (first_name, last_name, user_data_id) values ('Jan', 'Kowalski', 1);
insert into user (first_name, last_name,user_data_id) values ('Borys', 'Gambuś',2);
insert into user (first_name, last_name, user_data_id) values ('Kasia', 'Kuc', 3);
insert into user (first_name, last_name,user_data_id) values ('Bartek', 'Pietryga',4);
insert into user (first_name, last_name, user_data_id) values ('Krystian', 'Lotos', 5);
insert into user (first_name, last_name,user_data_id) values ('Borys', 'Gambuś',6);
insert into user (first_name, last_name, user_data_id) values ('Patrycja', 'Kos', 7);
insert into user (first_name, last_name,user_data_id) values ('Czarek', 'Ochman',8);
insert into user (first_name, last_name, user_data_id) values ('Marysia', 'Nowak', 9);
insert into user (first_name, last_name,user_data_id) values ('Marcin', 'Ulfik',10);

-- napoje

insert into recipe (category, description, title, user_id,img, rating) values (
'DRINK', 'Dla uzyskania klarownego płynu cocktail można przecedzić przez podwójne sitko. Pyszny domowy drink gotowy!', 'Lime Basil Smash', 1,'https://cdn.pixabay.com/photo/2016/10/22/20/09/white-wine-1761575_960_720.jpg', 1);
insert into ingredient (amount, name,recipe_id) values ('40 ml', 'gin', 1);
insert into ingredient (amount, name,recipe_id) values ('20 ml', 'sok z limonki', 1);
insert into ingredient (amount, name,recipe_id) values ('15 ml', 'syrop cukrowy', 1);
insert into ingredient (amount, name,recipe_id) values ('30 ml', 'sok jabłkowy', 1);
insert into ingredient (amount, name,recipe_id) values ('2 kostki', 'lód', 1);

insert into recipe (category, description, title, user_id,img, rating) values (
'DRINK', 'Ten prosty przepis z szybkością światła wprowadzi cię w świąteczny klimat. Pyszna kawa pachnie piernikiem, który od razu kojarzy nam się z zimą. Doskonała na rozgrzewkę po spacerze na mroźnym powietrzu oraz jako poranny zastrzyk energii.', 'Zimowa kawa', 2, 'https://v.wpimg.pl/MzExNzUwYhskGjhJegxvDmdCbBM8VWFYMFp0WHo4YkxxTDZOZkdiHmsPPhM4EGMKKVd9QmBCdUhzQXtXeEZ0TnRNdk9gRX5VLhk5G3sdPR8iWjM=',9);
insert into ingredient (amount, name,recipe_id) values ('1 szklanka', 'szklanka mleka', 2);
insert into ingredient (amount, name,recipe_id) values ('200 ml','świeżo zaparzonej kawy', 2);
insert into ingredient (amount, name,recipe_id) values ('1 łyżeczka', 'przyprawa do piernika', 2);
insert into ingredient (amount, name,recipe_id) values ('2 łyżeczki', 'kakao', 2);

insert into recipe (category, description, title, user_id,img, rating) values (
'DRINK', 'Gotowanie kakao to niezwykle trudna sztuka. Nie mamy na myśli kakao rozpuszczalnego, gdzie wystarczy wrzucić dwie łyżeczki proszku, zalać wodą albo gorącym mlekiem.', 'Kakao', 3, 'https://cdn.pixabay.com/photo/2016/10/30/09/30/hot-chocolate-1782623_960_720.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('1 szklanka', 'szklanka mleka', 3);
insert into ingredient (amount, name,recipe_id) values ('1 kostka', 'gorzka czekolada', 3);
insert into ingredient (amount, name,recipe_id) values ('4 łyżeczki', 'kakao', 3);


insert into recipe (category, description, title, user_id,img, rating) values (
'DRINK', 'Napewno wiele osób uwielbia słodkie mleko, teraz możecie sami je zrobić', 'Słodkie Mleko!', 1, 'https://cdn.pixabay.com/photo/2017/07/05/15/41/milk-2474993_960_720.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2 l', 'mleko', 4);
insert into ingredient (amount, name,recipe_id) values ('0,5 kg', 'cukier', 4);
insert into ingredient (amount, name,recipe_id) values ('1', 'cukier waniliowy', 4);
insert into ingredient (amount, name,recipe_id) values ('0,5 łyżeczki', 'soda', 4);

insert into recipe (category, description, title, user_id,img, rating) values (
'DRINK', 'Rozgrzewa, pobudza zmysły (szczególnie to z goździkami) i poprawia nastrój! Sięgaj po nie, kiedy przemarzłaś, a szybko wrócisz do formy. Grzane wino pomoże ci też w przeziębieniu.', 'Grzane wino', 1,'https://www.pieknowdomu.pl/wordpress/wp-content/uploads/2018/01/grzane-wino-01.jpg',6);
insert into ingredient (amount, name,recipe_id) values ('250 ml', 'wino', 5);
insert into ingredient (amount, name,recipe_id) values ('3 plastry', 'pomarańcza', 5);
insert into ingredient (amount, name,recipe_id) values ('5 całych', 'goździki', 5);
insert into ingredient (amount, name,recipe_id) values ('1 łyżka', 'przyprawa do grzanego wina', 5);

-- śniadanie

insert into recipe (category, description, title, user_id,img, rating) values (
'BREAKFAST', 'Idealna na śniadanie!', 'Jajecznica ze szczypiorkiem', 1,'https://cdn.pixabay.com/photo/2015/08/05/12/29/breakfast-876432_960_720.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2', 'jajka', 6);
insert into ingredient (amount, name,recipe_id) values ('1', 'bułka', 6);
insert into ingredient (amount, name,recipe_id) values ('1', 'cebula', 6);

insert into recipe (category, description, title, user_id,img, rating) values (
'BREAKFAST', 'Szybkie, smaczne idealne dla twojej 2 połówki!', 'Naleśniki z malinami', 2,'https://cdn.pixabay.com/photo/2017/05/07/08/56/pancakes-2291908_960_720.jpg',8);
insert into ingredient (amount, name,recipe_id) values ('200g', 'maliny', 7);
insert into ingredient (amount, name,recipe_id) values ('1 szklanka', 'mąka pszenna', 7);
insert into ingredient (amount, name,recipe_id) values ('2', 'jajka', 7);
insert into ingredient (amount, name,recipe_id) values ('szczypta', 'sól', 7);
insert into ingredient (amount, name,recipe_id) values ('3 łyżki', 'mleko', 7);

insert into recipe (category, description, title, user_id,img, rating) values (
'BREAKFAST', 'Lekkie, mało kaloryczne i do tego apetyczne', 'Jogurt z owocami', 3,'https://cdn.pixabay.com/photo/2016/06/07/17/15/yogurt-1442034_960_720.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('0,5 l', 'jogurt naturalny', 8);
insert into ingredient (amount, name,recipe_id) values ('20 g', 'musli', 8);
insert into ingredient (amount, name,recipe_id) values ('200g', 'mix owoców', 8);

insert into recipe (category, description, title, user_id,img, rating) values (
'BREAKFAST', 'Bomba witaminowa, polecamy wszystkim!', 'Witaminowe BUM', 4,'https://cdn.pixabay.com/photo/2016/02/19/10/29/breakfast-1209260_960_720.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('0,5 l', 'jogurt naturalny', 9);
insert into ingredient (amount, name,recipe_id) values ('50 g', 'musli', 9);
insert into ingredient (amount, name,recipe_id) values ('50g', 'mix orzechów', 9);
insert into ingredient (amount, name,recipe_id) values ('200g', 'mix owoców', 9);

insert into recipe (category, description, title, user_id,img, rating) values (
'BREAKFAST', 'Coś dla leniuchów', 'Płatki z mlekiem', 5,'https://cdn.pixabay.com/photo/2016/06/08/19/46/cereal-1444495_960_720.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('300 ml', 'mleko', 10);
insert into ingredient (amount, name,recipe_id) values ('100g', 'ulubione płatki', 10);

-- obiad

insert into recipe (category, description, title, user_id,img, rating) values (
'DINNER', 'Dla smakoszy zup', 'LECZO Z BATATAMI', 6,'https://www.kwestiasmaku.com/sites/v123.kwestiasmaku.com/files/styles/kafelki/public/leczo_z_chorizo_batatami_00.jpg?itok=7_JjkxPY',7);
insert into ingredient (amount, name,recipe_id) values ('1 łyżka', 'olej', 11);
insert into ingredient (amount, name,recipe_id) values ('1', 'cebula', 11);
insert into ingredient (amount, name,recipe_id) values ('1', 'batat', 11);
insert into ingredient (amount, name,recipe_id) values ('250g', 'cukinia', 11);


insert into recipe (category, description, title, user_id,img, rating) values (
'DINNER', 'Idelane dla dzieci', 'Makaron na słodko', 7,'https://www.kwestiasmaku.com/sites/v123.kwestiasmaku.com/files/styles/kafelki/public/makaron_z_truskawkami_00.jpg?itok=FCj10kAc',1);
insert into ingredient (amount, name,recipe_id) values ('150g', 'makaron', 12);
insert into ingredient (amount, name,recipe_id) values ('400g', 'truskawki', 12);
insert into ingredient (amount, name,recipe_id) values ('4 łyżki', 'cukier', 12);
insert into ingredient (amount, name,recipe_id) values ('1/3 szklanki', 'śmietana 18%', 12);

insert into recipe (category, description, title, user_id,img, rating) values (
'DINNER', 'Tym zaskoczysz teścia!', 'Szybki żurek', 7,'https://www.kwestiasmaku.com/sites/v123.kwestiasmaku.com/files/styles/kafelki/public/zurek_blyskawiczny_00.jpg?itok=5ruHyB12',1);
insert into ingredient (amount, name,recipe_id) values ('250g', 'boczek', 13);
insert into ingredient (amount, name,recipe_id) values ('2 l', 'bulion', 13);
insert into ingredient (amount, name,recipe_id) values ('500 ml', 'zakwas', 13);
insert into ingredient (amount, name,recipe_id) values ('200ml', 'gęsta śmietana', 13);
insert into ingredient (amount, name,recipe_id) values ('350g', 'wiejska kiełbasa', 13);


insert into recipe (category, description, title, user_id,img, rating) values (
'DINNER', 'Ciekawy smak, musisz spróbować!', 'Zupa Dyniowa', 9,'https://cdn.pixabay.com/photo/2017/11/23/13/50/pumpkin-soup-2972858_960_720.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('800g', 'dynia', 14);
insert into ingredient (amount, name,recipe_id) values ('250g', 'ziemniaki', 14);
insert into ingredient (amount, name,recipe_id) values ('25g', 'masło', 14);
insert into ingredient (amount, name,recipe_id) values ('1', 'cebula', 14);
insert into ingredient (amount, name,recipe_id) values ('2', 'czosnek', 14);


insert into recipe (category, description, title, user_id,img, rating) values (
'DINNER', 'Wyrazisty smak, lekka nuta cytryny', 'Zupa pomidorowa', 10,'https://cdn.pixabay.com/photo/2015/02/03/16/31/soup-622737__340.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2l', 'bulion z kury', 15);
insert into ingredient (amount, name,recipe_id) values ('200g', 'koncentrat pomidorowy', 15);
insert into ingredient (amount, name,recipe_id) values ('1 łyżeczka', 'pieprz', 15);
insert into ingredient (amount, name,recipe_id) values ('250ml', 'śmietana 18%', 15);

-- kolacja

insert into recipe (category, description, title, user_id,img, rating) values (
'SUPPER', 'Wyrazisty smak, lekka nuta cytryny', 'Zupa pomidorowa', 10,'https://cdn.pixabay.com/photo/2015/02/03/16/31/soup-622737__340.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2l', 'bulion z kury', 15);
insert into ingredient (amount, name,recipe_id) values ('200g', 'koncentrat pomidorowy', 15);
insert into ingredient (amount, name,recipe_id) values ('1 łyżeczka', 'pieprz', 15);
insert into ingredient (amount, name,recipe_id) values ('250ml', 'śmietana 18%', 15);

insert into recipe (category, description, title, user_id,img, rating) values (
'SUPPER', 'Wyrazisty smak, lekka nuta cytryny', 'Zupa pomidorowa', 10,'https://cdn.pixabay.com/photo/2015/02/03/16/31/soup-622737__340.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2l', 'bulion z kury', 15);
insert into ingredient (amount, name,recipe_id) values ('200g', 'koncentrat pomidorowy', 15);
insert into ingredient (amount, name,recipe_id) values ('1 łyżeczka', 'pieprz', 15);
insert into ingredient (amount, name,recipe_id) values ('250ml', 'śmietana 18%', 15);

insert into recipe (category, description, title, user_id,img, rating) values (
'SUPPER', 'Wyrazisty smak, lekka nuta cytryny', 'Zupa pomidorowa', 10,'https://cdn.pixabay.com/photo/2015/02/03/16/31/soup-622737__340.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2l', 'bulion z kury', 15);
insert into ingredient (amount, name,recipe_id) values ('200g', 'koncentrat pomidorowy', 15);
insert into ingredient (amount, name,recipe_id) values ('1 łyżeczka', 'pieprz', 15);
insert into ingredient (amount, name,recipe_id) values ('250ml', 'śmietana 18%', 15);

insert into recipe (category, description, title, user_id,img, rating) values (
'SUPPER', 'Wyrazisty smak, lekka nuta cytryny', 'Zupa pomidorowa', 10,'https://cdn.pixabay.com/photo/2015/02/03/16/31/soup-622737__340.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2l', 'bulion z kury', 15);
insert into ingredient (amount, name,recipe_id) values ('200g', 'koncentrat pomidorowy', 15);
insert into ingredient (amount, name,recipe_id) values ('1 łyżeczka', 'pieprz', 15);
insert into ingredient (amount, name,recipe_id) values ('250ml', 'śmietana 18%', 15);

insert into recipe (category, description, title, user_id,img, rating) values (
'SUPPER', 'Wyrazisty smak, lekka nuta cytryny', 'Zupa pomidorowa', 10,'https://cdn.pixabay.com/photo/2015/02/03/16/31/soup-622737__340.jpg',1);
insert into ingredient (amount, name,recipe_id) values ('2l', 'bulion z kury', 15);
insert into ingredient (amount, name,recipe_id) values ('200g', 'koncentrat pomidorowy', 15);
insert into ingredient (amount, name,recipe_id) values ('1 łyżeczka', 'pieprz', 15);
insert into ingredient (amount, name,recipe_id) values ('250ml', 'śmietana 18%', 15);

-- desser

