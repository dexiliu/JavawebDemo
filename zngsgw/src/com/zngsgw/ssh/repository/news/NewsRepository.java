package com.zngsgw.ssh.repository.news;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zngsgw.ssh.entity.news.News;


public interface NewsRepository extends PagingAndSortingRepository<News, Long>{

}
