package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();

        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());


        game.setLocationRelativeTo(null);
        game.setVisible(true);


//        System.out.println(model.canMove());
//
//
//
//
//
//       int count = 0;
////
//        for(int i = 0; i< model.getGameTiles().length; i++){ //заполняем игровое плитками
//            for(int j = 0; j< model.getGameTiles()[0].length; j++){
//                model.getGameTiles()[i][j] = new Tile(count++);
//            }
//        }
//        model.canMove();

//
//
//        for(int i = 0; i< model.getGameTiles().length; i++){
//            for(int j = 0; j< model.getGameTiles()[0].length; j++){
//                System.out.print(model.getGameTiles()[i][j].getValue()+" ");
//            }
//            System.out.println();
//        }
//
//
//        model.down();
//
//        System.out.println("------------");
//
//
//
//        for(int i = 0; i< model.getGameTiles().length; i++){
//            for(int j = 0; j< model.getGameTiles()[0].length; j++){
//                System.out.print(model.getGameTiles()[i][j].getValue()+" ");
//            }
//            System.out.println();
//        }








    }
}
