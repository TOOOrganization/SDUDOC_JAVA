package cn.edu.sdu.sdudoc.entity;

import java.util.ArrayList;
import java.util.List;

public class SmsArticleHeadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsArticleHeadExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(String value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(String value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(String value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(String value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(String value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(String value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLike(String value) {
            addCriterion("aid like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotLike(String value) {
            addCriterion("aid not like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<String> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<String> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(String value1, String value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(String value1, String value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andArticleauthorIsNull() {
            addCriterion("articleAuthor is null");
            return (Criteria) this;
        }

        public Criteria andArticleauthorIsNotNull() {
            addCriterion("articleAuthor is not null");
            return (Criteria) this;
        }

        public Criteria andArticleauthorEqualTo(String value) {
            addCriterion("articleAuthor =", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorNotEqualTo(String value) {
            addCriterion("articleAuthor <>", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorGreaterThan(String value) {
            addCriterion("articleAuthor >", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorGreaterThanOrEqualTo(String value) {
            addCriterion("articleAuthor >=", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorLessThan(String value) {
            addCriterion("articleAuthor <", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorLessThanOrEqualTo(String value) {
            addCriterion("articleAuthor <=", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorLike(String value) {
            addCriterion("articleAuthor like", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorNotLike(String value) {
            addCriterion("articleAuthor not like", value, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorIn(List<String> values) {
            addCriterion("articleAuthor in", values, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorNotIn(List<String> values) {
            addCriterion("articleAuthor not in", values, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorBetween(String value1, String value2) {
            addCriterion("articleAuthor between", value1, value2, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andArticleauthorNotBetween(String value1, String value2) {
            addCriterion("articleAuthor not between", value1, value2, "articleauthor");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNull() {
            addCriterion("bookname is null");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNotNull() {
            addCriterion("bookname is not null");
            return (Criteria) this;
        }

        public Criteria andBooknameEqualTo(String value) {
            addCriterion("bookname =", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotEqualTo(String value) {
            addCriterion("bookname <>", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThan(String value) {
            addCriterion("bookname >", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThanOrEqualTo(String value) {
            addCriterion("bookname >=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThan(String value) {
            addCriterion("bookname <", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThanOrEqualTo(String value) {
            addCriterion("bookname <=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLike(String value) {
            addCriterion("bookname like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotLike(String value) {
            addCriterion("bookname not like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameIn(List<String> values) {
            addCriterion("bookname in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotIn(List<String> values) {
            addCriterion("bookname not in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameBetween(String value1, String value2) {
            addCriterion("bookname between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotBetween(String value1, String value2) {
            addCriterion("bookname not between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andDynastyIsNull() {
            addCriterion("dynasty is null");
            return (Criteria) this;
        }

        public Criteria andDynastyIsNotNull() {
            addCriterion("dynasty is not null");
            return (Criteria) this;
        }

        public Criteria andDynastyEqualTo(String value) {
            addCriterion("dynasty =", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotEqualTo(String value) {
            addCriterion("dynasty <>", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyGreaterThan(String value) {
            addCriterion("dynasty >", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyGreaterThanOrEqualTo(String value) {
            addCriterion("dynasty >=", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyLessThan(String value) {
            addCriterion("dynasty <", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyLessThanOrEqualTo(String value) {
            addCriterion("dynasty <=", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyLike(String value) {
            addCriterion("dynasty like", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotLike(String value) {
            addCriterion("dynasty not like", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyIn(List<String> values) {
            addCriterion("dynasty in", values, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotIn(List<String> values) {
            addCriterion("dynasty not in", values, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyBetween(String value1, String value2) {
            addCriterion("dynasty between", value1, value2, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotBetween(String value1, String value2) {
            addCriterion("dynasty not between", value1, value2, "dynasty");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}