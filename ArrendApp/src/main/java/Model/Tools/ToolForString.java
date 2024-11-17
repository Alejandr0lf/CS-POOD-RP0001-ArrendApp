package Model.Tools;

public interface ToolForString {

    /**
     * This method will decompose the imputed String into an Array where the 0
     * element is the code of the country and the 1 element is the phone movile
     * number
     * 
     * @param number The String inputed
     * @return the Array with the code and the number
     */
    public default long[] decomposeNumber(String number) {
        if (isValidNumber(number)) {
            long[] twoParts = new long[2];
            String digitsOnly = number.replaceAll("[^0-9]", "");
            String num = digitsOnly.substring(digitsOnly.length() - 10);
            String code = digitsOnly.substring(0, digitsOnly.length() - 10);
            twoParts[1] = Long.valueOf(num);
            twoParts[0] = Long.valueOf(code);
            return twoParts;
        }
        StringBuilder error = new StringBuilder();
        error.append("JAVA-MT-TOOLFORSTRING: The inputed String is not valid like a phone movile number");
        error.append(padLeft("DECOMPOSE NUMBER ERROR", 80));
        throw new RuntimeException(error.toString());
    }

    /* -------------------------------------------------------------------------- */
    /* Private Methods */
    /* -------------------------------------------------------------------------- */

    /**
     * This method will comprobate if the String inputed is valid for the convertion
     * to a phone number
     * 
     * @param phoneNumber
     * @return
     */
    private boolean isValidNumber(String input) {
        if (input == null || input.isEmpty() || input.matches(".*[a-zA-Z].*")) {
            return false;
        }

        input = input.replaceAll("\\s+", "");

        // Verificar si comienza con '+' y tiene al menos 12 caracteres
        if (!input.startsWith("+") || input.length() <= 11) {
            return false;
        }

        // Verificar si tiene el formato adecuado: +[código][número de 10 dígitos]
        String regex = "\\+\\d{1,4}\\d{10}";
        if (!input.matches(regex)) {
            return false;
        }

        return true;
    }

    /**
     * This method will add a pading for a specific string
     * @param text
     * @param width
     * @return
     */
    private String padLeft(String text, int width) {
        return String.format("%" + width + "s", text);
    }
}
