package com.citichma.common.util;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * excel导出工具类
 * @author JIXD 
 * @date 2016年9月17日 下午10:22:33  
 *
 */
public class ExcelExportUtil {

	private XSSFWorkbook book;

	private XSSFSheet sheet;

	public ExcelExportUtil(XSSFWorkbook book, XSSFSheet sheet) {
		super();
		this.book = book;
		this.sheet = sheet;
	}

	public void setRegionStyle(CellRangeAddress region, XSSFCellStyle cs) {

		int toprowNum = region.getFirstRow();
		for (int i = toprowNum; i <= region.getLastRow(); i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = region.getFirstColumn(); j <= region.getLastColumn(); j++) {
				XSSFCell cell = row.getCell(j);
				cell.setCellStyle(cs);
			}
		}
	}
	
	/**
	 * 
	 * 设置表头单元格样式 
	 * @param   
	 * @return 
	 * @date 2016年9月17日 下午10:21:38  
	 * @throws
	 */
	public XSSFCellStyle getHeadStyle()  
    {  
        // 创建单元格样式  
        XSSFCellStyle cellStyle = book.createCellStyle();  
        // 设置单元格的背景颜色为淡蓝色  
        cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);  
        cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);  
        // 设置单元格居中对齐  
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
        // 设置单元格垂直居中对齐  
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);  
        // 创建单元格内容显示不下时自动换行  
        cellStyle.setWrapText(true);  
        // 设置单元格字体样式  
        XSSFFont font = book.createFont();  
        // 设置字体加粗  
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 200);  
        cellStyle.setFont(font);  
        // 设置单元格边框为细线条  
        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);  
        return cellStyle;  
    }  
	
	
	/** 
     * 设置表体的单元格样式 
     *  
     * @return 
     */  
    public XSSFCellStyle getBodyStyle()  
    {  
        // 创建单元格样式  
        XSSFCellStyle cellStyle = book.createCellStyle();  
        // 设置单元格居中对齐  
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
        // 设置单元格垂直居中对齐  
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);  
        // 创建单元格内容显示不下时自动换行  
        cellStyle.setWrapText(true);  
        // 设置单元格字体样式  
        XSSFFont font = book.createFont();  
        // 设置字体加粗  
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 200);  
        cellStyle.setFont(font);  
        // 设置单元格边框为细线条  
        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);  
        return cellStyle;  
    }  
    
    public XSSFCellStyle getBodyDateStyle()  
    {  
        // 创建单元格样式  
        XSSFCellStyle cellStyle = book.createCellStyle();  
        short df=book.createDataFormat().getFormat("yyyy-MM-dd");
        // 设置单元格居中对齐  
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
        // 设置单元格垂直居中对齐  
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);  
        // 创建单元格内容显示不下时自动换行  
        cellStyle.setWrapText(true);  
        //设置日期格式
        cellStyle.setDataFormat(df);
        // 设置单元格字体样式  
        XSSFFont font = book.createFont();  
        // 设置字体加粗  
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 200);  
        cellStyle.setFont(font);  
        // 设置单元格边框为细线条  
        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);  
        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);  
        return cellStyle;  
    }  
}
