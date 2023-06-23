package vkr.chebanuk.diplom.service.impl;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vkr.chebanuk.diplom.QRCodeGenerator;
import vkr.chebanuk.diplom.entity.Assets;
import vkr.chebanuk.diplom.repository.AssetsRepository;
import vkr.chebanuk.diplom.service.intrf.AssetsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetsServiceImpl extends AbstractCRUDService<Assets, Long> implements AssetsService {

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    CrudRepository<Assets, Long> getRepository() {
        return assetsRepository;
    }

    @Override
    public List<Assets> findAll() throws IOException, WriterException {

        List<Assets> assetsList = new ArrayList<>();

        getRepository().findAll().forEach(assetsList::add);


        for(Assets asset : assetsList){
            if(asset.getQRcode()==null){
                asset.setQRcode(QRCodeGenerator.generateQRCode(asset));
            }
        }

//        getRepository().saveAll((Iterable<? extends Assets>) assetsList);
        return assetsList;
    }

    @Override
    public void create(Assets assets) throws IOException, WriterException {

        assets.setQRcode(QRCodeGenerator.generateQRCode(assets));

        getRepository().save(assets);

    }

    @Override
    public Assets update(Assets assets) throws IOException, WriterException {
        assets.setQRcode(QRCodeGenerator.generateQRCode(assets));

        getRepository().save(assets);
        return assets;
    }
}