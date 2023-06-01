package vkr.chebanuk.diplom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import vkr.chebanuk.diplom.entity.Assets;
import vkr.chebanuk.diplom.repository.AssetsRepository;
import vkr.chebanuk.diplom.service.intrf.AssetsService;

@Service
public class AssetsServiceImpl extends AbstractCRUDService<Assets, Long> implements AssetsService {

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    CrudRepository<Assets, Long> getRepository() {
        return assetsRepository;
    }
}
