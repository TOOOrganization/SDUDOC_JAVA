package cn.edu.sdu.sdudoc.sdudocdao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addTime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andBookauthorIsNull() {
            addCriterion("bookAuthor is null");
            return (Criteria) this;
        }

        public Criteria andBookauthorIsNotNull() {
            addCriterion("bookAuthor is not null");
            return (Criteria) this;
        }

        public Criteria andBookauthorEqualTo(String value) {
            addCriterion("bookAuthor =", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotEqualTo(String value) {
            addCriterion("bookAuthor <>", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorGreaterThan(String value) {
            addCriterion("bookAuthor >", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorGreaterThanOrEqualTo(String value) {
            addCriterion("bookAuthor >=", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorLessThan(String value) {
            addCriterion("bookAuthor <", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorLessThanOrEqualTo(String value) {
            addCriterion("bookAuthor <=", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorLike(String value) {
            addCriterion("bookAuthor like", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotLike(String value) {
            addCriterion("bookAuthor not like", value, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorIn(List<String> values) {
            addCriterion("bookAuthor in", values, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotIn(List<String> values) {
            addCriterion("bookAuthor not in", values, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorBetween(String value1, String value2) {
            addCriterion("bookAuthor between", value1, value2, "bookauthor");
            return (Criteria) this;
        }

        public Criteria andBookauthorNotBetween(String value1, String value2) {
            addCriterion("bookAuthor not between", value1, value2, "bookauthor");
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

        public Criteria andPulishedtimeIsNull() {
            addCriterion("pulishedTime is null");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeIsNotNull() {
            addCriterion("pulishedTime is not null");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeEqualTo(Date value) {
            addCriterionForJDBCDate("pulishedTime =", value, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("pulishedTime <>", value, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("pulishedTime >", value, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pulishedTime >=", value, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeLessThan(Date value) {
            addCriterionForJDBCDate("pulishedTime <", value, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pulishedTime <=", value, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeIn(List<Date> values) {
            addCriterionForJDBCDate("pulishedTime in", values, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("pulishedTime not in", values, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pulishedTime between", value1, value2, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andPulishedtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pulishedTime not between", value1, value2, "pulishedtime");
            return (Criteria) this;
        }

        public Criteria andTotalarticleIsNull() {
            addCriterion("totalArticle is null");
            return (Criteria) this;
        }

        public Criteria andTotalarticleIsNotNull() {
            addCriterion("totalArticle is not null");
            return (Criteria) this;
        }

        public Criteria andTotalarticleEqualTo(String value) {
            addCriterion("totalArticle =", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleNotEqualTo(String value) {
            addCriterion("totalArticle <>", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleGreaterThan(String value) {
            addCriterion("totalArticle >", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleGreaterThanOrEqualTo(String value) {
            addCriterion("totalArticle >=", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleLessThan(String value) {
            addCriterion("totalArticle <", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleLessThanOrEqualTo(String value) {
            addCriterion("totalArticle <=", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleLike(String value) {
            addCriterion("totalArticle like", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleNotLike(String value) {
            addCriterion("totalArticle not like", value, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleIn(List<String> values) {
            addCriterion("totalArticle in", values, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleNotIn(List<String> values) {
            addCriterion("totalArticle not in", values, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleBetween(String value1, String value2) {
            addCriterion("totalArticle between", value1, value2, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andTotalarticleNotBetween(String value1, String value2) {
            addCriterion("totalArticle not between", value1, value2, "totalarticle");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uId is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uId is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uId =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uId <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uId >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uId >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uId <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uId <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uId like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uId not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uId in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uId not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uId between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uId not between", value1, value2, "uid");
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