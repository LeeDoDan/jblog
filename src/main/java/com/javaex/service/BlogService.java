package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class BlogService {
	
	@Autowired BlogDao blogDao;
	
	//내블로그 기본 메인
	public BlogVo getBlog(String id) {
		System.out.println("BlogService.getBlog()");
		BlogVo blogVo = blogDao.selectBlog(id);
		return blogVo;
	}
	//내블로그 기본 메인 리스트 (cate,post)
	public Map<String, Object> getMainList(String id, int cateNo,int postNo) {
		System.out.println("BlogService.getMainList()");
		List<CategoryVo> cateList =blogDao.selectCateList(id);
		List<PostVo> postList = blogDao.selectPostList(id);
		Map<String, Object> blogMap = new HashMap<>();
		blogMap.put("cateList", cateList);
		blogMap.put("postList", postList);
		blogMap.put("id", id);
		return blogMap;
	}
	
	//내블로그 베이직설정 수정(logoFile)
	public void blogBasicModify(MultipartFile file, BlogVo blogVo) {
		String saveDir = "C:\\javaStudy\\upload";
		if(!file.isEmpty()){//파일이 없지 않으면
            System.out.println("BlogService.blogBasicModify()");;
            // 원 파일 이름
            String orgName = file.getOriginalFilename();
            // 확장자
            String exName = orgName.substring(orgName.lastIndexOf("."));
            // 저장 파일 이름
            String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
            // 파일패스 (어느 경로에 어떤 이름으로)
            String filePath = saveDir + "\\" + saveName;
            // 저장 경로 VO 저장
            blogVo.setLogoFile(saveName);
    		//파일 업로드
            try {
                byte[] fileData = file.getBytes();
                OutputStream out = new FileOutputStream(filePath);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                bout.write(fileData);
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            BlogVo vo = new BlogVo(blogVo.getId(), blogVo.getBlogTitle(), saveName);
    		int count = blogDao.updateBasic(vo);
    		System.out.println(count);
		}
	}
	//내블로그 베이직설정 수정(logofile없을때)
	public void blogBasicModify(BlogVo blogVo) {
		System.out.println("BlogService.modify()1");
		BlogVo vo = new BlogVo(blogVo.getId(), blogVo.getBlogTitle(), blogVo.getLogoFile());
		blogDao.updateBasic(vo);
	}
	
}
