package cn.edu.sdu.component;

import org.apache.solr.client.solrj.SolrQuery;

public class SolrQueryBuilder {
    private String defaultField = "";
    private String query = "*:*";
    private String sortField = null;
    private SolrQuery.ORDER order = null;
    private Integer start = 0;
    private Integer rows = Integer.MAX_VALUE;
    private String[] filterQueries = null;


    public SolrQuery build() {
        SolrQuery solrQuery = new SolrQuery();

        solrQuery.set("df", defaultField);
        solrQuery.setQuery(query);

        if (sortField != null && order != null)
            solrQuery.setSort(sortField, order);

        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        solrQuery.setFilterQueries(filterQueries);

        return solrQuery;
    }


    public SolrQueryBuilder setDefaultField(String defaultField) {
        if (defaultField != null)
            this.defaultField = defaultField;
        return this;
    }

    public SolrQueryBuilder setQuery(String query) {
        if (query != null && !query.equals("") && !query.equals("*"))
            this.query = query;
        return this;
    }

    public SolrQueryBuilder setSortField(String sortField) {
        if (sortField != null)
            this.sortField = sortField;
        return this;
    }

    public SolrQueryBuilder setOrder(String order) {
        if (order != null){
            if (order.equals("asc")){
                this.order = SolrQuery.ORDER.asc;
            }else if (order.equals("desc")){
                this.order = SolrQuery.ORDER.desc;
            }
        }
        return this;
    }

    public SolrQueryBuilder setStart(Integer start) {
        if (start != null)
            this.start = start;
        return this;
    }

    public SolrQueryBuilder setRows(Integer rows) {
        this.rows = Integer.MAX_VALUE - start;
        if (rows != null && rows != -1)
            this.rows = rows;
        else if (rows != null)
            this.rows = Integer.MAX_VALUE - start;
        return this;
    }

    public SolrQueryBuilder setFilterQueries(String[] filterQueries) {
        if (filterQueries != null)
            this.filterQueries = filterQueries;
        return this;
    }
}
