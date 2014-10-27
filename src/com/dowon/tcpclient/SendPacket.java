package com.dowon.tcpclient;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;

public class SendPacket {
	private CRC32 crc32;
	private byte[] packet;
	
	

	//ADD TO PACKET CRC
	public void addCRC32() {
		crc32 = new CRC32();
		crc32.update(packet);
		Long crcvalue = crc32.getValue();
		
		byte[] temp = packet;
		packet = new byte[packet.length + Long.SIZE];
		System.arraycopy(temp, 0, packet, 0, temp.length);
		
		byte[] crc_array = longToBytes(crcvalue);
		System.arraycopy(crc_array, 0, packet, packet.length - 5, crc_array.length);
	}
	
	public byte[] longToBytes(long value) {
		ByteBuffer buffer = ByteBuffer.allocate(Long.SIZE);
		buffer.putLong(value);
		return buffer.array();
	}
}
