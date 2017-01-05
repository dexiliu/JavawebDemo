package com.zngsgw.ssh.controller.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		String src="E:/家庭报告书.pdf";
		String dest="E:/2.pdf";
		new ReadFile().copyFile(src, dest);
		System.out.println("finish");
//		String str1=new ReadFile().FileInputStreamDemo(path);
//		String str2=new ReadFile().BufferedReaderDemo(path);
//		
//		System.out.println("str1="+str1);
//		System.out.println("str2="+str2);
	}
	
	//利用FileInputStream读取文件
	public String FileInputStreamDemo(String path) throws IOException{
		File file=new File(path);
		if(!file.exists()||file.isDirectory())
			throw new FileNotFoundException();
		FileInputStream fis=new FileInputStream(file);
		byte[] buf=new byte[1024];
		StringBuffer sb=new StringBuffer();
		while((fis.read(buf))!=-1){
			sb.append(new String(buf));
			buf=new byte[1024];
		}
		return sb.toString();
	}
	
	//利用BufferedReader读取文件
	public String BufferedReaderDemo(String path) throws IOException{
		File file=new File(path);
		if(!file.exists()||file.isDirectory())
			throw new FileNotFoundException();
		BufferedReader br=new BufferedReader(new FileReader(file));
		String temp=null;
		StringBuffer sb=new StringBuffer();
		temp=br.readLine();
		while(temp!=null){
			sb.append(temp+" ");
			temp=br.readLine();
		}
		return sb.toString();
	}
	
	//利用PrintStream写文件
	public void PrintStreamDemo(){
        try{
            FileOutputStream out=new FileOutputStream("e:/2.pdf");
            PrintStream p=new PrintStream(out);
            for(int i=0;i<10;i++)
                p.println("This is "+i+" line");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
	
	//利用StringBuffer写文件
	public void StringBufferDemo() throws IOException{
        File file=new File("e:/3.pdf");
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true);        
        for(int i=0;i<10000;i++){
            StringBuffer sb=new StringBuffer();
            sb.append("这是第"+i+"行:前面介绍的各种方法都不关用,为什么总是奇怪的问题 ");
            out.write(sb.toString().getBytes("utf-8"));
        }        
        out.close();
    }
	
	 public void copyFile(String src,String dest) throws IOException{
         FileInputStream in=new FileInputStream(src);
         File file=new File(dest);
         if(!file.exists())
             file.createNewFile();
         FileOutputStream out=new FileOutputStream(file);
         int c;
         byte buffer[]=new byte[1024];
         while((c=in.read(buffer))!=-1){
             for(int i=0;i<c;i++)
                 out.write(buffer[i]);        
         }
         in.close();
         out.close();
     }
}
