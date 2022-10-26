import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
 
public class TestHttpServer {
 
   public static void main(String[] args) throws Exception {
      HttpServer server = HttpServer.create(new InetSocketAddress(8090), 0);
      server.createContext("/hello", new MyHandler());
      server.setExecutor(null);
      server.start();
      System.out.println("Server is listening on port 8080" );
   }
 
   static class MyHandler implements HttpHandler {
      public void handle(HttpExchange t) throws IOException {
         String response = System.getenv("MESSAGE");
         t.sendResponseHeaders(200, response.length());
         OutputStream os = t.getResponseBody();
         os.write(response.getBytes());
         os.close();
      }
   }
}