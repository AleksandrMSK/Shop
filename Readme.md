                       **Добро пожаловать в Readme** 

**Название проекто `Магазин бытовой техники `, базирующийся в Телемитряндии.**

Основными сущностями проекта являются _Администратор ,Клиент ,Сотрудник_<br>

_`КРАТКОЕ ОПИСАНИЕ ФУНКЦИОНАЛА АДМИНИСТАТОРА`_
- Авторизация админа <br>
  1.Логин: **admin**<br>
  2.Пароль: **admin1234**<br>
- Выводит остатки товара из базы данных товара (здесь же можно и отсортировать товар)<br>
- Добаляет товар (создаёт новый экземпляр класса Product)<br>
- Удаляет товар из Базы данных товара (удаляет экземпляр класса Product по index)<br>
- Нанять сотрудника (создаёт экземпляр класса ShopEmployee)<br>
- Уволить сотрудника (удаляет экземпляр класса ShopEmployee)<br>
- Вывести базу данных сотрудников и отсортировать их по имени<br>
- Вывести базу данных клиентов и отсортировать их по имени<br>
- Удалить клиента из регистра (удаляет экземпляр класса Costumer из базы данных RegistrationDatabase )

_`КРАТКОЕ ОПИСАНИЕ ФУНКЦИОНАЛА КЛИЕНТА`_<br>
- Тестовый доступ клиента:<br>
  1.Логин: **Test** (можно не соблюдать регистр)  
  2.Пароль: **12345678**<br>
- Выводит остаток товара в магазине на экран.
- Доступна сортировка по цене
- Клиент может добавить товар в корзину и очистить товар из корзины(это не оплата)
- Реализована система оплаты товара в которой учитывается сложная формуа по расчёту стоимости<br>
 _после нажатия кнопки ОПЛАТИТЬ программа идёт в метод calculatesFinalPriseProduct и оасчитывает итоговую стоимость<br>
 для клиента, программа смотрит сколько бонусов у клиента, отнимает от стоимости товара колличество бонусов<br>
  у клиента, затем проверяет хватает ли денег у клиента, если все проверки прошли успешно, проходит оплата_
- Клиент может отфильтровать товар по стоимости от и до.
- При желании клиент может пополнить свой баланс белками(деньга в нашем магазине)
- У клиента есть профиль ,в котором можно посмотреть всю информацию только о себе (программа знает кто сейчас в сеансе)

_`КРАТКОЕ ОПИСАНИЕ ФУНКЦИОНАЛА СОТРУДНИКА`_<br>
- Тестовый доступ сотрудника:<br>
  1.ID: **12**  
  2.Пароль: **!@#$%^&***<br>
- Сотрудник может просмотреть доступный товар
- Выставить товар по цене( сортировка по цене)
- Удаление товара с витрины (удаление Product из базы данных)
- Вывести данные о клиенте (поиск по логину)
- Сотрудник может начислять клиенту бонусы на бонусную карту<br>(для начисления нужно указать номер бонусной карты и колличество бонусов)

Функционал магазина от старта и до завершения построен на ваимодействии 3-х основных компонентов<br>
В Readme я не стал добавлять описание  классов ,так как оно присутствует в анатоции каждого класса.

Проект был написан ~~легко и быстро~~ через боль, и кучу потраченных нервных клеток на отлов багов <br>
Прошу особо не обращать внимания на орфографические ошибки, которые могут встречаться во всём проекте,<br>
так как автор прогуливал русский язык.

**_Автор проекта Aleksandr Moskalchuk_**