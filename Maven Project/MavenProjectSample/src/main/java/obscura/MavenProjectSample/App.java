package obscura.MavenProjectSample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class App 
{
	
	
	public static void readFromFile() {
		try
        {
            FileInputStream file = new FileInputStream(new File("D:\\Maven Project\\MavenProjectSample\\SijinText.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook1 = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet1 = workbook1.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet1.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    
                    System.out.print(cell.getStringCellValue() + "\t");
                    
                }
                System.out.println("");
            }
            file.close();
        } 
        catch (Exception e) 
        {
        	 e.printStackTrace();
        }
	}

	/**
	 * 
	 */
	public static void writeToFile() {
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		 
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("SijinText");
		    
		ArrayList<String> studentList = new ArrayList();
		studentList.add("Student Name");
		studentList.add("SIJIN");
		studentList.add("SIJIN\n  \t SHOBHITHA	");
		studentList.add("BABY");
		studentList.add("NOEL");
		studentList.add("for\n my\n Love\n shobhi");
		//studentList.remove(2);
		
		for (int counter = 0; counter < studentList.size(); counter++) 
		{ 		      
		    
			 Row row = sheet.createRow(counter);
			 Cell cell = row.createCell(0);
			 cell.setCellValue(studentList.get(counter));        			
		}  
		
		try
		{
		    //Write the workbook in file system
			File file = new File("SijinText.xlsx");
		    FileOutputStream out = new FileOutputStream(file);
		    workbook.write(out);
		    out.close();
		    System.out.println("Students.xlsx written successfully on disk.");
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
	}
	
    public static void main( String[] args)
    {
    	writeToFile();
    
    	readFromFile();
           
    
    }

	
}
