package vkr.chebanuk.diplom.controller.mvc;

import com.google.zxing.WriterException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vkr.chebanuk.diplom.ExcelBuilder;
import vkr.chebanuk.diplom.entity.Assets;
import vkr.chebanuk.diplom.repository.AssetsRepository;
import vkr.chebanuk.diplom.service.intrf.AssetsService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(AssetsController.ASSETS_URL)
public class AssetsController extends CRUDController<Assets, Long>{

    public static final String ASSETS_URL = "ui/assets";
    public static final String ASSETS_NAME = "assets";

    @Autowired
    private AssetsService assetsService;

    @Override
    String getEntityName() {
        return ASSETS_NAME;
    }

    @GetMapping("/excel-process")
    public String getExcel() throws IOException, WriterException {

        ExcelBuilder.buildExcelDocument(assetsService.findAll(), new HSSFWorkbook());

        return "redirect:/ui/assets/list";
    }
}
