package com.bwinchester.controller;
import com.bwinchester.EmailManager;
import com.bwinchester.view.ColorTheme;
import com.bwinchester.view.FontSize;
import com.bwinchester.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionWindowController extends BaseController implements Initializable {

        public OptionWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
                super(emailManager, viewFactory, fxmlName);
        }
        @FXML
        private Slider fontSizePicker;

        @FXML
        private ChoiceBox<ColorTheme> themePicker;

        @FXML
        void applyButtonAction() {

        }

        @FXML
        void cancelButtonAction() {
                Stage stage = (Stage) fontSizePicker.getScene().getWindow();
                viewFactory.closeStage(stage);
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                setUpThemePicker();
                setUpSizePicker();
        }

        private void setUpSizePicker() {
                fontSizePicker.setMin(0);
                fontSizePicker.setMax(FontSize.values().length - 1);
                fontSizePicker.setValue(viewFactory.getFontSize().ordinal());
                fontSizePicker.setMajorTickUnit(1);
                fontSizePicker.setMinorTickCount(0);
                fontSizePicker.setBlockIncrement(1);
                fontSizePicker.setSnapToTicks(true);
                fontSizePicker.setShowTickMarks(true);
                fontSizePicker.setShowTickLabels(true);
                fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
                        @Override
                        public String toString(Double object) {
                                int i = object.intValue();
                                return FontSize.values()[i].toString();
                        }

                        @Override
                        public Double fromString(String string) {
                                return null;
                        }
                });
                fontSizePicker.valueProperty().addListener((obs, oldVal, newVal) -> {
                        fontSizePicker.setValue(newVal.intValue());
                });
        }

        private void setUpThemePicker() {
                themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
                themePicker.setValue(viewFactory.getColorTheme());
        }
}
