package org.openmrs.module.ehraddons.reporting.library.indicator;

import org.openmrs.module.ehraddons.reporting.library.cohorts.Moh705aCohortDefinition;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.openmrs.module.kenyacore.report.ReportUtils.map;
import static org.openmrs.module.kenyaemr.reporting.EmrReportingUtils.cohortIndicator;

@Component
public class Moh705aIndicatorDefinition {
	
	private Moh705aCohortDefinition moh705aCohortDefinition;
	
	@Autowired
	public Moh705aIndicatorDefinition(Moh705aCohortDefinition moh705aCohortDefinition) {
		this.moh705aCohortDefinition = moh705aCohortDefinition;
	}
	
	public CohortIndicator getAllPatientsWithDiarrhoea(List<Integer> list) {
		return cohortIndicator(
		    "Diarrhoea",
		    map(moh705aCohortDefinition.getChildrenPatientsWhoHaveDiagnosis(list),
		        "startDate=${startDate},endDate=${endDate}"));
	}
}
