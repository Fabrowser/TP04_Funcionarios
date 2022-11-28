/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_04;
/**
 *
 * @author fabri
 */
public class Funcionario {
    
protected int id;	
protected String nome;
protected float salario;
protected String cargo;


Funcionario(int i,String n,float sal,String c){
    
	id = i;
    nome=n;
    salario = sal;
    cargo =c;
  }

public void setNome(String nome){
    
nome=this.nome;       

}
public void setSalario(float salario){
    
    salario=this.salario;   

}
public void setCargo(String cargo){
    
    cargo=this.cargo;

}

public String getNome(){
    
    return nome;

}
public float getSalario(){
    
    return salario;

}
public String getCargo(){

    return cargo;
    
}
    
}
