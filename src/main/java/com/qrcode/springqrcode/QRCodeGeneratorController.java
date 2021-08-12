package com.qrcode.springqrcode;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping(value = "/api/generate-qr")
public class QRCodeGeneratorController {


    @PostMapping(value = "/zxing-qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> zxingQRCode(@RequestBody String barcode) throws Exception{
        return susccessResponse(QRCodeGenerator.generateQR(barcode));
    }

    private ResponseEntity<BufferedImage> susccessResponse(BufferedImage image){
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
