/**
 * 
 */
package br.com.cenaculo.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author prisc
 *
 */
public class Santo {
	@SerializedName("santoId")
	private Integer santoId;
	
	@SerializedName("nome")
	private String nomeSanto;
	
	@SerializedName("descricao")
	private String descricao;
	
	@SerializedName("dia")
	private Integer dia;
	
	@SerializedName("mes")
	private Integer mes;
	
	@SerializedName("foto")
	private String foto;
	
	@SerializedName("status")
	private String status;
	
	public Santo() {
		super();
	}
	
	public Santo(Integer santoId, String nomeSanto, String descricao, Integer dia, Integer mes, String foto,
			String status) {
		super();
		this.santoId = santoId;
		this.nomeSanto = nomeSanto;
		this.descricao = descricao;
		this.dia = dia;
		this.mes = mes;
		this.foto = foto;
		this.status = status;
	}

	public Integer getSantoId() {
		return santoId;
	}
	public void setSantoId(Integer santoId) {
		this.santoId = santoId;
	}
	public String getNomeSanto() {
		return nomeSanto;
	}
	public void setNomeSanto(String nomeSanto) {
		this.nomeSanto = nomeSanto;
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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Santo [santoId=" + santoId + ", nomeSanto=" + nomeSanto + ", descricao=" + descricao + ", dia=" + dia
				+ ", mes=" + mes + ", foto=" + foto + ", status=" + status + "]";
	}

}
