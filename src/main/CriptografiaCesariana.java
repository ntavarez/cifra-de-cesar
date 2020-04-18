package main;

public class CriptografiaCesariana implements Criptografia {

	@Override
	public String criptografar(String texto) {
		String resultado = "";
		int rotacoes = 3;

		if (texto.isEmpty()) {
			return texto;
		} else {
			for (int i = 0; i < texto.length(); i++) {
				char ch = texto.charAt(i);
				if (ch >= 'A' && ch <= 'Z') {
					ch = (char) (ch + rotacoes);
					if (ch < 'A') {
						ch = (char) (ch - 26);
					}
				}
				if (ch >= 'a' && ch <= 'z') {
					ch = (char) (ch + rotacoes);
					if (ch < 'a') {
						ch = (char) (ch - 26);
					}
				}
				resultado += ch;
			}

			return resultado.toLowerCase();
		}
	}

	@Override
	public String descriptografar(String texto) {
		String resultado = "";
		int rotacoes = 3;

		if (texto.isEmpty()) {
			return texto;
		} else {
			for (int i = 0; i < texto.length(); i++) {
				char ch = texto.charAt(i);
				if (ch >= 'A' && ch <= 'Z') {
					ch = (char) (ch - rotacoes);
					if (ch < 'A') {
						ch = (char) (ch + 26);
					}
				}
				if (ch >= 'a' && ch <= 'z') {
					ch = (char) (ch - rotacoes);
					if (ch < 'a') {
						ch = (char) (ch + 26);
					}
				}
				resultado += ch;
			}
			return resultado.toLowerCase();
		}
	}
}
