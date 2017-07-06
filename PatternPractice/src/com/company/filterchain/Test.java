package com.company.filterchain;


public class Test {

	public static void main(String[] args) {
		Request req = new Request("禁止含有敏感字符，否则将采取暴力方式和谐，谢谢合作！<script>alert(':)');</script>"); 
		Response resp = new Response("begin");
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter())
		  .addFilter(new CharacterFilter());
		fc.doFilter(req, resp, fc);
		System.out.println(req.getReqStr());
		System.out.println(resp.getRespStr());
		
	}
}
