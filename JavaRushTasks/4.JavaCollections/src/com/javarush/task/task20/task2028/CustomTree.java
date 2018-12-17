package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    List<Entry> listOfEntries = new ArrayList<>();

    public CustomTree() {
        this.root = new Entry("0");
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {

          return listOfEntries.size();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }


    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        boolean hasLeftChildren;
        boolean hasRightChildren;


        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
        void checkChildren(){
            if(leftChild != null) {availableToAddLeftChildren = false; hasLeftChildren = true;}
            if(rightChild != null) {availableToAddRightChildren = false; hasRightChildren = true;}
        }

        boolean isAvailableToAddChildren(){
            if(availableToAddLeftChildren || availableToAddRightChildren) return true;
            return false;
        }

    }


    @Override
    public boolean add(String s) {

        boolean wasAdded = false;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            Entry entry = queue.poll(); //извлекаем верхний элемент из очереди

            Entry newEntry = new Entry(s);
            newEntry.parent=entry;

            entry.checkChildren(); //проверяем наследников
            if(entry.isAvailableToAddChildren()){  //если нет хотя бы одного элемента

                if(entry.availableToAddLeftChildren && !entry.availableToAddRightChildren) { //если нет левого элемента но есть правый
                    entry.leftChild = newEntry; //вставляем левый элемент
                    listOfEntries.add(newEntry);
                    wasAdded = true;
                    break;

                }
                if(entry.availableToAddRightChildren && !entry.availableToAddLeftChildren) { //если нет правого элемента, но есть левый

                    entry.rightChild = newEntry; //вставляем правый элемент
                    listOfEntries.add(newEntry);
                    wasAdded = true;
                    break;


                }
                if(entry.availableToAddRightChildren && entry.availableToAddLeftChildren){ // если отсутствуют оба элемента
                    entry.leftChild = newEntry; //вставляем левый элемент
                    listOfEntries.add(newEntry);
                    wasAdded = true;
                    break;
                }
            }
            else { //иначе есть оба наследника
                queue.add(entry.leftChild);
                queue.add(entry.rightChild);
            }
        }


        return wasAdded;
    }


    public String getParent(String s){

       for(Entry eachEntry : listOfEntries){
           if(eachEntry.elementName.equals(s)) return eachEntry.parent.elementName;
       }
        return null;
    }

    @Override
    public boolean remove(Object o) {

        boolean wasRemoved = false;
        if(!(o instanceof String)){
           throw new  UnsupportedOperationException();
        }

        String elementName = (String) o;
        Queue<Entry> queue = new LinkedList<>();

        for(Entry eachEntry : listOfEntries){
            if(eachEntry.elementName.equals(elementName)){
                        queue.add(eachEntry); //помещаем найденный элемент в очередь
                        break;
            }
        }


        while (!queue.isEmpty()){
                Entry entry = queue.poll();

        if(entry.parent.hasLeftChildren) {
            if (entry.parent.leftChild.equals(entry)) { //если удаляемый элемент - левый потомок родителя
                entry.parent.leftChild = null; // удаляем на него ссылку у родителя
                entry.parent.hasLeftChildren = false; // имеет левого наследника устанавливаем в false
                entry.parent.availableToAddLeftChildren = true; // можно добавить левого наследника устанавливаем в true
            }
        }
            if(entry.parent.hasRightChildren) {
             if (entry.parent.rightChild.equals(entry)) { //если удаляемый элемент - правый потомок родителя
                entry.parent.rightChild = null; // удаляем на него ссылку у родителя
                entry.parent.hasRightChildren = false; // имеет правого наследника устанавливаем в false
                entry.parent.availableToAddRightChildren = true; // можно добавить правого наследника устанавливаем в true
            }
        }

            listOfEntries.remove(entry); //удаляем элемент из списка
            wasRemoved = true;
            if(entry.hasLeftChildren){ //если у удаляемого элемента есть левый   потомок
                queue.add(entry.leftChild); //помещаем этого потомка в очередь в очередь
            }
            if(entry.hasRightChildren){ //если у удаляемого элемента есть правый   потомок
                queue.add(entry.rightChild); //помещаем этого потомка в очередь в очередь
            }



        }





        return wasRemoved;
    }
}
