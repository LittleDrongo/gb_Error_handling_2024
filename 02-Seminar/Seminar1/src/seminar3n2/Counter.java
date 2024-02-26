package seminar3n2;

import java.io.IOException;

/*
    Создайте класс Счетчик, у которого есть метод add(), увеличивающий
    значение внутренней int переменной на 1.Сделайте так, чтобы с объектом
    такого типа можно было работать в блоке try-with-resources. Нужно бросить
    исключение, если работа с объектом типа счетчик была не в ресурсном try
    и/или ресурс остался открыт. Подумайте какой тип исключения подойдет
    лучше всего.
*/
public class Counter {
    private Integer count;

    public Counter(){
        this.count = 0;
    }

    public static void main(String[] args) throws IOException {

        Counter cnt = new Counter();
        cnt.add();
        cnt.add();
        cnt.add();
        cnt.add();
        System.out.println(cnt.getCount());
        cnt.close();
        cnt.add();
    }

    public void add() throws IOException {
        this.check();
        this.count++;
    }

    public void check() throws IOException {
        if (this.count == null){
            throw new IOException("The count <null>");
        }
    }
    public Integer getCount() throws IOException{
        check();
        return count;
    }

    public void close(){
        this.count = null;
    }
}
