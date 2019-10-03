package com.example.demo;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Controller
public class HomeController {
    @Autowired
    JobRepository jobRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String messageList(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";}

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/add")
    public String jobForm(Model model) {
        model.addAttribute("job", new Job());
        return "jobform";
    }


    @PostMapping("/process")
    public String processForm(@ModelAttribute Job job, @RequestParam("file") MultipartFile file, BindingResult result){
                            if(file.isEmpty()){
                                job.setDefaultPic();
                                jobRepository.save(job);
                                return "redirect:/";
                            }
                            try {
                                Map uploadResult = cloudc.upload(file.getBytes(),
                                        ObjectUtils.asMap("resourcetype","auto"));
                                job.setPic(uploadResult.get("url").toString());
                                jobRepository.save(job);
                            }catch (IOException e){
                                e.printStackTrace();
                                return  "redirect:/add";}
                            if (result.hasErrors()) {
                                return "jobform";
                            }
                            jobRepository.save(job);
                            return "redirect:/";
                        }

    @RequestMapping("/detail/{id}")
    public String showMessage(@PathVariable("id") long id, Model model){
        model.addAttribute("job",jobRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateItem(@PathVariable("id") long id, Model model){
        model.addAttribute("job",jobRepository.findById(id).get());
        return "jobform";}

    @RequestMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") long id){
        jobRepository.deleteById(id);
        return "redirect:/";
    }
    @PostMapping("/processsearch")
    public String searchResult(Model model,@RequestParam(name="search") String search) {
        model.addAttribute("jobs", jobRepository.findByContentContainingIgnoreCaseOrTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(search,search,search));
        return "index";
    }

}