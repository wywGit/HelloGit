package com.company.socket;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerReadThread extends Thread{
	
	private DataInputStream is;
	
	public ServerReadThread(DataInputStream is) {
		this.is = is;
	}
	
	@Override
	public void run() {
		String msg;
		while(true){
			try {
				msg = is.readUTF();
				System.out.println("客户端："+msg);
				if(msg.equalsIgnoreCase("q")){
					System.out.println("客户端退出程序");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
