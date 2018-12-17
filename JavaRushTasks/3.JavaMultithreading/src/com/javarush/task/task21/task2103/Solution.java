package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!Хмм.. Карта Карно, круги Эйлера. Я просто посмотрел на выражение и понял, что всё зависет от "c".
Если c false , то и всё выражение false. Исходя из этого я вынес "c" за скобку и помотрел на на это же выражение без "c" . Оказалось что это выражение всегда true! А это значит, что всё зависет от "c", а остальное выражение бесполезно. Вот так вот.
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) {

    }
}
