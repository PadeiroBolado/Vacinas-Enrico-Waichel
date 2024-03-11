package model.entity;

import java.time.LocalDate;

public class Pessoa {
	public String nome;
	public LocalDate dtaNascimento;
	public char sexo;
	public String cpf;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, LocalDate dtaNascimento, char sexo, String cpf) {
		super();
		this.nome = nome;
		this.dtaNascimento = dtaNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDtaNascimento() {
		return dtaNascimento;
	}
	
	public void setDtaNascimento(LocalDate dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
