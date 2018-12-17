package com.javarush.task.task22.task2201;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {

            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {

        String exptn=String.format(string,e.getClass().getSimpleName(),e.getCause(),t.getName());

        return exptn;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {


        String exptn=String.format(string,e.getCause(),e.getClass().getSimpleName(),t.getName());



        return exptn;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {


/*
 Форматируем строку:
1 аргумент - заданный формат строки в переменной string = "%s : %s : %s"
2 аргумент - имя потока, в котором перехваченно исключение
3 аргумент - имя исключения, которое выплюнул метод:
  e.getClass() - получаем класс исключения
  e.getClass().getSimpleName() - получаем простое имя класса
4 аргумент - e.getCause() - наше первоначально перехваченное исключение,
  которое теперь является исключением-причиной для выплюнутого методом исключения
  */
        String exptn=String.format(string,t.getName(),e.getClass().getSimpleName(),e.getCause());

        return exptn;
    }
}

