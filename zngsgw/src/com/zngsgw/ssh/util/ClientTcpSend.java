package com.zngsgw.ssh.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTcpSend {

	public void client() {
		Socket socket = null;
		DataOutputStream dout = null;
		try {
			try {
				socket = new Socket();
				//向服务器获取socket通道，端口号33456，设置10秒连接超时
				socket.connect(new InetSocketAddress("192.168.2.122", 33456),
						10 * 1000);
				//获取socket的输出流
				dout = new DataOutputStream(socket.getOutputStream());
				dout.writeUTF("abd");
			} catch (Exception e) {
				
			} finally {
				if (dout != null)
					dout.close();
				if (socket != null)
					socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
