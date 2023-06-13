package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
    @Autowired
    private SqlSession sqlSession;
    
    //내블로그 기본설정 작성
    public void insertBlog(BlogVo blogVo) {
    	System.out.println("BlogDao.inertBlog()");
        sqlSession.insert("blog.insertBlog", blogVo);
        
    }
}
