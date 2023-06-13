package vkr.chebanuk.diplom.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vkr.chebanuk.diplom.entity.Assets;
import vkr.chebanuk.diplom.repository.AssetsRepository;

import java.util.List;

@Controller
@RequestMapping(AssetsController.ASSETS_URL)
public class AssetsController extends CRUDController<Assets, Long>{

    public static final String ASSETS_URL = "ui/assets";
    public static final String ASSETS_NAME = "assets";

    @Override
    String getEntityName() {
        return ASSETS_NAME;
    }
}
