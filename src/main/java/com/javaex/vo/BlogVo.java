package com.javaex.vo;

public class BlogVo {
	private String id;
	private String blogTitle;
	private String logoFile;
	private int userNo;

	public BlogVo(String id, String blogTitle, String logoFile, int userNo) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
		this.userNo = userNo;
	}
	public BlogVo(String id, String blogTitle, String logoFile) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}
	public BlogVo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + ", userNo=" + userNo + "]";
	}


	
	
}
