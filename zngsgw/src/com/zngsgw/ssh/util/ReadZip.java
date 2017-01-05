package com.zngsgw.ssh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;


import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

/**
 * ��ȡzipѹ���ļ����ı�������
 * 
 */
public class ReadZip {
	public static void main(String args[]) throws UnsupportedEncodingException {
		ReadZip zip = new ReadZip();
		zip.fileDownload();
		zip.unZip("d:/apache-tomcat-7.0.54 - 8090/webapps/zngsgw.zip", "d:/apache-tomcat-7.0.54 - 8090/webapps");
		System.gc();
		DeleteFolder("d:/apache-tomcat-7.0.54 - 8090/webapps/zngsgw.zip");
	}

	@SuppressWarnings("unchecked")
	public void unZip(String unZipfile, String destFile) {// unZipfile��Ҫ��ѹ��zip�ļ���
		FileOutputStream fileOut;
		File file;
		InputStream inputStream;
		ZipFile zipFile;
		byte[] buf = new byte[1024 * 4];

		try {
			// ���һ��zip���ļ�
			zipFile = new ZipFile(unZipfile);
			// ����zipFile�����е�ʵ�壬�������ǽ�ѹ����
			for (Enumeration<ZipEntry> entries = zipFile.getEntries(); entries
					.hasMoreElements();) {
				ZipEntry entry = entries.nextElement();
				// ������ǽ�ѹ���һ���ļ�
				file = new File(destFile + File.separator + entry.getName());

				if (entry.isDirectory()) {
					file.mkdirs();
				} else {
					// ���ָ���ļ���Ŀ¼������,�򴴽�֮.
					File parent = file.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}
					// ��ȡ����ѹ��ʵ���������
					inputStream = zipFile.getInputStream(entry);

					fileOut = new FileOutputStream(file);
					int length = 0;
					// ��ʵ��д�������ļ���ȥ
					while ((length = inputStream.read(buf)) > 0) {
						fileOut.write(buf, 0, length);
					}
					fileOut.flush();
					fileOut.close();
					inputStream.close();
				}
			}
			zipFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("��ѹ��ɣ�");
	}
	
	@SuppressWarnings("deprecation")
	public void fileDownload()throws UnsupportedEncodingException{
		
		File filePath=new File("d:/zngsgw.zip");//Ҫ���ص�ѹ���ļ�
		File save=new File("D:/apache-tomcat-7.0.54 - 8090/webapps"+"/zngsgw.zip");//����ѹ���ļ��󱣴��·��
		
		FileOutputStream out=null;
		FileInputStream in=null;
		
		try{
			out=new FileOutputStream(save);
			in=new FileInputStream(filePath);
			
			byte[] b=new byte[1024];
			int i=0;
			
			while((i=in.read(b))>0){
				out.write(b);
				out.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in=null;
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out=null;
			}
		}
		System.out.println("������ɣ�");
	}
	
	/**
	 * �ļ�ɾ��
	 * @param sPath
	 * @return
	 */
	public static boolean DeleteFolder(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // �ж�Ŀ¼���ļ��Ƿ����  
	    if (!file.exists()) {  // �����ڷ��� false  
	        return flag;  
	    } else {  
	        // �ж��Ƿ�Ϊ�ļ�  
	        if (file.isFile()) {  // Ϊ�ļ�ʱ����ɾ���ļ�����  
	            return deleteFile(sPath);  
	        } else {  // ΪĿ¼ʱ����ɾ��Ŀ¼����  
	            return deleteDirectory(sPath);  
	        }  
	    }  
	}  
	
	/** 
	 * ɾ����ļ� 
	 * @param   sPath    ��ɾ���ļ����ļ��� 
	 * @return �����ļ�ɾ��ɹ�����true�����򷵻�false 
	 */  
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 
	
	/** 
	 * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ� 
	 * @param   sPath ��ɾ��Ŀ¼���ļ�·�� 
	 * @return  Ŀ¼ɾ��ɹ�����true�����򷵻�false 
	 */  
	public static boolean deleteDirectory(String sPath) {  
	    //���sPath�����ļ��ָ����β���Զ�����ļ��ָ���  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //ɾ���ļ����µ������ļ�(������Ŀ¼)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //ɾ�����ļ�  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //ɾ����Ŀ¼  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //ɾ��ǰĿ¼  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  
}
