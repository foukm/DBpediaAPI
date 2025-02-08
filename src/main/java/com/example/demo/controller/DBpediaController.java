package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.DBpediaSpotlightService;


@Controller
public class DBpediaController {

    private final DBpediaSpotlightService spotlightService;

    public DBpediaController(DBpediaSpotlightService spotlightService) {
        this.spotlightService = spotlightService;
    }
    //gia dedault me to pou mpei kapoios
    @GetMapping("/")
    public String showForm() {
        return "form";
    }
    //meta to etoima
    @PostMapping("/annotate")
    public String annotateText(@RequestParam("text") String text, Model model) {
        String result;
        //an empty
        if(text.isEmpty()){
            model.addAttribute("error", "Empty text");
            return "form";
        }
        result = spotlightService.annotateText(text);
        model.addAttribute("text", text);
        model.addAttribute("annotatedText", result);
        return "result";
    }
}
