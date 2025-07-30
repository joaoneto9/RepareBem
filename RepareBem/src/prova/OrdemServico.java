package prova;

import java.util.Objects;

public class OrdemServico {	
	
	private final static int LIMITE_REPAROS = 10;
	
	private int id;
	private String nomeCliente;
	private String telefoneCliente;
	private String roupa;
	private String status;
	private Reparo[] reparos;
	private int indiceReparos;
	
	public OrdemServico(int id, String nomeCliente, String telefoneCliente, String roupa) {
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
		this.roupa = roupa;
		this.status = "Não iniciado";
		this.reparos = new Reparo[LIMITE_REPAROS];
	}

	
	public void incluirReparo(Reparo novoReparo) {
		if (indiceReparos >= LIMITE_REPAROS)
			return;
		
		if (existReparo(novoReparo)) 
			return;
		
		this.reparos[indiceReparos++] = novoReparo;	
	}
	
	private boolean existReparo(Reparo novoReparo) {
		for (int i = 0; i < indiceReparos; i++) {
			
			if (reparos[i].equals(novoReparo))
				return true;
			
		}
		
		return false;
	}


	public double calcularValor() {
		double total = 0;
		
		for (int i = 0; i < indiceReparos; i++)
			total += reparos[i].getPreco();
		
		return total;
		
	}	
	
	public int getId() {
		return id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getRoupa() {
		return roupa;
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
		OrdemServico other = (OrdemServico) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "OrdemServico [#" + id +" nomeCliente=" + nomeCliente + ", "
				+ "roupa=" + roupa + ", reparos= " + indiceReparos + ", total= R$" + calcularValor() + "]";
	}
	
	
	
	
	
	
	
	
}
