package com.arlearn.tesis.tesisuns.service;


import com.arlearn.tesis.tesisuns.models.ArImages;
import com.arlearn.tesis.tesisuns.repository.ArImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArImagesServiceImpl implements IArImageService {



    @Autowired
    private ArImageRepository arImageRepository;


    @Override
    public List<ArImages> listarImages() {
        return arImageRepository.findAll();
    }

    @Override
    public ArImages registrarImages(ArImages body) {
        ArImages imagesRegistrada=new ArImages(body.getName(), body.getUri(), body.getDescription(), "E");

        arImageRepository.save(imagesRegistrada);
        return imagesRegistrada;
    }

    @Override
    public ArImages actualizar(ArImages body, Long id) {
        Optional<ArImages> images=arImageRepository.findById(id);
        if(images.isPresent()){
            ArImages imagesActualizado=images.get();

            imagesActualizado.setName(body.getName());
            imagesActualizado.setDescription(body.getDescription());

            arImageRepository.save(imagesActualizado);
        }
        return null;
    }

    @Override
    public String eliminar(Long idImages) {
        Optional<ArImages> encontrado=arImageRepository.findById(idImages);

        if(encontrado.isPresent()){

            ArImages imagesDisabled=encontrado.get();
            imagesDisabled.setState("D");
            arImageRepository.save(imagesDisabled);
            return "Imagen deshabilitada";
        }

        return "No se encontró el id";
    }

}
