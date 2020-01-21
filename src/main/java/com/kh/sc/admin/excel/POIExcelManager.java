package com.kh.sc.admin.excel;

import java.util.HashMap;

public interface POIExcelManager {
	
	public HashMap<Integer,HashMap<Integer,String>> GetRowHashMap(String aFileName, int aSheetNumber);
	
	public boolean WriteExcelFile(String aXLSXExcelFilePath,String aSheetName, HashMap<Integer,HashMap<Integer,String>> aHashMap);
}
