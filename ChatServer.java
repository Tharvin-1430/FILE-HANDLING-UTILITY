import java.io.*;  
import java.net.*;  

public class ChatServer {  
    public static void main(String[] args) throws Exception {  
        ServerSocket server = new ServerSocket(1234);  
        while (true) new ClientHandler(server.accept()).start();  
    }  
}  

class ClientHandler extends Thread {  
    Socket socket;  
    ClientHandler(Socket s) { socket = s; }  
    public void run() {  
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {  
            out.println("Welcome! Type to chat.");
            String message;
            while ((message = in.readLine()) != null) System.out.println("Client: " + message);  
        } catch (Exception e) { e.printStackTrace(); }  
    }  
}