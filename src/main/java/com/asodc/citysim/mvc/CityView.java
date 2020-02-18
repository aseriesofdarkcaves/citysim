package com.asodc.citysim.mvc;

import javax.swing.*;
import java.awt.*;

public class CityView {
    private final JFrame frame;
    private final JPanel uiPanel;
    private final MapPanel mapPanel;
    private final JPanel controlPanel;
    private final JPanel infoPanel;
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    private final JLabel mapPanelLabel;
    private final JLabel controlPanelLabel;
    private final JLabel widthInfoLabelKey;
    private final JLabel widthInfoLabelValue;
    private final JLabel heightInfoLabelKey;
    private final JLabel heightInfoLabelValue;
    private final JLabel widthInputLabel;
    private final JLabel heightInputLabel;
    private final JTextField widthInputTextField;
    private final JTextField heightInputTextField;
    private final JButton generateButton;

    /**
     * uiPanel: FlowLayout
     *     mapPanel
     *     controlPanel: BoxLayout
     *         infoPanel
     *         inputPanel
     *         buttonPanel
     */
    public CityView() {
        // TODO: refactor init logic to private submethods
        // set up JFrame
        frame = new JFrame("CitySim");
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // uiPanel will be used as the contentPane
        uiPanel = new JPanel(new FlowLayout());

        // mapPanel currently empty
        mapPanel = new MapPanel();
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
        widthInfoLabelKey = new JLabel("x:");
        widthInfoLabelValue = new JLabel("0");
        heightInfoLabelKey = new JLabel("y:");
        heightInfoLabelValue = new JLabel("0");
        infoPanel.add(widthInfoLabelKey);
        infoPanel.add(widthInfoLabelValue);
        infoPanel.add(heightInfoLabelKey);
        infoPanel.add(heightInfoLabelValue);

        // inputPanel allows the user to input values
        inputPanel = new JPanel();
        widthInputLabel = new JLabel("x:");
        widthInputTextField = new JTextField("0");
        heightInputLabel = new JLabel("y:");
        heightInputTextField = new JTextField("0");
        inputPanel.add(widthInputLabel);
        inputPanel.add(widthInputTextField);
        inputPanel.add(heightInputLabel);
        inputPanel.add(heightInputTextField);

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
        // TODO: delegate this to the controller?
        frame.setVisible(true);
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    // TODO: return Swing objects or primatives?
    // TODO: manage negative inputs here?
    public int getWidthInput() {
        try {
            return Integer.parseInt(widthInputTextField.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public int getHeightInput() {
        try {
            return Integer.parseInt(heightInputTextField.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public void setWidthInfo(int value) {
        widthInfoLabelValue.setText(Integer.toString(value));
    }

    public void setHeightInfo(int value) {
        heightInfoLabelValue.setText(Integer.toString(value));
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
