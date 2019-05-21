package models.cra.fitness;

import architectureCRA.ClassModel;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MinimiseEmptyClasses implements IGuidanceFunction {

	public double computeFitness(Solution model) {
		
		var classes = ((ClassModel) model.getModel()).getClasses();	
		return classes.stream().filter(singleClass -> singleClass.getEncapsulates().isEmpty()).count();
	}

	public String getName() {
		return "Minimise Empty Classes";
	}

}
