package vkr.chebanuk.diplom;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import vkr.chebanuk.diplom.entity.Assets;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelBuilder {

    public static void buildExcelDocument(List<Assets> assetsList,
                                      HSSFWorkbook workbook) throws IOException {

        HSSFSheet sheet = workbook.createSheet("Assets");


        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        style.setFont(font);
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat((short)14);

        // create header row
        Row header = sheet.createRow(0);

        header.createCell(0, CellType.NUMERIC).setCellValue("ID");
        header.getCell(0).setCellStyle(style);

        header.createCell(1,CellType.STRING).setCellValue("Наименование");
        header.getCell(1).setCellStyle(style);

        header.createCell(2,CellType.STRING).setCellValue("Инвентарный номер");
        header.getCell(2).setCellStyle(style);

        header.createCell(3,CellType.STRING).setCellValue("Тип актива");
        header.getCell(3).setCellStyle(style);

        header.createCell(4,CellType.STRING).setCellValue("Категория");
        header.getCell(4).setCellStyle(style);

        header.createCell(5,CellType.STRING).setCellValue("Заводской номер");
        header.getCell(5).setCellStyle(style);

        header.createCell(6,CellType.STRING).setCellValue("Модель");
        header.getCell(6).setCellStyle(style);

        header.createCell(7,CellType.NUMERIC).setCellValue("Количество");
        header.getCell(7).setCellStyle(style);

        header.createCell(8,CellType.NUMERIC).setCellValue("Стоимость");
        header.getCell(8).setCellStyle(style);

        header.createCell(9,CellType.NUMERIC).setCellValue("Балансовая стоимость");
        header.getCell(9).setCellStyle(style);

        header.createCell(10,CellType.STRING).setCellValue("Дата ввода в эксплуатацию");
        header.getCell(10).setCellStyle(style);

        header.createCell(11,CellType.STRING).setCellValue("Аудитория");
        header.getCell(11).setCellStyle(style);

        header.createCell(12,CellType.STRING).setCellValue("Примечание");
        header.getCell(12).setCellStyle(style);

        // create data rows
        int rowCount = 1;

        for (Assets assets : assetsList) {
            Row aRow = sheet.createRow(rowCount++);
            aRow.createCell(0,CellType.NUMERIC).setCellValue(assets.getId());
            aRow.createCell(1,CellType.STRING).setCellValue(assets.getName());
            aRow.createCell(2,CellType.STRING).setCellValue(assets.getInventoryNumber());
            aRow.createCell(3,CellType.STRING).setCellValue(assets.getType());
            aRow.createCell(4,CellType.STRING).setCellValue(assets.getCategory());
            aRow.createCell(5,CellType.STRING).setCellValue(assets.getFactoryNumber());
            aRow.createCell(6,CellType.STRING).setCellValue(assets.getModel());
            aRow.createCell(7,CellType.NUMERIC).setCellValue(assets.getQuantity());
            aRow.createCell(8,CellType.NUMERIC).setCellValue(assets.getCost());
            aRow.createCell(9,CellType.NUMERIC).setCellValue(assets.getBalanceCost());
            aRow.createCell(10,CellType.STRING).setCellValue(assets.getCommissioningDate());
            aRow.createCell(11,CellType.STRING).setCellValue(assets.getAuditorium());
            aRow.createCell(12,CellType.STRING).setCellValue(assets.getNote());
        }

        File file = new File("C:/Users/filch/Desktop/Assets.xls");

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
    }
}
