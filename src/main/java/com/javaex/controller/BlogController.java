package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired BlogService blogService;
	
	//내블로그
	@RequestMapping(value="/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(@PathVariable("id")String id) {
		System.out.println("BlogController.blogMain()");
		return "blog/blog-main";
	}
	//내블로그 기본설정
	@RequestMapping(value="/{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminBasic(@PathVariable("id")String id, Model model) {
		System.out.println("BlogController.blogAdminBasic()");
		return "blog/admin/blog-admin-basic";
	}
	
	//내블로그 글 작성
	@RequestMapping(value="/{id}/admin/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminWrite(@PathVariable("id")String id, Model model) {
		System.out.println("BlogController.blogAdminWriteForm()");
		//blogService.addWrite(null);
		return "/blog/admin/blog-admin-write";
	}
	//내블로그 카테고리
	@RequestMapping(value="/{id}/admin/category", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminCate(@PathVariable("id")String id) {
		System.out.println("BlogController.blogAdminCate()");
		return "blog/admin/blog-admin-cate";
	}

	
}
