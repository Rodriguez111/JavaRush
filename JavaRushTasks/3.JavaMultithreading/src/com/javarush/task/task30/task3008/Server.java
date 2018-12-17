package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();



    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

       private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

        while (true){
           connection.send(new Message(MessageType.NAME_REQUEST));
           Message recievedMessage = connection.receive();
           if (recievedMessage.getType() == MessageType.USER_NAME) {

               if (!recievedMessage.getData().isEmpty() && !connectionMap.containsKey(recievedMessage.getData())) {
                   connectionMap.put(recievedMessage.getData(), connection);
                   connection.send(new Message(MessageType.NAME_ACCEPTED));
                   return recievedMessage.getData();
               }
           }
       }
       }

       private void sendListOfUsers(Connection connection, String userName) throws IOException{
           for(Map.Entry<String, Connection> map: connectionMap.entrySet()){

               if(!map.getKey().equals(userName)) {
                   connection.send(new Message(MessageType.USER_ADDED, map.getKey()));
               }
           }
       }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
           while (true) {
               Message message = connection.receive();
               if (message.getType() == MessageType.TEXT) {
                   Message newMessage = new Message(MessageType.TEXT, userName + ": " + message.getData());
                   sendBroadcastMessage(newMessage);
               }
               else{ConsoleHelper.writeMessage("Принятое сообщение не является текстовым");}
           }
        }


       public void run(){
           String clientName = null;

            ConsoleHelper.writeMessage("Установлено соединение с адресом "+socket.getRemoteSocketAddress());

           try(Connection connection = new Connection(socket)) {

               clientName = serverHandshake(connection);

               //рассылаем всем участникам сообщение о добавлении нового пользователя:
               sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName ));

               //сообщаем новому участнику о существующих участниках:
               sendListOfUsers(connection, clientName);

               serverMainLoop(connection, clientName);

               connectionMap.remove(clientName);
               sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
               ConsoleHelper.writeMessage("Соединение с удаленным сервером закрыто");



           } catch (ClassNotFoundException e) {
              ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
           } catch (IOException e) {
               ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
           }




       }




    }


    public static void main(String[] args) {

        ConsoleHelper.writeMessage("Введите номер порта для сервера:");
        int port =   ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port);) {

            ConsoleHelper.writeMessage("Сервер запущен");

            while (true){

              Socket newSocketConnection =   serverSocket.accept();
                new Handler(newSocketConnection).start();
            }

        } catch (IOException e) {
            ConsoleHelper.writeMessage("Возникла ошибка при запуске сервера");
        }


    }

  public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> map: connectionMap.entrySet()){

            try {
                map.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение пользователю "+map.getKey());
            }

        }
  }

}
