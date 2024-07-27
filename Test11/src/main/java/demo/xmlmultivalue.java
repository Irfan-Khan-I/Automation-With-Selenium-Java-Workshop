package demo;

import java.io.File;
import java.io.IOException;
import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.doc.table.OdfTableCell;

public class xmlmultivalue {
	
	
    public static void main(String[] args) {
        try {
            // Load the ODS file
            File odsFile = new File("/home/revenx/eclipse-workspace/Test11/xltest.ods");
            if (!odsFile.exists()) {
                System.err.println("File not found: " + odsFile.getAbsolutePath());
                return;
            }
            OdfSpreadsheetDocument spreadsheet = OdfSpreadsheetDocument.loadDocument(odsFile);
            
            // Iterate over tables to find the first table
            OdfTable sheet = null;
            for (OdfTable table : spreadsheet.getSpreadsheetTables()) {
                sheet = table;
                break; // Stop after the first table
            }
            
            if (sheet == null) {
                System.err.println("No sheet found in the document");
                return;
            }
            
            // Define the range of cells to read (e.g., from row 0 to 4 and column 0 to 2)
            int startRow = 0;
            int endRow = 2;
            int startCol = 0;
            int endCol = 1;

            // Iterate over the specified range of rows and columns
            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol; col++) {
                    OdfTableCell cell = sheet.getCellByPosition(col, row);
                    String cellValue = cell.getStringValue();
                    System.out.print(cellValue + "\t"); // Print cell value with tab separation
                }
                System.out.println(); // Move to the next line after each row
            }
        } catch (IOException e) {
            System.err.println("Error loading document: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
