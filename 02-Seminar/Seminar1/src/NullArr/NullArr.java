package NullArr;

public class NullArr {
    public static void main(String[] args) {
        Integer[] arr = {34, 56, null, null};
        checkArray(arr);
        checkArray(null);
        Integer[] arr1 = {0, 1, null};
        checkArray(arr1);
    }

    public static void checkArray(Integer[] arr) {
        if (arr == null)
            System.out.println("Массив пустой!");
        else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    System.out.println("Найдено значение null на индексе " + i);
                }
            }
        }
    }



}
