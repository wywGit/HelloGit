package com.company.webservice;  
   

import javax.jws.WebService;
   
@WebService(endpointInterface="com.company.webservice.WebServicePublisher")
public class WebServicePublisherImpl implements WebServicePublisher {
	
	@Override
	public String callWebService(String xml) {
		// TODO Auto-generated method stub
		return null;
	}
	
}  