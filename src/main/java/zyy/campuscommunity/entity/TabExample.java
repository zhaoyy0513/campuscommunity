package zyy.campuscommunity.entity;

import java.util.ArrayList;
import java.util.List;

public class TabExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTabNameIsNull() {
            addCriterion("tab_name is null");
            return (Criteria) this;
        }

        public Criteria andTabNameIsNotNull() {
            addCriterion("tab_name is not null");
            return (Criteria) this;
        }

        public Criteria andTabNameEqualTo(String value) {
            addCriterion("tab_name =", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotEqualTo(String value) {
            addCriterion("tab_name <>", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThan(String value) {
            addCriterion("tab_name >", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThanOrEqualTo(String value) {
            addCriterion("tab_name >=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThan(String value) {
            addCriterion("tab_name <", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThanOrEqualTo(String value) {
            addCriterion("tab_name <=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLike(String value) {
            addCriterion("tab_name like", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotLike(String value) {
            addCriterion("tab_name not like", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameIn(List<String> values) {
            addCriterion("tab_name in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotIn(List<String> values) {
            addCriterion("tab_name not in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameBetween(String value1, String value2) {
            addCriterion("tab_name between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotBetween(String value1, String value2) {
            addCriterion("tab_name not between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andTabDescribeIsNull() {
            addCriterion("tab_describe is null");
            return (Criteria) this;
        }

        public Criteria andTabDescribeIsNotNull() {
            addCriterion("tab_describe is not null");
            return (Criteria) this;
        }

        public Criteria andTabDescribeEqualTo(String value) {
            addCriterion("tab_describe =", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeNotEqualTo(String value) {
            addCriterion("tab_describe <>", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeGreaterThan(String value) {
            addCriterion("tab_describe >", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("tab_describe >=", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeLessThan(String value) {
            addCriterion("tab_describe <", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeLessThanOrEqualTo(String value) {
            addCriterion("tab_describe <=", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeLike(String value) {
            addCriterion("tab_describe like", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeNotLike(String value) {
            addCriterion("tab_describe not like", value, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeIn(List<String> values) {
            addCriterion("tab_describe in", values, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeNotIn(List<String> values) {
            addCriterion("tab_describe not in", values, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeBetween(String value1, String value2) {
            addCriterion("tab_describe between", value1, value2, "tabDescribe");
            return (Criteria) this;
        }

        public Criteria andTabDescribeNotBetween(String value1, String value2) {
            addCriterion("tab_describe not between", value1, value2, "tabDescribe");
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