package demo;

import java.io.File;
import java.io.IOException;

import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.doc.table.OdfTableCell;

public class xmltest {

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
            
            // Read the value of the cell (0,1) - First row, second column
            OdfTableCell cell = sheet.getCellByPosition(0, 0);
            String cellValue = cell.getStringValue();
            
            System.out.println("Cell value: " + cellValue);
        } catch (IOException e) {
            System.err.println("Error loading document: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
