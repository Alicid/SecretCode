package com.kh.sc.admin.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExcelManagerImpl implements POIExcelManager{

	protected XSSFWorkbook GetXSSFWorkbook(String aFileName) {
		
		XSSFWorkbook workbook = null;
		
		try {
			FileInputStream file = new FileInputStream(new File(aFileName));
			workbook = new XSSFWorkbook(file);
			file.close();
		} catch (Exception e) {
			return null;
		}
		
		return workbook;
	}
	
	protected XSSFSheet GetXSSFSheet(String aFileName, int aSheetNumber) {
		XSSFWorkbook workbook = this.GetXSSFWorkbook(aFileName);
		XSSFSheet sheet = null;
		
		if(workbook==null) {
			return null;
		}
		try {
			sheet = workbook.getSheetAt(aSheetNumber);
		}catch(Exception e) {
			return null;
		}
		return sheet;
	}
	
	@Override
	public  HashMap<Integer, HashMap<Integer, String>> GetRowHashMap(String aFileName, int aSheetNumber) {
		
		Iterator<Row> rowIterator = null;
		XSSFSheet sheet = this.GetXSSFSheet(aFileName, aSheetNumber);
		
		if(sheet ==null) {
			return null;
		}
		
		HashMap<Integer,HashMap<Integer,String>> excelHashMap = new HashMap<>();
		HashMap<Integer,String> cellHashMap = new HashMap<>();
		
		rowIterator= sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator(); 
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int columnIndex = cell.getColumnIndex();
				String strCellValue="";
				switch(cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					strCellValue = String.valueOf(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					strCellValue = cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					strCellValue="";
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					strCellValue= String.valueOf(cell.getBooleanCellValue());
				default :
					strCellValue="";
					break;
				}
				cellHashMap.put(columnIndex,strCellValue);
			}
			excelHashMap.put(excelHashMap.size(), cellHashMap);
			cellHashMap = new HashMap<>();
			
			
		}
		if(excelHashMap.size()==0) {
			return null;
		}
		
		return excelHashMap;
	}

	@Override
	public boolean WriteExcelFile(String aXLSXExcelFilePath, String aSheetName,
			HashMap<Integer, HashMap<Integer, String>> aHashMap) {
		
		if(aHashMap == null||aHashMap.size()==0) {
			return false;
		}
		
		if(aSheetName==null||aSheetName.length()==0) {
			return false;
		}
		
		int dataFormatToken = aXLSXExcelFilePath.indexOf(".");
		String strDataFormat = aXLSXExcelFilePath.substring(dataFormatToken+1,aXLSXExcelFilePath.length());
		if(!strDataFormat.equals("xlsx")) {
			return false;
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(aSheetName);
		
		for(int rowIdx=0;rowIdx<aHashMap.size();rowIdx++) {
			Row row = sheet.createRow(rowIdx);
			HashMap<Integer,String> cellHashMap = aHashMap.get(rowIdx);
			Set<Integer> keySet = cellHashMap.keySet();
			Iterator<Integer> keyIterator = keySet.iterator();
			while(keyIterator.hasNext()) {
				Integer key = keyIterator.next();
				Cell cell = row.createCell(key);
				String strCellValue=cellHashMap.get(key);
				cell.setCellValue(strCellValue);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File(aXLSXExcelFilePath));
			workbook.write(out);
			out.close();
			System.out.println("성공");
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
 
}
