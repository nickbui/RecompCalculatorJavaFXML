/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nicholas
 */
public class Calculation {
    private float weightKG;
    private float heightCM;
    private int age;
    private float lifeStyleMultiplier;
   private float bodyFatPercentage;
   private float protein;
   private float fat;
   private float carbs;
    
    public Calculation() {
    
    
    }
    
    public float maleBMRCalculation(float weightKG, float heightCM, int age){
            float maleBMR = (float)((10 * weightKG) + (6.25 * heightCM) - (5 * age) + 5);
            return maleBMR;
        }
    
    public float femaleBMRCalculation(float weightKG, float heightCM, int age){
        float femaleBMR = (float) ((10*weightKG) +(6.25 * heightCM) - (5 * age) -161);
        return femaleBMR;
    }
    
    public float leanBodyMassCalculation(float weightKG, float bodyFatPercentage){
       float weightLBS = (float)(weightKG/0.453592);
       float bodyFat = (float) (bodyFatPercentage/100);
       float leanBodyMass = (float) (weightLBS -(weightLBS * bodyFat));
       return leanBodyMass;
    }
    
    public float maintenanceCalorieCalculation(float bmr, float lifeStyleMultiplier) {
        float maintenance = bmr * lifeStyleMultiplier;
        return maintenance;
    }
    
    public float cuttingCalorieCalculation(float maintenance) {
        float cuttingCalorie = maintenance -(maintenance * .10f);
        return cuttingCalorie;
    }
    
    public float bulkingCalorieCalculation(float maintenance) {
        float bulkingCalorie = maintenance + (maintenance * .10f);
        return bulkingCalorie;
    }
    
    public float proteinCalculation(float leanBodyMass, float proteinMultiplier ) {
        protein = leanBodyMass * proteinMultiplier;
        return protein;
    }
    
    public float fatCalculation(float fatMultiplier, float finalCalories) {
        fat = ((finalCalories * fatMultiplier)/9);
        return fat;
    }
    
    public float carbCalculation(float finalCalories, float protein, float fat) {
        carbs = (finalCalories- ((protein *4) + (fat *9)))/4;
        return carbs;
    }

    /**
     * @return the weightKG
     */
    public float getWeightKG() {
        return weightKG;
    }

    /**
     * @return the heightCM
     */
    public float getHeightCM() {
        return heightCM;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the lifeStyleMultiplier
     */
    public float getLifeStyleMultiplier() {
        return lifeStyleMultiplier;
    }

    /**
     * @return the bodyFatPercentage
     */
    public float getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    /**
     * @param weightKG the weightKG to set
     */
    public void setWeightKG(float weightKG) {
        this.weightKG = weightKG;
    }

    /**
     * @param heightCM the heightCM to set
     */
    public void setHeightCM(float heightCM) {
        this.heightCM = heightCM;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param lifeStyleMultiplier the lifeStyleMultiplier to set
     */
    public void setLifeStyleMultiplier(float lifeStyleMultiplier) {
        this.lifeStyleMultiplier = lifeStyleMultiplier;
    }

    /**
     * @param bodyFatPercentage the bodyFatPercentage to set
     */
    public void setBodyFatPercentage(float bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }
        
        
    }
