package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Contract {

	private Integer codigo;
	private Date data;
	private Double valorTotal;


	private List<Installment> parcela = new ArrayList<>();

	public Contract() {

	}

	public Contract(Integer codigo, Date data, Double valorTotal) {
		this.codigo = codigo;
		this.data = data;
		this.valorTotal = valorTotal;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public List<Installment> getParcela() {
		return parcela;
	}



}
