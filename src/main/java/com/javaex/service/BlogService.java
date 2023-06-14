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
	
	
	String saveDir = "C:\\javaStudy\\upload";
	
	//내블로그 베이직설정 수정
	public Map<String, Object> blogBasicModify(String id, BlogVo blogVo, MultipartFile file) {
        // 파일 업로드(사용자 파일 복사 - 하드디스크 저장)
        if(!file.isEmpty()) {//
        	blogDao.updateBasic(blogVo);
        }else {
            System.out.println("BlogService.blogBasicModify()");;
            // 원 파일 이름
            String orgName = file.getOriginalFilename();
            // 확장자
            String exName = orgName.substring(orgName.lastIndexOf("."));
            // 저장 파일 이름
            String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
            // 파일패스 (어느 경로에 어떤 이름으로)
            String filePath = saveDir + "\\" + saveName;
            try {
                byte[] fileData = file.getBytes();
                OutputStream out = new FileOutputStream(filePath);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                bout.write(fileData);
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 파일 업로드 후 basic 정보 업데이트
            blogVo.setLogoFile(saveName);
            blogDao.updateBasic(blogVo);
        }
        Map<String, Object> blogMap = new HashMap<>();
        return blogMap;
        /*SEVERE: 경로 [/jblog]의 컨텍스트 내의 서블릿 [spring]을(를) 위한 Servlet.service() 호출이, 근본 원인(root cause)과 함께, 예외 [Request processing failed; nested exception is org.springframework.jdbc.UncategorizedSQLException: Error setting null for parameter #2 with JdbcType OTHER . Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. Cause: java.sql.SQLException: 부적합한 열 유형: 1111
; uncategorized SQLException for SQL []; SQL state [99999]; error code [17004]; 부적합한 열 유형: 1111; nested exception is java.sql.SQLException: 부적합한 열 유형: 1111]을(를) 발생시켰습니다.
java.sql.SQLException: 부적합한 열 유형: 1111*/
    }

	
}
