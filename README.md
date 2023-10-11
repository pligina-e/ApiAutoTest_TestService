[![.github/workflows/maven.yml](https://github.com/pligina-e/ApiAutoTest_TestService/actions/workflows/maven.yml/badge.svg)](https://github.com/pligina-e/ApiAutoTest_TestService/actions/workflows/maven.yml)
# ApiAutoTest_TestService
Автоматизированное тестирование сервиса, который предоставляет точки доступа для управления сущностями в базе данных PostgreSQL, подробнее: [test-service](https://github.com/sun6r0/test-service)
## Используемые инструменты:
1. Язык программирования *Java 17*
2. IntelliJ IDEA Community Edition 2022.3
3. Тестовый фреймворк *TestNG*
4. Библиотека *Rest Assured*
5. Сборщик *Maven*
6. Библиотека *Jackson*
7. Библиотека *Lombok*
8. Фреймворк *Allure*
## Точки доступа API:
1. Создание сущности: POST **/api/create**
2. Удаление сущности: DELETE **/api/delete/{id}**
3. Получение сущности: GET **/api/get/{id}**
4. Получение всех сущностей: **GET /api/getAll**
5. Обновление сущности: PATCH **/api/patch/{id}**
## Как начать:
1. Склонировать репозиторий: [test-service](https://github.com/sun6r0/test-service)
2. Установить *Docker Desktop* (минимум версия 4.4.4) и *Docker Compose* (может потребоваться установка/обновление WSL 2)
3. Для запуска сервиса, базы данных и миграций, перейдите в каталог проекта и выполните: `docker-compose up --build -d`
4. Откройте проект [ApiAutoTest_TestService](https://github.com/pligina-e/ApiAutoTest_TestService) и запустите, например, файл *testng.xml* для параллельного запуска четырех тестов
## Дополнительное задание №1. Реализация формирования отчетов Allure
Было реализовано формирование отчетов Allure. В файле *pom.xml* прописаны специальные разделы сборки.
#### Необходимые команды для генерации отчетов:
1. `mvn clean test` - проведите тесты
2. `mvn allure:serve` - создать отчет

Таким образом откроется окно в браузере с информацией по отчету Allure.
## Дополнительное задание №2. Реализация параллельного запуска тестов
Для параллельного выполнения тестов в *TestNG* мы можем использовать атрибут **parallel** в *testng.xml*.

Укажем в качестве атрибута **parallel** тега suite значение **classes**, благодаря которому все тесты, находящиеся в теге *\<test>* файла *testng.xml*, будут выполняться параллельно. Значение количества потоков **thread-count** играет важную роль, поскольку, если количество потоков меньше числа тестов, тестам придется ждать выполнения других тестов. 

Напишем пять тегов *\<test>*, в которых укажем тестовые классы: **GetEntityTest**, **CreateEntityTest**, **DeleteEntityTest**, **GetAllEntitiesTest**, **UpdateEntityTest**.
Таким образом, параллельно запускаются пять тестовых классов.
## Дополнительное задание №3. Реализация запуска в системе CI/CD
Можно реализовать запуск в системе CI/CD в *Github* на вкладке *Actions*, подробнее: [github-actions](https://docs.github.com/ru/actions/learn-github-actions/understanding-github-actions). Про запуск docker-compose: [compose-action](https://github.com/isbang/compose-action?ysclid=lnlq267fwy191556728).
## Автор
Работу выполнила *Плигина Эвелина*.
