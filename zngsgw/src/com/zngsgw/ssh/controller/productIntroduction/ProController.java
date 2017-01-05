package com.zngsgw.ssh.controller.productIntroduction;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zngsgw.ssh.entity.productIntroduction.Product;
import com.zngsgw.ssh.service.productIntroduction.ProServiceI;

@Controller
@RequestMapping("/product")
public class ProController {
	@Resource
	private ProServiceI proService;
	
	@RequestMapping(params="goAddProduct")
	public ModelAndView goAddProduct(){
		return new ModelAndView("product/addProduct");
	}
	
	@RequestMapping(params="list")
	public ModelAndView list(){
		ModelAndView mv=new ModelAndView();
		List<Product> lists=proService.findAllList();
		mv.addObject("lists", lists);
		mv.setViewName("product/list");
		return mv;
	}
	
	@RequestMapping(params="addProduct")
	public ModelAndView addProduct(HttpServletRequest request,String productName,String createTime,Double price,String description) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		Product product=new Product();
		product.setCreateTime(createTime);
		product.setDescription(description);
		product.setPrice(price);
		product.setProductName(productName);
		String photoePath=this.fileUpload(request);
		product.setPhotoPath(photoePath);
		proService.save(product);
		List<Product> lists=proService.findAllList();
		mv.addObject("lists", lists);
		mv.setViewName("product/list");
		return mv;
	}
	
	@RequestMapping(params="delete")
	public ModelAndView delete(HttpServletRequest request,Long id){
		ModelAndView mv=new ModelAndView();
		if(id!=null){
			proService.delete(id);
			List<Product> lists=proService.findAllList();
			mv.addObject("lists", lists);
			mv.setViewName("product/list");
			return mv;
		}else{
			request.setAttribute("msg", "删除产品信息失败！");
			mv.setViewName("common/blank");
			return mv;
		}
	}
	
	@RequestMapping(params="goUpdate")
	public ModelAndView goUpdate(Long id){
		ModelAndView mv=new ModelAndView();
		Product product=proService.findById(id);
		mv.addObject("product", product);
		mv.setViewName("product/update");
		return mv;
	}
	
	@RequestMapping(params="doUpdate")
	public ModelAndView doUpdate(HttpServletRequest request,Long id,String productName,String lastUpdateTime,Double price,String description){
		ModelAndView mv=new ModelAndView();
		Product product=new Product();
		product.setId(id);
		product.setLastUpdateTime(lastUpdateTime);
		product.setDescription(description);
		product.setPrice(price);
		product.setProductName(productName);
		proService.update(product);
		List<Product> lists=proService.findAllList();
		mv.addObject("lists", lists);
		mv.setViewName("product/list");
		return mv;
	}
	
	@RequestMapping(params="productDetail")
	public ModelAndView productDetail(Long id){
		ModelAndView mv=new ModelAndView();
		Product product=proService.findById(id);
		mv.addObject("product", product);
		mv.setViewName("product/detail");
		return mv;
	}
	
	
	public String fileUpload(HttpServletRequest request)
			throws IllegalStateException, IOException {
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
					}
				}

			}
		}
		return filePath;
	}
}
