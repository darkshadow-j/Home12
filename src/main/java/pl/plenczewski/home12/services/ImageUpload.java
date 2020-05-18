package pl.plenczewski.home12.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ImageUpload {
    File uploadFile(MultipartFile multipartFile);
}
