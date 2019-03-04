package de.mpc.pia.intermediate;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import de.mpc.pia.tools.PIAConstants;

import uk.ac.ebi.jmzidml.model.mzidml.AnalysisCollection;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisProtocolCollection;
import uk.ac.ebi.jmzidml.model.mzidml.AnalysisSoftware;
import uk.ac.ebi.jmzidml.model.mzidml.Enzyme;
import uk.ac.ebi.jmzidml.model.mzidml.InputSpectra;
import uk.ac.ebi.jmzidml.model.mzidml.SearchDatabase;
import uk.ac.ebi.jmzidml.model.mzidml.SearchDatabaseRef;
import uk.ac.ebi.jmzidml.model.mzidml.SpectraData;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentification;
import uk.ac.ebi.jmzidml.model.mzidml.SpectrumIdentificationProtocol;

import uk.ac.ebi.jpepxml.model.pepxml.MsmsPipelineAnalysis;
import uk.ac.ebi.jpepxml.model.pepxml.PeptideprophetSummary;
import uk.ac.ebi.jpepxml.model.pepxml.InterprophetSummary;
import uk.ac.ebi.jpepxml.model.pepxml.PeptideprophetSummary;
import uk.ac.ebi.jpepxml.model.pepxml.AsapratioSummary;
import uk.ac.ebi.jpepxml.model.pepxml.XpressratioSummary;
import uk.ac.ebi.jpepxml.model.pepxml.PeptideprophetResult;
import uk.ac.ebi.jpepxml.model.pepxml.InterprophetResult;
import uk.ac.ebi.jpepxml.model.pepxml.AsapratioResult;
import uk.ac.ebi.jpepxml.model.pepxml.AsapratioPeptideData;
import uk.ac.ebi.jpepxml.model.pepxml.AsapratioContribution;
import uk.ac.ebi.jpepxml.model.pepxml.AsapratioLcLightpeak;
import uk.ac.ebi.jpepxml.model.pepxml.AsapratioLcHeavypeak;
import uk.ac.ebi.jpepxml.model.pepxml.DatabaseRefreshTimestamp;
import uk.ac.ebi.jpepxml.model.pepxml.XpressratioTimestamp;
import uk.ac.ebi.jpepxml.model.pepxml.AsapratioTimestamp;
import uk.ac.ebi.jpepxml.model.pepxml.XpressratioResult;
import uk.ac.ebi.jpepxml.model.pepxml.InteractSummary;
import uk.ac.ebi.jpepxml.model.pepxml.LibraResult;
import uk.ac.ebi.jpepxml.model.pepxml.LibraSummary;

/**
 * File containing input for the intermediate structure.
 *
 * @author julian
 */
public class PIAInputFile implements Serializable {

    private static final long serialVersionUID = -5611387583481669510L;


    /** ID of the file */
    private long id;

    /** a name for easier identification */
    private String name;

    /** the path to the file */
    private String fileName;

    /** format of the file */
    private String format;

    /** the collection of SpectrumIdentifications (same as in mzIdentML) */
    private AnalysisCollection analysisCollection;

    /** the AnalysisProtocolCollection (same as in mzIdentML) */
    private AnalysisProtocolCollection analysisProtocolCollection;
    
    private MsmsPipelineAnalysis msmsPipelineAnalysis
    private PeptideprophetSummary peptideprophetSummary;
	private InterprophetSummary interprophetSummary;
	private PeptideprophetSummary peptideprophetSummary;
	private AsapratioSummary asapratioSummary;
	private XpressratioSummary xpressratioSummary;
	private PeptideprophetResult peptideprophetResult;
	private InterprophetResult interprophetResult;
	private AsapratioResult asapratioResult;
	private AsapratioPeptideData asapratioPeptideData;
	private AsapratioContribution asapratioContribution;
	private AsapratioLcLightpeak asapratioLcLightpeak;
	private AsapratioLcHeavypeak asapratioLcHeavypeak;
	private DatabaseRefreshTimestamp databaseRefreshTimestamp;
	private XpressratioTimestamp xpressratioTimestamp;
	private AsapratioTimestamp asapratioTimestamp;
	private XpressratioResult xpressratioResult;
	private InteractSummary interactSummary;
	private LibraResult libraResult;
	private LibraSummary libraSummary;


    public PIAInputFile(long id, String name, String filename, String format) {
        this.id = id;
        this.name = name;
        this.fileName = filename;
        this.format = format;
        this.analysisCollection = new AnalysisCollection();
        this.analysisProtocolCollection = new AnalysisProtocolCollection();
	    this.msmsPipelineAnalysis = new MsmsPipelineAnalysis();
	    this.peptideprophetSummary = PeptideprophetSummary();
		this.interprophetSummary = InterprophetSummary();
		this.peptideprophetSummary = PeptideprophetSummary();
		this.asapratioSummary = AsapratioSummary();
		this.xpressratioSummary = XpressratioSummary();
		this.peptideprophetResult = PeptideprophetResult();
		this.interprophetResult = InterprophetResult();
		this.asapratioResult = AsapratioResult();
		this.asapratioPeptideData = AsapratioPeptideData();
		this.asapratioContribution = AsapratioContribution();
		this.asapratioLcLightpeak = AsapratioLcLightpeak();
		this.asapratioLcHeavypeak = AsapratioLcHeavypeak();
		this.databaseRefreshTimestamp = DatabaseRefreshTimestamp();
		this.xpressratioTimestamp = XpressratioTimestamp();
		this.asapratioTimestamp = AsapratioTimestamp();
		this.xpressratioResult = XpressratioResult();
		this.interactSummary = InteractSummary();
		this.libraResult = LibraResult();
		this.libraSummary = LibraSummary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PIAInputFile that = (PIAInputFile) o;

        if (id != that.id) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        return format != null ? format.equals(that.format) : that.format == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }

