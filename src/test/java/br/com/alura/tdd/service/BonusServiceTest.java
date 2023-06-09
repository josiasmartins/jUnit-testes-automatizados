package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		
		// testar exception no jUnit
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")))
		);
		
		// outra forma de fazer e pegar a mensagem da Exception
//		try {
//			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//			fail("Não deu a exception");
//		} catch (Exception e) {
//			Assertions.assertEquals("Funcionario com salário maior que R$10000 não pode receber bonus", e.getMessage());
//		}
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
		
		BigDecimal valorEsperado = new BigDecimal("250.00");
		
		Assertions.assertEquals(valorEsperado, bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
		
		BigDecimal valorEsperado = new BigDecimal("1000.00");
		
		Assertions.assertEquals(valorEsperado, bonus);
	}

}
