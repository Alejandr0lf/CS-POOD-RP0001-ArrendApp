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
    public default String isValidMovile(String number) {
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
    private String verifyMovile(String num) {
        if (num != null) {
            num = num.replaceAll("[^0-9]", "");
            if (num.length() >= 11 && num.length() <= 14) {
                return "+" + num;
            }
        }
        throw new IllegalArgumentException(
                "The inputed String isn't valid to convert into a number with the +[code][number] format!");
    }
}
