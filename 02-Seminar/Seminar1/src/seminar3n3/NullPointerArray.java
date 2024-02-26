package seminar3n3;

public class NullPointerArray extends NullPointerException {
    public NullPointerArray() {
        super("Элемент не найден");
    }

    public NullPointerArray(int count) {
        super("Элемент на индексе " + count + " пустой");
    }
}
