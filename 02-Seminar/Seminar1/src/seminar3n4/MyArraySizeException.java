package seminar3n4;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int row, int columns){
        super("Массив, должен иметь размеры 4х4, у вас: (" + row + "," + columns + ")");
    }

    public MyArraySizeException() {
        super("Массив, должен иметь размеры 4х4");
    }
}
