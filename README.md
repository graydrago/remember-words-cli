# Remember Words

Добро пожаловать!

## Введение

Прототип программы для запоминания английских слов и выражений.

Выложенный здесь код является демонстрационным, поэтому тут столько же строк,
сколько и инфраструктуры ( Maven, JUnit ).

Само собой в этом проекте показаны далеко не все мои знания, сейчас его задача
только показать пример моего кода.

В перспективе, а так же наличии свободного времени, переписать это на JavaFX
или поднять Web-сервис.

## Компиляция и запуск

В качестве сборщика используется Apache Maven, поэтому, после того как
клонируете себе исходные коды, достаточно вызвать в терминале:

```
$ mvn package
```

К проекту прилагаю файл со словами `demo.txt`. Для запуска наберите:

```
$ ./run.sh demo.txt
```

И второй файл, только с одним словом:

```
$ ./run.sh demo2.txt
```

## Как это работает?

Тестировал под Ubuntu, Java 7/8, терминале с поддержкой utf-8 и 256 цветов.

Для вывода справки нужно набрать `\h`, для выхода - `\e`:

```
$ ./run.sh demo.txt 
Количество слов: 19
Быть
\h
Короткая справка по командам
? - показать подсказку
\e - выход
\h - показать эту справку
```

Для вывода подсказки - `?`, без лидирующего слеша и кавычек:

```
Количество слов: 0
вести переговоры
?
Подсказка: negotiate
вести переговоры
```

`Количество слов: 19` - Показывает сколько слов еще в очереди. 0 означает что
очередь пуста, а на экране осталось последнее слово.

Если вы запросили подсказку или набрали слово неправильно, то оно снова уходит
в очередь и Вам будет предложено его ввести заново. Неправильный ввод будет
подсвечен красным и звездочками ( на месте пробелов или лишних слов ).

## Дальнейшие планы

По мере нахождения свободного времени буду улучшать код:

* Добавить больше Unit тестов.
* Организовать функциональное тестирование.
* Подробнее оформить JavaDoc.
* Добавить учет статистики.
* Вывод ранее изученных слов, в первую очередь с самой плохой статистикой.

