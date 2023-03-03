package zm.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger("cloudLogger");
    public static void addDataToExcel(Workbook workbook, List<String> tableHeadName,
                                      List<String> tableHeadCode, Map<String, List<Map<String, Object>>> data) {
        // 表头样式
        CellStyle headCellStyle = workbook.createCellStyle();
        headCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Font headFont = workbook.createFont();
        headFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headCellStyle.setFont(headFont);
        for (Map.Entry<String, List<Map<String, Object>>> stringListEntry : data.entrySet()) {
            String sheetName = stringListEntry.getKey();
            if (StringUtils.isAllBlank(sheetName)) {
                sheetName = "Sheet1";
            }
            List<Map<String, Object>> value = stringListEntry.getValue();
            // 创建sheet
            Sheet sheet = workbook.getSheet(sheetName);
            boolean existed = true;
            int lastRowNum=0;
            if (sheet == null) {
                existed = false;
                sheet = workbook.createSheet(sheetName);
            }else {
                lastRowNum = sheet.getLastRowNum();
            }
                for (int i = lastRowNum; i < value.size() + lastRowNum; i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tableHeadCode.size(); j++) {
                        Object o = value.get(i - lastRowNum).get(tableHeadCode.get(j));
                        if (o != null) {
                            Cell cell = row.createCell(j);
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            cell.setCellValue(String.valueOf(o));
                        }
                    }
                }
            if (!existed) {
                // 不存在则设置表头
                Row row0 = sheet.createRow(0);
                for (int i = 0; i < tableHeadName.size(); i++) {
                    Cell cell = row0.createCell(i);
                    cell.setCellValue(tableHeadName.get(i));
                    cell.setCellStyle(headCellStyle);
                }
            }

        }
    }

    public static void outPutExcelToHttpResponse(HttpServletRequest request, HttpServletResponse response, Workbook workbook, String fileName) {
        ServletOutputStream outputStream = null;
        try {
            String userAgent = request.getHeader("User-Agent");
            byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes(StandardCharsets.UTF_8);
            String fileName8859 = new String(bytes, StandardCharsets.ISO_8859_1);
            String filenameutf8 = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name());
            if (request.getHeader("User-Agent").toLowerCase().contains("firefox")) {
                response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\";", fileName8859));
            } else {
                response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\";filename*=utf-8''\"%s\"", fileName8859, filenameutf8));
            }
            response.setContentType("application/force-download");
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (IOException e) {
            LOGGER.info("导出数据时出错",e);
        } finally {
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                LOGGER.info("导出数据时出错",e);
            }
        }
    }
}

