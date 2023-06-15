package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PostService;
import com.javaex.vo.PostVo;

@Controller
public class PostController {
	
	@Autowired PostService postService;

	//내블로그 글 작성 폼
	@RequestMapping(value="/{id}/admin/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminWriteForm(@PathVariable("id")String id, Model model) {
		System.out.println("BlogController.blogAdminWriteForm()");
		return "/blog/admin/blog-admin-write";
	}
	//내블로그 글 작성
	@RequestMapping(value="/{id}/admin/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminWrite(@PathVariable("id")String id, @ModelAttribute PostVo postVo) {
		System.out.println("BlogController.blogAdminWriteForm()");
		postService.addWrite(postVo);
		return "redirect:/"+id+"/admin/writeForm";
	}
}
