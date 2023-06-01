package vkr.chebanuk.diplom.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vkr.chebanuk.diplom.entity.Assets;

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
