public class CalculatorHex extends Calculator {

    private CalcEngineHex engine;
    private UserInterfaceHex gui;

    /**
     * Create a new calculator and show it.
     */
    public CalculatorHex() {
        engine = new CalcEngineHex();
        gui = new UserInterfaceHex(engine);
    }

    public static void main(String[] args) {
        new CalculatorHex();
    }
}
