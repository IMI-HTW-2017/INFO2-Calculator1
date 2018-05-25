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

        addButton(buttonPanel, "0xA");
        addButton(buttonPanel, "0xB");
        addButton(buttonPanel, "0xC");
        addButton(buttonPanel, "0xD");
        addButton(buttonPanel, "0xE");
        addButton(buttonPanel, "0xF");

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JCheckBox checkBox = new JCheckBox("Hex Mode?", true);
        checkBox.addActionListener(this);
        frame.getContentPane().add(checkBox, BorderLayout.WEST);

        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);

        String command = event.getActionCommand();

        if (command.equals("0xA") ||
            command.equals("0xB") ||
            command.equals("0xC") ||
            command.equals("0xD") ||
            command.equals("0xE") ||
            command.equals("0xF")) {
            int number = Integer.decode(command);
            if (isHexModeActive) {
                calcEngineHex.numberPressedHex(number);
            } else {
                calc.numberPressed(number);
            }
        } else if (command.equals("Hex Mode?")) {
            toggleHexMode();
        }

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

        if (isHexModeActive) {
            buttonPanel.setVisible(true);
        } else {
            buttonPanel.setVisible(false);
        }
    }
}
