package com.company.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(10101);
			System.out.println("服务已开启。。。。");
			Socket server = s.accept();
			DataInputStream is = new DataInputStream(server.getInputStream());
			DataOutputStream os = new DataOutputStream(server.getOutputStream());
			
			Thread s1 = new ServerReadThread(is);
			Thread s2 = new ServerWriteThread(os);
			
			s1.start();
			s2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
