package com.asodc.citysim;

import javax.swing.*;
import java.awt.*;

public class CitySimUI {
    private final JFrame frame;
    private final JPanel uiPanel;
    private final JPanel mapPanel;
    private final JPanel controlPanel;
    private final JPanel infoPanel;
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    private final JLabel mapPanelLabel;
    private final JLabel controlPanelLabel;
    private final JLabel xSizeInfoLabel;
    private final JLabel ySizeInfoLabel;
    private final JLabel xSizeInputLabel;
    private final JLabel ySizeInputLabel;
    private final JTextField xSizeInputTextField;
    private final JTextField ySizeInputTextField;
    private final JButton generateButton;

    /**
     * uiPanel: FlowLayout
     *     mapPanel
     *     controlPanel: BoxLayout
     *         infoPanel
     *         inputPanel
     *         buttonPanel
     */
    public CitySimUI() {
        // TODO: refactor logic to private methods
        // set up JFrame
        frame = new JFrame("CitySim");
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // uiPanel will be used as the contentPane
        uiPanel = new JPanel(new FlowLayout());

        // mapPanel currently empty
        mapPanel = new JPanel();
        mapPanelLabel = new JLabel("Map");
        mapPanel.add(mapPanelLabel);

        // controlPanel contains 3 sub-panels: infoPanel, inputPanel & buttonPanel
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
        controlPanel.setOpaque(true);
        controlPanelLabel = new JLabel("Control Panel");
        controlPanel.add(controlPanelLabel);

        // infoPanel contains information about the currently generated city
        infoPanel = new JPanel();
        xSizeInfoLabel = new JLabel("x: 0");
        ySizeInfoLabel = new JLabel("y: 0");
        infoPanel.add(xSizeInfoLabel);
        infoPanel.add(ySizeInfoLabel);

        // inputPanel allows the user to input values
        inputPanel = new JPanel();
        xSizeInputLabel = new JLabel("x:");
        xSizeInputTextField = new JTextField("10");
        ySizeInputLabel = new JLabel("y:");
        ySizeInputTextField = new JTextField("10");
        inputPanel.add(xSizeInputLabel);
        inputPanel.add(xSizeInputTextField);
        inputPanel.add(ySizeInputLabel);
        inputPanel.add(ySizeInputTextField);

        // buttonPanel contains the buttons
        buttonPanel = new JPanel();
        generateButton = new JButton("Generate");
        buttonPanel.add(generateButton);

        // add the 3 sub-panels to the controlPanel
        controlPanel.add(infoPanel);
        controlPanel.add(inputPanel);
        controlPanel.add(buttonPanel);

        uiPanel.add(mapPanel);
        uiPanel.add(controlPanel);
        // I think this stops repainting of everything behind it, should be ok for now
        uiPanel.setOpaque(true);

        frame.setContentPane(uiPanel);
        frame.setVisible(true);
    }

    public void setLayoutDebugMode(boolean isDebugModeEnabled) {
        if(isDebugModeEnabled) {
            frame.setBackground(Color.YELLOW);
            uiPanel.setBackground(Color.PINK);
            mapPanel.setBackground(Color.BLUE);
            controlPanel.setBackground(Color.CYAN);
            infoPanel.setBackground(Color.GREEN);
            inputPanel.setBackground(Color.ORANGE);
            buttonPanel.setBackground(Color.RED);
        }
    }
}
