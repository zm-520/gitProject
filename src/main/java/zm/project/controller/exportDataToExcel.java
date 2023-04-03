package zm.project.controller;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import zm.project.service.AppUserService;
import zm.util.ExcelUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class exportDataToExcel {
    private static final Logger LOGGER = LoggerFactory.getLogger("cloudLogger");
    @Autowired
    AppUserService appUserService;

    @GetMapping("/exportDataToExcel")
    public void exportDataToExcel(HttpServletRequest request, HttpServletResponse response) {
        int pageNo = 1;
        int pageNum = 500;
        List<String> headerName = Arrays.asList("序号", "姓名", "邮箱", "电话", "性别", "密码", "年龄", "创建时间");
        List<String> headerCode = Arrays.asList("id", "name", "email", "phone", "gender", "password", "age", "createTime");
        SXSSFWorkbook workbook = new SXSSFWorkbook(pageNum + 1);
        while (true) {
            if (pageNo * pageNum > 100000) {
                // 限制导出100000条
                break;
            }
            List<Map<String, Object>> result = appUserService.selectUserByPage(pageNo, pageNum);
            //注意此处的逻辑
            if (result.size() == 0) {
                if (pageNo == 1) {
                    LOGGER.info("暂无数据");
                    return;
                }
                break;
            }
            HashMap<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>(1);
            map.put("", result);
            ExcelUtils.addDataToExcel(workbook, headerName, headerCode, map);
            pageNo++;
        }
        String fileName = "app_user" + ".xlsx";
        ExcelUtils.outPutExcelToHttpResponse(request, response, workbook, fileName);
    }
}
