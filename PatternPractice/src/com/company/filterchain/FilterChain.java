package com.company.filterchain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

	private List<Filter> filters = new ArrayList<Filter>();
	private int index=0;
	
	public void doFilter(Request req, Response resp,FilterChain chain) {
		if(index == filters.size())return;
		Filter f = filters.get(index);
		index++;
		f.doFilter(req, resp, chain);
	}
	
	public FilterChain addFilter(Filter o){
		this.filters.add(o);
		return this;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public List<Filter> getFilters() {
		return filters;
	}

}
