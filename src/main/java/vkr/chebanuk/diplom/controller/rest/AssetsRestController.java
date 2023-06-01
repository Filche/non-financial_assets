package vkr.chebanuk.diplom.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vkr.chebanuk.diplom.entity.Assets;
import vkr.chebanuk.diplom.service.intrf.AssetsService;
import vkr.chebanuk.diplom.service.intrf.CRUDService;

@RestController
@RequestMapping(AssetsRestController.ASSETS_REST_URL)
public class AssetsRestController extends CRUDRestController<Assets, Long> {

    public static final String ASSETS_REST_URL = "assets";

    @Autowired
    private AssetsService assetsService;

    @Override
    CRUDService<Assets, Long> getService() {
        return assetsService;
    }
}
