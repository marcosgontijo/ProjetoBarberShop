/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ninob
 */
public class AgendaHelper implements IHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
            
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamento().getModel();
        tableModel.setNumRows(0);
        
        
        //Percorrer a lista preenchendo o table model 
        
        for (Agendamento agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
            
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
            
            
            
        }
        
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        
        DefaultComboBoxModel comboBoxModel =  (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        
        for (Cliente cliente : clientes) {
            
            comboBoxModel.addElement(cliente); //aqui esta o truqe para adicionar clientes
            
        }
    }

    public void preencherServico(ArrayList<Servico> servicos) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
        
        for (Servico servico : servicos) {
            
            comboBoxModel.addElement(servico); //aqui esta o truqe para adicionar clientes
            
        }
        
    }

     public Cliente obterCliente() {
        return (Cliente) view.getjComboBoxCliente().getSelectedItem();
    }
    
    public Servico obterServico() {
        return (Servico) view.getjComboBoxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
       view.getjTextValor().setText(valor + "");
    }

    @Override
    public Object obterModelo() {
        //new Agendamento();
        String idString = view.getjTextID().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getjTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getJTextData().getText();
        String hora = view.getjTextHora().getText();
        String dataHora = data + " " + hora;   
        String observacao = view.getjTextObservacao().getText();
        
       Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
       return agendamento;
    }

    @Override
    public void limparTela() {
        view.getjTextID().setText("0");
        view.getjTextHora().setText("");
        view.getjTextObservacao().setText("");
        view.getJTextData().setText("");
    }
    
    
}
