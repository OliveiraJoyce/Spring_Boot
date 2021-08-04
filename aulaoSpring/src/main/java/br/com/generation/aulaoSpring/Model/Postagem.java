package br.com.generation.aulaoSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

@Entity // Entidade que conversa com o banco
@Table(name = "Tb_postagem") //Nome da tabela
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Chave Primaria
	private long id;
	
	@NotBlank
	@Size(min = 10, max = 500)
	private String texto;
	
	@NotBlank
	@Size(min = 5, max = 15)
	private String titulo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Data data = (Data) new java.sql.Date(System.currentTimeMillis());
}

