package com.zngsgw.ssh.controller.demo;

import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.MalformedURLException;  
  
public class ReadWriteFile {  
    /** 
     * 从本地文件11.txt读取数据写入本地文件12.txt 
     * 
     * 
     */  
    public static void main(String[] args) throws IOException {  
        //输入流  
        InputStream in = new FileInputStream("e:/家庭报告书.pdf");  
        //输出流  
        OutputStream out = new FileOutputStream("e:/1.pdf", true);  
  
        try {  
            byte[] buffer = new byte[1024];  
            while (true) {  
                int byteRead = in.read(buffer);  
                if (byteRead == -1)  
                    break;  
                out.write(buffer, 0, byteRead);  
            }  
        }  
  
        catch (MalformedURLException ex) {  
            System.err.println(args[0] + " is not a URL Java understands.");  
        } finally {  
            if (in != null)  
                in.close();  
            if (out != null) {  
                out.close();  
            }  
        }  
    }  
}  
