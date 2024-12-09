package com.example.patbingsu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patbingsu")
public class PatbingsuController {

  private final PatbingsuRepository repository;

  public PatbingsuController(PatbingsuRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public String list(Model model) {
    model.addAttribute("patbingsus", repository.findAll());
    return "list";
  }

  @GetMapping("/new")
  public String createForm(Model model) {
    model.addAttribute("patbingsu", new Patbingsu());
    return "form";
  }

  @PostMapping
  public String save(@ModelAttribute Patbingsu patbingsu) {
    repository.save(patbingsu);
    return "redirect:/patbingsu";
  }
}
