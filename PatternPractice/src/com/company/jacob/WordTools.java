package com.company.jacob;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;



public class WordTools {
	
	
	private ActiveXComponent WordApp = null;//创建一个word程序
	private Dispatch document = null;//word文档内容
	
	public WordTools(){
		this.WordApp = new ActiveXComponent("Word.Application");
	}
	
	public void setLocation(int top,int left,int height,int width){
		Dispatch activeWindow = Dispatch.get(WordApp, "Application").toDispatch();
		Dispatch.put(activeWindow, "WindowState", new Variant(0));//0=default// 1=maximize// 2=minimize
		Dispatch.put(activeWindow, "Top", new Variant(top));
		Dispatch.put(activeWindow, "Left", new Variant(left));
		Dispatch.put(activeWindow, "Height", new Variant(height));
		Dispatch.put(activeWindow, "Width", new Variant(width));
	}
	
	public void createDocument(){
		Dispatch dp = Dispatch.get(WordApp, "Documents").toDispatch();
		document = Dispatch.call(dp, "Add").toDispatch();
	}
	
	public void openDocument(String filePath){
		Dispatch dp = Dispatch.get(WordApp, "Documents").toDispatch();
		/*第一个boolean表示 是否进行转换ConfirmConversions */   /*第二个boolean表示 是否只读 */
		document = Dispatch.call(dp, "Open",filePath,new Variant(true),new Variant(false)).toDispatch();
	}
	
	public void insertFormatStr(String text) {
		Dispatch wordContent = Dispatch.get(document, "Content").toDispatch(); // 取得word文件的内容
		Dispatch.call(wordContent, "InsertAfter", text);// 插入一个段落到最后
		Dispatch paragraphs = Dispatch.get(wordContent, "Paragraphs").toDispatch(); // 所有段落
		int paragraphCount = Dispatch.get(paragraphs, "Count").changeType(Variant.VariantInt).getInt();// 一共的段落数
//		printContent();
		// 找到刚输入的段落，设置格式
		Dispatch lastParagraph = Dispatch.call(paragraphs, "Item",new Variant(paragraphCount)).toDispatch(); // 最后一段（也就是刚插入的）
		// Range 对象表示文档中的一个连续范围，由一个起始字符位置和一个终止字符位置定义
		Dispatch lastParagraphRange = Dispatch.get(lastParagraph, "Range").toDispatch();
		Dispatch font = Dispatch.get(lastParagraphRange, "Font").toDispatch();
		Dispatch.put(font, "Bold", new Variant(true)); // 设置为黑体
		Dispatch.put(font, "Italic", new Variant(true)); // 设置为斜体
		Dispatch.put(font, "Name", new Variant("宋体")); //
		Dispatch.put(font, "Size", new Variant(12)); // 小四
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch();
		Dispatch.call(selection, "TypeParagraph");// 插入一个空行
		Dispatch alignment = Dispatch.get(selection, "ParagraphFormat").toDispatch();// 段落格式
		Dispatch.put(alignment, "Alignment", "2"); // (1:置中 2:靠右 3:靠左)
	}
	
	public void insertText(String content){
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch();
		Dispatch.call(selection, "MoveRight",new Variant(1),new Variant(1));
		Dispatch.put(selection, "Text",content);
		Dispatch.call(selection, "MoveRight",new Variant(1),new Variant(1));
	}
	
	public boolean replaceText(String toFindText, String newText) {
		if (!find(toFindText))
			return false;
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // 输入内容需要的对象
		Dispatch.put(selection, "Text", newText);
		return true;
	}
	
	public boolean find(String toFindText) {
		if (toFindText == null || toFindText.equals(""))
			return false;
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // 输入内容需要的对象
		// 从selection所在位置开始查询
		Dispatch find = Dispatch.call(selection, "Find").toDispatch();
		// 设置要查找的内容
		Dispatch.put(find, "Text", toFindText);
		// 向前查找
		Dispatch.put(find, "Forward", "True");
		// 设置格式
		Dispatch.put(find, "Format", "True");
		// 大小写匹配
		Dispatch.put(find, "MatchCase", "True");
		// 全字匹配
		Dispatch.put(find, "MatchWholeWord", "True");
		// 查找并选中
		return Dispatch.call(find, "Execute").getBoolean();
	}
	
	public void moveUp(int pos) {
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // 输入内容需要的对象
		for (int i = 0; i < pos; i++) {
			// MoveDown MoveLeft moveRight
			// moveStart ( Dispatch.call(selection, "HomeKey", new Variant(6));
			// )
			// moveEnd Dispatch.call(selection, "EndKey", new Variant(6));
			Dispatch.call(selection, "MoveUp");
		}
	}
	
	public void save(){
		Dispatch.call(document, "Save");
	}
	
