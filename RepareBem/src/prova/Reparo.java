package prova;
import java.util.Objects;

public class Reparo {
	private String id;
	private String descricao;
	private double preco;
	
	public Reparo(String id, String descricao, double preco) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparo other = (Reparo) obj;
		return Objects.equals(id, other.id);
	}


	public String getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}

	public void reajustarPreco(double porcentagem) {
		this.preco = this.preco * ((100 + porcentagem) / 100);
	}	
	
	
	
}


