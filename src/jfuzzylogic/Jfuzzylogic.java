/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfuzzylogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author Suporte
 */
public class Jfuzzylogic {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
		//Carrega arquivo fcl
		FIS fis = FIS.load("src/resource/frioCarro.fcl", true);
		
		if (fis == null) {
			System.err.println("Can't load file");
			System.exit(1);
		}

		
		// Mostra todas as varivais linguisticas em grafico
        JFuzzyChart.get().chart(fis.getFunctionBlock("freioCarro"));
		
	    //Seta as entradas para cada variavel linguistica
        fis.setVariable("pressao", 60); 
	    fis.setVariable("velocidade", 80);
	   
	    
	    //Avalia as regras
	    fis.evaluate();

	    //Mostra saída em grafico
        Variable biomassa = fis.getFunctionBlock("freioCarro").getVariable("freio");
        JFuzzyChart.get().chart(biomassa, biomassa.getDefuzzifier(), true);
        System.out.println(biomassa.getValue());
	}
    
}
