package br.com.fiap.haras_kzd.controller;

import br.com.fiap.haras_kzd.model.Vacina;
import br.com.fiap.haras_kzd.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacinas")
public class VacinaController {

    @Autowired
    private VacinaRepository vRep;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vacinas", vRep.findAll());
        return "vacina/vacina";
    }

    // NOVA
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("vacina", new Vacina());
        return "vacina/cadastroVacina";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Vacina vacina) {
        vRep.save(vacina);
        return "redirect:/vacinas";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Vacina vacina = vRep.findById(id).orElseThrow();
        model.addAttribute("vacina", vacina);
        return "vacina/cadastroVacina";
    }

    // DELETAR
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        vRep.deleteById(id);
        return "redirect:/vacinas";
    }

}
