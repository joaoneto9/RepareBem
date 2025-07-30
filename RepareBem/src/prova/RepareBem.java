package prova;

public class RepareBem {
	
	private OrdemServico[] servicos;
	private Reparo[] reparos;
	private static final int QUANTIDADE_REPAROS = 100;
	private static final int QUANTIDADE_SERVICOS = 500;
	private int indiceReparo; // ja inicia com zero
	private int indiceServico; // ja inicia com zero
	
	public RepareBem() {
		this.reparos = new Reparo[QUANTIDADE_REPAROS];
		this.servicos = new OrdemServico[QUANTIDADE_SERVICOS];
	}
	
	public void cadastrarReparo(String id, String descricao, double preco) {	
		if (indiceReparo >= QUANTIDADE_REPAROS) return; //cheio
		
		if (temReparo(id)) return; //ja cadastrado
		
		Reparo novo = new Reparo(id, descricao, preco);
		reparos[indiceReparo++] = novo;	// cadastra novo reparo e incrementa o indice de reparos
	}
	
	public void reajustarPrecoReparo(String idReparo, double percentual){
		Reparo reparo = getReparo(idReparo); // busca o reparo
		reparo.reajustarPreco(percentual); // repara o preco com percentual
	}
	
	public int cadastrarOrdemDeServico( String cliente, String telefone, String roupa) {
		if (indiceServico >= QUANTIDADE_SERVICOS) return -1; // nao adiciona, esta cheio
		
		servicos[indiceServico++] = new OrdemServico(indiceServico, cliente, telefone, roupa); // insere no array
		
		return indiceServico; // retorna indice que identifica a OS
	}
	
	public String exibirOrdemDeServico(int idOs) {
		return getOrdemServico(idOs).toString();
	}
	
	public void incluirReparoOrdemDeServico( int idServico, String idReparo ) {
		Reparo reparo = getReparo(idReparo); // busca reparo
		
		OrdemServico ordemServico = getOrdemServico(idServico); // busca a ordem de servico
	
		ordemServico.incluirReparo(reparo); // adiciona o reparo na ordem de servico
	}
	
	public void mudarStatusOrdemDeServico( int idOs, String status) {
		getOrdemServico(idOs).setStatus(status); // busca e muda o status
	}
	
	public double obterValorOrdemServico(int idOs) {
		return getOrdemServico(idOs).calcularValor(); // retorna o valor total da ordem de servico
	}
	
	public String listarOrdemDeServico( String status ) {
		return listarOrdensDeServico(status); // lista todas as Ordens de servico com esse status
	}
	
	public String listarOrdemDeServico( ) {
		return listarOrdensDeServico(); // lista todas as ordens de servico
	}
	
	private String listarOrdensDeServico() {
		String resultado = "Ordens de Serviço" + "\n\n";
		
		for (int i = 0; i < indiceServico; i++) {
			resultado += servicos[i].toString() + "\n"; 
			// concatena a representacao textual de todos os servicos na String resultante
		}
		
		return resultado;
	}
	
	private String listarOrdensDeServico(String status) {
		String resultado = "Ordens de Serviço - " + status + "\n\n";
		
		for (int i = 0; i < indiceServico; i++) {
			if (servicos[i].getStatus().equals(status))
				resultado += servicos[i].toString() + "\n"; 
				// se for igual, concatena na String resultante
		}
		
		return resultado;	
	}
	
	private OrdemServico getOrdemServico(int idServico) throws IllegalArgumentException {
		if (servicos[idServico - 1] == null)
			throw new IllegalArgumentException("Id não existente no array de serviços"); 
		// indice invalido, lançar exceção
		
		return servicos[idServico - 1];
	}

	private Reparo getReparo(String id) throws IllegalArgumentException {
		for (int i = 0; i < indiceReparo; i++)
			if (reparos[i].getId().equals(id))
				return reparos[i];
		
		throw new IllegalArgumentException("Id não existente no array de reparos"); 
		// caso não encontrar, lança excessão, como foi pedido na documentação
		
	}
	
	private boolean temReparo(String id) {
		for (int i = 0; i < indiceReparo; i++)
			if (reparos[i].getId().equals(id))
				return true;
		
		return false;		
	}
	

}
