package lib.clearclass;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) throws IOException {
		String encoding = args.length==1 ? args[0] : "UTF-8";
		try(ServerSocket ss = new ServerSocket(8080)){
			for(int i = 0; ; i++){
				System.out.println("...................:::::::::Ожидание подключения... " + i);
				try(Socket s = ss.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), encoding));
						PrintStream out = new PrintStream(s.getOutputStream(), true, encoding);
						InputStream html = new FileInputStream("index.html")) {
					
					// REQUEST READING ...
					//    request line and headers reading ...
					int n = 0; // number of bytes in message body
					for (String st = in.readLine(); st!=null && !st.equals(""); st=in.readLine()) {
						if(st.startsWith("Content-Length: ")) n = Integer.parseInt(st.substring(16));
						System.out.println(st);
					}
					System.out.println();
					
					// content reading ...
					if(n!=0) {
						char[] ms = new char[n];
						in.read(ms);
						System.out.println(new String(ms));
					}
					
					// RESPONSE SENDING ...
					out.println("HTTP/1.1 200 OK");
					out.println("Content-Length: " + html.available());
					out.println("Content-Type: text/html");
					out.println();
					out.write(html.readAllBytes());
					out.flush();
					
				} // close connection and io streams.
			}
		}
	}
}
