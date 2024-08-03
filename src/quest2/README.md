# Saddle Point Finder

## Описание
Программа находит седловую точку в матрице. Седловая точка — это элемент матрицы, который является минимальным в своей строке и максимальным в своем столбце.

## Как работает
1. Программа считывает матрицы, закодированные в программе.
2. Для каждой строки матрицы находит минимальный элемент.
3. Проверяет, является ли этот элемент максимальным в своем столбце.
4. Если найден такой элемент, он считается седловой точкой.

## Пример матрицы
В программе используется следующая матрица:
```
{
{1, 2, 3},
{4, 5, 6},
{7, 8, 9}
}
```