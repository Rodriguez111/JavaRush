package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
          sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
          super.clientMainLoop();

        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(message.contains(":")) {

                String[] messageSplit = message.split(":");
                Calendar calendar = Calendar.getInstance();
                if (messageSplit[1].trim().equals("дата")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                } else if (messageSplit[1].trim().equals("день")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("d");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                } else if (messageSplit[1].trim().equals("месяц")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("MMMM");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                } else if (messageSplit[1].trim().equals("год")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("YYYY");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                } else if (messageSplit[1].trim().equals("время")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("H:mm:ss");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                } else if (messageSplit[1].trim().equals("час")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("H");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                } else if (messageSplit[1].trim().equals("минуты")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("m");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                } else if (messageSplit[1].trim().equals("секунды")) {
                    SimpleDateFormat sfd = new SimpleDateFormat("s");
                    sendTextMessage("Информация для " + messageSplit[0].trim() + ": " + sfd.format(calendar.getTime()));
                }
            }

        }
    }


    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {

        return "date_bot_"+(int)(Math.random()*100);
    }


    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

}
