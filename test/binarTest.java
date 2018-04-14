import org.junit.Test;

import static org.junit.Assert.*;

public class binarTest {

    @Test
    public void add() {
        binar a = new binar();
        a.add(1,1);
        //a.add(1, 1);
        assertEquals(1, a.get(1)); //добавление элемента, даже при двух одинаковых не происходит конфликта
    }

    @Test
    public void get() {
        binar a = new binar();
        a.add(1,1);
        assertEquals(1, a.get(1)); //когда значение существует
        assertEquals(null, a.get(2)); //когда значение не существует
    }

    //в тестах remove проверена работа containsKey

    @Test
    public void removeLast() { //удаление значения с конца
        binar a = new binar();
        a.add(1,1);
        a.add(2,2);
        a.add(3, 3);
        a.remove(3);
        assertEquals(true, a.containsKey(2));
        assertEquals(true, a.containsKey(1));
        assertEquals(false, a.containsKey(3));
    }
    @Test
    public void removeFirst() { //удаление значения из начала => и при значении из середины работать будет
        binar a = new binar();
        a.add(1,1);
        a.add(2,2);
        a.add(3, 3);
        a.remove(1);
        assertEquals(false, a.containsKey(1));
        assertEquals(true, a.containsKey(2));
        assertEquals(true, a.containsKey(3));
    }

    @Test
    public void getChild(){
        binar a = new binar();
        //a.add(1,1);
        a.add(2, 2);
        //a.add(3, 3);
        a.add(4, 4);
        a.add(1, 1);
        assertEquals(4, a.getRightChild(2)); // когда правый ребенок существует
        assertEquals(1, a.getLeftChild(2)); // когда левый ребенок существует
        assertEquals(null, a.getRightChild(7)); // когда правый ребенок не существует (и не существует зачение)
        assertEquals(null, a.getLeftChild(7)); // когда левый ребенок не существует (и не существует значение)
        assertEquals(null, a.getRightChild(4)); // когда правый ребенок не существует
        assertEquals(null, a.getLeftChild(4)); // когда левый ребенок не существует
    }

    @Test
    public void getParent(){
        binar a = new binar();
        a.add(2, 2);
        a.add(1, 1);
        a.add(3, 3);
        assertEquals(null, a.getParent(2)); // когда родителя нет
        assertEquals(2, a.getParent(1)); //когда родитель есть
        assertEquals(null, a.getParent(4)); //когда значения нет в дереве
    }

}