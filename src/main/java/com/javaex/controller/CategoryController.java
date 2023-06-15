package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
public class CategoryController {
	
	@Autowired CategoryService categoryService;
	
	//내블로그 카테고리 폼
	@RequestMapping(value="/{id}/admin/category", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminCate(@PathVariable("id")String id) {
		System.out.println("BlogController.blogAdminCate()");
		return "blog/admin/blog-admin-cate";
	}
	
	//카테고리 추가
	@RequestMapping(value="/{id}/admin/category/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogAdminCateAdd(@PathVariable("id")String id, @ModelAttribute CategoryVo categoryVo) {
		System.out.println("BlogController.blogAdminCateAdd()");
		categoryService.addCate(categoryVo);
		return "redirect:/admin/blog-admin-cate";
	}
	
}
