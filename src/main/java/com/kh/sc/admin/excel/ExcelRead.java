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

import com.kh.sc.admin.model.vo.AnswerInsert;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.admin.model.vo.QuestionInsert;
import com.kh.sc.question.model.vo.Answer;

public class ExcelRead {
	public List<List<Object>> getXLSXExcel2(String filePath,int uno) {
		List<List<Object>> list = new ArrayList();
		int cno=0;
	try {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        int rowindex=0;
        int columnindex=0;
        //시트 수 (첫번째에만 존재하므로 0을 준다)
        //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
        XSSFSheet sheet=workbook.getSheetAt(1);
        //행의 수
        int rows=sheet.getPhysicalNumberOfRows();        
        for(rowindex=0;rowindex<rows;rowindex++){
        	List<Object> questionSet = new ArrayList<Object>();
            //행을읽는다
			QuestionInsert qin = new QuestionInsert.qBuilder(uno).qBuild();
    		AnswerInsert ain = new AnswerInsert.aBuilder(uno).aBuild();
            XSSFRow row=sheet.getRow(rowindex);
            if(row !=null){
                //셀의 수
                int cells=row.getPhysicalNumberOfCells();
                for(columnindex=0; columnindex<=cells; columnindex++){
                	if(columnindex%2 == 1) ain = new AnswerInsert.aBuilder(uno).aBuild();
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
                    if(rowindex==2&&columnindex==2) {
		            	System.out.println("종목번호  :"+value);
		            	cno = (int)Double.parseDouble(value);
		            	System.out.println("종목번호  :"+cno);
		            }
                    if(rowindex>3) {
		            	if(columnindex<5) {
		            		switch(columnindex) {
			        		case 1: qin.setUnitNum((int)Double.parseDouble(value));
			        				qin.setcNo(cno);
			        			break;
			        		case 2: qin.setqContent(value);
			        			break;
			        		case 3: qin.setqLevel(value);
			        			break;
			        		case 4 : qin.setqScore((int)Double.parseDouble(value));
			        		questionSet.add(qin);
			        			break;
			        		}
		            	}else if(columnindex>=5&&!value.equals("false")) {
		            		
		            		switch(columnindex%2) {
		            		case 0:	
		            			System.out.println("----------------------------------");	
		            			System.out.println("보기 정답 입력단계 : " + columnindex);
					            	ain.setQstatus(value);
					            	System.out.println(ain);
	            					questionSet.add(ain);
	            					System.out.println(questionSet);
	            					System.out.println("----------------------------------");
		            			break;
		            		case 1: ain.setQancontent(value);
		            				ain.setCno(cno);
		            				System.out.println(ain);
		            			System.out.println("보기 내용 입력단계 : " + columnindex);
		            			break;
		            		}

		            	}// 5열 이상일때 
		        	}
                    System.out.println(rowindex+"번 행 : "+columnindex+"번 열 값은: "+value);
                }

            }
            if(rowindex>3) {
            	System.out.println(questionSet);
            	list.add(questionSet);            	
            }
        }//줄 끝

    }catch(Exception e) {
       System.out.println("엑셀파일 읽기 종료!");
    }
	return list;

}
	
	public void getXLSXExcel(String filePath,int uno) {
		List<List<Object>> list = new ArrayList();
		int cno=0;
		//QuestionInsert qin = new QuestionInsert.qBuilder(uno, cNo).qBuild();
		//AnwerInsert ain = new AnswerInsert.aBuilder(qno, uno).aBuild();
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
		System.out.println("읽은줄 갯수 : " + rows);
		for(rowindex=0;rowindex<rows;rowindex++){
		    //행을읽는다
			List<Object> questionSet = new ArrayList<Object>();
			QuestionInsert qin = new QuestionInsert.qBuilder(uno).qBuild();
    		AnswerInsert ain = new AnswerInsert.aBuilder(uno).aBuild();
		    XSSFRow row=sheet.getRow(rowindex);
		    if(row !=null){
		        //셀의 수
		        int cells=row.getPhysicalNumberOfCells();
		        System.out.println("줄 길이 : "+cells);
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
		            
		            if(rowindex==2&&columnindex==2) {
		            	System.out.println("종목번호  :"+value);
		            	cno = Integer.parseInt(value);
		            }
		       
		            
		            
		            System.out.println("각 셀 내용 :"+value);
		        }// 1셀씩
		        list.add(questionSet);
			    System.out.println(questionSet);
			    System.out.println("------------------"+rowindex+"번째줄 끝------------------");
		    }// 줄이 빈줄이 아니라는 가정하에.
		    
		}//1줄씩


		
			
			
		
		
	}//메소드 끝
}							
	

