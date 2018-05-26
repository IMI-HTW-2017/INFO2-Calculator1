import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserInterfaceHex extends UserInterface {

    private CalcEngineHex calcEngineHex;
    private JPanel buttonPanel;

    private boolean isHexModeActive = true;

    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    public UserInterfaceHex(CalcEngineHex engine) {
        super(engine);
        calcEngineHex = engine;
        addHexButtons();
    }

    private void addHexButtons() {
        buttonPanel = new JPanel(new GridLayout(2, 3));

        addButton(buttonPanel, "a");
        addButton(buttonPanel, "b");
        addButton(buttonPanel, "c");
        addButton(buttonPanel, "d");
        addButton(buttonPanel, "e");
        addButton(buttonPanel, "f");

        //Remove info text before adding new button panel
        frame.getContentPane().remove(frame.getContentPane().getComponentCount() - 1);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JCheckBox checkBox = new JCheckBox("Hex Mode?", true);
        checkBox.addActionListener(this);
        frame.getContentPane().add(checkBox, BorderLayout.WEST);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (!isHexModeActive)
            super.actionPerformed(event);
        else {
            switch (command) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "a":
                case "b":
                case "c":
                case "d":
                case "e":
                case "f":
                    calcEngineHex.numberPressedHex(Integer.decode("0x" + command));
                    break;
                case "+":
                    calc.plus();
                    break;
                case "-":
                    calc.minus();
                    break;
                case "=":
                    calc.equals();
                    break;
                case "C":
                    calc.clear();
                    break;
                case "x":
                    calc.multiply();
                    break;
                case "/":
                    calc.divide();
                    break;
            }
        }

        if (command.equals("Hex Mode?"))
            toggleHexMode();

        redisplay();
    }

    @Override
    protected void redisplay() {
        if (!isHexModeActive) {
            display.setText("" + calcEngineHex.getDisplayValue());
        } else {
            display.setText(calcEngineHex.getDisplayValueHex());
        }
    }

    private void toggleHexMode() {
        isHexModeActive = !isHexModeActive;

        redisplay();

        buttonPanel.setVisible(isHexModeActive);
        frame.pack();
    }
}
