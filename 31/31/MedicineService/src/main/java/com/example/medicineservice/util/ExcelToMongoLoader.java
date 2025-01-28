package com.example.medicineservice.util;

import com.example.medicineservice.model.Medicine;
import com.example.medicineservice.service.MedicineDataService;
import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelToMongoLoader {
    private final MedicineDataService medicineDataService;

    @Autowired
    public ExcelToMongoLoader(MedicineDataService medicineDataService) {
        this.medicineDataService = medicineDataService;
    }

    @PostConstruct
    public void loadData() throws IOException {
        String filePath = "C:\\Users\\efeilhan\\Desktop\\31\\31\\MedicineService\\src\\main\\java\\com\\example\\medicineservice\\util\\medicine.xlsx";
        List<Medicine> medicines = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Başlıkları atla
                String name = row.getCell(0).getStringCellValue();
                medicines.add(new Medicine(name));
            }
        }

        medicineDataService.saveMedicines(medicines);
    }
}

