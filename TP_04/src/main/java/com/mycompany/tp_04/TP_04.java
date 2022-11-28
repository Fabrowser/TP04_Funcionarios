/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp_04;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author fabri
 */
public class TP_04 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
 
           Formulario formulario =  new Formulario();
           formulario.setVisible(true); 
           Conexao conexao = new Conexao();  
           JOptionPane.showMessageDialog(null, conexao.dadosConexao());    
           conexao.fecharConexao();
           
    }
           
    }
