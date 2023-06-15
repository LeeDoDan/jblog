package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	@Autowired PostDao postDao;
	
	//글 작성
	public void addWrite(PostVo postVo) {
		System.out.println("PostService.addWirte()");
		postDao.insert(postVo);
	}
}
