package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired UserDao userDao;
    @Autowired BlogDao blogDao;
    @Autowired CategoryDao categoryDao;
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("UserService.login()");
		UserVo loginUser = userDao.selectUser(userVo);
		return loginUser;
	}
	
	//회원가입★
	public int join(UserVo userVo) {
		System.out.println("UserService.join()");
		// User 정보 삽입
		int count =userDao.insertUser(userVo);
        // Blog 정보 삽입
        BlogVo blogVo = new BlogVo();
        blogVo.setUserNo(userVo.getUserNo());
        //blogDao.insertBlog(blogVo);
        // Category 정보 삽입
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setCateName("Default Category");
        categoryDao.insertCategory(categoryVo);
		return count;
	}
	
	
}
