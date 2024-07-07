# Проект Банкомат (ATM)

## Описание
Этот проект представляет собой симуляцию системы банкоматов, которая позволяет пользователям управлять своими банковскими аккаунтами и выполнять транзакции. Приложение разработано с использованием Java, Spring Boot и Spring Data JPA.

## Возможности
- One-to-One связь между пользователями и аккаунтами.
- Автоматическая генерация ID для пользователей.
- Основные операции: проверка баланса, пополнение счета, снятие средств и перевод средств.

## Технологии
- Java
- Spring Boot
- Spring Data JPA
- MySQL

## Установка и запуск
1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/bolshakovvvv/ATM.git
    ```
2. Перейдите в директорию проекта:
    ```bash
    cd ATM
    ```
3. Создайте базу данных MySQL с именем `atm`.
4. Настройте `application.properties` с вашими учетными данными для базы данных:
    ```properties
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/users
    spring.datasource.username=root
    spring.datasource.password=root
    ```
5. Соберите и запустите проект с помощью Maven:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Использование
Приложение будет доступно по адресу `http://localhost:8080`.

## Структура проекта
### Контроллеры
- **ATMController.java** - Обрабатывает HTTP-запросы для операций банкомата.

### Сущности
- **Users.java** - Класс-сущность для пользователей.
- **Accounts.java** - Класс-сущность для аккаунтов.

### Репозитории
- **UserRepository.java** - Репозиторий для пользователей.
- **AccountRepository.java** - Репозиторий для аккаунтов.

### Сервисы
- **ATMService.java** - Сервис, содержащий логику операций банкомата.

### Запросы
- **AddUserToDB.java** - Запрос на добавление нового пользователя в базу данных.
- **DepositMoneyRequest.java** - Запрос на пополнение счета.
- **SendMoneyRequest.java** - Запрос на перевод средств.
- **WithdrawMoneyRequest.java** - Запрос на снятие средств.
