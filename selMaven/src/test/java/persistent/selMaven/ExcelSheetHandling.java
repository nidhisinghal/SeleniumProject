package persistent.selMaven;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.Test;

public class ExcelSheetHandling {
  @Test
  public void f() throws BiffException, IOException, RowsExceededException, WriteException {
	// Read from an Excel file
	  Workbook book1 = Workbook.getWorkbook(new File("./src/test/Book1.xls"));
	  Sheet sheet1 = book1.getSheet("NameData");
	  
	  //Read a single column value
	 // String name = sheetname.getCell(0,1).getContents();
	  //System.out.println(name);
	  
	  //Read content of all populated columns
	  for (int i=0; i<sheet1.getRows(); i++) {
		  for (int j=0; j<sheet1.getColumns(); j++) {
			  System.out.print(sheet1.getCell(j,i).getContents()+"\t");
			  
		  }
		  System.out.println("\n");
	  }
	 // book1.close();
	  // create and write to a new Excel file
	  WritableWorkbook book2 = Workbook.createWorkbook(new File("./src/test/Book2.xls"));
	  WritableSheet sheet2 = book2.createSheet("Master", 0);
	  Label l1=new Label(2,1,"Peter");
	  sheet2.addCell(l1);
	  book2.write();
	  book2.close();
	  
	  //Copy content from an existing book and add new cell to this new file. Remember we can't modify an existing excel file. 
	  //That is the limitation of jxl
	  WritableWorkbook book3 = Workbook.createWorkbook(new File("./src/test/Book4.xls"), book1);
	  WritableSheet sheet3= book3.createSheet("MasterCopy",0);
	  Label l2= new Label(4,4,"Nidhi");
	  sheet3.addCell(l2);
	  book3.write();
	  book3.close();
	  book1.close();
	  
  }
	  
	  }

