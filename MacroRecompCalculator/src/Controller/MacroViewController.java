package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Model.Calculation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Nicholas
 */
public class MacroViewController {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField weightText;
    
    @FXML
    private TextField heightText;
    
    @FXML
    private TextField ageText;
    
    @FXML
    private TextField lifeStyleText;
    
    @FXML
    private TextField bodyFatPercentage;
    
    @FXML 
    private RadioButton maleRadioButton;
    
    @FXML 
    private RadioButton femaleRadioButton;
  
    @FXML 
    private RadioButton cutRadioButton;
    
    @FXML 
    private RadioButton bulkRadioButton;
    
    @FXML 
    private RadioButton maintainRadioButton;
 
    @FXML
    private Text bmrText;
    
    @FXML
    private Text calorieText;
    
    @FXML
    private Text leanBodyMassText;
    
    @FXML
    private TextField proteinText;
    
    @FXML
    private TextField fatText;
 
    @FXML
    private Text proteinDisplay;
    
    @FXML
    private Text fatDisplay;
    
    @FXML 
    private Text carbDisplay;
    
    
    float weightInput;
    float heightInput;
    int ageInput;
    float lifeStyleInput;
    float bodyFatPercentageInput;
    float finalCalories;
    float proteinInput;
    float fatInput;
    float carbs;

    Calculation calc = new Calculation();
    
