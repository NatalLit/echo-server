package echo.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket socket = serverSocket.accept();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {

                String message = bufferedReader.readLine();

                bufferedWriter.write("echo " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
