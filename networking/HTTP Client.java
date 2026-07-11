import java.io.*;
import java.net.*;
public class HttpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // Send HTTP Request
        out.println("GET / HTTP/1.1");
        out.println("Host: localhost");
        out.println();
        out.flush();
        // Read HTTP Response
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        socket.close();
    }
}
