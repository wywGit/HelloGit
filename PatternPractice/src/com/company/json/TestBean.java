package com.company.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestBean {

	private int name;
	private String date;
	private int cell;
	
	public TestBean(){}
	public TestBean(int name,String date){
		this.setName(name);
		this.date=date;
	}
	/**实体里面多字段 或者 json串多属性 都不影响**/
	public static void main(String[] args) {
		String jsonStr = "{\"resCode\":\"0003\",\"signStr\":\"RoYTap5lQ0h0N0Tc8JRM6kl4b4fp50bBtOUhn87NaXbZc80czmjk1ZU/6gGseZhs/O9Qui15d5iyzBF4Q9PJiA==\"}";
//		String jsonStr = "{\"code\":100,\"msg\":\"success\",\"datas\":{\"user_guid\":\"20120209091540656_D68A2C372A0F483C9F9B5191EEB0FD6A\",\"hbdwbh\":\"3501\",\"login_dwbh\":\"0101,0102,0103,0104,0105,201,202,203,204,205,206,207\",\"login_dwbh_list\":null,\"default_login_dwbh\":\"0101\",\"userid\":\"00\",\"password\":\"C4CA4238A0B923820DCC509A6F75849B\",\"encode_password\":null,\"truename\":\"系统隐藏用户\",\"usersex\":\"男\",\"userage\":0,\"dept_guid\":\"20160525085847620_ED23601CF12D4B8D922AEEED92B2F54E\",\"dept_id\":\"405\",\"dept_name\":null,\"dept_id_name\":null,\"isSystemUser\":\"1\",\"createTime\":\"2012-02-09 09:15:40\",\"loginTime\":null,\"mobile_phone\":\"\",\"family_phone\":\"\",\"user_idcard\":\"\",\"user_jibie\":null,\"user_state\":null,\"user_zhineng\":null,\"user_gangwei\":\"1,2,5,6,12,20,29\",\"user_type\":null,\"user_zhichen\":null,\"user_zhiwu\":null,\"is_stop\":\"0\",\"roleList\":[],\"role_list_str\":\"\",\"gangwei_idList\":[],\"gangwei_codeList\":[],\"gangwei_codeListStr\":\"\"}}";
//		String jsonStr2 = "[{\"dates\":\"new Date()\",\"name\":\"123\",\"add\":\"123\",\"cell\":12},{\"date\":\"new Date()\",\"name\":\"133\"}]";
//		JSONArray ja = JSONArray.fromObject(jsonStr);
		JSONObject jo = JSONObject.fromObject(jsonStr);
		
		System.out.println(jo.getString("resCode"));
		
//		TestBean tb2 = new TestBean();
//		tb2 = (TestBean) JSONObject.toBean(ja.getJSONObject(0),TestBean.class);
//		System.out.println(tb2);
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getName() {
		return name;
	}
	public void setCell(int cell) {
		this.cell = cell;
	}
	public int getCell() {
		return cell;
	}
	@Override
	public String toString() {
		return "name:"+name+",date:"+date+",cell:"+cell;
	}
}
