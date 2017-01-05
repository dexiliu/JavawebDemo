package com.zngsgw.ssh.service.news;

import java.util.List;

import com.zngsgw.ssh.entity.news.News;

public interface NewsServiceI {

	public void save(News news);
	
	public void update(News news);
	
	public void delete(Long id);
	
	public News findById(Long id);
	
	public List<News> findAllList();
	
}
