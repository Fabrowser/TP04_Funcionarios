package com.mycompany.tp_04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DropMode;
import javax.swing.JToggleButton;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;


public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private ResultSet rs;
	private int indexado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		
		 Funcionarios funcionarios = new Funcionarios();
		 
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(215, 25, 77, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
				Conexao con = new Conexao();   
				PreparedStatement pstm = null;
				rs = null;
				
					pstm = con.conexao.prepareStatement("\r\n"
							+ "Select f.nm_funcionario, f.vl_salario, c.ds_cargo\r\n"
							+ "from tb_funcionario as f\r\n"
							+ "	INNER JOIN tb_cargo as c\r\n"
							+ "ON f.cd_cargo=c.cd_cargo where f.nm_funcionario='"
							+ textField.getText()+"'");
					
					rs = pstm.executeQuery();
					
					while(rs.next()) {
						
						 textField_1.setText(rs.getString(1));
						 textField_2.setText(rs.getString(2));
						 textField_3.setText(rs.getString(3));
						 		 			
					}
					
								
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
				
			}
		});
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(19, 26, 186, 19);
		contentPane.add(textField);
		textField.setColumns(20);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(64, 72, 159, 19);
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(textField_1);
		textField_1.setColumns(15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 101, 159, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(64, 130, 159, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(19, 75, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Salário");
		lblNewLabel_1.setBounds(19, 104, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo");
		lblNewLabel_2.setBounds(19, 133, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  /* JOptionPane.showMessageDialog(null,"TESTE");
		            
		            String nome = textField_1.getText();
		            float salario = Float.parseFloat(textField_2.getText());
		            String cargo = textField_3.getText();     
		        
		           Funcionario funcionario1 = new Funcionario(nome,salario,cargo);           
		           
		           JOptionPane.showMessageDialog(null, funcionario1.getNome());
		           JOptionPane.showMessageDialog(null, funcionario1.getSalario());
		           JOptionPane.showMessageDialog(null, funcionario1.getCargo());
		           
		           funcionarios.listaFuncionarios.add(funcionario1);
		           
		           JOptionPane.showMessageDialog(null,"Quantidade de Funcionarios: " + funcionarios.listaFuncionarios.size());*/

			}
		});
		btnNewButton_1.setBounds(233, 100, 95, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Anterior");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				textField_1.setText(funcionarios.listaFuncionarios.get(indexado-1).nome);
				textField_2.setText(funcionarios.listaFuncionarios.get(indexado-1).salario+"");
				textField_2.setText(funcionarios.listaFuncionarios.get(indexado-1).cargo+"");
				indexado--;
			
			}
			});
		
		btnNewButton_2.setBounds(53, 159, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Próximo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			textField_1.setText(funcionarios.listaFuncionarios.get(indexado+1).nome);
			textField_2.setText(funcionarios.listaFuncionarios.get(indexado+1).salario+"");
			textField_2.setText(funcionarios.listaFuncionarios.get(indexado+1).cargo+"");
			indexado++;
			
			}

		});
		btnNewButton_3.setBounds(138, 159, 85, 21);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Limpar Filtro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				
				try {
					
					Conexao con = new Conexao();   
					PreparedStatement pstm = null;
					
					 
						int i = 0;
						//Filtro SQL SERVER
						pstm = con.conexao.prepareStatement("\r\n"
								+ "Select f.cd_funcionario, f.nm_funcionario, f.vl_salario, c.ds_cargo\r\n"
								+ "from tb_funcionario as f\r\n"
								+ "	INNER JOIN tb_cargo as c\r\n"
								+ "ON f.cd_cargo=c.cd_cargo ORDER by f.cd_funcionario");
						
						rs = pstm.executeQuery();
						
						
						//Limpando Objetos
						for (Funcionario func : funcionarios.listaFuncionarios) {
							
							funcionarios.listaFuncionarios.remove(func);
						}
						
						JOptionPane.showMessageDialog(null,"Quantidade de Funcionarios: " + funcionarios.listaFuncionarios.size());
						
						
						//Realocando Objetos de acordo com a Query
						
						while(rs.next()) {
						
							Funcionario func = new Funcionario (rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
							funcionarios.setFuncionario(func);
							i++;
							 		 			
						}
						
						
						JOptionPane.showMessageDialog(null,"Quantidade de Funcionarios: " + funcionarios.listaFuncionarios.size());
						
						textField_1.setText(funcionarios.listaFuncionarios.get(0).nome);
						textField_2.setText(funcionarios.listaFuncionarios.get(0).salario+",00");
						textField_3.setText(funcionarios.listaFuncionarios.get(0).cargo);
						indexado=0;
							
									
					} catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
					
					
				}
		});
		
		btnNewButton_4.setBounds(233, 71, 95, 21);
		contentPane.add(btnNewButton_4);
	}
}
