package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
    @Autowired
    private SqlSession sqlSession;
    
    //카테고리 추가
    public void insert(CategoryVo categoryVo) {
    	System.out.println("CategoryDao.insert()");
        sqlSession.insert("category.insert", categoryVo);
    }
}
