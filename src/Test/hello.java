package Test;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class hello
{
	
    public static void main (String[] args)
    {
        // new R-engine
    	//System.setProperty("java.library.path", "/home/padmaja/R/x86_64-pc-linux-gnu-library/3.1/rJava/jri");
    	//System.out.println(System.getProperty("java.library.path"));
    	//-Djava.library.path=.:/home/padmaja/R/x86_64-pc-linux-gnu-library/3.1/rJava/jri
   
    	Rengine re=new Rengine (new String [] {"--no-save"}, false, null);
        /*if (!re.waitForR())
        {
            System.out.println ("Cannot load R");
            return;
        }*/
        
        // print a random number from uniform distribution
    	// System.out.println (re.eval ("sqrt(25)"));
    	re.eval(String.format("inputFile <- c('%s')","/home/padmaja/Desktop/295B/239/DataSets/CancerChart.txt"));
		re.eval(String.format("train <- read.table(c(inputFile), header=T, sep=\"\t\")"));
		// re.eval ("myFormula <- Deaths ~ Region.Code + Age.Group.Code + Sex + Year");
		re.eval(String.format("myFormula <- c('%s')", "Deaths ~ Age.Group.Code + Sex + Year"));
		re.eval(String.format("fit <- lm(myFormula, train)"));
		re.eval(String.format("Age.Group.Code <- c('%s')", "45-49"));
		re.eval(String.format("Sex <- c('%s')", "Male"));
		re.eval(String.format("Year <- c(%s)", 2010));
		re.eval(String.format("predictTable <- data.frame(Age.Group.Code,Sex,Year);"));
		re.eval(String.format("prediction <- predict(fit, predictTable)"));
		
		REXP inputFile = re.eval("inputFile");
		System.out.println("inputFile is : "+inputFile.asString());
		
		REXP train = re.eval("train");
		System.out.println("train : "+ train.asVector());
		
		REXP myFormula = re.eval("myFormula");
		System.out.println("myFormula is : "+myFormula.asString());
		
		REXP fit = re.eval("fit");
		System.out.println("fit is : "+ fit.asVector());
		
		REXP result = re.eval("Sex");
		REXP ageprinting = re.eval("Year");
		System.out.println("the sex is " + result.asString() +" the year is "+ageprinting.asDouble());
		
		REXP predictTable = re.eval("predictTable");
		System.out.println("table to predict is : "+predictTable.asVector());
		
		REXP prediction = re.eval("prediction");
		System.out.println("number of deaths is : "+prediction.asDouble());
        
        re.end();
    }
    
}