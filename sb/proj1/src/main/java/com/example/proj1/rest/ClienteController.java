package com.example.proj1.rest;

import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.proj1.entities.Cliente;
import com.example.proj1.repositorio.Clientes;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private Clientes c;

    public ClienteController(Clientes c) {
        this.c = c;
    }

    @GetMapping("/{id}")//o valor vindo dessa url vai pra variavel ali embaixo     
    public Cliente getClienteById(@PathVariable Integer id){

        return c
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
      
    }
    //request eh o que ta entrando, response saindo
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @RequestBody @Valid Cliente cliente ){
        Cliente clienteSalvo = c.save(cliente);
        return clienteSalvo;
    }

    @DeleteMapping("/clientes/{id}")    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable Integer id){
                c.findById(id)
                    .map(cliente ->{
                        c.delete(cliente);
                        return cliente; 
                    } )
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

            

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable Integer id, @RequestBody @Valid Cliente cliente) {
        c.findById(id)
            .map(existingCliente -> {
                cliente.setId(existingCliente.getId()); // Ensures that the ID from the existing client is used
                c.save(cliente); // Saves the updated cliente
                return cliente; 
            })
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); // Returns 404 Not Found if the cliente is not found
    }

    @GetMapping("/clientes")
    public List<Cliente> find(Cliente filtroCliente) {
        // Create an ExampleMatcher to customize how fields should be matched
        ExampleMatcher em = ExampleMatcher
                                .matching()
                                .withIgnoreCase() // Ignore case for string comparisons
                                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); // Partial match for strings
    
        // Create an Example object using the filter Cliente and the ExampleMatcher
        Example<Cliente> ex = Example.of(filtroCliente, em);
    
    
        // Return the filtered list in the response
        return c.findAll(ex);
    }
    
}
