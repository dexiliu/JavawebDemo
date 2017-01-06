package com.model;

import java.util.List;

public class PageModel<T> {

	private int page;//当前页码
	private int size;//每页显示的条数
	private int totalCount;//总记录数，来自于数据库查询结果
	private List<T> list;
	
	public PageModel(){
	}
	
	public PageModel(int page,int size){
		this.page=page;
		this.size=size;
	}
	
	public PageModel(int page,int size,int totalCount,List<T> list){
		this.page=page;
		this.size=size;
		this.totalCount=totalCount;
		this.list=list;
	}
	
	//获取总页数
	public int getTotalPage(){
		return ((totalCount-1)/size)+1;
	}
	
	//获取上一页
	public int getPre(){
		page=page-1;
		return page;
	}
	
	//获取下一页
	public int getNext(){
		page=page+1;
		return page;
	}
	
	//判断是否有上一页
	public boolean hasPre(){
		if((page-1)>0){
			return true;
		}else{
			return false;
		}
	}
	
	//判断是否有下一页
	public boolean hasNext(){
		if((page+1)<=((totalCount-1)/size)+1){
			return true;
		}else{
			return false;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
