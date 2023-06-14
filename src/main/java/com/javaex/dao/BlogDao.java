package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Repository
public class BlogDao {
    @Autowired
    private SqlSession sqlSession;
    
    //내블로그 기본메인
    public BlogVo selectBlog(String id) {
		System.out.println("BlogDao.selectBlog()");
		BlogVo blogVo = sqlSession.selectOne("blog.selectMain", id);
		return blogVo;
    }
    //내블로그 메인 리스트(cate)
    public List<CategoryVo> selectCateList(String id) {
    	System.out.println("BlogDao.selectCateList()");
    	List<CategoryVo> cateList = sqlSession.selectList("blog.selectCateList", id);
    	return cateList;
    }
    //내블로그 메인 리스트(post)
    public List<PostVo> selectPostList(String id) {
    	System.out.println("BlogDao.selectPostList()");
    	List<PostVo> postList = sqlSession.selectList("blog.selectPostList", id);
    	return postList;
    }
    //내블로그 basic 수정
	public int updateBasic(BlogVo blogVo) {
		System.out.println("BlogDao.updateBasic");
		int count = sqlSession.update("blog.updateBasic", blogVo);
		System.out.println(count);
		return count;
	}
}
