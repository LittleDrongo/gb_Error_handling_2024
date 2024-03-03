package seminar3n4;

/*Задание №4
    1. Напишите метод, на вход которого подаётся двумерный строковый массив
    размером 4х4. При подаче массива другого размера необходимо бросить
    исключение MyArraySizeException.

    2. Далее метод должен пройтись по всем элементам массива, преобразовать в
    int и просуммировать. Если в каком-то элементе массива преобразование
    не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException с детализацией, в
    какой именно ячейке лежат неверные данные.

    3. В методе main() вызвать полученный метод, обработать возможные
    исключения MyArraySizeException и MyArrayDataException и вывести
    результат расчета (сумму элементов, при условии, что подали на вход
    корректный массив).
*/
public class Main {
    public static void main(String[] args) {

    }

    public static int sumElementsArray(String[][] array) {{
        if (array.length != 4 && array[0].length != 4){
            throw new MyArraySizeException(array.length, array[0].length);
        }

        int resultSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try{
                    resultSum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return resultSum;
    }

    }
}
