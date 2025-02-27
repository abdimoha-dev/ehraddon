package org.openmrs.module.ehraddons.reporting.library.dataset;

import org.openmrs.module.ehraddons.diagnosis.lists.DiagnosisLists;
import org.openmrs.module.ehraddons.reporting.library.dimesions.EhrAddonDimesion;
import org.openmrs.module.ehraddons.reporting.library.indicator.Moh705IndicatorDefinitions;
import org.openmrs.module.ehraddons.reporting.utils.EhrAddonUtils;
import org.openmrs.module.ehraddons.utils.EhrReportingUtils;
import org.openmrs.module.kenyacore.report.ReportUtils;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Moh705aDatasetDefinition {
	
	private Moh705IndicatorDefinitions moh705aIndicator;
	
	private EhrAddonDimesion ehrAddonDimesion;
	
	@Autowired
	public Moh705aDatasetDefinition(Moh705IndicatorDefinitions moh705aIndicator, EhrAddonDimesion ehrAddonDimesion) {
		this.moh705aIndicator = moh705aIndicator;
		this.ehrAddonDimesion = ehrAddonDimesion;
	}
	
	/**
	 * Get moh 705 a dataset
	 * 
	 * @return @{@link org.openmrs.module.reporting.dataset.definition.DataSetDefinition}
	 */
	public DataSetDefinition getMoh705aDataset() {
		CohortIndicatorDataSetDefinition dsd = new CohortIndicatorDataSetDefinition();
		String indParam = "startDate=${startDate},endDate=${endDate}";
		//dsd.addDimension("days", ReportUtils.map(ehrAddonDimesion.encountersOfMonthPerDay(), "endDate=${endDate}"));
		dsd.setName("MOH705A");
		dsd.addParameter(new Parameter("startDate", "Start Date", Date.class));
		dsd.addParameter(new Parameter("endDate", "End Date", Date.class));
		dsd.addDimension("day", ReportUtils.map(ehrAddonDimesion.encountersOfMonthPerDay(), "endDate=${endDate}"));
		// populate datasets
		//getDiarrhoea(dsd, indParam);
		EhrReportingUtils.addRow(dsd, "DC", "Diarrhoea", ReportUtils.map(
		    moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getDiarrheaDiagnosisList()), indParam),
		    EhrAddonUtils.getAdultChildrenColumns());
		EhrReportingUtils.addRow(dsd, "TC", "Tuberculosis", ReportUtils.map(
		    moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getTuberculosisDiagnosisList()), indParam),
		    EhrAddonUtils.getAdultChildrenColumns());
		EhrReportingUtils.addRow(dsd, "DYC", "Dysentery", ReportUtils.map(
		    moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getDysenteryList()), indParam),
			EhrAddonUtils.getAdultChildrenColumns());
			
		EhrReportingUtils.addRow(dsd, "CLC", "Cholera", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getCholeraList()), indParam),
			EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "MCC", "MeningococcalMeningitis", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getMeningococcalMeningitisList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "OMC", "OtherMenigitis", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getOtherMenigitisList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "PMC", "Poliomyelitis", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getPoliomyelitisList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "NNC", "NeonatalTetanus", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getNeonatalTetanusList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "CPC", "Chicken Pox", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getChickenPoxList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "MSC", "Measles", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getMeaslesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "HPC", "Hepatitis", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getHepatitisList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "MPC", "Mumps", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getMumpsList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "FC", "Fevers", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getFeversList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "SMC", "Suspected Malaria", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getSuspectedMalariaList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "CMC", "Confirmed Malaria", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getConfirmedMalariaList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "UTC", "Urinary Tract Infection", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getUrinaryTractInfectionList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "TYC", "Typhoid", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getTyphoidList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "BLC", "Bilharzia", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getBilharziaList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "HPC", "Hepatitis", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getInterstinalwormsList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "MNC", "Malnutrition", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getMalnutritionList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "ANC", "Anaemia", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getAnaemiaList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "EC", "EyeInfections", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getEyeInfectionsList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "OEC", "Other Eye Conditions", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getOtherEyeConditionsList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "EIC", "Ear Infections Conditions", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getEarInfectionsConditionsList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "URC", "Upper Respiratory Tract Infections", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getUpperRespiratoryTractInfectionsList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "ASC", "Asthma", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getAsthmaList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "PNC", "Pneumonia", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getPneumoniaList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());


		EhrReportingUtils.addRow(dsd, "MDC", "Mental Disorders", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getMentalDisordersList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());


		EhrReportingUtils.addRow(dsd, "DDC", "DentalDisorders", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getDentalDisordersList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());


		EhrReportingUtils.addRow(dsd, "JIC", "Jiggers Infestation", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getJiggersInfestationList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());


		EhrReportingUtils.addRow(dsd, "DOC", "Disease Of The Skin", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getDiseaseOfTheSkinList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());


		EhrReportingUtils.addRow(dsd, "PC", "Poisoning", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getPoisoningList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());


		EhrReportingUtils.addRow(dsd, "RTC", "Road TrafficI Injuries", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getRoadTrafficInjuriesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());


		EhrReportingUtils.addRow(dsd, "OIC", "Other Injuries", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getOtherInjuriesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "SAC", "Sexual Asualt", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getSexualAssaultList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "BC", "Burns", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getBurnsList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "SBC", "Snake Bites", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getSnakeBitesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "DBC", "Dog BITES", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getDogBitesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "OBC", "Other Bites", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getOtherBitesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "TSC", "Tonsilities", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getTonsilitiesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "CAC", "Chromosomal Abnormalities", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getChromosomalAbnormalitiesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "CGC", "Congenital Anomalies", ReportUtils.map(
			moh705aIndicator.getAllChildrenPatientsWithDiagnosis(DiagnosisLists.getCongenitalAnomaliesList()), indParam),
		EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "DTC", "Diabetes", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getDiabetesList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "EPC", "Epilepsy", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getEpilepsyList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());
		EhrReportingUtils.addRow(dsd, "NHC", "Newly Diagnosed Hiv", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getEpilepsyList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "BRC", "Brucellosis", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getBrucellosisList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "CAC", "Cardiovascular Conditions", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getCardiovascularConditionsList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "OVC", "Overweight", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getOvrerweightList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "MSC", "Muscular Skeletal Conditions", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getMuscularSkeletalConditionsList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "FIC", "Fistula Birth Related", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getFistulaBirthRelatedList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "NSC", "Neoplams", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getNeoplamsList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "PHC", "Physical Disability", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getPhysicalDisabilityList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "PHC", "Physical Disability", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getFistulaBirthRelatedList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "TRC", "Tryponomiasis", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getTryponomiasisList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "KAC", "Kalazar leishmaniasis", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getKalazarLeishmaniasisList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "DAC", "Daracuncolosis Guinea Worm", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getDaracuncolosisGuineaWormList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "YEC", "Yellow Fever", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getYellowFeverList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());

		EhrReportingUtils.addRow(dsd, "VHC", "Viral Haemorrhagic Fever", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getViralHaemorrhagicFeverList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());
		EhrReportingUtils.addRow(dsd, "PLC", "Plague", ReportUtils.map(
				moh705aIndicator.getAllAdultPatientsWithDiagnosis(DiagnosisLists.getPlagueList()), indParam),
				EhrAddonUtils.getAdultChildrenColumns());



	










		






		
		return dsd;
		
	}
	
}
