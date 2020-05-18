package pl.plenczewski.home12.services;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SearchTextOnImageImpl implements SearchTextOnImage {

    private final static String DATAPATH_NAME="/home/tessdata";

    @Override
    public String getText(File imageFile) {
        ITesseract instance = new Tesseract();
        instance.setDatapath(DATAPATH_NAME);

        try {
            return instance.doOCR(imageFile);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
