
public class Variable 
{
	private char varName;
	private double valValue;
	
	 Variable(char varName, double valValue)
	 {
		 this.setValValue(valValue);
		 this.setVarName(varName);
	 }

	public char getVarName() {
		return varName;
	}

	public void setVarName(char varName) {
		this.varName = varName;
	}

	public double getValValue() {
		return valValue;
	}

	public void setValValue(double valValue) {
		this.valValue = valValue;
	}
	public String toString()
	{
		return String.format("%s  %15s", varName,valValue);
	}
}
