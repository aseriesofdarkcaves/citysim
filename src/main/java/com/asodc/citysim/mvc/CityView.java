package com.asodc.citysim.mvc;

import javax.swing.*;
import java.awt.*;

public class CityView {
    private MapView mapView;
    private final JFrame frame;
    private final JPanel mainPanel;
    private final JPanel mapPanel;
    private final JPanel controlPanel;
    private final JPanel infoPanel;
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    private final JLabel mapPanelLabel;
    private final JLabel controlPanelLabel;
    private final JLabel infoPanelLabel;
    private final JLabel widthInfoLabelKey;
    private final JLabel widthInfoLabelValue;
    private final JLabel heightInfoLabelKey;
    private final JLabel heightInfoLabelValue;
    private final JLabel inputPanelLabel;
    private final JLabel widthInputLabel;
    private final JLabel heightInputLabel;
    private final JTextField widthInputTextField;
    private final JTextField heightInputTextField;
    private final JButton generateButton;

    /**
     * Heirarchy of UI containers
     *
     * mainPanel :: FlowLayout
     *     mapPanel :: BoxLayout
     *         mapView
     *     controlPanel :: BoxLayout
     *         infoPanel
     *         inputPanel
     *         buttonPanel
     */
    public CityView() {
        frame = new JFrame("CitySim");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // mainPanel will be used as the contentPane
        mainPanel = new JPanel(new FlowLayout());

        // mapView initially empty
        mapPanel = new JPanel();
        mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.Y_AXIS));
        mapPanelLabel = new JLabel("Map Panel");
        mapView = new MapView();
        mapPanel.add(mapPanelLabel);
        mapPanel.add(mapView);

        // controlPanel contains 3 sub-panels: infoPanel, inputPanel & buttonPanel
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setOpaque(true);
        controlPanelLabel = new JLabel("Control Panel");
        controlPanel.add(controlPanelLabel);

        // infoPanel contains information about the currently generated city
        infoPanel = new JPanel();
        infoPanelLabel = new JLabel("Info Panel");
        widthInfoLabelKey = new JLabel("x:");
        widthInfoLabelValue = new JLabel("0");
        heightInfoLabelKey = new JLabel("y:");
        heightInfoLabelValue = new JLabel("0");
        infoPanel.add(infoPanelLabel);
        infoPanel.add(widthInfoLabelKey);
        infoPanel.add(widthInfoLabelValue);
        infoPanel.add(heightInfoLabelKey);
        infoPanel.add(heightInfoLabelValue);

        // inputPanel allows the user to input values
        inputPanel = new JPanel();
        inputPanelLabel = new JLabel("Input Panel");
        widthInputLabel = new JLabel("x:");
        widthInputTextField = new JTextField("0");
        heightInputLabel = new JLabel("y:");
        heightInputTextField = new JTextField("0");
        inputPanel.add(inputPanelLabel);
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

        mainPanel.add(mapPanel);
        mainPanel.add(controlPanel);
        // I think this stops repainting of everything behind it, should be ok for now
        mainPanel.setOpaque(true);

        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

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

    public void update(CityModel city) {
        widthInfoLabelValue.setText(Integer.toString(city.getWidth()));
        heightInfoLabelValue.setText(Integer.toString(city.getHeight()));
        mapView = new MapView(city);
        mapView.repaint();
    }

    public void setLayoutDebugMode(boolean isDebugModeEnabled) {
        if(isDebugModeEnabled) {
            frame.setBackground(Color.YELLOW);
            mainPanel.setBackground(Color.PINK);
            mapPanel.setBackground(Color.MAGENTA);
            mapView.setBackground(Color.BLUE);
            controlPanel.setBackground(Color.CYAN);
            infoPanel.setBackground(Color.GREEN);
            inputPanel.setBackground(Color.ORANGE);
            buttonPanel.setBackground(Color.RED);
        }
    }
}
