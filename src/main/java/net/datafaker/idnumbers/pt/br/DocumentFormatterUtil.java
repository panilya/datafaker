package net.datafaker.idnumbers.pt.br;

public final class DocumentFormatterUtil {

    private DocumentFormatterUtil() {
    }

    public static String cnpj(String cnpj) {
        final char[] input = cnpj.toCharArray();
        final char[] res = new char[cnpj.length() + 4];
        // Format should be ##.###.###/####-##
        System.arraycopy(input, 0, res, 0, 2);
        res[2] = '.';
        System.arraycopy(input, 2, res, 3, 3);
        res[6] = '.';
        System.arraycopy(input, 5, res, 7, 3);
        res[10] = '/';
        System.arraycopy(input, 8, res, 11, 4);
        res[15] = '-';
        System.arraycopy(input, 12, res, 16, cnpj.length() - 12);
        return String.valueOf(res);
    }

    public static String cpf(String cpf) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(cpf, 0, 3)
                .append('.').append(cpf, 3, 6)
                .append('.').append(cpf, 6, 9)
                .append('-').append(cpf, 9, cpf.length());
        return sb.toString();
    }

    public static String unmask(String doc) {
        final char[] res = new char[doc.length()];
        int index = 0;
        for (int i = 0; i < doc.length(); i++) {
            final char c = doc.charAt(i);
            if (Character.isDigit(c)) {
                res[index++] = c;
            }
        }
        return String.valueOf(res, 0, index);
    }

}
