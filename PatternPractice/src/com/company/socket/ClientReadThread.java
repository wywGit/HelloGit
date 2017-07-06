package com.company.socket;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientReadThread extends Thread{
	
	private DataInputStream is;
	
	public ClientReadThread(DataInputStream is) {
		this.is = is;
	}
	
	@Override
	public void run() {
		String msg;
		while(true){
			try {
				msg = is.readUTF();
				System.out.println("����ˣ�"+msg);
				if(msg.equalsIgnoreCase("q")){
					System.out.println("������˳�����");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
