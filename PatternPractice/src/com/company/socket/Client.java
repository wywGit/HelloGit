package com.company.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",10101);
			System.out.println("客户端已开启。。。。");
			DataInputStream is = new DataInputStream(s.getInputStream());
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			
			Thread s1 = new ClientReadThread(is);
			Thread s2 = new ClientWriteThread(os);
			
			s1.start();
			s2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
