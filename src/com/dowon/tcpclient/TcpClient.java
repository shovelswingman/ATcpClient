package com.dowon.tcpclient;
import java.net.Socket;


public class TcpClient {
	private int ConnTimeout = 3000;
	private int RecvTimeout = 3000;
	
	private boolean isConnected = false;
	private boolean isRecved = false;
	
	private String SERVER = "";
	private int PORT = 0;
	
	private Socket socket;
	
	
	//Connection Timeout
	public void setConnectTimeout(int millisec) {
		ConnTimeout = millisec;
	}
	
	//Receive Timeout
	public void setRecvTimeout(int millisec) {
		RecvTimeout = millisec;
	}
	
	

}
