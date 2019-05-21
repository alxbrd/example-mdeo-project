package models.cra.fitness;

import architectureCRA.ClassModel;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MinimiseClasslessFeatures implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution model) {
		
		var features = ((ClassModel) model.getModel()).getFeatures();
		return features.stream().filter(feature -> feature.getIsEncapsulatedBy() == null).count();
	}

	@Override
	public String getName() {
		return "Minimise Classless Features";
	}

}
