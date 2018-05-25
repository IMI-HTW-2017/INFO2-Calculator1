public class CalcEngineHex extends CalcEngine {

    public void numberPressedHex(int number) {
        if(buildingDisplayValue) {
            // Incorporate this digit.
            displayValue = displayValue*16 + number;
        }
        else {
            // Start building a new number.
            displayValue = number;

            if (minus) {
                displayValue *= -1;
                minus = false;
            }

            buildingDisplayValue = true;
        }
    }

    public String getDisplayValueHex() {
        return Integer.toHexString(super.getDisplayValue());
    }
}
