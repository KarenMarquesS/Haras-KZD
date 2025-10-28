package br.com.fiap.haras_kzd.controller;

import br.com.fiap.haras_kzd.model.Funcionario;
import br.com.fiap.haras_kzd.model.Ovino;
import br.com.fiap.haras_kzd.repository.FuncionarioRepository;
import br.com.fiap.haras_kzd.repository.HistoricoRepository;
import br.com.fiap.haras_kzd.repository.OvinoRepository;
import br.com.fiap.haras_kzd.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ovinos")
public class OvinoController {

    @Autowired
    private OvinoRepository oRep;

    @Autowired
    private VacinaRepository vRep;

    @Autowired
    private FuncionarioRepository fRep;

    @Autowired
    private HistoricoRepository hRep;


    // === LISTAR ===
    @GetMapping
    public String listar(Model model) {
        List<Ovino> ovinos = oRep.findAll();
        model.addAttribute("ovinos", ovinos);

//        Map<Long, String> ganhoPesoPorOvino = new HashMap<>();
//        for (Ovino ovino : ovinos) {
//            ganhoPesoPorOvino.put(ovino.getId_ovino(), calcularGanhoDePeso(ovino));
//        }
//        model.addAttribute("ganhoPeso", ganhoPesoPorOvino);
        return "ovinos/listaOvinos";
    }

    // === CRIAR ===
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("ovino", new Ovino());
        return "ovinos/cadastroOvinos";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Ovino ovino) {
        oRep.save(ovino);
        return "redirect:/ovinos";
    }

    // === EDITAR ===
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Ovino ovino = oRep.findById(id).orElseThrow();
        model.addAttribute("ovino", ovino);
        return "ovinos/cadastroOvinos";
    }

    // === DELETAR ===
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        oRep.deleteById(id);
        return "redirect:/ovinos";
    }

    // === VISUALIZAR DETALHES + HISTÓRICO ===
    @GetMapping("/view/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Ovino ovino = oRep.findById(id).orElseThrow();
        model.addAttribute("ovino", ovino);
        model.addAttribute("vacinas", vRep.findAll());
        model.addAttribute("funcionarios", fRep.findAll());
        return "ovinos/view";
    }



}

