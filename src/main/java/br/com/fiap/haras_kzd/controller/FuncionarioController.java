package br.com.fiap.haras_kzd.controller;

import br.com.fiap.haras_kzd.model.EnumFuncao;
import br.com.fiap.haras_kzd.model.Funcionario;
import br.com.fiap.haras_kzd.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repo;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", repo.findAll());
        return "funcionario/funcionario";
    }

    // NOVO
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("funcoes", EnumFuncao.values());
        return "funcionario/cadastroFuncionario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario) {
        repo.save(funcionario);
        return "redirect:/funcionarios";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Funcionario funcionario = repo.findById(id).orElseThrow();
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("funcoes", EnumFuncao.values());
        return "funcionario/cadastroFuncionario";
    }

    // DELETAR
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/funcionarios";
    }

}

