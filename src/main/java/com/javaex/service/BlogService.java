package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired BlogDao blogDao;
	
	//내블로그 기본설정 작성
	public void addWrite(BlogVo blogVo) {
		System.out.println("BlogService.addWrite()");
		blogDao.insertBlog(blogVo);
	}
}
