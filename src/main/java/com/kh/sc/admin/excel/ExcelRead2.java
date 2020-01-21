package com.kh.sc.admin.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.admin.model.vo.QuestionInsert;
import com.kh.sc.question.model.vo.Answer;

public class ExcelRead2 {

	public void getXLSExcelFile(String filePath) {
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			
			int rowIndex= 0;
			int columnIndex=0;
			
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			int rows = sheet.getPhysicalNumberOfRows();
			for(rowIndex=1;rowIndex<rows;rowIndex++) {
				//행을 읽는다.
				HSSFRow row=sheet.getRow(rowIndex);
				if(row !=null) {
				// 셀의 수
					int cells = row.getPhysicalNumberOfCells();
					
					for(columnIndex=0;columnIndex<=cells;columnIndex++) {
						//셀값을 읽는다.
						HSSFCell cell = row.getCell(columnIndex);
						String value="";
						if(cell==null) {
							continue;
						}else {
							//타입별로 읽기
							switch(cell.getCellType()) {
							case HSSFCell.CELL_TYPE_FORMULA:
								value=cell.getCellFormula();
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								value=cell.getNumericCellValue()+"";
								break;
							case HSSFCell.CELL_TYPE_STRING:
								value=cell.getStringCellValue()+"";
								break;
							case HSSFCell.CELL_TYPE_BLANK:
								value=cell.getBooleanCellValue()+"";
							case HSSFCell.CELL_TYPE_ERROR:
								value=cell.getErrorCellValue()+"";
								break;
							}
						}
						System.out.println("각 셀 내용 : " + value);
					}
				}
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getXLSXExcel(String filePath,int uno) {
		List<Question> qlist = new ArrayList();
		List<Answer> alist = new ArrayList();
		int cNum = 0;
		//파일을 읽기위해 엑셀파일을 가져온다 
		XSSFWorkbook workbook =null;
		try {
			FileInputStream fis=new FileInputStream(filePath); 
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int rowindex = 0;
		int columnindex=0;
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		int rows=sheet.getPhysicalNumberOfRows();
		for(rowindex=1;rowindex<rows;rowindex++){
		    //행을읽는다
		    XSSFRow row=sheet.getRow(rowindex);
		    if(row !=null){
		        //셀의 수
		        int cells=row.getPhysicalNumberOfCells();
		        for(columnindex=0;columnindex<=cells;columnindex++){
		            //셀값을 읽는다
		            XSSFCell cell=row.getCell(columnindex);
		            String value="";
		            //셀이 빈값일경우를 위한 널체크
		            if(cell==null){
		                continue;
		            }else{
		                //타입별로 내용 읽기
		                switch (cell.getCellType()){
		                case XSSFCell.CELL_TYPE_FORMULA:
		                    value=cell.getCellFormula();
		                    break;
		                case XSSFCell.CELL_TYPE_NUMERIC:
		                    value=cell.getNumericCellValue()+"";
		                    break;
		                case XSSFCell.CELL_TYPE_STRING:
		                    value=cell.getStringCellValue()+"";
		                    break;
		                case XSSFCell.CELL_TYPE_BLANK:
		                    value=cell.getBooleanCellValue()+"";
		                    break;
		                case XSSFCell.CELL_TYPE_ERROR:
		                    value=cell.getErrorCellValue()+"";
		                    break;
		                }
		            }
		            System.out.println("각 셀 내용 :"+value);
		        }
		    }
		    System.out.println("------------------"+rowindex+"번째줄 끝------------------");
		}


		
			
			
		
		
	}//메소드 끝
}				
	

