package com.company.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import sun.misc.Regexp;

public class Test{
//	public static NewTest s = new NewTest();
	private String mypri;
	public String mypub;
//	static{
//		System.out.println("class static");
//	}
	public Test(){
		print();
		System.out.println("class con");
		
	}
	public Test(String name){
		print();
		System.out.println("class con:"+name);
	}
	public void print(){
		System.out.println("class print");
	}
	//按日期排序
	public static void orderByDate(String fliePath) {
	   File file = new File(fliePath);
	   File[] fs = file.listFiles();
	   Arrays.sort(fs,new Comparator< File>(){
		   public int compare(File f1, File f2) {
		   long diff = f1.lastModified() - f2.lastModified();
		   if (diff > 0)
			  return 1;
		   else if (diff == 0)
			  return 0;
		   else
			  return -1;
		   }
		   public boolean equals(Object obj) {
		   	  return true;
		   }
	   });
       for (int i = fs.length-1; i >-1; i--) {
		   System.out.println(fs[i].getName());
		   System.out.println(new Date(fs[i].lastModified()));
       }
	}
	public static void main(String[] args) {
		try{
//			String str = "0x3C68746D6C3E3C686561643E3C7469746C653EE4BD8FE999A2E79785E58E863C2F7469746C653E0D0A3C6D65746120687474702D65717569763D22436F6E74656E742D547970652220636F6E74656E743D22746578742F68746D6C3B20636861727365743D5554462D38223E0D0A3C2F686561643E0D0A3C626F6479206267636F6C6F723D222366666666666622206C6566746D617267696E3D383320746F706D617267696E3D3133342072696768746D617267696E3D353720626F74746F6D6D617267696E3D38323E0D0A3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763EE5A793E5908DEFBC9AE5BCA0E88DA3E5969C20266E6273703B20E680A7E588ABEFBC9AE794B720E5B9B4E9BE84EFBC9A2D20266E6273703BE5A99AE5A7BBEFBC9A20266E6273703BE8818CE4B89AEFBC9A20266E6273703B20266E6273703BE6B091E6978FEFBC9A3C2F6469763E0D0A3C6469763EE587BAE7949FE59CB0EFBC9A2D2DE58EBFEFBC88E5B882EFBC89E79785E58FB2E99988E8BFB0E88085EFBC9AE682A3E88085E69CACE4BABA20266E6273703B20266E6273703B20266E6273703BE58FAFE99DA0E7A88BE5BAA6EFBC9A616161613C2F6469763E0D0A3C6469763EE58D95E4BD8DEFBC9A2D20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20E59CB0E59D80EFBC9A2D3C2F6469763E0D0A3C6469763EE585A5E999A2E697A5E69C9FEFBC9A323031332D30312D31352031303A343720266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703BE79785E58FB2E98787E99B86E697A5E69C9FEFBC9A323031322D31322D31382031373A32383C2F6469763E0D0A3C6469763EE8AEB0E5BD95E697A5E69C9FEFBC9A323031322D31322D31382031373A3238203C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E3C623EE4B8BB266E6273703B20E8AF89EFBC9A3C2F623EE58F8DE5A48DE592B3E597BD31E69C88E4BD99E380823C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E3C623EE78EB0E79785E58FB2EFBC9A3C2F623EE682A3E88085E4BA8E31E69C88E4BD99E5A4A9E5898DE5A78BE587BAE78EB0E797B0E9878FE5B091EFBC8CE889B2E9BB84EFBC8CE697A0E58F91E783ADEFBC8CE59CA8E5AEB6E58FA3E69C8DE2809CE4B889E4B99DE6849FE58692E9A297E7B292E38081E5B79DE8B49DE69E87E69DB7E8868FE38081E6849FE58692E6B885E9A297E7B292E2809DE5908EE592B3E597BDEFBC8CE592B3E797B0EFBC8CE697A0E7BC93E8A7A3EFBC8CE4BA8EE4B8A4E5A4A9E5898DE58F91E783ADEFBC8CE4BD93E6B8A9E9AB9833392E30E28483EFBC8CE5B0B1E8AF8AE4BA8EE5B882E7ACACE4B880E58CBBE999A2E69FA5E8A180E5B8B8E8A784EFBC9A57424332302E31C39731303C666F6E742073697A653D343E3C7375703E393C2F7375703E3C2F666F6E743E2F4CEFBC8C4E20266E6273703B37382E3225E38082E883B8E78987E7A4BAEFBC9AE58FB3E882BAE4B8ADE4B88BE9878EE69691E78987E5BDB1EFBC8CE8AF8AE696ADE4B8BAEFBC9AE58FB3E882BAE7828EE38082E7BB99E4BA88E2809CE998BFE5A587E99C89E7B4A0E38081E5A4B4E5ADA2E590A1E8829FE2809DE99D99E6B3A8E4B8A4E5A4A9EFBC8CE5BBBAE8AEAEE4BD8FE999A2E6B2BBE79697EFBC8CE59BA0E697A0E5BA8AE4BD8DE8BDACE887B3E68891E999A2E38082E997A8E8AF8AE68B9F312EE58FB3E882BAE7828E322EE9AB98E8A180E58E8BE694B6E585A5E68891E7A791E38082E682A3E88085E887AAE58F91E79785E4BBA5E69DA5E7B2BEE7A59EE6ACA0E4BDB3E38081E5A4A7E5B08FE4BEBFE6ADA3E5B8B8E38081E4BD93E9878DE697A0E5878FE8BDBBE380823C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E3C623EE697A2E5BE80E58FB2EFBC9A3C2F623EE58F91E78EB0E9AB98E8A180E58E8B352D36E5B9B4EFBC8CE5B9B3E697B6E58FA3E69C8DE68A97E9AB98E8A180E58E8BE88DAFEFBC8CE8A180E58E8BE68EA7E588B6E5B9B3E7A8B3E38082E4B8A4E5B9B4E5898DE69BBEE682A3E2809CE882BE20E7828EE2809DE78EB0E4BB8DE58FA3E69C8DE2809CE882BEE7828EE78987E2809DE38082E590A6E8AEA4E2809CE8829DE7828EE38081E7BB93E6A0B8E2809DE7AD89E4BCA0E69F93E79785E58FB2EFBC8CE590A6E8AEA4E2809CE586A0E5BF83E79785E2809DE7AD89E685A2E680A7E796BEE79785E58FB2E38082E590A6E8AEA4E2809CE5BF83E38081E88491E38081E884BEE38081E882BEE38081E8829DE2809DE7AD89E9878DE8A681E8848FE599A8E796BEE79785E58FB2E38082E697A0E88DAFE789A9E8BF87E6958FE58FB2EFBC8CE9A284E998B2E68EA5E7A78DE58FB2E4B88DE8AFA6E380823C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E3C623EE4B8AAE4BABAE58FB2EFBC9A3C2F623EE7949FE5B185E4BA8EE58E9FE7B18DE38082E697A0E796ABE6BA90E59CB0E995BFE69C9FE5B185E4BD8FE58FB2E38082E697A0E7839FE98592E7AD89E4B88DE889AFE5979CE5A5BDE380823C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E3C623EE5A99AE882B2E58FB2EFBC9A3C2F623EE5B7B2E5A99AEFBC8CE5B7B2E882B2EFBC8CE788B1E4BABAE58F8AE5AD90E5A5B3E4BD93E581A5E380823C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E3C623EE5AEB6E6978FE58FB2EFBC9A3C2F623EE590A6E8AEA4E69C89E2809CE9AB98E8A180E58E8BE79785E38081E7B396E5B0BFE79785E7AD89E2809DE5AEB6E6978FE98197E4BCA0E680A7E796BEE79785EFBC8CE697A0E7B2BEE7A59EE79785E58FB2E380823C2F6469763E0D0A3C64697620616C69676E3D63656E7465723E3C623EE4BD93E6A0BCE6A380E69FA53C2F623E203C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E20266E6273703B20266E6273703B20266E6273703B54EFBC9A33382E32E28483EFBC8C20266E6273703B20266E6273703B20266E6273703B50EFBC9A31303062706DEFBC8C20266E6273703B20266E6273703B20266E6273703B52EFBC9A323462706DEFBC8C20266E6273703B20266E6273703B20266E6273703B4270EFBC9A3132302F39306D6D4867EFBC8C3C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793EE58F91E882B2E6ADA3E5B8B8EFBC8CE890A5E585BBE4B8ADE7AD89EFBC8CE680A5E680A7E99DA2E5AEB9EFBC8CE7A59EE5BF97E6B885E6A59AEFBC8CE887AAE4B8BBE4BD93E4BD8DEFBC8CE6A380E69FA5E59088E4BD9CEFBC8CE8B5B0E585A5E999A2EFBC8CE99DA2E5AEB9E781B0E69A97EFBC8CE79AAEE882A4E6B8A9E5BAA6E6ADA3E5B8B8EFBC8CE5BCB9E680A7E58FAFEFBC8CE697A0E6B0B4E882BFE38081E79AAEE796B9E38081E79880E782B9E38081E7B4ABE7999CE38081E79AAEE4B88BE7BB93E88A82E38081E882BFE59D97EFBC8CE697A0E8829DE68E8CE38081E6BA83E796A1E5928CE796A4E79795EFBC8CE6AF9BE58F91E58886E5B883E6ADA3E5B8B8E38082E9A288E5898DE38081E9A288E5908EE38081E99481E9AAA8E4B88AE7AA9DE38081E8858BE7AA9DE38081E6BB91E8BDA6E4B88AE38081E885B9E882A1E6B29FE7AD89E6B585E8A1A8E6B78BE5B7B4E7BB93E59D87E69CAAE8A7A6E58F8AE38082E5A4B4E9A285E5A4A7E5B08FE6ADA3E5B8B8E38081E697A0E795B8E5BDA2EFBC8CE697A0E882BFE59D97EFBC8CE697A0E58E8BE7979BEFBC8CE697A0E796A4E79795EFBC8CE6AF9BE58F91E58886E5B883E6ADA3E5B8B8E38082E79C89E6AF9BE697A0E884B1E890BDEFBC8CE697A0E58092E79DABEFBC8CE79CBCE79D91E697A0E4B88BE59E82EFBC8CE79CBCE79083E697A0E7AA81E587BAEFBC8CE7BB93E8869CE697A0E58585E8A180EFBC8CE5B7A9E8869CE697A0E9BB84E69F93EFBC8CE8A792E8869CE697A0E796A4E79795EFBC8CE79EB3E5AD94E79BB4E5BE84336D6DEFBC8CE79CBCE79083E8BF90E58AA8E6ADA3E5B8B8EFBC8CE5AFB9E58589E58F8DE5B084E6ADA3E5B8B8EFBC8CE880B3E5BB93E697A0E795B8E5BDA2EFBC8CE5A496E880B3E98193E697A0E58886E6B38CE789A9EFBC8CE4B9B3E7AA81E697A0E58E8BE7979BE38081E590ACE58A9BE6ADA3E5B8B8E38082E9BCBBE5A4A7E5B08FE6ADA3E5B8B8E38081E697A0E795B8E5BDA2E38081E697A0E9BCBBE7BFBCE68987E58AA8E38081E5A496E9BCBBE98193E697A0E5BC82E5B8B8E58886E6B38CE789A9E38081E9BCBBE88594E9809AE79585EFBC8CE9BCBBE4B8ADE99A94E697A0E5818FE69BB2EFBC8CE59084E589AFE9BCBBE7AAA6E697A0E58E8BE7979BE38082E58FA3E88594E697A0E5BC82E5B8B8E6B094E591B3E38081E59487E697A0E7B4ABE7BB80E38081E58FA3E59487E697A0E796B1E796B9EFBC8CE697A0E9BE8BE9BDBFE38081E78999E9BE88E697A0E587BAE8A180E38081E697A0E6BAA2E88493EFBC8CE8888CE5A4A7E5B08FE6ADA3E5B8B8E38081E8888CE88B94E6ADA3E5B8B8EFBC8CE4BCB8E8888CE5B185E4B8ADE38081E8888CE8828CE697A0E8908EE7BCA9E38081E697A0E8888CE9A2A4EFBC8CE9A28AE9BB8FE8869CE697A0E6BA83E796A1E38081E697A0E889B2E7B4A0E6B289E79D80EFBC8CE592BDE697A0E58585E8A180EFBC8CE682ACE99B8DE59E82E5B185E4B8ADEFBC8CE68981E6A183E4BD93E697A0E882BFE5A4A7E38081E697A0E58585E8A180EFBC8CE58F91E99FB3E6ADA3E5B8B8E38082E9A288E8BDAFE697A0E68AB5E68A97EFBC8CE9A288E99D99E88489E697A0E68092E5BCA0EFBC8CE8829DE9A288E99D99E88489E59B9EE6B581E5BE81E998B4E680A7EFBC8CE9A288E58AA8E88489E697A0E5BC82E5B8B8E6908FE58AA8EFBC8CE6B094E7AEA1E5B185E4B8ADEFBC8CE794B2E78AB6E885BAE697A0E882BFE5A4A7E38082E883B8E5BB93E697A0E795B8E5BDA2EFBC8CE883B8E9AAA8E697A0E58E8BE7979BEFBC8CE591BCE590B8E5B9B3E7A8B3EFBC8CE4B9B3E5A4B4E5A4A7E5B08FE6ADA3E5B8B8E38081E697A0E587B9E999B7EFBC8CE4B9B3E688BFE697A0E5BC82E5B8B8E58886E6B38CE789A9EFBC8CE883B8E5A381E99D99E88489E697A0E69BB2E5BCA0EFBC8CE591BCE590B8E5AFB9E7A7B0EFBC8CE8828BE997B4E99A99E697A0E5A29EE5AEBDEFBC8CE885B9E5BC8FE591BCE590B8E4B8BAE4B8BBEFBC8CE58F8CE4BEA7E591BCE590B8E5AFB9E7A7B0EFBC8CE58F8CE4BEA7E8AFADE9A2A4E6ADA3E5B8B8E38081E5AFB9E7A7B0EFBC8CE697A0E883B8E8869CE691A9E693A6E6849FEFBC8CE697A0E79AAEE4B88BE68DBBE58F91E6849FEFBC8CE58F8CE882BAE58FA9E8AF8AE6B885E99FB3EFBC8CE882BAE4B88BE7958CE6ADA3E5B8B8E38082E58F8CE882BAE591BCE590B8E99FB3E6B885EFBC8CE58F8CE882BAE58FAFE997BBE58F8AE5B091E8AEB8E6B9BFE680A7E595B0E99FB3E697A0E883B8E8869CE691A9E693A6E99FB3EFBC8CE8AFADE99FB3E4BCA0E5AFBCE6ADA3E5B8B8E38082E5BF83E5898DE58CBAE697A0E795B8E5BDA2EFBC8CE5BF83E5B096E6908FE58AA8E4BD8DE4BA8EE7ACACE285A4E8828BE997B4E5B7A6E99481E9AAA8E58685302E35636DE38082E6908FE58AA8E88C83E59BB4E7BAA632636DEFBC8CE69CAAE8A7A6E58F8AE68AACE4B8BEE680A7E5BF83E5B096E6908FE58AA8EFBC8CE697A0E99C87E9A2A4EFBC8CE697A0E5BF83E58C85E691A9E693A6E6849FEFBC8CE5BF83E7958CE58FA9E8AF8AE59CA8E6ADA3E5B8B8E88C83E59BB4EFBC8C485231303062706DEFBC8CE5BE8BE9BD90EFBC8C4132EFBC9E5032EFBC8CE5BF83E99FB3E58FAFEFBC8CE59084E793A3E8869CE590ACE8AF8AE58CBAE69CAAE997BBE58F8AE8A180E7AEA1E69D82E99FB3EFBC8CE697A0E6AF9BE7BB86E8A180E7AEA1E6908FE58AA8E5BE81EFBC8CE885B9E5B9B3EFBC8CE69CAAE8A781E88383E59E8BE882A0E59E8BE58F8AE88383E882A0E8A095E58AA8E6B3A2EFBC8CE697A0E79AAEE796B9EFBC8CE697A0E889B2E7B4A0E6B289E79D80EFBC8CE697A0E7969DE6B094E38081E697A0E796A4E79795EFBC8CE885B9E5A381E99D99E88489E697A0E69BB2E5BCA0EFBC8CE69CAAE8A781E5B180E983A8E99A86E8B5B7EFBC8CE585A8E885B9E8BDAFEFBC8CE8829DE884BEE8828BE4B88BE69CAAE8A7A6E58F8AEFBC8CE69CAAE8A7A6E58F8AE58C85E59D97EFBC8CE585A8E885B9E697A0E58E8BE7979BE58F8DE8B7B3E7979BEFBC8CE59084E8BE93E5B0BFE7AEA1E782B9E697A0E58E8BE7979BEFBC8CE697A0E7A7BBE58AA8E680A7E6B58AE99FB3EFBC8CE8829DE58CBAE38081E58F8CE882BEE58CBAE697A0E58FA9E587BBE7979BEFBC8CE8829DE4B88AE7958CE59CA8E58FB3E99481E9AAA8E4B8ADE7BABFE7ACACE285A3E8828BE997B4EFBC8CE882A0E9B8A3E99FB3E6ADA3E5B8B8EFBC8CE885B9E4B8BBE58AA8E88489E58CBAE58F8CE882BEE58CBAE69CAAE997BBE58F8AE8A180E7AEA1E69D82E99FB3EFBC8CE697A0E68CAFE6B0B4E99FB3EFBC8CE8848AE69FB1E697A0E795B8E5BDA2EFBC8CE697A0E58E8BE7979BE38081E58FA9E587BBE7979BEFBC8CE6B4BBE58AA8E6ADA3E5B8B8EFBC8CE58F8CE4B88BE882A2E697A0E6B5AEE882BFE38082E7A59EE7BB8FE7B3BBE7BB9FE6A380E69FA5EFBC9AE9A285E7A59EE7BB8FEFBC88EFBC8DEFBC89EFBC8CE9A288E697A0E68AB5E68A97EFBC8CE58F8CE9BCBBE59487E6B29FE5AFB9E7A7B0EFBC8CE58FA3E8A792E697A0E6ADAAE6969CEFBC8CE58F8CE4BEA7E882A2E4BD93E8828CE58A9BE6ADA3E5B8B8E38081E8828CE5BCA0E58A9BE6ADA3E5B8B8E5AFB9E7A7B0EFBC8CE58F8CE5B7B4E6B08FE5BE81E998B4E680A7E38082266E6273703B203C2F6469763E0D0A3C64697620616C69676E3D63656E7465723E3C623EE4B893E7A791E6A380E69FA53C2F623E3C623E20266E6273703B203C2F623E3C2F6469763E0D0A3C64697620616C69676E3D63656E7465723E3C666F6E7420636F6C6F723D2223666666666666223EE8BE85E58AA9E6A380E69FA53C2F666F6E743E20266E6273703B3C2F6469763E0D0A3C64697620616C69676E3D63656E7465723EE69A82E697A0616161616161616161616161616161616161613C2F6469763E0D0A3C6469763E626262626262626262626262626262626262626262623C2F6469763E0D0A3C6469763E3C7461626C652077696474683D22313030252220626F726465723D302063656C6C70616464696E673D3020626F72646572636F6C6F723D2223303030303030222063656C6C73706163696E673D303E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D323639206865696768743D32323E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE587BAE999A2E8AF8AE696ADEFBC9A3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C74642077696474683D333737206865696768743D32323E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE5889DE6ADA5E8AF8AE696ADEFBC9A3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D323639206865696768743D32343E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763EE88491E6A297E5A19E783C7375703E393939393C2F7375703E203C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C74642077696474683D333737206865696768743D32343E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763EE88491E6A297E5A19E783C7375703E393939393C2F7375703E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C2F7461626C653E0D0A3C2F6469763E0D0A3C6469763E3C7461626C652077696474683D22313030252220626F726465723D302063656C6C70616464696E673D3020626F72646572636F6C6F723D2223303030303030222063656C6C73706163696E673D303E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D323435206865696768743D31383E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E58CBBE7949FEFBC9A3C2F623E3C623E20266E6273703B20266E6273703B3C2F623E3C623EE58CBBE7949FE7ADBEE5908D3C2F623E3C623E20266E6273703B3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C74642077696474683D333432206865696768743D31383E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E58CBBE7949FEFBC9A3C2F623E3C623E20266E6273703B20266E6273703B3C2F623E3C623EE58CBBE7949FE7ADBEE5908D3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D323435206865696768743D32303E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E697A5E69C9FEFBC9A3C2F623E3C623EE8AEB0E5BD95E697A5E69C9F3C2F623E3C623E203C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C74642077696474683D333432206865696768743D32303E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E697A5E69C9FEFBC9A3C2F623E3C623EE8AEB0E5BD95E697A5E69C9F3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C2F7461626C653E0D0A3C2F6469763E0D0A3C6469763E3C7461626C652077696474683D22313030252220626F726465723D302063656C6C70616464696E673D3020626F72646572636F6C6F723D2223303030303030222063656C6C73706163696E673D303E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D333738206865696768743D31383E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE585A5E999A2E8AF8AE696ADEFBC9A3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D333738206865696768743D34343E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763EE88491E6A297E5A19E783C7375703E393939393C2F7375703E203C2F6469763E0D0A3C6469763E473C7375703E323C2F7375703E503C7375703E323C2F7375703E203C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D333738206865696768743D31393E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E58CBBE7949FEFBC9A3C2F623E3C623E20266E6273703B20266E6273703B3C2F623E3C623EE58CBBE7949FE7ADBEE5908D3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D333738206865696768743D31353E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E697A5E69C9FEFBC9A3C2F623E3C623EE8AEB0E5BD95E697A5E69C9F3C2F623E3C623E203C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C2F7461626C653E0D0A3C2F6469763E0D0A3C6469763E3C7461626C652077696474683D22313030252220626F726465723D302063656C6C70616464696E673D3020626F72646572636F6C6F723D2223303030303030222063656C6C73706163696E673D303E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D333830206865696768743D32343E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8BDACE587BAE8AF8AE696ADEFBC9A3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D3338303E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C62723E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D333830206865696768743D32323E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763EE8AEB0E5BD95E58CBBE7949FEFBC9A3C2F6469763E0D0A3C6469763E3C623EE8AEB0E5BD95E58CBBE7949FEFBC9A3C2F623E3C623E20266E6273703B20266E6273703B3C2F623E3C623EE58CBBE7949FE7ADBEE5908D3C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74642077696474683D3338303E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E697A5E69C9FEFBC9A3C2F623E3C623EE8AEB0E5BD95E697A5E69C9F3C2F623E3C623E203C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C2F7461626C653E0D0A3C2F6469763E0D0A3C6469763E3C7461626C652077696474683D22313030252220626F726465723D302063656C6C70616464696E673D3020626F72646572636F6C6F723D2223303030303030222063656C6C73706163696E673D303E0D0A3C74722076616C69676E3D746F703E0D0A3C7464206865696768743D32323E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763EE8BDACE585A5E8AF8AE696ADEFBC9A3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74643E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C62723E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C7464206865696768743D31393E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E58CBBE7949FEFBC9A3C2F623E3C623E20266E6273703B20266E6273703B3C2F623E3C623EE58CBBE7949FE7ADBEE5908D3C2F623E3C623E203C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C74722076616C69676E3D746F703E0D0A3C74643E3C666F6E742073697A653D3320636F6C6F723D22233030303030302220666163653D22E5AE8BE4BD93223E0D0A3C6469763E3C623EE8AEB0E5BD95E697A5E69C9FEFBC9A3C2F623E3C623EE8AEB0E5BD95E697A5E69C9F3C2F623E3C623E203C2F623E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F74643E0D0A3C2F74723E0D0A3C2F7461626C653E0D0A3C2F6469763E0D0A3C6469763E3C623E20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B203C2F623E3C2F6469763E0D0A3C6469763E3C623E20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B20266E6273703B3C2F623E3C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E203C2F6469763E0D0A3C64697620616C69676E3D6A7573746966793E3C62723E3C2F6469763E0D0A3C2F666F6E743E0D0A3C2F626F64793E3C2F68746D6C3E0D0A";
//			System.out.println(Integer.parseInt(str));
//			FinalImpl f = new FinalImpl();
//			f.doFianl();
			TestImpl ti = new TestImpl();
			ti.t();
		}catch(Exception e){
		}finally{
//			System.out.println(3<<2);
		}
	}
	
	/**
	 * 按字节截取字符串
	 * @since 2015-3-10
	 * @param str 需截取的字符串
	 * @param num 需截取多少字节
	 * @author wuyw
	 */
	public static void splitByByte(String str,int num){
		StringBuffer sb = new StringBuffer();
		int tmp=0;
		for(int i=0; i<str.length(); i++){
			String c = str.charAt(i)+"";
			if(c.getBytes().length>1){
				tmp+=2;
			}else{
				tmp+=1;
			}
			if(tmp>num){
				break;
			}else{
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}
	public static void sortByPUPO(int[] arr){
		for(int i=0; i<arr.length; i++){
			boolean flag = false;
			for(int j=0; j<arr.length-1; j++){
				if(arr[j] < arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					flag=true;
				}
			}
			printArr(arr);
			if(!flag)break;
		}
	}
	
	public static void sortBySwap(int[] arr){
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]<arr[j]){
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			printArr(arr);
		}
	}
	
	public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}

}
