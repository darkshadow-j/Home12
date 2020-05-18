package pl.plenczewski.home12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.plenczewski.home12.services.ImageUpload;
import pl.plenczewski.home12.services.ImageUploadImpl;
import pl.plenczewski.home12.services.SearchTextOnImage;

import java.io.File;

@Controller
@CrossOrigin
@RequestMapping("/app")
public class MainController {

    private SearchTextOnImage searchTextOnImage;
    private ImageUpload imageUpload;

    @Autowired
    public MainController(SearchTextOnImage searchTextOnImage, ImageUpload imageUpload) {
        this.searchTextOnImage = searchTextOnImage;
        this.imageUpload = imageUpload;
    }

    @GetMapping
    public String mainPage(){
        return "index";
    }

    @PostMapping
    public String appPage(Model model, @RequestParam("file") MultipartFile multipartFile){
        model.addAttribute("textData", searchTextOnImage.getText(imageUpload.uploadFile(multipartFile)));
        return "app";
    }
}
