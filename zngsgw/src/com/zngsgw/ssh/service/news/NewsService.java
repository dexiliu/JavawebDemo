package com.zngsgw.ssh.service.news;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zngsgw.ssh.entity.news.News;
import com.zngsgw.ssh.repository.news.NewsRepository;
import com.zngsgw.ssh.service.news.NewsServiceI;

import org.springframework.beans.BeanUtils;

@Service("newsService")
@Transactional
public class NewsService implements NewsServiceI {

	@Resource
	private NewsRepository newsRepository;
	
	public void save(News news) {
		newsRepository.save(news);
	}

	public void update(News news) {
		News news2=this.findById(news.getId());
		BeanUtils.copyProperties(news, news2);
		newsRepository.save(news2);
	}

	public void delete(Long id) {
		newsRepository.delete(id);
	}

	public News findById(Long id) {
		News news=new News();
		if(id!=null||id!=0){
			news=newsRepository.findOne(id);
			return news;
		}else{
			return null;
		}
	}

	public List<News> findAllList() {
		return (List<News>) newsRepository.findAll();
	}


}
