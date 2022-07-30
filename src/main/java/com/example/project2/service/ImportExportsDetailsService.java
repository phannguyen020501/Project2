package com.example.project2.service;

import com.example.project2.model.*;
import com.example.project2.repository.ImportExportsDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportExportsDetailsService {
    @Autowired
    ImportExportsDetailsRepository importExportsDetailsRepository;
    @Autowired ImportExportsService importExportsService;
    @Autowired ProductsService productsService;


    public ImportExportsDetails findById(int id){
        return importExportsDetailsRepository.findById(id);
    }
    public ImportExportsDetails create(ImportExportsDetails importExportsDetails){
        int import_export_id = importExportsDetails.getImportExportId();
        ImportExports importExports = importExportsService.findById(import_export_id);
        if(importExports == null){
            return null;
        }

        int product_id = importExportsDetails.getProductId();
        Products products = productsService.findById(product_id);
        if(products == null){
            return null;
        }

        importExportsDetails.setImportExportsByImportExportId(importExports);
        importExportsDetails.setProductsByProductsId(products);

        importExportsDetailsRepository.save(importExportsDetails);
        return importExportsDetails;
    }

    public ImportExportsDetails update(int id, ImportExportsDetails importExportsDetails){
        ImportExportsDetails updated = importExportsDetailsRepository.findById(id);
        if(updated == null) return null;

        int import_export_id = importExportsDetails.getImportExportId();
        ImportExports importExports = importExportsService.findById(import_export_id);
        if(importExports == null){
            return null;
        }

        int product_id = importExportsDetails.getProductId();
        Products products = productsService.findById(product_id);
        if(products == null){
            return null;
        }

        importExportsDetails.setImportExportsByImportExportId(importExports);
        importExportsDetails.setProductsByProductsId(products);

        importExportsDetailsRepository.save(importExportsDetails);
        return importExportsDetails;
    }

    public boolean delete(int id){
        ImportExportsDetails importExportsDetails = importExportsDetailsRepository.findById(id);
        if(importExportsDetails == null) return false;
        importExportsDetailsRepository.delete(importExportsDetails);
        return true;
    }
}