    @FXML
    private void handleCalculateButton(ActionEvent event) {
        
        if(this.isEmpty(weightText) || !this.floatNumberOrNot(weightText.getText())) {
            System.out.println("error");
        }else if(this.isEmpty(heightText) || !this.floatNumberOrNot(heightText.getText())) {
            System.out.println("error");
        }else if(this.isEmpty(ageText) || !this.intNumberOrNot(ageText.getText())) {
            System.out.println("error");
        }else if(this.isEmpty(lifeStyleText) || this.validateMultiplier(lifeStyleText) || !this.floatNumberOrNot(lifeStyleText.getText())) {
            System.out.println("error");
        }else if(bodyFatPercentage.getText().isEmpty() || !this.floatNumberOrNot(bodyFatPercentage.getText())) {
            System.out.println("error");
        }else if(this.isEmpty(proteinText) || !this.floatNumberOrNot(proteinText.getText()) || this.validateProtein(proteinText)) {
            System.out.println("Error");
        }else if (this.isEmpty(fatText) || !this.floatNumberOrNot(fatText.getText()) || this.validateFat(fatText)) {
            System.out.println("Error");
        }
        else {
        
            //Take user input
            weightInput =Float.parseFloat(weightText.getText());
            heightInput = Float.parseFloat(heightText.getText());
            ageInput = Integer.parseInt(ageText.getText());
            lifeStyleInput = Float.parseFloat(lifeStyleText.getText());
            bodyFatPercentageInput = Float.parseFloat(bodyFatPercentage.getText());
            proteinInput = Float.parseFloat(proteinText.getText());
            fatInput = Float.parseFloat(fatText.getText());
        
            //Perform calculations
            if(maleRadioButton.isSelected()) {
                float maleBMR = calc.maleBMRCalculation(weightInput, heightInput, ageInput);
                float maintenanceCalories = calc.maintenanceCalorieCalculation(maleBMR, lifeStyleInput);
                float leanBodyMass = calc.leanBodyMassCalculation(weightInput, bodyFatPercentageInput);
                float dailyProtein = calc.proteinCalculation(leanBodyMass, proteinInput);
                
                if(cutRadioButton.isSelected()) {
                    finalCalories = calc.cuttingCalorieCalculation(maintenanceCalories);
                    String bmrString = Float.toString(maleBMR);
                    String maintenanceCaloriesString = Float.toString(finalCalories);
                    String leanBodyMassString = Float.toString(leanBodyMass);
                    String dailyProteinString = Float.toString(dailyProtein);
                    float dailyFat = calc.fatCalculation(fatInput, finalCalories);
                    String dailyFatString = Float.toString(dailyFat);
                    carbs = calc.carbCalculation(finalCalories, dailyProtein, dailyFat);
                    String dailyCarbString = Float.toString(carbs);
                    
                    
                    bmrText.setText(bmrString);
                    calorieText.setText(maintenanceCaloriesString);
                    leanBodyMassText.setText(leanBodyMassString);
                    proteinDisplay.setText(dailyProteinString);
                    fatDisplay.setText(dailyFatString);
                    carbDisplay.setText(dailyCarbString);
                } else if (bulkRadioButton.isSelected()) {
                    finalCalories = calc.bulkingCalorieCalculation(maintenanceCalories);
                    String bmrString = Float.toString(maleBMR);
                    String maintenanceCaloriesString = Float.toString(finalCalories);
                    String leanBodyMassString = Float.toString(leanBodyMass);
                    String dailyProteinString = Float.toString(dailyProtein);
                    float dailyFat = calc.fatCalculation(fatInput, finalCalories);
                    String dailyFatString = Float.toString(dailyFat);
                    carbs = calc.carbCalculation(finalCalories, dailyProtein, dailyFat);
                    String dailyCarbString = Float.toString(carbs);
                    
                    
                    bmrText.setText(bmrString);
                    calorieText.setText(maintenanceCaloriesString);
                    leanBodyMassText.setText(leanBodyMassString);
                    proteinDisplay.setText(dailyProteinString);
                    fatDisplay.setText(dailyFatString);
                    carbDisplay.setText(dailyCarbString);
                } else if(maintainRadioButton.isSelected()) {
                    finalCalories = maintenanceCalories;
                    String bmrString = Float.toString(maleBMR);
                    String maintenanceCaloriesString = Float.toString(finalCalories);
                    String leanBodyMassString = Float.toString(leanBodyMass);
                    String dailyProteinString = Float.toString(dailyProtein);
                    float dailyFat = calc.fatCalculation(fatInput, finalCalories);
                    String dailyFatString = Float.toString(dailyFat);
                    carbs = calc.carbCalculation(finalCalories, dailyProtein, dailyFat);
                    String dailyCarbString = Float.toString(carbs);
                    
                    
                    bmrText.setText(bmrString);
                    calorieText.setText(maintenanceCaloriesString);
                    leanBodyMassText.setText(leanBodyMassString);
                    proteinDisplay.setText(dailyProteinString);
                    fatDisplay.setText(dailyFatString);
                    carbDisplay.setText(dailyCarbString);
                } else {
                    System.out.println("Please select");
                }
            
           }else if (femaleRadioButton.isSelected()){
                float femaleBMR = calc.femaleBMRCalculation(weightInput, heightInput, ageInput);
                float maintenanceCalories = calc.maintenanceCalorieCalculation(femaleBMR, lifeStyleInput);
                float leanBodyMass = calc.leanBodyMassCalculation(weightInput, bodyFatPercentageInput);
                float dailyProtein = calc.proteinCalculation(leanBodyMass, proteinInput);
        
                if(cutRadioButton.isSelected()) {
                    finalCalories = calc.cuttingCalorieCalculation(maintenanceCalories);
                    String bmrString = Float.toString(femaleBMR);
                    String maintenanceCaloriesString = Float.toString(finalCalories);
                    String leanBodyMassString = Float.toString(leanBodyMass);
                    String dailyProteinString = Float.toString(dailyProtein);
                    float dailyFat = calc.fatCalculation(fatInput, finalCalories);
                    String dailyFatString = Float.toString(dailyFat);
                    carbs = calc.carbCalculation(finalCalories, dailyProtein, dailyFat);
                    String dailyCarbString = Float.toString(carbs);
                    
                    
                    bmrText.setText(bmrString);
                    calorieText.setText(maintenanceCaloriesString);
                    leanBodyMassText.setText(leanBodyMassString);
                    proteinDisplay.setText(dailyProteinString);
                    fatDisplay.setText(dailyFatString);
                    carbDisplay.setText(dailyCarbString);
                } else if (bulkRadioButton.isSelected()) {
                    finalCalories = calc.bulkingCalorieCalculation(maintenanceCalories);
                    String bmrString = Float.toString(femaleBMR);
                    String maintenanceCaloriesString = Float.toString(finalCalories);
                    String leanBodyMassString = Float.toString(leanBodyMass);
                    String dailyProteinString = Float.toString(dailyProtein);
                    float dailyFat = calc.fatCalculation(fatInput, finalCalories);
                    String dailyFatString = Float.toString(dailyFat);
                    carbs = calc.carbCalculation(finalCalories, dailyProtein, dailyFat);
                    String dailyCarbString = Float.toString(carbs);
                    
                    
                    bmrText.setText(bmrString);
                    calorieText.setText(maintenanceCaloriesString);
                    leanBodyMassText.setText(leanBodyMassString);
                    proteinDisplay.setText(dailyProteinString);
                    fatDisplay.setText(dailyFatString);
                    carbDisplay.setText(dailyCarbString);
                } else if(maintainRadioButton.isSelected()) {
                    finalCalories = maintenanceCalories;
                    String bmrString = Float.toString(femaleBMR);
                    String maintenanceCaloriesString = Float.toString(finalCalories);
                    String leanBodyMassString = Float.toString(leanBodyMass);
                    String dailyProteinString = Float.toString(dailyProtein);
                    float dailyFat = calc.fatCalculation(fatInput, finalCalories);
                    String dailyFatString = Float.toString(dailyFat);
                    carbs = calc.carbCalculation(finalCalories, dailyProtein, dailyFat);
                    String dailyCarbString = Float.toString(carbs);
                    
                    
                    bmrText.setText(bmrString);
                    calorieText.setText(maintenanceCaloriesString);
                    leanBodyMassText.setText(leanBodyMassString);
                    proteinDisplay.setText(dailyProteinString);
                    fatDisplay.setText(dailyFatString);
                    carbDisplay.setText(dailyCarbString);
                } else {
                    System.out.println("Please select");
                }
            } else{
                System.out.println("Please select");
        }
        
        }
    }
    
    @FXML
    public boolean isEmpty(TextField field) {
        if(field.getText().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @FXML
    public boolean validateMultiplier(TextField multiplier) {
        if (Float.parseFloat(multiplier.getText()) <= 1.2 || Float.parseFloat(multiplier.getText()) >= 2.21) {
            return true;
        } else {
            return false;
        }
    }
    
    @FXML
    public boolean validateProtein(TextField protein) {
        if(Float.parseFloat(proteinText.getText()) <= 1.2 || Float.parseFloat(proteinText.getText()) >= 1.61) {
            return true;
        } else {
            return false;
        }
    }
    
    @FXML
    public boolean validateFat(TextField fat) {
        if(Float.parseFloat(fatText.getText()) <= .20 || Float.parseFloat(fatText.getText()) >= .351) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean floatNumberOrNot(String input) {
        
        try {
            Float.parseFloat(input);
        }
        catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
    

    public boolean intNumberOrNot(String input) {
        
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
        
}
    


