package com.example.proj1.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.proj1.entities.Cliente;
import com.example.proj1.entities.Produto;
import com.example.proj1.repositorio.Produtos;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private Produtos p;

    public ProdutoController(Produtos p) {
        this.p = p;
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Integer id){
        //return p.findOneById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (p.findOneById(id) != null)
            return p.findOneById(id);   
        else 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);     
    }

    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save( @RequestBody Produto produto ){
        Produto produtoSalvo = p.save(produto);
        return produtoSalvo;
    }
    
     @DeleteMapping("/produtos/{id}")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Integer id){
                p.findById(id)
                    .map(produto ->{
                        p.delete(produto);
                        return produto; 
                    } )
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

            

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        p.findById(id)
            .map(existingProduto -> {
                produto.setId(existingProduto.getId()); // Ensures that the ID from the existing client is used
                p.save(produto); // Saves the updated cliente
                return produto; 
            })
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); // Returns 404 Not Found if the cliente is not found
    }

    @GetMapping("/produtos")
    public List<Produto> find(Produto filtroProduto) {
        // Create an ExampleMatcher to customize how fields should be matched
        ExampleMatcher em = ExampleMatcher
                                .matching()
                                .withIgnoreCase() // Ignore case for string comparisons
                                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); // Partial match for strings
    
        // Create an Example object using the filter Cliente and the ExampleMatcher
        Example<Produto> ex = Example.of(filtroProduto, em);
    
    
        // Return the filtered list in the response
        return p.findAll(ex);
    }
}
