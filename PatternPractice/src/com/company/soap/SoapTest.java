package com.company.soap;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang3.StringEscapeUtils;
import org.w3c.dom.NodeList;

public class SoapTest {

	public static void main(String[] args) {
		new SoapTest().testSoap();
	}
	public void testSoap() {
//		String wsdl = "http://192.168.1.4:6060/ServiceBusWeb/services/invoker";
		String wsdl = "http://59.56.182.79:9999/AreaLISHISDATA/services/IWebService";
//		useHttpClient(wsdl);
		httpPost(wsdl, getInvokeParamXmlStr2());
	}
	
//	public Map useHttpClient(String wsdl) {
//		Map<String,Object> result = new HashMap<String, Object>();
//		HttpClient client = HttpClientUtils.getHttpClient();
//		HttpPost post = new HttpPost(wsdl);
//		try {
//			StringEntity s = new StringEntity(getInvokeParamXmlStr(), "utf-8");
//			post.setEntity(s);
//			HttpResponse response = client.execute(post);
//			result.put("code", response.getStatusLine().getStatusCode());
//			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//				HttpEntity entity = response.getEntity();
//				String responseString = EntityUtils.toString(entity);
//				System.out.println(responseString);
//				result.put("datas", responseString);
//			}else{
//				System.out.println(response.getStatusLine().getStatusCode());
//				InputStream inStream =     response.getEntity().getContent();  
//	            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream,"utf-8"));    
//	            StringBuilder strber = new StringBuilder();    
//	            String line = null;    
//	            while ((line = reader.readLine()) != null)
//	                strber.append(line + "\n");    
//	            inStream.close();
//	            System.out.println("error message:"+strber);
//	            result.put("datas", strber);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}

	public void parseSoapXml() throws Exception {
		String responseString="<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns2:invokeWebServiceResponse xmlns:ns2=\"http://webservice.servicebusweb.ecan.com/\"><return xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xsi:type=\"xs:string\">{\"code\":206,\"msg\":\"false\",\"datas\":\"www.strongsoft.com.cn\"}</return><return xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xsi:type=\"xs:string\">eaca75faa78a4ae79dd5d0bc09662ebd</return><return xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xsi:type=\"xs:int\">200</return></ns2:invokeWebServiceResponse></soap:Body></soap:Envelope>";
		MessageFactory msgFactory = MessageFactory.newInstance();
        SOAPMessage reqMsg = msgFactory.createMessage(new MimeHeaders(),
                 new ByteArrayInputStream(responseString.getBytes("UTF-8")));
        reqMsg.saveChanges();
        SOAPBody body = reqMsg.getSOAPBody();
        NodeList ret = body.getElementsByTagName("return");
        System.out.println(ret.item(0).getTextContent());
	}
	

	public static void httpPost(String requestUrl, String content) {
		StringBuffer buffer = new StringBuffer();
		try {

			URL url = null;
			if (requestUrl.contains("https")) {
				url = new URL(null, requestUrl, new sun.net.www.protocol.https.Handler());
			} else {
				url = new URL(requestUrl);
			}
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

			httpUrlConn.setRequestProperty("Content-Length", String.valueOf(content.getBytes().length));
			httpUrlConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setRequestMethod("POST");
			httpUrlConn.connect();
			OutputStream outputStream = httpUrlConn.getOutputStream();
			if (null != content) {
				outputStream.write(content.getBytes("UTF-8"));
				outputStream.flush();
			}
			outputStream.close();
			int responseCode = httpUrlConn.getResponseCode();
			System.out.println("response code -----" + responseCode + "-------------");
			// 将返回的输入流转换成字符�?
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;

			httpUrlConn.disconnect();
//			System.out.println(buffer.toString());
			System.out.println("java:"+StringEscapeUtils.unescapeXml(buffer.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static String getInvokeParamXmlStr2(){
		StringBuffer soap = new StringBuffer("");
		soap.append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		soap.append("<soap:Body>");
		soap.append("<nsa2:GetDictionary xmlns:nsa2=\"http://webservice.service.backstage.his.ecan.com/\">");//invokeWebService是一个方法，后面地址为命名空间
		soap.append("<arg0><![CDATA[");
		StringBuffer xml = new StringBuffer("");
//		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<root>");
		xml.append("<parameter>");
		xml.append("<orgcode>1100</orgcode>");
		xml.append("<dict>user</dict>");
		xml.append("</parameter>");
		xml.append("</root>");
		
//		soap.append(StringEscapeUtils.escapeXml(xml.toString()));//xml�?��转义
		soap.append(xml.toString());//xml�?��转义
		soap.append("]]></arg0>");
		soap.append("</nsa2:GetDictionary>");
		soap.append("</soap:Body>");
		soap.append("</soap:Envelope>");
		System.out.println("send soap:"+soap.toString());
		return soap.toString();
	}
	public static String getInvokeParamXmlStr(){
		StringBuffer soap = new StringBuffer("");
		soap.append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		soap.append("<soap:Header>");
		soap.append("<authHeader>");///<!--权限验证头部-->
		soap.append("<key>test</key>");//<!--tba_user.user_id,由servicebus分配 -->
		soap.append("<token>test</token>");//<!-- tba_user.password-->
		soap.append("</authHeader>");
		soap.append("</soap:Header>");
		soap.append("<soap:Body>");
		soap.append("<nsa2:invokeWebService xmlns:nsa2=\"http://webservice.servicebusweb.ecan.com/\">");//invokeWebService是一个方法，后面地址为命名空间
		soap.append("<arg0>");
			StringBuffer xml = new StringBuffer("");
			xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
			xml.append("<paramsList>");
			xml.append("<param>");
			xml.append("<name>00100000</name>");
			xml.append("<value>11</value>");
			xml.append("</param>");
			xml.append("<param>");
			xml.append("<name>param</name>");
			xml.append("<value>");
			xml.append("<![CDATA[" + qzjXML() + "]]>");
			xml.append("</value>");
			xml.append("</param>");//<!--可能有多个参�?-->
			xml.append("</paramsList>");
			
		soap.append(StringEscapeUtils.escapeXml(xml.toString()));//xml�?��转义
		soap.append("</arg0>");
		soap.append("</nsa2:invokeWebService>");
		soap.append("</soap:Body>");
		soap.append("</soap:Envelope>");
		System.out.println("send soap:"+soap.toString());
		return soap.toString();
	}
	
	public static String qzjXML(){
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xml.append("<data>");
		xml.append("<orgNo>11</orgNo>");
		xml.append("<token>"+getToken()+"</token>");
		xml.append("<methodCode>getUserInfo</methodCode>");
		xml.append("<iscompress>1</iscompress>");
		xml.append("<serviceType>http</serviceType>");
		xml.append("<returnType>0</returnType>");
		xml.append("<params>");
		xml.append("<login>");
		xml.append("userid=00;hbdwbh=3501;password=1;operatorTime=2016-12-29");
		xml.append("</login>");
//		xml.append("<waixiu_guid>20150807083748977_11BA91F3685D4A30BDD158E143EC06B7</waixiu_guid>");
//		xml.append("<waixiu_guid>20160510170842999_6990B39FFD3D4399BCD02655FB615C06</waixiu_guid>");
		xml.append("</params>");
		xml.append("</data>");
		return xml.toString();
	}
	
	public static String getToken(){
		
		String token = "2N5keFqnKyjrMHeFBKJczg==";
//		Encrypt encrypt = new Encrypt();
		//String token = encrypt.get3DESEncrypt("gradeCure", "ecan");
//		System.out.println(token);
		return token;
	}
}
