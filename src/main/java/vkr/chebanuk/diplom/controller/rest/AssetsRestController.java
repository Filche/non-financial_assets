package vkr.chebanuk.diplom.controller.rest;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vkr.chebanuk.diplom.QRCodeGenerator;
import vkr.chebanuk.diplom.entity.Assets;
import vkr.chebanuk.diplom.service.impl.AssetsServiceImpl;
import vkr.chebanuk.diplom.service.intrf.AssetsService;
import vkr.chebanuk.diplom.service.intrf.CRUDService;

import java.io.IOException;
import java.util.List;

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

/*    @Override
    public ResponseEntity<List<Assets>> findAll() throws IOException, WriterException {

        List<Assets> assetsList = getService().findAll();

        for(Assets asset : assetsList){
            asset.setQRcode(QRCodeGenerator.generateQRCode(asset));
        }

        return ResponseEntity.ok(assetsList);
    }*/
}
