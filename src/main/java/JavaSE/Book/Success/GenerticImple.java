package JavaSE.Book.Success;

public class GenerticImple<E> implements GenerticInterface<E>{

    public <E>void show(E e) {
        System.out.println(e);
    }

}