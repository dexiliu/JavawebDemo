package com.zngsgw.ssh.controller.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class FileUpload {

	public static void main(String[] args) throws IllegalStateException, IOException {
		FileUpload upload=new FileUpload();
		String str=upload.fileUpload("E:/2015.5.16元老欢送会照片/IMG_2002.JPG","E:/");
		System.out.println(str);
	}
	
	public String fileUpload(String filePath,String serverPath)
			throws IllegalStateException, IOException {
		String resultPath = "";          //上传后图片所在的路径 
	    FileOutputStream out = null;     //文件输出流 
	    try {                               //验证图片上传的格式是否正确 
	     File f = new File(filePath); 
	        if (!f.isFile()) { 
	        throw new Exception(f+" 不是图片文件!"); 
	    } 
	     if (f != null && f.exists()) {          //这里的ImageIO属于java工厂类，在工厂类class里面，调用的System.gc()，频繁调用会造成dump，需要考虑优化 
	        BufferedImage image = ImageIO.read(f); // 读入文件 
	        if (image != null) { 
	        BufferedImage tag = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);  //构造一个类型为预定义图像类型之一的 BufferedImage 
	           tag.getGraphics().drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);                     //绘制所需要尺寸大小的图片 
	        /* 
	         * 以下生成图片上传后在服务器上的新路径 
	         */ 
	        int lastLength = filePath.lastIndexOf("."); 
	        Date date = new Date(System.currentTimeMillis()); 
	        String strDate = new SimpleDateFormat("yyyyMMddhhmmss").format(date); 
	        int random = (int)(Math.random()*99); 
	        String imageName = strDate+random;                          //以系统时间来随机的创建图片文件名 
	        String fileType = filePath.substring(lastLength);              //获取上传图片的类型 
	        resultPath = serverPath+"site"+imageName+fileType; 
	        /* 
	         * 进行图片的绘制 
	         */ 
//	        out = new FileOutputStream(resultPath); 
//	        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
//	        JPEGEncodeParam param = 
//	        encoder.getDefaultJPEGEncodeParam(tag); 
//	        param.setQuality(0.95f, true); //95%图像       
//	        param.setDensityUnit(1);                //像素尺寸单位.像素/英寸     
//	        param.setXDensity(300);                  //水平分辨率       
//	        param.setYDensity(300);                 //垂直分辨率 
//	        encoder.setJPEGEncodeParam(param); 
//	        encoder.encode(tag); 
//	        tag = null; 
	      } 
	     } 

	     f = null; 

	    } catch (Exception ex) { 
	     ex.printStackTrace(); 
	    } finally { 
	     out.close(); 
	     out = null; 
	    } 
	    return resultPath; 
	}

}
