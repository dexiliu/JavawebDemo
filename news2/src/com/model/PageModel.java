package com.model;

import java.util.List;

public class PageModel<T> {

	private int page;//��ǰҳ��
	private int size;//ÿҳ��ʾ������
	private int totalCount;//�ܼ�¼�������������ݿ��ѯ���
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
	
	//��ȡ��ҳ��
	public int getTotalPage(){
		return ((totalCount-1)/size)+1;
	}
	
	//��ȡ��һҳ
	public int getPre(){
		page=page-1;
		return page;
	}
	
	//��ȡ��һҳ
	public int getNext(){
		page=page+1;
		return page;
	}
	
	//�ж��Ƿ�����һҳ
	public boolean hasPre(){
		if((page-1)>0){
			return true;
		}else{
			return false;
		}
	}
	
	//�ж��Ƿ�����һҳ
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
