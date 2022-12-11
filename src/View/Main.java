/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;

/**
 *
 * @author ninob
 */
public class Main {
    
    public static void main(String[] args) {
        
        String nome = "nino";
        System.out.println(nome);
        
  
        Servico servico = new Servico(1, "barba", 30);
        
        Cliente cliente = new Cliente("rua teste", "123456789", 1, "Nino");
        System.out.println(cliente.getNome());
     
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "26/10/2022 09:15");
        System.err.println(agendamento.getCliente().getNome());
    }
    
} 
