package com.priventiveMaintenance.pmService.checkListMaster;

import com.priventiveMaintenance.pmService.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class CheckListController extends BaseController {
    @Autowired
    CheckListService checkListService;

    @PostMapping("check-list")
    public ResponseEntity<List<CheckList>> uploadCheckList(@RequestParam("file")MultipartFile file){
            List<CheckList> dto = new ArrayList<>();
            try {
                Workbook workbook = new XSSFWorkbook(file.getInputStream());
                Sheet sheet = workbook.getSheetAt(1);
                int rowNumber = sheet.getPhysicalNumberOfRows();
                if (rowNumber > 1) {
                    for (int i = 1; i < rowNumber; i++) {
                        Row row = sheet.getRow(i);
                        CheckList checkList = new CheckList();
                        checkList.setCheckPoint(row.getCell(1).getStringCellValue());
                        checkList.setDescription(row.getCell(2).getStringCellValue());
                        checkList.setStandardCondition(row.getCell(3).getStringCellValue());
                        checkList.setActionPlan(row.getCell(4).getStringCellValue());
                        checkListService.saveCheckList(checkList);
                        dto.add(checkList);
                    }
                } else {
                    throw new NoSuchFieldException("No data in excel sheet\", \"Import");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
