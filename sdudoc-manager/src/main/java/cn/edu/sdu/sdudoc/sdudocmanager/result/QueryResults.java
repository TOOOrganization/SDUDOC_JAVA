package cn.edu.sdu.sdudoc.sdudocmanager.result;

import org.apache.solr.common.SolrDocumentList;

public class QueryResults {

    private long numFound;
    private SolrDocumentList results;

    public QueryResults(long numFound, SolrDocumentList results) {
        this.numFound = numFound;
        this.results = results;
    }

    public long getNumFound() {
        return numFound;
    }

    public void setNumFound(long numFound) {
        this.numFound = numFound;
    }

    public SolrDocumentList getResults() {
        return results;
    }

    public void setResults(SolrDocumentList results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "QueryResults{" +
                "numFound=" + numFound +
                ", results=" + results +
                '}';
    }
}
