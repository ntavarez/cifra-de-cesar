package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Criptografia;
import main.CriptografiaCesariana;

public class CriptografiaCesarianaTest {

	private static final String TEXTO_CRIPTOGRAFADO = "500 gldv frp hod";
	private static final String TEXTO_DESCRIPTOGRAFADO = "500 dias com ela";

	private Criptografia criptografia;

	@Before
	public void before() {
		criptografia = new CriptografiaCesariana();
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarErroQuandoOCriptografaTextoEhVazio() {
		String texto = "Aprender Java gera felicidade";
		if (criptografia.criptografar(texto).isEmpty()) {
			throw new IllegalArgumentException("Não é possível criptografar: campo vazio.");
		}
	}

	@Test(expected = NullPointerException.class)
	public void deveRetornarErroQuandoCriptografaTextoEhNulo() {
		String texto = "Hello";
		if (criptografia.criptografar(texto).contains(null)) {
			throw new NullPointerException("Não é possível criptografar: valor nulo.");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarErroQuandoODesCriptografaTextoEhVazio() {
		String texto = "Dsuhqghu Mdyd jhud iholflgdgh";
		if (criptografia.criptografar(texto).isEmpty()) {
			throw new IllegalArgumentException("Não é possível criptografar: campo vazio.");
		}
	}

	@Test(expected = NullPointerException.class)
	public void deveRetornarErroQuandoDesCriptografaTextoEhNulo() {
		String texto = "Khoor";
		if (criptografia.descriptografar(texto).contains(null)) {
			throw new NullPointerException("Não é possível descriptografar: campo vazio.");
		}
	}

	@Test
	public void deveCriptografarTexto() {
		String texto = TEXTO_DESCRIPTOGRAFADO;
		assertEquals(TEXTO_CRIPTOGRAFADO, criptografia.criptografar(texto));
	}

	@Test
	public void deveDescriptografarTexto() {
		String texto = TEXTO_CRIPTOGRAFADO;
		assertEquals(TEXTO_DESCRIPTOGRAFADO, criptografia.descriptografar(texto));
	}

	@Test
	public void deveManterOsNumerosNaCriptografia() {
		String texto = "sejam bem vindos ao Acelera Brasil 2019";
		assertEquals("vhmdp ehp ylqgrv dr dfhohud eudvlo 2019", criptografia.criptografar(texto));
	}

	@Test
	public void deveManterOsNumerosNaDescriptografia() {
		String textoCifrado = "vhmdp ehp ylqgrv dr dfhohud eudvlo 2019";
		assertEquals("sejam bem vindos ao acelera brasil 2019", criptografia.descriptografar(textoCifrado));
	}

	@Test
	public void deveConverterCaracteresParaMinusculoNaCriptografia() {
		String texto = "Aprender Java gera felicidade";
		assertEquals("dsuhqghu mdyd jhud iholflgdgh", criptografia.criptografar(texto));
	}

	@Test
	public void deveConverterCaracteresParaMinusculoNaDescriptografia() {
		String textoCifrado = "Dsuhqghu Mdyd jhud iholflgdgh";
		assertEquals("aprender java gera felicidade", criptografia.descriptografar(textoCifrado));
	}

}
