package com.dowon.tcpclient;

public interface ResultInterface {
	public void OnConnectionTimeout(int id);
	public void OnReceiveTimeout(int id);
}
