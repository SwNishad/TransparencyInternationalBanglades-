/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Acer
 */
public class FinanceRecord {
    
    private float currentAssets;
    private float currentLiabilities;
    private float cashInHand;
    private float marketableSecurities;
    
    public FinanceRecord(float currentAssets, float currentLiabilities, float cashInHand, float marketableSecurities) {
        this.currentAssets = currentAssets;
        this.currentLiabilities = currentLiabilities;
        this.cashInHand = cashInHand;
        this.marketableSecurities = marketableSecurities;
    }
    
    //Financial methods
    
    public float calculateCurrentRatio(float currentAssets, float currentLiabilities) {
        float currentRatio;
        currentRatio = currentAssets / currentLiabilities;
        return currentRatio;
    }
    
    public float calculateCashRatio(float cashInHand, float marketableSecurities, float currentLiabilities) {
        float cashRatio;
        cashRatio = (cashInHand + marketableSecurities)/currentLiabilities;
        return cashRatio;
    }
    
    public String cashToString(float ratioResult)
    {
        return "Cash Ratio = (cashInHand + marketableSecurities)/currentLiabilities = " + ratioResult;
    }
    
    public String currentToString(float ratioResult)
    {
        return "Current Ratio = currentAssets / currentLiabilities = " + ratioResult;
    }

    public float getCurrentAssets() {
        return currentAssets;
    }

    public float getCurrentLiabilities() {
        return currentLiabilities;
    }

    public float getCashInHand() {
        return cashInHand;
    }

    public float getMarketableSecurities() {
        return marketableSecurities;
    }

    public void setCurrentAssets(float currentAssets) {
        this.currentAssets = currentAssets;
    }

    public void setCurrentLiabilities(float currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public void setCashInHand(float cashInHand) {
        this.cashInHand = cashInHand;
    }

    public void setMarketableSecurities(float marketableSecurities) {
        this.marketableSecurities = marketableSecurities;
    }
    
    
    
}
