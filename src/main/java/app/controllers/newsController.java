package app.controllers;

import app.enitites.Category;
import app.enitites.News;
import app.repositories.CategoriesRepository;
import app.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/")
@Controller
public class newsController {

    @Autowired
    private NewsRepository newsRepo;
    @Autowired
    private CategoriesRepository catsRepo;

    @GetMapping
    public String newsList(Model model) {
        model.addAttribute("newss", newsRepo.findAll());
        return "main";
    }

    @PostMapping
    public String saveNews (
            @RequestParam String text,
            @RequestParam String title,
            @RequestParam int category,
            @RequestParam int id){
        News news = newsRepo.findById(id);
        news.setCategory(catsRepo.findById(category));
        news.setTitle(title);
        news.setText(text);
        newsRepo.save(news);
        return "redirect:/";
    }


    @GetMapping("/add")
    public String addNewsPage (Model model){
        model.addAttribute("categories", catsRepo.findAll());
        return "add";
    }

    @PostMapping("/add")
    public String addNews (
            @RequestParam String text,
            @RequestParam String title,
            @RequestParam int category){
        newsRepo.save(new News(title,text,new Date(),catsRepo.findById(category)));
        return "redirect:/";
        }

    @GetMapping("/remove/{id}")
    public String removeNewsPage (
            @PathVariable int id,
            Model model){
        News news = newsRepo.findById(id);
        newsRepo.delete(news);
        return "redirect:/";
    }

    @GetMapping("redact/{id}")
    public String newsRedactForm(@PathVariable Integer id, Model model) {
        News news = newsRepo.findById(id);
        model.addAttribute("news", news);
        model.addAttribute("categories", catsRepo.findAll());
        return "redact";
    }

    @PostMapping("/search")
    public String search(
                @RequestParam String filterName,
                @RequestParam String filterValue,
                Model model) {
        switch (filterName){
            case "category":
                List<Category> categories = catsRepo.findByCategoryContaining(filterValue);
                ArrayList<News> newss = new ArrayList<>();
                for (Category c : categories)
                newss.addAll(newsRepo.findByCategoryId(c.getId()));
                model.addAttribute("newss", newss);
            break;
            case "text": model.addAttribute("newss", newsRepo.findByTextContaining(filterValue));break;
            case "title": model.addAttribute("newss", newsRepo.findByTitleContaining(filterValue));break;
        }
    return "main";
    }
}