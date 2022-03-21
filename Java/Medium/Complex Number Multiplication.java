class ComplexNumber{
    private int realNumber;    
    private int imaginaryNumber;
    
    public ComplexNumber(int realNumber, int imaginaryNumber){
        this.realNumber = realNumber;       
        this.imaginaryNumber = imaginaryNumber;
    }
    
    public ComplexNumber(String number){
        char[] charArrayNumber = number.toCharArray();
        String realNumber = "";        
        String imaginaryNumber = "";
        int indexNumber = 0;
        
        //get realNumber
        while(charArrayNumber[indexNumber] != '+'){
            realNumber += charArrayNumber[indexNumber];
            indexNumber++;
        }
        
        indexNumber++;
        
        //get imaginaryNumber
        while(charArrayNumber[indexNumber] != 'i'){
            imaginaryNumber += charArrayNumber[indexNumber];
            indexNumber++;
        }
        
        
        this.realNumber = Integer.parseInt(realNumber);  
        this.imaginaryNumber = Integer.parseInt(imaginaryNumber);
    }
    
    public int getRealNumber(){return this.realNumber;} 
    public int getImaginaryNumber(){return this.imaginaryNumber;}

    
    public ComplexNumber multiplication(ComplexNumber other){
        
        int resultRealNumber = (this.getRealNumber() * other.getRealNumber()) - 
                               (this.getImaginaryNumber() * other.getImaginaryNumber());  
        
        int resultImaginaryNumber = (this.getRealNumber() * other.getImaginaryNumber()) + 
                                    (this.getImaginaryNumber() * other.getRealNumber());

        
        ComplexNumber result = new ComplexNumber(resultRealNumber, resultImaginaryNumber);

        return result;
    }
    
    @Override
    public String toString(){
        return realNumber + "+" + imaginaryNumber + "i";
    }

}

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNumber complexNumber1 = new ComplexNumber(num1);                 
        ComplexNumber complexNumber2 = new ComplexNumber(num2);
        
        ComplexNumber result = complexNumber1.multiplication(complexNumber2);

        return result.toString();

    }
}
