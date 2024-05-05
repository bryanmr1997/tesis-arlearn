package com.arlearn.tesis.tesisuns.service;


import com.arlearn.tesis.tesisuns.models.ArImages;


import java.util.List;

public interface IArImageService {




    List<ArImages> listarImages();

    ArImages registrarImages(ArImages body);

    ArImages actualizar(ArImages body, Long id);

    String eliminar(Long idImages);
}
