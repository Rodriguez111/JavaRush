package com.javarush.task.task35.task3513;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Model {

    private static final int FIELD_WIDTH = 4;
    protected int score = 0;
    protected int maxTile = 0;
    private Tile [][] gameTiles;
    private Stack<Tile[][]> previousStates = new Stack();
    private Stack<Integer> previousScores = new Stack();
    private boolean isSaveNeeded = true;


    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public int getScore() {
        return score;
    }

    public Model() {
        resetGameTiles();

    }

    protected void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH]; //устанавливаем размер игрового поля (4*4)

        for(int i = 0; i< gameTiles.length; i++){ //заполняем игровое пустыми плитками
            for(int j = 0; j< gameTiles[0].length; j++){
                gameTiles[i][j] = new Tile();
            }
        }

        addTile(); //добавляем новую случайную плитку со значением
        addTile(); //добавляем новую случайную плитку со значением

    }


    private List<Tile> getEmptyTiles(){

        List<Tile> listOfEmptyTiles = new ArrayList<>();
        for(int i = 0; i< gameTiles.length; i++){
            for(int j = 0; j< gameTiles[0].length; j++){
                if(gameTiles[i][j].isEmpty()){
                    listOfEmptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return listOfEmptyTiles;

    }

    private void addTile(){

        List<Tile> listOfEmptyTiles = getEmptyTiles(); //получаем список пустых плиток
        if(!listOfEmptyTiles.isEmpty()) { //если есть хотя бы одна пустая плитка
            int randomIndexOfEmptyTile = (int) (listOfEmptyTiles.size() * Math.random()); //выбираем случайную плитку
            int randomValue = Math.random() < 0.9 ? 2 : 4; //если случайное число менье 0,9, тогда присваиваем 2, иначе присваиваем 4
            listOfEmptyTiles.get(randomIndexOfEmptyTile).setValue(randomValue); //присваиваем случайной плитке значение
        }
    }

    private boolean compressTiles(Tile[] tiles){
        boolean wasChanged = false;
        for(int i = 0; i< 3; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j < tiles.length - 1 && tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = new Tile();
                    wasChanged = true;
                }
            }
        }
            return wasChanged;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean wasChanged = false;
        for (int j = 0; j < tiles.length; j++) {
            if (j < tiles.length - 1 && tiles[j].getValue()>0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() + tiles[j + 1].getValue());
                tiles[j + 1] = new Tile();
                compressTiles(tiles);
                if(tiles[j].getValue()>maxTile){maxTile = tiles[j].getValue();} //если новое значение больше максимального - меняем поле максимального значения
                score = score+tiles[j].getValue(); //увеличиваем текущий счет
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    public void left(){

        if (isSaveNeeded){
            saveState(gameTiles); //сохраняем текущее состояние игры
        }

        boolean wasChanged = false;

        for(int i = 0; i<gameTiles.length; i++){

            if(compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])){wasChanged = true;}

        }
        if(wasChanged) {
            addTile();
            isSaveNeeded = true;
        }

    }



    public void down(){
        saveState(gameTiles); //сохраняем текущее состояние игры
        rotate90(); //поворачиваем по часовой на 90 градусов
        left(); //сдвигаем влево, то есть вниз
        rotate90();
        rotate90();
        rotate90();

    }

    public void right(){
        saveState(gameTiles); //сохраняем текущее состояние игры
        rotate90();  //поворачиваем по часовой на 180 градусов
        rotate90();
        left(); //сдвигаем влево, то есть вправо
        rotate90();
        rotate90();
    }

    public void up(){
        saveState(gameTiles); //сохраняем текущее состояние игры
        rotate90(); //поворачиваем по часовой на 270 градусов
        rotate90();
        rotate90();
        left(); //сдвигаем влево, то есть вверх
        rotate90();
    }



    private Tile[][] copyToNewArray(Tile[][] tiles){
        Tile[][] newTiles = new Tile[gameTiles.length][gameTiles[0].length]; //объявляем новый массив

        for (int i = 0; i < newTiles.length; i++) { //копируем объекты в новый массив
            for (int j = 0; j< newTiles.length; j++){
                newTiles[i][j] = new Tile(tiles[i][j].value); //создаем НОВЫЙ  объект с нужным значением
            }
        }
            return newTiles;

    }




    public void rotate90(){

         Tile[][] newTiles = copyToNewArray(gameTiles);


        int lineNumber = 0; //счетчик строк нового массива

        for (int i = 0; i < newTiles[0].length; i++) {
            int columnNumber = 0; //счетчик столбцов нового массива
            for (int j = newTiles.length-1; j >=0 ; j--){

                gameTiles[lineNumber][columnNumber] = newTiles[j][i]; //транспонируем значение из старой в новую
                columnNumber++;
            }
            lineNumber++;
        }

    }

    public boolean  canMove(){
        boolean canMove = false;
        for (int i = 0; i < gameTiles.length; i++) { //копируем объекты в новый массив
            for (int j = 0; j< gameTiles.length; j++){
        try {
            if(gameTiles[i][j].isEmpty()){canMove = true; break;}
            if(gameTiles[i][j].getValue()==gameTiles[i+1][j].getValue()){canMove = true; break;}
            if(gameTiles[i][j].getValue()==gameTiles[i][j+1].getValue()){canMove = true; break;}

        }catch (ArrayIndexOutOfBoundsException e){
            /*NOP*/
        }


            }
        }

        return canMove;
    }

            private void saveState(Tile[][] tiles){

        Tile[][] newTiles = copyToNewArray(tiles);

                    previousStates.push(newTiles);
                    previousScores.push(score);
                     isSaveNeeded = false;
            }

            public void rollback(){

                if(!previousStates.empty() && !previousScores.empty()){
                    gameTiles = previousStates.pop();
                    score = previousScores.pop();
                }
            }

    public void randomMove (){
        int  n = ((int) (Math.random() *4 )); //случайное число от 0 до 3
        List<Method> listOfMethods = new ArrayList<>();
        Class clz = Model.class;
        try {
            Method method0 = clz.getMethod("up");
            Method method1 = clz.getMethod("down");
            Method method2 = clz.getMethod("left");
            Method method3 = clz.getMethod("right");
            listOfMethods.add(method0);
            listOfMethods.add(method1);
            listOfMethods.add(method2);
            listOfMethods.add(method3);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            listOfMethods.get(n).invoke(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public boolean hasBoardChanged(){
        int currentWeight = 0; //суммарный вес всех плиток текущего состояния игрового поля
        int stackWeight = 0; //суммарный вес всех плиток последнего сохраненного состояния игрового поля

        for (int i = 0; i < gameTiles.length; i++) { //суммируем вес всех плиток текущего состояния
            for (int j = 0; j< gameTiles.length; j++){
                currentWeight = currentWeight + gameTiles[i][j].getValue();
            }
        }

        Tile[][] lastSavedTile = previousStates.peek();

        for (int i = 0; i < lastSavedTile.length; i++) { //суммируем вес всех плиток текущего состояния
            for (int j = 0; j< lastSavedTile.length; j++){
                stackWeight = stackWeight + lastSavedTile[i][j].getValue();
            }
        }
                if(currentWeight != stackWeight) return true;
          return false;
    }

public MoveEfficiency getMoveEfficiency(Move move){
    move.move();
    int numberOfEmptyTiles = 0;

    for (int i = 0; i < gameTiles.length; i++) { //суммируем вес всех плиток текущего состояния
        for (int j = 0; j< gameTiles.length; j++){
            if(gameTiles[i][j].isEmpty()){numberOfEmptyTiles++;};
        }
    }

    if(!hasBoardChanged()){numberOfEmptyTiles = -1; score = 0;}

    MoveEfficiency moveEfficiency = new MoveEfficiency(numberOfEmptyTiles, score, move);
    rollback();

    return moveEfficiency;

}

public void autoMove(){
    PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder() );

    priorityQueue.offer( getMoveEfficiency(new Move() {
        @Override
        public void move() {
            left();
        }
    }));

    priorityQueue.offer( getMoveEfficiency(new Move() {
        @Override
        public void move() {
            right();
        }
    }));

    priorityQueue.offer( getMoveEfficiency(new Move() {
        @Override
        public void move() {
            up();
        }
    }));
    priorityQueue.offer( getMoveEfficiency(new Move() {
        @Override
        public void move() {
            down();
        }
    }));

    priorityQueue.peek().getMove().move();


}


}
