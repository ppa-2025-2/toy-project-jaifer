
package com.example.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/evidences")
public class EvidencesController {

    private static final Logger logger = LoggerFactory
            .getLogger(EvidencesController.class.getName());
            
            private final IFileService fileService

    @PostMapping(
       consumes = { "multipart/form-data" }
    )
    public ResponseEntity uploadEvidence(@RequestPart("evidence") MultipartFile file) {
        
        if (file.isEmpty()) return ResponseEntity.badRequest().body(Map.of(
            "erro", "arquivo evidence não encontrado"
        ));

        var name = file.getOriginalFilename();
        var size = file.getSize();
        var contentType = file.getContentType();
        
        logger.info("Recebendo upload de evidência: {}", file.getOriginalFilename());
       
        fileService.upload(name,tipo,file.getBytes());
        
        return ResponseEntity.ok(Map.of(
            "name", name,
            "size", size,
            "contentType", contentType
        ));
    }
}
