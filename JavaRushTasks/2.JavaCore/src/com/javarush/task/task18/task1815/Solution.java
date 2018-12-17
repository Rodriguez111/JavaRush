package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
       private ATableInterface aTbleInterface;

        public TableInterfaceWrapper(ATableInterface aTbleInterface){
            this.aTbleInterface=aTbleInterface;
        }



        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            aTbleInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return aTbleInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            aTbleInterface.setHeaderText(newHeaderText);

        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}