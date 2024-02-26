package seminar3n4;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super("Не удалось преобразовать элемент, находящийся на позиции (" + i + ", " + j + ")");
    }

    public MyArrayDataException() {
        super("Не удалось преобразовать элемент");
    }
}