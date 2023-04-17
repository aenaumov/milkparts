INSERT INTO CATEGORIES (CAT_ID, CAT_RU, CAT_DESCRIPTION, CAT_KEYWORDS)
VALUES ('drain_valves', 'Дренажные клапана AuK Muller',
        'В данном разделе представлены дренажные сливные клапаны AuK Muller. Клапана применяются на оборудовании в различных сферах: сельское хозяйство, медицина, кондиционирование и др. В частности устанавливаются на танки для охлаждения молока производства DeLaval, Fabdec, Serap, GEA, Mueller, Frigomilk, Japy, Roka, Packo, Wedholm, Etscheid, Dari-Kool, Гомельагрокомплект',
        'дренажный сливной клапан вентиль AuK Muller АК Мюллер'),
       ('test', 'Дренажные клапана AuK Muller',
        'В данном разделе представлены дренажные сливные клапаны AuK Muller. Клапана применяются на оборудовании в различных сферах: сельское хозяйство, медицина, кондиционирование и др. В частности устанавливаются на танки для охлаждения молока производства DeLaval, Fabdec, Serap, GEA, Mueller, Frigomilk, Japy, Roka, Packo, Wedholm, Etscheid, Dari-Kool, Гомельагрокомплект',
        'дренажный сливной клапан вентиль AuK Muller АК Мюллер');

INSERT INTO ITEMS (ITEM_ID, ITEM_RU, ITEM_DESCRIPTION, ITEM_KEYWORDS, CAT_CANONICAL, ITEM_FIRST_PAGE)
VALUES ('530200', 'Дренажный клапан AuK Muller DN40, 220V, NC, патрубок / патрубок',
        'Дренажный сливной клапан AuK Muller DN40, 220V, NC, нормально закрытый, патрубок / патрубок<br>тип 4.040.116<br>2/2-ходовой<br>IP65<br>корпус клапана выполнен из пластика PPE<br>штекер<br>артикул AuK Muller 59755<br>артикул DeLaval 9804343435<br>производство Германия<br><span>В разделе <a href=https://www.milkparts.ru/drain_valves>Дренажные сливные клапана AuK Muller</a> Вы можете подобрать клапана с другими техническими характеристиками</span>',
        '59755 530200 4.040.116 4040116 9804343435', 'test', true),
       ('530153', 'Дренажный клапан AuK Muller DN40, 220V, NO, патрубок / патрубок',
        'Дренажный сливной клапан AuK Muller DN40, 220V, NO, нормально открытый, патрубок / патрубок<br>тип 4.040.916<br>2/2-ходовой<br>IP65<br>корпус клапана выполнен из пластика PPE<br>штекер<br>артикул AuK Muller 51756<br>артикул GEA 3300-0222-062<br>производство Германия<span>В разделе <a href=https://www.milkparts.ru/drain_valves>Дренажные сливные клапана AuK Muller</a> Вы можете подобрать клапана с другими техническими характеристиками</span>',
        '51756 530153 4.040.916 4040916 GEA 3300 0222 062 3300-0222-062', 'drain_valves', false);

INSERT INTO CATEGORIES_ITEMS (CATEGORY_CAT_ID, ITEMS_ITEM_ID)
VALUES ('drain_valves', '530200'),
       ('drain_valves', '530153');