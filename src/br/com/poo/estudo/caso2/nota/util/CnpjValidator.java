package br.com.poo.estudo.caso2.nota.util;

public class CnpjValidator {
    public static boolean isValidCNPJ(String cnpj) {
        // Remover caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verificar se o CNPJ tem 14 dígitos
        if (cnpj.length() != 14)
            return false;

        // Calcular o primeiro dígito verificador
        int sum = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            sum += (cnpj.charAt(i) - '0') * peso;
            peso++;
            if (peso == 10)
                peso = 2;
        }
        int remainder = sum % 11;
        int digito1 = (remainder < 2) ? 0 : (11 - remainder);

        // Verificar o primeiro dígito verificador
        if ((cnpj.charAt(12) - '0') != digito1)
            return false;

        // Calcular o segundo dígito verificador
        sum = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            sum += (cnpj.charAt(i) - '0') * peso;
            peso++;
            if (peso == 10)
                peso = 2;
        }
        remainder = sum % 11;
        int digito2 = (remainder < 2) ? 0 : (11 - remainder);

        // Verificar o segundo dígito verificador
        return (cnpj.charAt(13) - '0') == digito2;
    }
}