	public void saveAs(String filePath){
		Dispatch.call(document, "SaveAs", filePath);
	}
	
	public void close(){
		Dispatch.call(document, "Close", new Variant(0));
		Dispatch.call(WordApp, "Quit");
	}
	public void insertJPEG(String path){
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch();
		Dispatch image = Dispatch.get(selection, "InLineShapes").toDispatch();
		Dispatch.call(image, "AddPicture",path);
	}
	
	public Dispatch insertTable(String tableTitle,int row,int col){
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch();
		Dispatch.call(selection, "TypeText",tableTitle);
		Dispatch.call(selection, "TypeParagraph"); // 空一行段落
		Dispatch.call(selection, "TypeParagraph"); // 空一行段落
		Dispatch.call(selection, "MoveDown"); // 游标往下一行
		
		Dispatch table = Dispatch.get(document, "Tables").toDispatch();
		Dispatch range = Dispatch.get(selection, "Range").toDispatch();
		Dispatch newTable = Dispatch.call(table, "Add", range, new Variant(row),new Variant(col),new Variant(1)).toDispatch();
		Dispatch cols = Dispatch.get(newTable, "Columns").toDispatch(); // 此表的所有列，
		int colCount = Dispatch.get(cols, "Count").changeType(Variant.VariantInt).getInt();// 一共有多少列 实际上这个数==column
		System.out.println(colCount + "列");
		for (int i = 1; i <= colCount; i++) { // 循环取出每一列
			Dispatch col1 = Dispatch.call(cols, "Item", new Variant(i)).toDispatch();
			Dispatch cells = Dispatch.get(col1, "Cells").toDispatch();// 当前列中单元格
			int cellCount = Dispatch.get(cells, "Count").changeType(Variant.VariantInt).getInt();// 当前列中单元格数 实际上这个数等于row
			for (int j = 1; j <= cellCount; j++) {// 每一列中的单元格数
				// Dispatch cell = Dispatch.call(cells, "Item", new
				// Variant(j)).toDispatch(); //当前单元格
				// Dispatch cell = Dispatch.call(newTable, "Cell", new
				// Variant(j) , new Variant(i) ).toDispatch(); //取单元格的另一种方法
				// Dispatch.call(cell, "Select");//选中当前单元格
				// Dispatch.put(selection, "Text",
				// "第"+j+"行，第"+i+"列");//往选中的区域中填值，也就是往当前单元格填值
				putTxtToCell(newTable, j, i, "第" + j + "行，第" + i + "列");// 与上面四句的作用相同
			}
		}
		return newTable;
	}
	
	public void mergeCell(Dispatch cell1, Dispatch cell2) {
		Dispatch.call(cell1, "Merge", cell2);
	}
	public void mergeCell(Dispatch table, int row1, int col1, int row2, int col2) {
		Dispatch cell1 = Dispatch.call(table, "Cell", new Variant(row1),
				new Variant(col1)).toDispatch();
		Dispatch cell2 = Dispatch.call(table, "Cell", new Variant(row2),
				new Variant(col2)).toDispatch();
		mergeCell(cell1, cell2);
	}
	
	public void putTxtToCell(Dispatch table, int cellRowIdx, int cellColIdx,
			String txt) {
		Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),
				new Variant(cellColIdx)).toDispatch();
		Dispatch.call(cell, "Select");
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // 输入内容需要的对象
		Dispatch.put(selection, "Text", txt);
	}
	
	public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx,
			String txt) {
		// 所有表格
		Dispatch tables = Dispatch.get(document, "Tables").toDispatch();
		// 要填充的表格
		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
				.toDispatch();
		Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),
				new Variant(cellColIdx)).toDispatch();
		Dispatch.call(cell, "Select");
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // 输入内容需要的对象
		Dispatch.put(selection, "Text", txt);
	}
	
	public void setVisible(boolean visible) {
		WordApp.setProperty("Visible", new Variant(visible));
		// 这一句作用相同
		// Dispatch.put(MsWordApp, "Visible", new Variant(visible));
	}
	
	//jacob-1.17-x86.dll  将改文件拷贝到java bin目录下
	public static void main2(String[] args) {
		String path = "E:\\mywork\\PatternPractice\\src\\com\\company\\jacob\\test.doc";
		//创建一个word程序
		WordTools wt = new WordTools();
//		wt.createDocument();
//		wt.setLocation(0, 0, 600, 800);
//		Dispatch table = wt.insertTable("hello word", 10, 10);
//		wt.mergeCell(table, 2, 1, 4, 5);
//		wt.saveAs(path);
		
		//====================================
		wt.openDocument(path);
		wt.insertFormatStr("t");
		wt.close();
	}
	public static void main(String[] args) {
		int i=1;
		int s= ++i + ++i+ ++i + ++i;
		System.out.println(s+"'"+i);
	}
}
