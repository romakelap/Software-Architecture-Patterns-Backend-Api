package GapiV2.Garlands.controller;

import GapiV2.Garlands.entity.Template;
import GapiV2.Garlands.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {
    private final TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping("/get-all")
    public List<Template> getAllTemplates() {
        return templateService.getAllTemplates();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("name") String name,
                                              @RequestParam("htmlFile") MultipartFile htmlFile,
                                              @RequestParam("cssFile") MultipartFile cssFile,
                                              @RequestParam("jsFile") MultipartFile jsFile) {
        try {
            // Membaca konten file yang diunggah
            String htmlContent = new String(htmlFile.getBytes());
            String cssContent = new String(cssFile.getBytes());
            String jsContent = new String(jsFile.getBytes());

            // Membuat objek Website baru
            Template website = new Template();
            website.setName(name);
            website.setHtmlContent(htmlContent);
            website.setCssContent(cssContent);
            website.setJsContent(jsContent);

            // Menyimpan objek Website ke database
            templateService.saveWebsite(website);

            return ResponseEntity.ok("File berhasil diunggah");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Gagal mengunggah file");
        }
    }

    @GetMapping("/{websiteId}")
    public ResponseEntity<String> getWebsite(@PathVariable("websiteId") int id) {
        Template website = templateService.getWebsiteById(id);
        if (website != null) {
            // Menggabungkan konten HTML, CSS, dan JS
            String websiteContent =
                    "<html><head><style>" +
                            website.getCssContent() +
                            "</style></head><body>" +
                            website.getHtmlContent() +
                            "<script>" +
                            website.getJsContent() +
                            "</script></body></html>";

            return ResponseEntity.ok().body(websiteContent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable int id) {
        templateService.deleteTemplateById(id);
    }
}
