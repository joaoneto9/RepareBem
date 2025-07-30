package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import prova.OrdemServico;
import prova.RepareBem;
import prova.Reparo;

// testes que o simulado pediu ára serem feitos 
// -> OBS: apenas esses são considerados na correção
class ReaparoBemTest {
	
	private Reparo reparo1;
	private OrdemServico os1;
	
	
	@BeforeEach
	void ReparoBemTest() {
		this.reparo1 = new Reparo("reparo1", "descricao", 100);
		this.os1 = new OrdemServico(1, "joaozinho", "(83) 9919-91992", "Camisa");
	}
	
	// teste do reajuste do valor 
	@Test
	void reajustarPrecoReparoTest() {
		this.reparo1.reajustarPreco(70); // reajuste de 70 % 
		assertEquals(this.reparo1.getPreco(), 170); // retorno esperado -> 100 8 1.7
	}
	
	@Test
	void mudarStatusOrdemServicoTest() {
		String newStatus = "iniciado";
	
		String statusAntigo = this.os1.getStatus();
		
		this.os1.setStatus(newStatus);
		
		// testo se mudou realmente o status, com o anterior
		assertNotEquals(statusAntigo, this.os1.getStatus()); 
		
		// testo se mudou para o esperado
		assertEquals(this.os1.getStatus(), newStatus);
		
	}

}
