/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_04;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author fabri
 */
public class Funcionarios {
    
    ArrayList<Funcionario> listaFuncionarios = new ArrayList();
   
   public void setFuncionario(Funcionario func){
    
    listaFuncionarios.add(func);
}     
     
   public void getFuncioario(){

      
}
   
   public DefaultListModel listar(){
       
       String dados = "";
       
       JOptionPane.showMessageDialog(null, "TEMOS " + listaFuncionarios.size() + "FUNCIONARIOS");
       DefaultListModel model = new DefaultListModel();

       for(int i=0;i<listaFuncionarios.size();i++){
            
           dados = ("Nome: " + listaFuncionarios.get(i).nome + "-"+
                   "Salario: " + listaFuncionarios.get(i).salario + "-"+ 
                   "Cargo: " + listaFuncionarios.get(i).cargo);  
           
           model.addElement(dados);
       }
  
        return model;
    }
}
