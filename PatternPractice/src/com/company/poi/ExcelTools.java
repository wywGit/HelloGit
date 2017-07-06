package com.company.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
		String path="C:\\Users\\WYW\\Desktop\\注册商户模板.xlsx";
		FileInputStream is = null;
		XSSFWorkbook wb = null;
		try {
			File file = new File(path);
			is = new FileInputStream(file);
			wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(0);
			int num = sheet.getLastRowNum();
			System.out.println(num);
			XSSFRow row = sheet.getRow(1);
			String s = row.getCell(1).getStringCellValue();
			System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				is.close();
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
			WritableSheet ws = wwb.createSheet("树状图", 0);
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
					if(null!=co.getChild()){//判断当前节点的儿子个数，列表行数加上儿子个数 作为新一行开始
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
	 * 根据合成树的不同级别 设置其显示格式
	 * @since 2015-2-11
	 * @param wcf 表格格式
	 * @param level 合成树的级别
	 * @return void
	 * @author wuyw
	 */
	private static void getCellType(WritableCellFormat wcf,int level){
		Alignment ag = null;
		Colour c = null;
		Border b = null;
		BorderLineStyle bls = null;
		WritableFont font = null;
		//共同的设置
		ag = Alignment.CENTRE;
		b = Border.ALL;
		bls = BorderLineStyle.THIN;
		//个别设置
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
