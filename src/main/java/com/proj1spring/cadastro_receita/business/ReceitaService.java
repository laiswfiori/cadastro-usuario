package com.proj1spring.cadastro_receita.business;

import com.proj1spring.cadastro_receita.infrastructure.entitys.Receita;
import com.proj1spring.cadastro_receita.infrastructure.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    public void salvarReceita(Receita receita) {
        receitaRepository.save(receita);
    }

    public List<Receita> buscarReceitasPorNome(String nome) {
        List<Receita> receitas = receitaRepository.findByNomeIgnoreCase(nome);
        if (receitas.isEmpty()) {
            throw new RuntimeException("Nenhuma receita com nome '" + nome + "' foi encontrada.");
        }
        return receitas;
    }


    public List<Receita> listarTodasReceitas() {
        return receitaRepository.findAll();
    }

    public void deletarReceitaPorNome(String nome) {
        List<Receita> receitas = buscarReceitasPorNome(nome);
        Receita receita = receitas.get(0); // ou outra lógica para escolher
        receitaRepository.delete(receita);
    }

    public void atualizarReceitaPorNome(String nome, Receita novaReceita) {
        List<Receita> receitas = buscarReceitasPorNome(nome);
        Receita existente = receitas.get(0); // cuidado com nomes duplicados

        existente.setNome(novaReceita.getNome());
        existente.setIngredientes(novaReceita.getIngredientes());
        existente.setModoPreparo(novaReceita.getModoPreparo());
        existente.setCategoria(novaReceita.getCategoria());

        receitaRepository.save(existente);
    }

}
