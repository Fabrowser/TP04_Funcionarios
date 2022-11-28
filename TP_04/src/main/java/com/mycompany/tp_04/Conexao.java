package com.mycompany.tp_04;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;
import java.beans.Statement;
import javax.swing.*;


public class Conexao {
	
	
	protected String url;
	protected String driver;
	protected Connection conexao;
	
	
	public Conexao() throws SQLException, ClassNotFoundException {
			
		
		try
		         {
		url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=dbProdutos;trustServerCertificate=true;integratedSecurity=true;useSSL=false;";
		driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
		this.conexao =  DriverManager.getConnection(url);
		
		         }catch (Exception e) {
		        	 
		        	  JOptionPane.showMessageDialog(null,"Erro de Conexão");
		        	  
		        	 
					// TODO: handle exception
				}
		
		
	}
	
	public String dadosConexao() throws SQLException {
		
         //dados da conexao
         DatabaseMetaData db = conexao.getMetaData();
         System.out.println("Conectado a "+db.getURL());
         System.out.println("Conexao "+db.getConnection());
         System.out.println("Driver "+db.getDriverName());
         System.out.println("Usuario "+db.getUserName());
         System.out.println("----------------------------------");
         return "Conexao OK";

		}
	
	public void fecharConexao() throws SQLException {
        conexao.close();
     }
	
	
	}
	

