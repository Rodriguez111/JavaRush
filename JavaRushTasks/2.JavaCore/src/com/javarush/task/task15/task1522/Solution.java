package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution  {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {

        try {
            readKeyFromConsoleAndInitPlanet();
            //System.out.println(thePlanet.toString());
        }
        catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planet = reader.readLine();
        if(planet.equals(Planet.SUN)){thePlanet=Sun.getInstance(); }
        else if(planet.equals(Planet.MOON)){thePlanet=Moon.getInstance(); }
        else if(planet.equals(Planet.EARTH)){thePlanet=Earth.getInstance(); }
        else thePlanet=null;

    }
}
