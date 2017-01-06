package util;

import java.io.File;

import javax.swing.ImageIcon;


public class ImageUtil {

	/**
	 * 直接调用linux命令convert实现图片缩放 
	 * 参数： 原图全路径（包括文件名），目标图全路径（包括文件名），正方形比例
	 * sjl 2008-12-18
	 */
	public static final void convertImageSize(String sourceImgFile,String targetImgFile, int toSize){
	  	  File file = new File(sourceImgFile); 
		  if(file.exists()){ 
			  ImageIcon icon=new ImageIcon(sourceImgFile);  
			  double w = icon.getIconWidth();   
	          double h = icon.getIconHeight();  
	          
			  //传过来的参数绝对不能为0，零不能做除数
			  if(w==0){w=1;}
			  if(h==0){h=1;}
				
	          int toWidth=(int)w;
	          int toHeight=(int)h;
	          
	          if(w>=h){
	        	  if(w>toSize){
	        		  toWidth=toSize;
	        		  toHeight = (int)(h*toSize/w);
	        	  }
	          }else{
	        	  if(h>toSize){
	        		  toWidth= (int)(w*toSize/h);
	        		  toHeight =toSize;	        		  
	        	  }
	          }
	           
	          Runtime Deruntime = Runtime.getRuntime();
	          StringBuffer sb = new StringBuffer(500);
	          try {
	        	sb.append(MyConfigUtil.getValue("imageMagick.convert.path")).append(" -resize ").append(toWidth).append("x").append(toHeight).append(" -quality 90 -colorspace rgb ").append(sourceImgFile).append(" ").append(targetImgFile.toString());
				Deruntime.exec(sb.toString());
				Deruntime.freeMemory();
				Thread.sleep(4000);
	          } catch (Exception e) {
				System.out.print(e.toString());
	          } finally {
				sb = null;
	          }
		  }else{
			  System.out.print("file not exists!");
		  }
	}
}
