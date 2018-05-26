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
        super.actionPerformed(event);

        String command = event.getActionCommand();

        if (command.equals("a") ||
            command.equals("b") ||
            command.equals("c") ||
            command.equals("d") ||
            command.equals("e") ||
            command.equals("f")) {
            int number = Integer.decode("0x" + command);
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

        buttonPanel.setVisible(isHexModeActive);
    }
}
