package org.openmrs.module.ehraddons.reports.indicator;

import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.openmrs.module.kenyacore.report.ReportUtils.map;
import static org.openmrs.module.kenyaemr.reporting.EmrReportingUtils.cohortIndicator;

@Component
public class Moh705aIndicators {
	
	private Moh705aCohortQueries queries;
	
	@Autowired
	public Moh705aIndicators(Moh705aCohortQueries queries) {
		this.queries = queries;
	}
	
	public CohortIndicator getAllPatients() {
		return cohortIndicator("all", map(queries.getAllPatients(), "startDate=${startDate},endDate=${endDate}"));
	}
}
