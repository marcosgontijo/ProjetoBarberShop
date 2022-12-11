/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author ninob
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view) {
        this.view = view;
        this.helper =  new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        Usuario usuario = helper.obterModelo();
              
        //Pegar usuario da view
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        //pesquisar no Banco
        //Se o usuario da view tiver o mesmo usuario e senha que o usuario vindo do banco direcionar para o menu principal
        if(usuarioAutenticado != null){
            //navegar para menu principal 
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            view.exibeMensagem("Usuario ou senha invalidos");
        }
        // Senão mostrar uma mensagem ao usuario "Usuario ou senha invalido"
        
    }
    
    public void fizTarefa(){
        System.err.println("Busquei algo no banco de dados");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
