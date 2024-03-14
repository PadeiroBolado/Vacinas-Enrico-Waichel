package model.entity;

import java.time.LocalDate;

public class Pessoa {
	private int id;
	private String nome;
	private LocalDate dtaNascimento;
	private String sexo;
	private String cpf;
	public Pessoa() {
		super();
	}
	public Pessoa(int id, String nome, LocalDate dtaNascimento, String sexo, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtaNascimento = dtaNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String string) {
		this.sexo = string;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
