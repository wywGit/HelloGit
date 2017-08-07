package com.company.webservice;

import javax.xml.ws.Endpoint;

public class Main {
	
//	private static final Log log = LogFactory.getLog(Main.class);
	public static void main(String[] args) {
//		log.info("ServiceManager start...");
		Endpoint.publish("http://192.168.1.149:9080/services/webService", new WebServicePublisherImpl());
	}
}
