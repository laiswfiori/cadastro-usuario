package com.proj1spring.cadastro_receita.controller;

import com.proj1spring.cadastro_receita.business.ReceitaService;
import com.proj1spring.cadastro_receita.infrastructure.entitys.Receita;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Void> salvarReceita(@RequestBody Receita receita) {
        receitaService.salvarReceita(receita);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Receita>> buscarReceitasPorNome(@PathVariable String nome) {
        try {
            List<Receita> receitas = receitaService.buscarReceitasPorNome(nome);
            return ResponseEntity.ok(receitas);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping
    public ResponseEntity<List<Receita>> listarTodasReceitas() {
        return ResponseEntity.ok(receitaService.listarTodasReceitas());
    }

    @DeleteMapping("/nome/{nome}")
    public ResponseEntity<Void> deletarReceitaPorNome(@PathVariable String nome) {
        receitaService.deletarReceitaPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/nome/{nome}")
    public ResponseEntity<Void> atualizarReceitaPorNome(@PathVariable String nome, @RequestBody Receita receita) {
        receitaService.atualizarReceitaPorNome(nome, receita);
        return ResponseEntity.ok().build();
    }
}
