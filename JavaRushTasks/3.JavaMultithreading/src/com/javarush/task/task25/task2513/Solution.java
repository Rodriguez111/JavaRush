package com.javarush.task.task25.task2513;

import java.util.Random;

/* 
Обеспечение отсутствия прерывания важной операции
*/
public class Solution {
    private static final Integer THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();


    public synchronized void moveMoney(Account from, Account to, int amount) {

        /*
        * Логика очень простая: В задаче два запроса.
        * Первый списание средств с одного счета, второй — зачисление этих средств на другой счет.
         *Пошел запрос на списание (Необходимо изменить баланс) и если на том конце произойдет разрыв
         * соединения или другими словами время соединения (RANDOM) будет больше порогового
         * значения (THRESHOLD_VALUE), то операцию продолжать нельзя и нужно ее отъелдить
         * (передать другому потоку, который проверит соединение и т.д. и т.п.).
        * */


           from.setBalance(from.getBalance() - amount);
        if(RANDOM.nextInt(5000)>THRESHOLD_VALUE){Thread.yield();}//решение
           to.setBalance(to.getBalance() + amount);


    }

    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.Account account1 = solution.new Account();
        Solution.Account account2 = solution.new Account();


        account1.setBalance(200);
        account2.setBalance(300);

        System.out.println("Баланс аккаунта 1: "+account1.getBalance()+", Баланс аккаунта 2: "+account2.getBalance());



        solution.moveMoney(account1, account2, 50);
        System.out.println("Баланс аккаунта 1: "+account1.getBalance()+", Баланс аккаунта 2: "+account2.getBalance());





    }
}
