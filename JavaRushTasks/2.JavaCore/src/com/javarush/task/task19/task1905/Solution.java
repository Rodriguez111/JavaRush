package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode="";
            for (Map.Entry<String,String> pair:countries.entrySet()){

                if(pair.getValue().equals(customer.getCountryName())){
                    countryCode=pair.getKey();
                }
            }
            return countryCode;

        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {

            String getName =contact.getName();
            String firstName = getName.substring(getName.indexOf(" ")+1);
            return firstName;
        }

        @Override
        public String getContactLastName() {
            String getName =contact.getName();
            String lastName = getName.substring(0, getName.indexOf(", "));
            return lastName;
        }

        @Override
        public String getDialString() {
            String getPhoneNumber = contact.getPhoneNumber();
            String phoneNumber = "callto://"+getPhoneNumber.replaceAll("[-() ]","");

            return phoneNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}