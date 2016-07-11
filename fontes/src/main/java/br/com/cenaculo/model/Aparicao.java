/**
 * 
 */
package br.com.cenaculo.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author prisc
 *
 */
public class Aparicao {
	@SerializedName("aparicaoId")
	private Integer idaparicao;
	
	@SerializedName("nome")
	private String nome;
	
	@SerializedName("descricao")
	private String descricao;
	
	@SerializedName("dia")
	private Integer dia;
	
	@SerializedName("mes")
	private Integer mes;
	
	@SerializedName("ano")
	private Integer ano;
	
	@SerializedName("foto")
	private String foto;

	public Aparicao() {
		super();
	}
	
	


	public Aparicao(Integer idaparicao, String nome, String descricao, Integer dia, Integer mes, Integer ano,
			String foto) {
		super();
		this.idaparicao = idaparicao;
		this.nome = nome;
		this.descricao = descricao;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.foto = foto;
	}




	public Integer getIdaparicao() {
		return idaparicao;
	}


	public void setIdaparicao(Integer idaparicao) {
		this.idaparicao = idaparicao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	

	public Integer getAno() {
		return ano;
	}




	public void setAno(Integer ano) {
		this.ano = ano;
	}




	@Override
	public String toString() {
		return "Aparicao [idaparicao=" + idaparicao + ", nome=" + nome + ", descricao=" + descricao + ", dia=" + dia
				+ ", mes=" + mes + ", ano=" + ano + ", foto=" + foto + "]";
	}





}
