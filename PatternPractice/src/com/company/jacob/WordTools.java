package com.company.jacob;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;



public class WordTools {
	
	
	private ActiveXComponent WordApp = null;//����һ��word����
	private Dispatch document = null;//word�ĵ�����
	
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
		/*��һ��boolean��ʾ �Ƿ����ת��ConfirmConversions */   /*�ڶ���boolean��ʾ �Ƿ�ֻ�� */
		document = Dispatch.call(dp, "Open",filePath,new Variant(true),new Variant(false)).toDispatch();
	}
	
	public void insertFormatStr(String text) {
		Dispatch wordContent = Dispatch.get(document, "Content").toDispatch(); // ȡ��word�ļ�������
		Dispatch.call(wordContent, "InsertAfter", text);// ����һ�����䵽���
		Dispatch paragraphs = Dispatch.get(wordContent, "Paragraphs").toDispatch(); // ���ж���
		int paragraphCount = Dispatch.get(paragraphs, "Count").changeType(Variant.VariantInt).getInt();// һ���Ķ�����
//		printContent();
		// �ҵ�������Ķ��䣬���ø�ʽ
		Dispatch lastParagraph = Dispatch.call(paragraphs, "Item",new Variant(paragraphCount)).toDispatch(); // ���һ�Σ�Ҳ���Ǹղ���ģ�
		// Range �����ʾ�ĵ��е�һ��������Χ����һ����ʼ�ַ�λ�ú�һ����ֹ�ַ�λ�ö���
		Dispatch lastParagraphRange = Dispatch.get(lastParagraph, "Range").toDispatch();
		Dispatch font = Dispatch.get(lastParagraphRange, "Font").toDispatch();
		Dispatch.put(font, "Bold", new Variant(true)); // ����Ϊ����
		Dispatch.put(font, "Italic", new Variant(true)); // ����Ϊб��
		Dispatch.put(font, "Name", new Variant("����")); //
		Dispatch.put(font, "Size", new Variant(12)); // С��
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch();
		Dispatch.call(selection, "TypeParagraph");// ����һ������
		Dispatch alignment = Dispatch.get(selection, "ParagraphFormat").toDispatch();// �����ʽ
		Dispatch.put(alignment, "Alignment", "2"); // (1:���� 2:���� 3:����)
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
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // ����������Ҫ�Ķ���
		Dispatch.put(selection, "Text", newText);
		return true;
	}
	
	public boolean find(String toFindText) {
		if (toFindText == null || toFindText.equals(""))
			return false;
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // ����������Ҫ�Ķ���
		// ��selection����λ�ÿ�ʼ��ѯ
		Dispatch find = Dispatch.call(selection, "Find").toDispatch();
		// ����Ҫ���ҵ�����
		Dispatch.put(find, "Text", toFindText);
		// ��ǰ����
		Dispatch.put(find, "Forward", "True");
		// ���ø�ʽ
		Dispatch.put(find, "Format", "True");
		// ��Сдƥ��
		Dispatch.put(find, "MatchCase", "True");
		// ȫ��ƥ��
		Dispatch.put(find, "MatchWholeWord", "True");
		// ���Ҳ�ѡ��
		return Dispatch.call(find, "Execute").getBoolean();
	}
	
	public void moveUp(int pos) {
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // ����������Ҫ�Ķ���
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
		Dispatch.call(selection, "TypeParagraph"); // ��һ�ж���
		Dispatch.call(selection, "TypeParagraph"); // ��һ�ж���
		Dispatch.call(selection, "MoveDown"); // �α�����һ��
		
		Dispatch table = Dispatch.get(document, "Tables").toDispatch();
		Dispatch range = Dispatch.get(selection, "Range").toDispatch();
		Dispatch newTable = Dispatch.call(table, "Add", range, new Variant(row),new Variant(col),new Variant(1)).toDispatch();
		Dispatch cols = Dispatch.get(newTable, "Columns").toDispatch(); // �˱�������У�
		int colCount = Dispatch.get(cols, "Count").changeType(Variant.VariantInt).getInt();// һ���ж����� ʵ���������==column
		System.out.println(colCount + "��");
		for (int i = 1; i <= colCount; i++) { // ѭ��ȡ��ÿһ��
			Dispatch col1 = Dispatch.call(cols, "Item", new Variant(i)).toDispatch();
			Dispatch cells = Dispatch.get(col1, "Cells").toDispatch();// ��ǰ���е�Ԫ��
			int cellCount = Dispatch.get(cells, "Count").changeType(Variant.VariantInt).getInt();// ��ǰ���е�Ԫ���� ʵ�������������row
			for (int j = 1; j <= cellCount; j++) {// ÿһ���еĵ�Ԫ����
				// Dispatch cell = Dispatch.call(cells, "Item", new
				// Variant(j)).toDispatch(); //��ǰ��Ԫ��
				// Dispatch cell = Dispatch.call(newTable, "Cell", new
				// Variant(j) , new Variant(i) ).toDispatch(); //ȡ��Ԫ�����һ�ַ���
				// Dispatch.call(cell, "Select");//ѡ�е�ǰ��Ԫ��
				// Dispatch.put(selection, "Text",
				// "��"+j+"�У���"+i+"��");//��ѡ�е���������ֵ��Ҳ��������ǰ��Ԫ����ֵ
				putTxtToCell(newTable, j, i, "��" + j + "�У���" + i + "��");// �������ľ��������ͬ
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
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // ����������Ҫ�Ķ���
		Dispatch.put(selection, "Text", txt);
	}
	
	public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx,
			String txt) {
		// ���б��
		Dispatch tables = Dispatch.get(document, "Tables").toDispatch();
		// Ҫ���ı��
		Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
				.toDispatch();
		Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),
				new Variant(cellColIdx)).toDispatch();
		Dispatch.call(cell, "Select");
		Dispatch selection = Dispatch.get(WordApp, "Selection").toDispatch(); // ����������Ҫ�Ķ���
		Dispatch.put(selection, "Text", txt);
	}
	
	public void setVisible(boolean visible) {
		WordApp.setProperty("Visible", new Variant(visible));
		// ��һ��������ͬ
		// Dispatch.put(MsWordApp, "Visible", new Variant(visible));
	}
	
	//jacob-1.17-x86.dll  �����ļ�������java binĿ¼��
	public static void main2(String[] args) {
		String path = "E:\\mywork\\PatternPractice\\src\\com\\company\\jacob\\test.doc";
		//����һ��word����
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
