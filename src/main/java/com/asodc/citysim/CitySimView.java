package com.asodc.citysim;

import javax.swing.*;
import java.awt.*;

class CitySimView {
    private CityMap cityMap;
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
     * Heirarchy of containers inside JFrame
     *
     * mainPanel :: FlowLayout
     *     mapPanel :: BoxLayout
     *         mapView
     *     controlPanel :: BoxLayout
     *         infoPanel
     *         inputPanel
     *         buttonPanel
     */
    CitySimView() {
        // mainPanel will be used as the contentPane
        mainPanel = new JPanel(new FlowLayout());

        // mapPanel
        mapPanel = new JPanel();
        mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.Y_AXIS));
        mapPanelLabel = new JLabel("Map Panel");
        mapPanel.add(mapPanelLabel);
        cityMap = new CityMap();
        cityMap.setName("cityMap");
        mapPanel.add(cityMap);

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
        widthInputTextField = new JTextField("25");
        heightInputLabel = new JLabel("y:");
        heightInputTextField = new JTextField("25");
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

        // init frame
        frame = new JFrame("CitySim");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    JButton getGenerateButton() {
        return generateButton;
    }

    int getWidthInput() {
        try {
            return Integer.parseInt(widthInputTextField.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    int getHeightInput() {
        try {
            return Integer.parseInt(heightInputTextField.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    void update(CityModel cityModel) {
        widthInfoLabelValue.setText(Integer.toString(cityModel.getWidth()));
        heightInfoLabelValue.setText(Integer.toString(cityModel.getHeight()));
        // remove the old cityMap before creating a new one
        mapPanel.remove(cityMap);
        cityMap = new CityMap(cityModel);
        mapPanel.add(cityMap);
        cityMap.revalidate();
//        frame.pack();
    }

    void setLayoutDebugMode(boolean isDebugModeEnabled) {
        if(isDebugModeEnabled) {
            frame.setBackground(Color.YELLOW);
            mainPanel.setBackground(Color.PINK);
            mapPanel.setBackground(Color.MAGENTA);
            cityMap.setBackground(Color.BLUE);
            controlPanel.setBackground(Color.CYAN);
            infoPanel.setBackground(Color.GREEN);
            inputPanel.setBackground(Color.ORANGE);
            buttonPanel.setBackground(Color.RED);
        }
    }
}
