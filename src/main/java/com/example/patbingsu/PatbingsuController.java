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

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable Long id) {
    repository.deleteById(id);
    return "redirect:/patbingsu";
  }

  @PostMapping("/{id}/update")
  public String update(@PathVariable Long id, @RequestParam int price) {
    Patbingsu patbingsu = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Patbingsu ID:" + id));
    patbingsu.setPrice(price);
    repository.save(patbingsu);
    return "redirect:/patbingsu";
  }


}
