# Box Assembly Checker

## Описание
Программа проверяет возможность сборки коробки из фанерных листов, размеры которых указаны в файле `sheets.txt`.
## Как работает
1. Программа считывает размеры листов из файлов тестов (sheets1.txt, sheets2.txt, sheets3.txt, sheets4.txt, sheets5.txt).
2. Проверяет, что каждая пара размеров встречается ровно дважды.
3. Если каждая пара размеров встречается ровно дважды, можно собрать коробку.

## Входной файл
Создайте файл `sheets.txt` в той же директории, что и программа. Пример содержимого файла:
```
2 3
3 2
2 4
4 2
3 4
4 3
```