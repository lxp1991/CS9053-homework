package edu.nyu.cs9053.homework2;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: blangel
 * Date: 9/5/15
 * Time: 10:24 AM
 *
 * Hint, to compute a monthly mortgage payment use the following formula:
 * M = P (i(1 + i)^n) / ((1 + i)^n – 1)
 * where M is the monthly mortgage payment
 * where P is the principal of the loan, the loan amount
 * where i is the monthly interest rate
 * and where n is the duration in months of the loan
 *
 */
public class MortgageCalculator {

    /**
     * Use this scale when doing BigDecimal division.
     */
    private static final int DEFAULT_SCALE = 10;
    /**
     * Use this rounding mode when doing BigDecimal division.
     */
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    //Convert Year to Month
    private static final int YEAR_TO_MONTH = 12;
    
    
    public BigDecimal computeMonthlyPaymentOn15YearFixedLoan(double loanAmount, double annualInterestRateInPercent) {
    	BigDecimal bdLoanAmount = new BigDecimal(Double.toString(loanAmount));
        BigDecimal bdAnnualInterestRateInPercent = new BigDecimal(Double.toString(annualInterestRateInPercent));
        
        //Change Percent to Decimal
        BigDecimal bdAnnualInterestRateInDecimal = bdAnnualInterestRateInPercent.divide(new BigDecimal(100*YEAR_TO_MONTH), DEFAULT_SCALE, RoundingMode.HALF_UP);
    	BigDecimal bdNumeratorInFormula, bdDenominatorInFormula;
    	
        bdNumeratorInFormula = bdAnnualInterestRateInDecimal.add(new BigDecimal("1"));         //(1 + i)       
        bdNumeratorInFormula = bdNumeratorInFormula.pow(15*YEAR_TO_MONTH);                     //(1 + i)^n 
        bdDenominatorInFormula = bdNumeratorInFormula;                                         //Numerator and denominator has the same part: (1 + i)^n
        bdNumeratorInFormula = bdNumeratorInFormula.multiply(bdAnnualInterestRateInDecimal);   //i(1 + i)^n
        bdNumeratorInFormula = bdNumeratorInFormula.multiply(bdLoanAmount);                    //P (i(1 + i)^n)
    	

        bdDenominatorInFormula = bdDenominatorInFormula.subtract(new BigDecimal("1"));         //(1 + i)^n - 1
        
        BigDecimal result = bdNumeratorInFormula.divide(bdDenominatorInFormula, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        result = result.setScale(5, DEFAULT_ROUNDING_MODE);
        result = result.setScale(10, DEFAULT_ROUNDING_MODE);
        //return bdNumeratorInFormula.divide(bdDenominatorInFormula, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        return result;
    }

    public BigDecimal computeMonthlyPaymentOn30YearFixedLoan(double loanAmount, double annualInterestRateInPercent) {
    	BigDecimal bdLoanAmount = new BigDecimal(Double.toString(loanAmount));
        BigDecimal bdAnnualInterestRateInPercent = new BigDecimal(Double.toString(annualInterestRateInPercent));
        
        //Change Percent to Decimal
        BigDecimal bdAnnualInterestRateInDecimal = bdAnnualInterestRateInPercent.divide(new BigDecimal(100*YEAR_TO_MONTH), DEFAULT_SCALE, RoundingMode.HALF_UP);
    	BigDecimal bdNumeratorInFormula, bdDenominatorInFormula;
    	
        bdNumeratorInFormula = bdAnnualInterestRateInDecimal.add(new BigDecimal("1"));         //(1 + i)       
        bdNumeratorInFormula = bdNumeratorInFormula.pow(30*YEAR_TO_MONTH);                     //(1 + i)^n 
        bdDenominatorInFormula = bdNumeratorInFormula;                                         //Numerator and denominator has the same part: (1 + i)^n
        bdNumeratorInFormula = bdNumeratorInFormula.multiply(bdAnnualInterestRateInDecimal);   //i(1 + i)^n
        bdNumeratorInFormula = bdNumeratorInFormula.multiply(bdLoanAmount);                    //P (i(1 + i)^n)
    	

        bdDenominatorInFormula = bdDenominatorInFormula.subtract(new BigDecimal("1"));         //(1 + i)^n - 1
        
        BigDecimal result = bdNumeratorInFormula.divide(bdDenominatorInFormula, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
        result = result.setScale(5, DEFAULT_ROUNDING_MODE);
        result = result.setScale(10, DEFAULT_ROUNDING_MODE);
        return result;
    }

    public BigDecimal computeMonthlyPaymentOnFixedLoan(double loanAmount, double annualInterestRateInPercent, int years) {
    	
    	
    	if (years <= 0) {
    		System.out.println("Argument Error, Years should be greater than 0");
    		return null;
    	}
    	
    	if (Double.compare(loanAmount, 0d) <= 0) {
    		System.out.println("Argument Error, Loan Amount should be greater than 0");
    		return null;    		
    	} 
    	
    	if (Double.compare(annualInterestRateInPercent, 0d) <= 0) {
    		System.out.println("Argument Error, Annual Interest Rate should be greater than 0");
    		return null;      		
    	}
    	
    	//Calculating...	
    	//Not quite sure why there is special functions for the 15 and 30 years loan
    	if (years == 15)
            return computeMonthlyPaymentOn15YearFixedLoan(loanAmount, annualInterestRateInPercent);
        else if (years == 30)
            return computeMonthlyPaymentOn30YearFixedLoan(loanAmount, annualInterestRateInPercent);
        else {
            BigDecimal bdLoanAmount = new BigDecimal(Double.toString(loanAmount));
            BigDecimal bdAnnualInterestRateInPercent = new BigDecimal(Double.toString(annualInterestRateInPercent));
        	BigDecimal bdAnnualInterestRateInDecimal = bdAnnualInterestRateInPercent.divide(new BigDecimal(100*YEAR_TO_MONTH), DEFAULT_SCALE, RoundingMode.HALF_UP);
        	BigDecimal bdNumeratorInFormula, bdDenominatorInFormula;
        	
            bdNumeratorInFormula = bdAnnualInterestRateInDecimal.add(new BigDecimal("1"));         //(1 + i)       
            bdNumeratorInFormula = bdNumeratorInFormula.pow(years*YEAR_TO_MONTH);                  //(1 + i)^n 
            bdDenominatorInFormula = bdNumeratorInFormula;                                         //Numerator and denominator has the same part: (1 + i)^n
            bdNumeratorInFormula = bdNumeratorInFormula.multiply(bdAnnualInterestRateInDecimal);   //i(1 + i)^n
            bdNumeratorInFormula = bdNumeratorInFormula.multiply(bdLoanAmount);                    //P (i(1 + i)^n)
        	

            bdDenominatorInFormula = bdDenominatorInFormula.subtract(new BigDecimal("1"));         //(1 + i)^n - 1

            //return bdNumeratorInFormula.divide(bdDenominatorInFormula, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
            BigDecimal result = bdNumeratorInFormula.divide(bdDenominatorInFormula, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
            result = result.setScale(5, DEFAULT_ROUNDING_MODE);
            result = result.setScale(10, DEFAULT_ROUNDING_MODE);
            //return bdNumeratorInFormula.divide(bdDenominatorInFormula, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
            return result;
        
        }

    }

}