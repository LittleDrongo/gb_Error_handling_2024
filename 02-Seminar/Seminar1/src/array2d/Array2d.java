package array2d;

/*
    Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
    Необходимо посчитать и вернуть сумму элементов этого массива.
    При этом накладываем на метод 2 ограничения: метод может работать только с
    квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
    только значение 0 или 1.
    Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
    ошибке.
*/

public class Array2d {
    public static void main(String[] args) {

        int[][] array = {{1, 0, 0}, {1, 0, 1}};

        checkMatrix(array);
        checkMatrix2(array);


    }


    public static void checkMatrix(int[][] array2D) {

        if (array2D == null) throw new RuntimeException("Массив пустой");
        else if (array2D.length == array2D[0].length) throw new RuntimeException("Размер массива не совпадают");

        int sum = 0;
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D.length; j++) {

                if (array2D[i][j] != 0 && array2D[i][j] != 1) throw new RuntimeException("Число в массиве не 1 и 0");
                sum += array2D[i][j];

            }
        }

        System.out.println(sum);

    }

    public static void checkMatrix2(int[][] array){
        int sum = 0;
        if(array ==null)throw new RuntimeException("Массив пустой");
        if (array.length != array[0].length) throw new RuntimeException("Размеры массива не совпадают");
        for (int i = 0;i<array.length;i++){
            for (int j = 0; j< array[i].length;j++){
                if (array[i][j]!=0 && array[i][j]!=1) throw new RuntimeException("Число в массиве не 1 или 0");
                sum+= array[i][j];
            }
        }
        System.out.println(sum);
    }

}
