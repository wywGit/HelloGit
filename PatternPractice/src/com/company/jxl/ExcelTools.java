package com.company.jxl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.company.composite.Component;



public class ExcelTools {
	
	public static void main(String[] args) {
//		String path = "E:\\workspaces\\PatternPractice\\src\\com\\company\\jxl\\test.xls";
		String path="C:\\Users\\tp\\Desktop\\test2.xls";
		FileOutputStream os = null;
		WritableWorkbook wwb = null;
		try {
			File file = new File(path);
			os = new FileOutputStream(file);
			wwb = Workbook.createWorkbook(os);//�˴������� ���������File�Ļ�����֪��ΪʲôûЧ��
			WritableSheet ws1 = wwb.createSheet("sheetO", 0);
			WritableSheet ws2 = wwb.createSheet("sheetW", 1);
			WritableSheet ws3 = wwb.createSheet("sheetT", 2);
			
			WritableCellFormat wcf = new WritableCellFormat();
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setBackground(Colour.GRAY_25);
			wcf.setAlignment(Alignment.CENTRE);
			
			Label label = null;
			ws1.mergeCells(0, 0, 1, 0);//ws1.mergeCells(arg0, arg1, arg2, arg3):�ϲ���Ԫ�񣬴�arg0�е�arg2�У���arg1�е�arg3��
			label = new Label(0, 0, "����", wcf);
			ws1.addCell(label);
			
			ws1.mergeCells(2, 0, 3, 0);//�ϲ���0�е� 2,3��
			label = new Label(2, 0, "����", wcf);//�ӵ�0�еĵڶ��з���label
			ws1.addCell(label);
			
			ws1.mergeCells(4, 0, 5, 0);
			label = new Label(4, 0, "��ַ", wcf);
			ws1.addCell(label);
			
			wwb.write();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				wwb.close();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void Composite2Excel(Component comp,int deep){
		String path = "E:\\workspaces\\PatternPractice\\src\\com\\company\\jxl\\test.xls";
		FileOutputStream os = null;
		WritableWorkbook wwb = null;
		try{
			os = new FileOutputStream(new File(path));
			wwb = Workbook.createWorkbook(os);
			WritableSheet ws = wwb.createSheet("��״ͼ", 0);
			searchChild(ws,comp,0,0,deep);
			wwb.write();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				wwb.close();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	private static void searchChild(WritableSheet ws, Component comp, int c, int r, int deep) {
		
		try {
			WritableCellFormat wcf = new WritableCellFormat();
			getCellType(wcf, comp.getLevel()-deep);
			
			ws.mergeCells(c, r, c+1, r);
			Label label = new Label(c, r, comp.getName(), wcf);
			ws.addCell(label);
			List<Component> clist = comp.getChild();
			if(null!=clist && clist.size()!=0){
				c++;
				for(Component co:clist){
					r++;
					searchChild(ws,co,c,r,co.getLevel()-deep);
					if(null!=co.getChild()){//�жϵ�ǰ�ڵ�Ķ��Ӹ������б��������϶��Ӹ��� ��Ϊ��һ�п�ʼ
						r+=co.getChild().size();
					}
				}
			}
		} catch (WriteException e) {
			e.printStackTrace();
		}finally{
		}
	}
	
	/**
	 * ���ݺϳ����Ĳ�ͬ���� ��������ʾ��ʽ
	 * @since 2015-2-11
	 * @param wcf ����ʽ
	 * @param level �ϳ����ļ���
	 * @return void
	 * @author wuyw
	 */
	private static void getCellType(WritableCellFormat wcf,int level){
		Alignment ag = null;
		Colour c = null;
		Border b = null;
		BorderLineStyle bls = null;
		WritableFont font = null;
		//��ͬ������
		ag = Alignment.CENTRE;
		b = Border.ALL;
		bls = BorderLineStyle.THIN;
		//��������
		try {
			switch(level){
			case 0:
				c = Colour.GRAY_50;
				font = new WritableFont(WritableFont.ARIAL,14);
				font.setColour(Colour.BLACK);
				break;
			case 1:
				c = Colour.LIGHT_BLUE;
				font = new WritableFont(WritableFont.TAHOMA,10);
				font.setColour(Colour.GREY_50_PERCENT);
				break;
			case 2:
				c = Colour.OLIVE_GREEN;
				font = new WritableFont(WritableFont.TIMES,8);
				font.setColour(Colour.BLUE_GREY);
				break;
			default:
				c = Colour.WHITE;
				font = new WritableFont(WritableFont.COURIER,WritableFont.DEFAULT_POINT_SIZE);
				font.setColour(Colour.BLACK);
				break;
			}
			wcf.setAlignment(ag);
			wcf.setBackground(c);
			wcf.setBorder(b, bls);
			wcf.setFont(font);
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
