package com.company.webservice;
   
import java.lang.annotation.Documented;

import javax.jws.WebService;
   
@WebService
public interface WebServicePublisher {
	public String callWebService(String xml);
}  