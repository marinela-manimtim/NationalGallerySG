package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
public class ExcelUtil {
    private static final String FILE_PATH = "TicketData.xlsx";

    public static Object[][] getTicketData() throws IOException {
        List<Object[]> dataList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                String type = row.getCell(0).getStringCellValue();
                double price = row.getCell(1).getNumericCellValue();
                int quantity = (int) row.getCell(2).getNumericCellValue();
                dataList.add(new Object[]{type, price, quantity});
            }
        }
        return dataList.toArray(new Object[0][0]);
    }

    public static void updateTicketData(String ticketType, double newPrice, int newQuantity) throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(ticketType)) {
                    row.getCell(1).setCellValue(newPrice);
                    row.getCell(2).setCellValue(newQuantity);
                    break;
                }
            }
            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }
        }
    }
}
*/
