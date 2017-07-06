package com.company.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class ClientWriteThread extends Thread{

	private DataOutputStream os;
	
	public ClientWriteThread(DataOutputStream os) {
		this.os = os;
	}
	
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		String msg ;
		
		try {
			while(true){
				msg = scan.nextLine();
				os.writeUTF(msg);
				if(msg.equalsIgnoreCase("q")){
					System.out.println("客户端退出程序");
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
