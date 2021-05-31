package cn.edu.sdu.component;

import org.apache.solr.client.solrj.SolrQuery;

import java.util.ArrayList;
import java.util.List;

public class SolrQueryBuilder {
    private String defaultField = "";
    private String query = "*:*";
    private List<SolrQuery.SortClause> sort = new ArrayList<>();
    private Integer start = 0;
    private Integer rows = Integer.MAX_VALUE;
    private String group = "";
    private List<String> fields = new ArrayList<>();
    private String[] filterQueries = null;


    public SolrQuery build() {
        SolrQuery solrQuery = new SolrQuery();

        solrQuery.set("df", defaultField);
        solrQuery.setQuery(query);

        if (sort != null){
            for (SolrQuery.SortClause sortClause : sort){
                solrQuery.addSort(sortClause);
            }
        }

        solrQuery.setStart(start);
        solrQuery.setRows(rows);

        if (!group.equals("")){
            solrQuery.set("group",true);
            solrQuery.set("group.field", group);
        }

        if (fields != null){
            for (String field : fields)
                solrQuery.addField(field);
        }

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

    public SolrQueryBuilder setSort(String sort) {
        if (sort != null && !sort.equals("")){
            String[] sortArray = sort.split(",");
            for (String sortStr : sortArray){
                if(!sortStr.isEmpty()){
                    String[] sortClause = sortStr.split(" ");
                    if (sortClause[1].equals("asc"))
                        this.sort.add(new SolrQuery.SortClause(sortClause[0], SolrQuery.ORDER.asc));
                    else if (sortClause[1].equals("desc"))
                        this.sort.add(new SolrQuery.SortClause(sortClause[0], SolrQuery.ORDER.desc));
                }
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

    public SolrQueryBuilder setGroup(String group) {
        if (group != null && !group.equals(""))
            this.group = group;
        return this;
    }

    public SolrQueryBuilder setFields(String fields){
        if (fields != null && !fields.equals("")){
            String[] fieldsArray = fields.split(" ");
            for (String field : fieldsArray){
                if (!field.equals(""))
                    this.fields.add(field);
            }
        }
        return this;
    }

    public SolrQueryBuilder setFilterQueries(String[] filterQueries) {
        if (filterQueries != null)
            this.filterQueries = filterQueries;
        return this;
    }
}
