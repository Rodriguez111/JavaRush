package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine") ;
        countries.put("RU", "Russia") ;
        countries.put("CA", "Canada") ;

    }


    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {

     private IncomeData data;
     public IncomeDataAdapter(IncomeData data){
         this.data=data;
     }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
           String country="";
            for (Map.Entry<String, String> pair :countries.entrySet()
                 ) {

                if(pair.getKey()==data.getCountryCode()){
                    country=pair.getValue();
                }

            }

         return country;

        }

        @Override
        public String getName() {
          String name=data.getContactLastName()+", "+data.getContactFirstName();
            return name;

        }

        @Override
        public String getPhoneNumber() {
            String code = ""+data.getCountryPhoneCode();
            String number = ""+data.getPhoneNumber();
            while (number.length()<10){number ="0"+number;}//добавляем нули до 10 символов

     String phoneNumber = "+"+code+"("+number.substring(0,3)+")"+number.substring(3,6)+"-"+number.substring(6,8)+"-"+number.substring(8);

return phoneNumber;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}