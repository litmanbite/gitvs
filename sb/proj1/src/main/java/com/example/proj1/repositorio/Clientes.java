package com.example.proj1.repositorio;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.proj1.entities.Cliente;

@Repository
public class Clientes {
    private static final String INSERT = "INSERT INTO cliente (nome) VALUES (?)";    
    private static final String SELECT_ALL = "SELECT * FROM cliente";    
    private static final String UPDATE = "UPDATE cliente SET nome = ? WHERE id = ?";    
    private static final String DELL = "DELETE FROM cliente WHERE id = ?";  
    private static final String SELECT_NOME = "SELECT * FROM cliente WHERE nome LIKE ?";  

    //JDBC SERIA ALGO MAIS DESATUALIZADO

    @Autowired
    private JdbcTemplate jdbctemplate;
    

    public Cliente salvar(Cliente cliente){
        jdbctemplate.update(INSERT, new Object[]{cliente.getName()});
        return cliente;
    }

    public List<Cliente> obterTodos() {
        return jdbctemplate.query(SELECT_ALL, mapaCliente());
    }

    @SuppressWarnings("deprecation")
    public List<Cliente> buscaNome(String name) {
        return jdbctemplate.query(SELECT_NOME, new Object[]{"%" + name + "%"},mapaCliente());
    }

    public Cliente atualizar(Cliente cliente){
        jdbctemplate.update(UPDATE, new Object[] {cliente.getName(),cliente.getId()});
        return cliente;
    }

    public void deletar(Integer id){
        jdbctemplate.update(DELL, new Object[] {id});       
    }

    public RowMapper<Cliente> mapaCliente(){
        return new RowMapper<Cliente>() {          
        
            public Cliente mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
                Cliente cliente = new Cliente();
                cliente.setName(rs.getString("nome"));
                cliente.setId(rs.getInt("id"));
                return cliente;
            }
    
        };
    }

}
