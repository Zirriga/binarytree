import org.junit.Test;

import static org.junit.Assert.*;

public class binarTest {

    @Test
    public void Add() {
        binar a = new binar();
        a.Add(1, 1);
        //a.Add(1, 1);
        assertEquals(1, a.Get(1)); //добавление элемента, даже при двух одинаковых не происходит конфликта
    }

    @Test
    public void Get() {
        binar a = new binar();
        a.Add(1, 1);
        assertEquals(1, a.Get(1)); //когда значение существует
        assertEquals(null, a.Get(2)); //когда значение не существует
    }

    //в тестах remove проверена работа ContainsKey

    @Test
    public void RemoveLast() { //удаление значения с конца
        binar a = new binar();
        a.Add(1, 1);
        a.Add(2, 2);
        a.Add(3, 3);
        a.Remove(3);
        assertEquals(true, a.ContainsKey(2));
        assertEquals(true, a.ContainsKey(1));
        assertEquals(false, a.ContainsKey(3));
    }

    @Test
    public void RemoveFirst() { //удаление значения из начала => и при значении из середины работать будет
        binar a = new binar();
        a.Add(1, 1);
        a.Add(2, 2);
        a.Add(3, 3);
        a.Remove(1);
        assertEquals(false, a.ContainsKey(1));
        assertEquals(true, a.ContainsKey(2));
        assertEquals(true, a.ContainsKey(3));
    }

    @Test
    public void RemoveOneChild() { //у удаляемого элемента есть только правый наследник
        binar a = new binar();
        a.Add(1, 1);
        a.Add(2, 2);
        a.Remove(1);
        assertEquals(false, a.ContainsKey(1));
        assertEquals(true, a.ContainsKey(2));
    }

    @Test
    public void GetChild() {
        binar a = new binar();
        //a.Add(1,1);
        a.Add(2, 2);
        //a.Add(3, 3);
        a.Add(4, 4);
        a.Add(1, 1);
        assertEquals(4, a.GetRightChild(2)); // когда правый ребенок существует
        assertEquals(1, a.GetLeftChild(2)); // когда левый ребенок существует
        assertEquals(null, a.GetRightChild(7)); // когда правый ребенок не существует (и не существует зачение)
        assertEquals(null, a.GetLeftChild(7)); // когда левый ребенок не существует (и не существует значение)
        assertEquals(null, a.GetRightChild(4)); // когда правый ребенок не существует
        assertEquals(null, a.GetLeftChild(4)); // когда левый ребенок не существует
    }

    @Test
    public void GetParent() {
        binar a = new binar();
        a.Add(2, 2);
        a.Add(1, 1);
        a.Add(3, 3);
        assertEquals(null, a.GetParent(2)); // когда родителя нет
        assertEquals(2, a.GetParent(1)); //когда родитель есть
        assertEquals(null, a.GetParent(4)); //когда значения нет в дереве
    }

}