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
    public default boolean isValidMovile(String number) {
        return this.verifyMovile(number);
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
    private boolean verifyMovile(String input) {

        // Verify if the String is not null
        if (input != null) {

            // Verify if the String isn't empty, and doesn't contains letters
            if (!input.isEmpty() || !input.matches(".*[a-zA-Z].*")) {

                // Replace all the spaces
                input = input.replaceAll("[^0-9]", "");
                String regex = "\\+\\d{1,4}\\d{10}";

                // Verify if the string starts with +, has more than 11 characters, and has the
                // regex format
                if (input.startsWith("+") && input.length() > 11 && input.matches(regex)) {
                    return true;
                }
            }
        }
        return false;
    }
}
