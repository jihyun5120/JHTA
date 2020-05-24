package semishit;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public boolean xlsxWiter(List<FinanVo> list) {
		boolean bo = false;
		//���щ� ����
		XSSFWorkbook workbook = new XSSFWorkbook();
		//���ъ���� ����
		XSSFSheet sheet = workbook.createSheet();
		//��
		XSSFRow row = sheet.createRow(0);
		//��
		XSSFCell cell =  null;
		
		//���� ���� �ㅻ�� 援ъ��
		cell = row.createCell(0);
		cell.setCellValue("월");
		
		cell = row.createCell(1);
		cell.setCellValue("수익"); 
		
		cell = row.createCell(2);
		cell.setCellValue("비용");
		
		//由ъ�ㅽ�� �ъ�댁�留��� row����
		FinanVo vo = new FinanVo();
		
		//엑셀 파일에서 날짜형식 지수형으로 바뀌는 것 방지하기 위해 작성
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM"));
		
		
		for(int i=0; i<list.size(); i++) {
			vo = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell(0);
			cell.setCellValue(vo.getIdate());
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(1);
			cell.setCellValue(vo.getProfit());
			
			cell = row.createCell(2);
			cell.setCellValue(vo.getExpend());
		}
		
		File file = new File("C:\\Users\\JHTA\\Desktop\\excel");
		FileOutputStream fos = null;
		if(!file.exists()) {
			file.mkdir();
		}
		
		try {
			fos = new FileOutputStream("C:\\Users\\JHTA\\Desktop\\excel\\test.xlsx");
			workbook.write(fos);
			bo = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(workbook!=null) try {workbook.close();} catch(Exception e) {}
			if(fos!=null) try {workbook.close();} catch(Exception e) {}
		}
		return bo;
	}
	
	
/*	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		FinanDao dao = new FinanDao();
		List<FinanVo> list = dao.selectPE();
		Excel ex = new Excel();
		
		ex.xlsxWiter(list);
	}*/
}
