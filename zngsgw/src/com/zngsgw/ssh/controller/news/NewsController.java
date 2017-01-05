package com.zngsgw.ssh.controller.news;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.zip.ZipEntry;  
import org.apache.tools.zip.ZipFile;  

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zngsgw.ssh.entity.news.News;
import com.zngsgw.ssh.service.news.NewsServiceI;
import com.zngsgw.ssh.util.ClientTcpSend;
import com.zngsgw.ssh.util.DESUtil;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Resource
	private NewsServiceI newsService;

	@RequestMapping(params = "goAddNews")
	public ModelAndView goAddNews() {
		return new ModelAndView("news/createNews");
	}

	@RequestMapping(params = "goUpload")
	public ModelAndView goUpload() {
		return new ModelAndView("news/fileUpload");
	}

	/**
	 * 单文件上存
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, params = "upload")
	public ModelAndView upload(HttpServletRequest request, ModelMap model) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		// 构建图片保存的目录
		String logoPathDir = "/images" + dateformat.format(new Date());
		// 得到图片保存目录的真实路径
		String logoRealPathDir = request.getSession().getServletContext()
				.getRealPath(logoPathDir);
		System.out.println("真实路径=" + logoRealPathDir);
		// 根据真实目录创建目录
		File logoSaveFile = new File(logoRealPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();
		// 页面控件的文件流
		MultipartFile multipartFile = multipartRequest.getFile("file");
		// 构建文件名称
		String logImageName = multipartFile.getOriginalFilename();
		// 拼成完整的文件保存路径加文件
		String fileName = logoRealPathDir + File.separator + logImageName;
		File file = new File(fileName);

		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.put("fileName", fileName);
		request.setAttribute("msg", "文件上存成功！");
		return new ModelAndView("common/blank");
	}

	/**
	 * 多文件上存
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(params = "upload2")
	public ModelAndView upload2(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		fileUpload(request);
		request.setAttribute("msg", "文件上存成功！");
		return new ModelAndView("common/blank");
	}

	@RequestMapping(params = "delete")
	public ModelAndView delete(HttpServletRequest request, Long id) {
		ModelAndView mv = new ModelAndView();
		if (id != null) {
			newsService.delete(id);
			List<News> newsLists = newsService.findAllList();
			mv.addObject("newsLists", newsLists);
			mv.setViewName("news/newsList");
			return mv;
		} else {
			request.setAttribute("msg", "删除新闻失败！");
			mv.setViewName("common/blank");
			return mv;
		}
	}

	@RequestMapping(params = "createNews")
	public ModelAndView createNews(HttpServletRequest request, String title,
			String source, String author, String createTime, String content,
			String keywords) throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView();
		News news = new News();
		news.setTitle(title);
		news.setSource(source);
		news.setAuthor(author);
		news.setCreateTime(createTime);
		news.setContent(content);
		news.setKeywords(keywords);
		String photoPath = this.fileUpload(request);
		news.setPhotoPath(photoPath);
		newsService.save(news);
		List<News> newsLists = newsService.findAllList();
		mv.addObject("newsLists", newsLists);
		mv.setViewName("news/newsList");
		return mv;
	}

	@RequestMapping(params = "list")
	public ModelAndView listNews(Model model) {
		ModelAndView mv = new ModelAndView();
		List<News> newsLists = newsService.findAllList();
		mv.addObject("newsLists", newsLists);
		mv.setViewName("news/newsList");
		return mv;
	}

	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(Long id) {
		ModelAndView mv = new ModelAndView();
		News news = newsService.findById(id);
		mv.addObject("news", news);
		mv.setViewName("news/update");
		return mv;
	}

	@RequestMapping(params = "doUpdate")
	public ModelAndView doUpdate(HttpServletRequest request, Long id,
			String title, String source, String author, String lastUpdateTime,
			String content, String keywords) {
		ModelAndView mv = new ModelAndView();
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setSource(source);
		news.setAuthor(author);
		news.setLastUpdateTime(lastUpdateTime);
		news.setContent(content);
		news.setKeywords(keywords);
		newsService.update(news);
		List<News> newsLists = newsService.findAllList();
		mv.addObject("newsLists", newsLists);
		mv.setViewName("news/newsList");
		return mv;
	}

	@RequestMapping(params = "newsDetail")
	public ModelAndView newsDetail(HttpServletRequest request, Long id) {
		ModelAndView mv = new ModelAndView();
		News news = newsService.findById(id);
		mv.addObject("news", news);
		mv.setViewName("news/detail");
		return mv;
	}

	public String fileUpload(HttpServletRequest request)
			throws IllegalStateException, IOException {
		String names=request.getParameter("names");
		String filePath = null;
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断request是否有文件上传，即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
			// 构建图片保存的目录
			String logoPathDir = "/images/" + dateformat.format(new Date());
			// 得到图片保存目录的真实路径
			String logoRealPathDir = request.getSession().getServletContext()
					.getRealPath(logoPathDir);
			File savePath = new File(logoRealPathDir);
			if (!savePath.exists())
				savePath.mkdirs();
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为""，说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						// 拼成完整的文件保存路径加文件
						filePath = logoRealPathDir + File.separator
								+ myFileName;
						File localPath = new File(filePath);
						file.transferTo(localPath);
						System.out.println("aaaa");
					}
				}

			}
		}
		return filePath;
	}
	
	//=================================================================================================
	/**
	 * 文件下载和解压
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(params = "download")
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		String str=request.getRealPath("..")+File.separator;
		String path="http://192.168.2.179:8082/a/13.jpg";
		URL url=new URL(path);
//		String st[]=url.toString().split("/");
//		String filename=st[st.length-1];
		
		download(request,response,url);
		/*unZip(str+filename, request.getRealPath(".."));
		System.out.println("下载解压完成！");
		System.gc();
		//删除压缩包
		deleteFile(str+filename);
		
		//执行sql文件
		this.antExecSql(str+filename.replace("zip", "sql"));
//		this.antExecSql(request.getRealPath("..")+File.separator+"school.sql");
		System.gc();
		deleteFile(str+filename.replace("zip", "sql"));*/
	}
	
	/**
	 * 从服务器下载
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 */
	public void download(HttpServletRequest request,HttpServletResponse response,URL url) throws IOException{
		response.setContentType("application/x-download");
		FileOutputStream out=null;
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		BufferedInputStream in=new BufferedInputStream(conn.getInputStream());
		
		String st[]=url.toString().split("/");
		String filename=st[st.length-1];

		File save=new File(request.getRealPath("..")+File.separator+filename);
		int len;
		byte[] bt = new byte[1024];
		try {
			out=new FileOutputStream(save);
			while ((len = in.read(bt)) != -1) {
				out.write(bt,0,len);
			}
		} finally {
			out.close();
			in.close();
		}
	}
	
	/**
	 * 从本地下载
	 * @param request
	 * @param response
	 * @param path
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public void fileDownload(HttpServletRequest request,HttpServletResponse response,String path)throws IOException{
		response.setContentType("application/x-download");
		
		File filePath=new File(path);//要下载的压缩文件
		System.out.println("filePath="+filePath+",name="+filePath.getName());
		File save=new File(request.getRealPath("..")+File.separator+filePath.getName());//下载压缩文件后保存的路径
		
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
				in.close();
				in=null;
			}
			if(out!=null){
				out.close();
				out=null;
			}
		}
		System.out.println("下载完成！");
	}
	
	public void unZip(String unZipfile, String destFile) {// unZipfile需要解压的zip文件名
	      FileOutputStream fileOut;
	      File file;
	      InputStream inputStream;
	      ZipFile zipFile;
	      byte[] buf=new byte[1024*4];

	      try {
	          //生成一个zip的文件
	          zipFile = new ZipFile(unZipfile);
	          //遍历zipFile中所有的实体，并把他们解压出来
	          for (Enumeration<ZipEntry> entries = zipFile.getEntries(); entries
	                  .hasMoreElements();) {
	              ZipEntry entry =  entries.nextElement();
	              //生成他们解压后的一个文件  
	              file = new File(destFile+File.separator+entry.getName());

	              if (entry.isDirectory()) {
	                  file.mkdirs();
	              } else {
	                  // 如果指定文件的目录不存在,则创建之.
	                  File parent = file.getParentFile();
	                  if (!parent.exists()) {
	                      parent.mkdirs();
	                  }  
	                  //获取出该压缩实体的输入流 
	                  inputStream = zipFile.getInputStream(entry);

	                  fileOut = new FileOutputStream(file);
	                  int length = 0;
	                  //将实体写到本地文件中去
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
	      System.out.println("解压完成！");
	  }
	
	/**
	 * 文件删除
	 * @param sPath
	 * @return
	 */
	public boolean DeleteFolder(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return flag;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	            return deleteFile(sPath);  
	        } else {  // 为目录时调用删除目录方法  
	            return deleteDirectory(sPath);  
	        }  
	    }  
	}  
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 
	
	/** 
	 * 删除目录（文件夹）以及目录下的文件 
	 * @param   sPath 被删除目录的文件路径 
	 * @return  目录删除成功返回true，否则返回false 
	 */  
	public boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  
	
	public void antExecSql(String path){
		SQLExec sqlExec = new SQLExec();
		// 设置数据库参数
		sqlExec.setDriver("com.mysql.jdbc.Driver");
		sqlExec.setUrl("jdbc:mysql://127.0.0.1:3306/zngsgw?useUnicode=true&characterEncoding=UTF-8");
		sqlExec.setUserid("root");
		sqlExec.setPassword("root");
		// 要执行的脚本
		sqlExec.setSrc(new File(path));
		sqlExec.setPrint(true); // 设置是否输出
		sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错
		sqlExec.execute();
	}
	
	@RequestMapping(params="send")
	public void read(HttpServletRequest request,HttpServletResponse response) throws MalformedURLException{
		String str=request.getParameter("str");
		System.out.println(str);
		String key = "A1B2C3D4E5F60704";
		DESUtil util=new DESUtil();
		
		String path="http://192.168.2.122:8090/zngsgw/version/tnsz.sql";
		URL url=new URL(path);
		
		try {
			String decryptData=util.decrypt(str, key);
	        if(decryptData.equals("super222")){
	        	request.getSession().setAttribute("name", decryptData);
	        	String name=(String)request.getSession().getAttribute("name");
	        	System.out.println(name);
	        	download(request,response,url);
	        	System.out.println("解密后: " + decryptData);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(params="rec")
	public void rev(HttpServletRequest request,HttpServletResponse response){
		String str=request.getParameter("str");
		System.out.println("str====="+str);
		if(str!=null){
			request.getSession().setAttribute("name", str);
			System.out.println("name="+request.getSession().getAttribute("name"));
			try {
//				response.sendRedirect("http://192.168.2.122:8080/school/tbVersionController?systemUpdate&filePath=http://192.168.2.122:8090/zngsgw/version/tnsz.sql&flag=ok");
				response.sendRedirect("http://192.168.2.122:8082/zngsgw/news.do?download&flag=ok");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
