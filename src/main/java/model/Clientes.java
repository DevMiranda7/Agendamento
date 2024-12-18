package model;

public class Clientes {
	
	//Atributos
	
	private String id_clientes;
	private String nome;
	private String dataMarcada;
	private String horario;
	private String valor;
	
	//Construtor vázio
	
	public Clientes() {
		super();
	}
	
	//Construtor secundário
	
	public Clientes(String id_clientes, String nome, String dataMarcada, String horario, String valor) {
		super();
		this.id_clientes = id_clientes;
		this.nome = nome;
		this.dataMarcada = dataMarcada;
		this.horario = horario;
		this.valor = valor;
	}
	
	//Métodos de acesso
	
	public void setId_cliente(String id_clientes) {
		this.id_clientes = id_clientes;
	}
	
	public String getId_cliente() {
		return id_clientes;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDataMarcada(String dataMarcada) {
		this.dataMarcada = dataMarcada;
	}
	
	public String getDataMarcada() {
		return dataMarcada;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	
}
