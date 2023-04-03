package com.crv.microstore.catalogservice.controller;

import com.crv.microstore.catalogservice.config.CatalogConstants.ControllerConstants;
import com.crv.microstore.catalogservice.model.CatalogModel;
import com.crv.microstore.catalogservice.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = ControllerConstants.CATALOG_URL)
public class CatalogController {

    private CatalogService catalogService;

    @GetMapping
    public List<CatalogModel> getAllCatalogs(){
        return catalogService.getAllCatalogs();
    }

    @PostMapping(value = ControllerConstants.URL_POST)
    public void saveNewCatalogModel(@RequestBody CatalogModel catalogModel){
        if(ObjectUtils.isNotEmpty(catalogModel)){
            catalogService.saveCatalog(catalogModel);

            log.info(" {} catalog with the Id {} was saved in the database...", catalogModel.getName(), catalogModel.getId());
        }else{
            log.warn("The catalog was not saved because the object is NULL / EMPTY");
        }
    }

    @DeleteMapping(value = ControllerConstants.URL_DELETE)
    public void deleteCatalog(@RequestBody Long id){
        catalogService.deleteCatalogById(id);
    }

    @GetMapping(value = ControllerConstants.URL_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCatalogModelById(@PathVariable(ControllerConstants.PATH_VARIABLE_ID) final Long id){

        CatalogModel catalogModel = null;

        if (ObjectUtils.isNotEmpty(id)) {
            catalogModel = catalogService.findCatalogById(id).get();

            log.info("Catalog {} with id {} was found in the database", catalogModel.getName(), id);

            return new ResponseEntity<>(catalogModel, HttpStatus.ACCEPTED);
        }
        else{
            log.warn("The id is empty or null...");
            return new ResponseEntity<>(catalogModel, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = ControllerConstants.URL_PUT, method = {RequestMethod.PUT, GET})
    public void updateCatalogModel(@RequestBody CatalogModel catalogModel){

        if(ObjectUtils.isNotEmpty(catalogModel)) {

            catalogService.saveCatalog(catalogModel);
            log.info("{} catalog with id {} was saved", catalogModel.getName(), catalogModel.getId());
        }else{
            log.warn("Catalog sent is empty or null...");
        }
    }

}
