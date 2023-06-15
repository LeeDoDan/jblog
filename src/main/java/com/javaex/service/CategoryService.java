package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired CategoryDao categoryDao;
	
	//카테고리 추가
	public void addCate(CategoryVo categoryVo) {
		System.out.println("CategoryService.addCate()");
		categoryDao.insert(categoryVo);
	}
	
}
