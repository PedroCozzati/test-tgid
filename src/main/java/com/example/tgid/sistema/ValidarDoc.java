package com.example.tgid.sistema;

public class ValidarDoc {
    static String type;

    static boolean valida(String doc, String type) {
        String remover_chars_regex = "[^0-9]";
        doc = doc.replaceAll(remover_chars_regex, "");

        boolean digitos_sao_iguais = true;

        if (type.equals("cpf")) {
            for (int i = 1; i < 11; i++) {
                if (doc.charAt(i) != doc.charAt(0)) {
                    digitos_sao_iguais = false;
                    break;
                }
            }
            if (digitos_sao_iguais)
                return false;
        } else if (type.equals("cnpj")) {
            for (int i = 1; i < 14; i++) {
                if (doc.charAt(i) != doc.charAt(0)) {
                    digitos_sao_iguais = false;
                    break;
                }
            }
            if (digitos_sao_iguais)
                return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma = soma + Character.getNumericValue(doc.charAt(i)) * (10 - i);
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador >= 10)
            primeiroDigitoVerificador = 0;

        if (Character.getNumericValue(doc.charAt(9)) != primeiroDigitoVerificador)
            return false;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(doc.charAt(i)) * (11 - i);
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador >= 10)
            segundoDigitoVerificador = 0;

        return Character.getNumericValue(doc.charAt(10)) == segundoDigitoVerificador;
    }

    static void isCPFOrCNPJ(String doc) {
        if (doc.length() == 11) {
            type = "cpf";
        } else if (doc.length() == 14) {
            type = "cnpj";
        } else {
            type = "invalido";
        }
    }

    public static boolean validarDoc(String doc) {
        isCPFOrCNPJ(doc);
        if (!type.equals("invalido")) {
            return valida(doc, type);
        }
        return false;
    }


}
