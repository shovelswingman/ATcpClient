package com.dowon.tcpclient;
import java.net.Socket;

import android.os.Handler;
import android.os.Message;


public class TcpClient {
	private int ConnTimeout = 3000;
	private int RecvTimeout = 3000;
	
	private boolean isConnected = false;
	private boolean isRecved = false;
	
	private String SERVER = "";
	private int PORT = 0;
	
	private Socket socket;
	
	private static final int CONN_TIMEOUT_MESSAGE = 0;
	private static final int RECV_TIMEOUT_MESSAGE = 0;
	
	private ResultInterface resultInterface = null;
	
	
	//Connection Timeout
	public void setConnectTimeout(int millisec) {
		ConnTimeout = millisec;
	}
	
	//Receive Timeout
	public void setRecvTimeout(int millisec) {
		RecvTimeout = millisec;
	}
	
	Handler TimeoutHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what) {
			case CONN_TIMEOUT_MESSAGE :
				resultInterface.OnConnectionTimeout(id);
				break;
			case RECV_TIMEOUT_MESSAGE :
				resultInterface.OnReceiveTimeout(id);
				break;
			}
		}
	};

}
