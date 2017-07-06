package com.company.filterchain;

public interface Filter {

	void doFilter(Request req,Response resp,FilterChain chain);
}
