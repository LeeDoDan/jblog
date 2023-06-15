package com.javaex.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {
	
	@Autowired BlogService blogService;
	
	//내블로그 메인
	@RequestMapping(value="/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(@PathVariable("id") String id, Model model,
						@RequestParam(value = "cateNo", required = false, defaultValue ="0") int cateNo,
						@RequestParam( value = "postNo", required = false, defaultValue = "0") int postNo) {
		System.out.println("BlogController.blogMain()");
		BlogVo blogVo = blogService.getBlog(id);
		Map<String, Object> blogMap = blogService.getMainList(id, cateNo, postNo);
		model.addAttribute(blogMap);
		return "blog/blog-main";
	}

	
	//내블로그 기본설정
	@RequestMapping(value="/{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminBasic(@PathVariable("id")String id, Model model) {
		System.out.println("BlogController.blogAdminBasic()");
		return "blog/admin/blog-admin-basic";
	}
	
	//내블로그 베이직설정 업데이트
	@RequestMapping(value="/admin/basicModify", method = RequestMethod.POST)
	public String blogBasicModify(@PathVariable("id") String id, @ModelAttribute BlogVo blogVo,
			@RequestParam("file") MultipartFile file) {
		System.out.println("BlogController.blogAdminBasicModify()");
		if(file.getOriginalFilename() == "") {
			blogService.blogBasicModify(blogVo);
		}else {
			blogService.blogBasicModify(file, blogVo);
		}
		return "redirect:/"+id+"/admin/basic";
	}
	
}
