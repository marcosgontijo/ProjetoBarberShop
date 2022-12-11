/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author ninob
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;
    
    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        
        //Buscar Lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        //Exibir essa lista na View
        helper.preencherTabela(agendamentos);
        
    }
    
    public void atualizaCliente(){
        //Buscar cliente do Banco e exibir clientes no comboBox cliente 
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        //exibir clientes no comboBox cliente 
        helper.preencherClientes(clientes);
        
    }
    
    public void atualizaServico(){
        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.selectAll();
        
         ArrayList<Servico> servicos = servicoDAO.selectAll();
         helper.preencherServico(servicos);
    }
    
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        //Busca lista de agendamento no banco de dados
        Agendamento agendamento = (Agendamento) helper.obterModelo();
        
        //salvar objeto no banco de dados
        new AgendamentoDAO().insert(agendamento);
        
        //inserir no banco de dados
        atualizaTabela();
        helper.limparTela();
                       
    }
    
}
