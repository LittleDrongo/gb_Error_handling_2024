package seminar3n3;

public class DivByZero extends ArithmeticException {
    public DivByZero(){
        super("Нельзя делить на ноль");
    }
}
