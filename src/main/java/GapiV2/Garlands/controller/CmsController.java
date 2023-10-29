package GapiV2.Garlands.controller;

import GapiV2.Garlands.entity.CMS;
import GapiV2.Garlands.entity.Template;
import GapiV2.Garlands.repository.CmsRepo;
import GapiV2.Garlands.request.CmsAddRequest;
import GapiV2.Garlands.response.CmsGetResponse;
import GapiV2.Garlands.service.CmsService;
import GapiV2.Garlands.service.TemplateService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cms")
public class CmsController {
    private final CmsService cmsService;
    private final CmsRepo cmsRepo;
    private final TemplateService templateService;

    public CmsController(CmsService cmsService, CmsRepo cmsRepo, TemplateService templateService) {
        this.cmsService = cmsService;
        this.cmsRepo = cmsRepo;
        this.templateService = templateService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CmsGetResponse>> getAll(){
        return new ResponseEntity<>(cmsService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        CmsGetResponse cmsResponse = cmsService.getResponseById(id);
        if (cmsResponse != null) {
            int templateId = cmsResponse.getTemplateId();
            Template template = templateService.getWebsiteById(templateId);

            if (template != null) {
                String websiteContent = generateWebsiteContent(template, cmsResponse);
                return ResponseEntity.ok().body(websiteContent);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String generateWebsiteContent(Template template, CmsGetResponse cmsResponse) {
        String htmlContent = template.getHtmlContent();
        String cssContent = template.getCssContent();
        String jsContent = template.getJsContent();

        // Ganti placeholder dengan data dari CMS
        htmlContent = htmlContent.replace("{{title}}", cmsResponse.getTitle());
        htmlContent = htmlContent.replace("{{content}}", cmsResponse.getContent());
        htmlContent = htmlContent.replace("{{location}}", cmsResponse.getLocation());
        htmlContent = htmlContent.replace("{{userFirstName}}", cmsResponse.getUserFirstName());
        htmlContent = htmlContent.replace("{{userLastName}}", cmsResponse.getUserLastName());

        // Menggabungkan konten HTML, CSS, dan JS dari template
        String websiteContent = "<html><head><style>" +
                cssContent +
                "</style></head><body>" +
                htmlContent +
                "<script>" +
                jsContent +
                "</script></body></html>";

        return websiteContent;
    }



    @GetMapping("/get-by-user/{userId}")
    public ResponseEntity<List<CmsGetResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(cmsService.getAllByUser(userId),HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody CmsAddRequest cmsAddRequest){
        int cmsId = cmsService.add(cmsAddRequest);
        return new ResponseEntity<>(cmsId,HttpStatus.CREATED);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        cmsService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/cms/{id}")
    public CMS getCMS(@PathVariable int id, Model model) throws ChangeSetPersister.NotFoundException {
        CMS cms = cmsRepo.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        model.addAttribute("cms", cms);
        return cms;
    }
}