    /**
     * Getter for the ID.
     * @return
     */
    public Long getID() {
        return id;
    }


    /**
     * Getter for the name.
     * @return
     */
    public String getName() {
        return name;
    }


    /**
     * Getter for the filename.
     * @return
     */
    public String getFileName() {
        return fileName;
    }


    /**
     * Getter for the file format of the file.
     * @return
     */
    public String getFormat() {
        return format;
    }


    /**
     * Adds the given {@link SpectrumIdentification} to the analysisCollection.
     */
    public String addSpectrumIdentification(SpectrumIdentification si) {
        String strID = PIAConstants.spectrum_identification_prefix + this.id +
                '_' + (analysisCollection.getSpectrumIdentification().size() + 1L);
        si.setId(strID);
        // we don't have any SpectrumIdentificationList in the PIA file
        si.setSpectrumIdentificationList(null);
        analysisCollection.getSpectrumIdentification().add(si);
        return strID;
    }


    /**
     * Gets the {@link SpectrumIdentification} with the given ID or null, if
     * none is found.
     *
     * @param id
     * @return
     */
    public SpectrumIdentification getSpectrumIdentification(String id) {
        for (SpectrumIdentification si
                : analysisCollection.getSpectrumIdentification()) {
            if (si.getId().equals(id)) {
                return si;
            }
        }

        return null;
    }


    /**
     * Getter for the analysisCollection.
     * @return
     */
    public AnalysisCollection getAnalysisCollection() {
        return analysisCollection;
    }

    /**
     * Adds the given {@link SpectrumIdentificationProtocol} to the analysisProtocolCollection.
     * @param sip
     */
    public String addSpectrumIdentificationProtocol(SpectrumIdentificationProtocol sip) {
        String strID = PIAConstants.identification_protocol_prefix + this.id +
                '_' + (analysisProtocolCollection.getSpectrumIdentificationProtocol().size() + 1L);
        String ref = sip.getId();
        sip.setId(strID);
        analysisProtocolCollection.getSpectrumIdentificationProtocol().add(sip);

        // go through the analysisCollection an re-reference the SpectrumIdentificationProtocol
        analysisCollection.getSpectrumIdentification().stream().filter(spectrumId -> spectrumId.getSpectrumIdentificationProtocolRef().equals(ref)).forEach(spectrumId -> spectrumId.setSpectrumIdentificationProtocol(sip));

        // uniquify the enzymes' IDs in the SpectrumIdentificationProtocol
        int idx = 1;
        if (sip.getEnzymes() != null) {
            for (Enzyme enzyme : sip.getEnzymes().getEnzyme()) {
                enzyme.setId(PIAConstants.enzyme_prefix + this.id + '_' + idx);
                idx++;
            }
        }

        return strID;
    }


    /**
     *
     */
    public void updateReferences(Map<String, SpectraData> spectraDataRefs,
            Map<String, SearchDatabase> searchDBRefs,
            Map<String, AnalysisSoftware> analysisSoftwareRefs) {

        for (SpectrumIdentification si
                : analysisCollection.getSpectrumIdentification()) {
            // update the SpectraDataRefs
            Set<SpectraData> newSpectraData = si.getInputSpectra().stream().map(spectra -> spectraDataRefs.get(spectra.getSpectraDataRef())).collect(Collectors.toSet());

            // clear the old InputSpectra
            si.getInputSpectra().clear();
            // and add the new spectra
            for (SpectraData spectra : newSpectraData) {
                InputSpectra inputSpectra = new InputSpectra();
                inputSpectra.setSpectraData(spectra);
                si.getInputSpectra().add(inputSpectra);
            }


            // update the SearchDatabaseRefs
            Set<SearchDatabase> newSearchDBs = si.getSearchDatabaseRef().stream().map(searchDBRef -> searchDBRefs.get(searchDBRef.getSearchDatabaseRef())).collect(Collectors.toSet());
            // clear old searchDBRefs
            si.getSearchDatabaseRef().clear();
            // add the new searchDBs
            for (SearchDatabase sDB : newSearchDBs) {
                SearchDatabaseRef sDBRef = new SearchDatabaseRef();
                sDBRef.setSearchDatabase(sDB);
                si.getSearchDatabaseRef().add(sDBRef);
            }
        }

        for (SpectrumIdentificationProtocol protocol :
            // update the AnalysisSoftware in the protocols
            analysisProtocolCollection.getSpectrumIdentificationProtocol()) {
            AnalysisSoftware software =
                    analysisSoftwareRefs.get(protocol.getAnalysisSoftwareRef());
            protocol.setAnalysisSoftware(software);
        }
    }


    /**
     * Getter for the analysisProtocolCollection.
     * @return
     */
    public AnalysisProtocolCollection getAnalysisProtocolCollection() {
        return analysisProtocolCollection;
    }
}
