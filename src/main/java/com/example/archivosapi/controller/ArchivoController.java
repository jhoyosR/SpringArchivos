package com.example.archivosapi.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiarchivos")
public class ArchivoController {

    // Mostrar una imagen
    @GetMapping("/imagen")
    public ResponseEntity<Resource> mostrarImagen() {
        Resource imagen = new ClassPathResource("static/imagen/tu_imagen.jpg");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imagen);
    }

    // Mostrar un archivo HTML
    @GetMapping("/html")
    public ResponseEntity<Resource> mostrarHtml() {
        Resource html = new ClassPathResource("static/html/tu_archivo.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }

    // Mostrar un archivo XML
    @GetMapping("/xml")
    public ResponseEntity<Resource> mostrarXml() {
        Resource xml = new ClassPathResource("static/xml/tu_archivo.xml");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(xml);
    }

    // Mostrar un archivo PDF
    @GetMapping("/pdf")
    public ResponseEntity<Resource> mostrarPdf() {
        Resource pdf = new ClassPathResource("static/pdf/tu_archivo.pdf");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=tu_archivo.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
