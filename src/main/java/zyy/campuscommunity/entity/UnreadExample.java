package zyy.campuscommunity.entity;

import java.util.ArrayList;
import java.util.List;

public class UnreadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnreadExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdIsNull() {
            addCriterion("infocome_id is null");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdIsNotNull() {
            addCriterion("infocome_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdEqualTo(Integer value) {
            addCriterion("infocome_id =", value, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdNotEqualTo(Integer value) {
            addCriterion("infocome_id <>", value, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdGreaterThan(Integer value) {
            addCriterion("infocome_id >", value, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("infocome_id >=", value, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdLessThan(Integer value) {
            addCriterion("infocome_id <", value, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdLessThanOrEqualTo(Integer value) {
            addCriterion("infocome_id <=", value, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdIn(List<Integer> values) {
            addCriterion("infocome_id in", values, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdNotIn(List<Integer> values) {
            addCriterion("infocome_id not in", values, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdBetween(Integer value1, Integer value2) {
            addCriterion("infocome_id between", value1, value2, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("infocome_id not between", value1, value2, "infocomeId");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameIsNull() {
            addCriterion("infocome_name is null");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameIsNotNull() {
            addCriterion("infocome_name is not null");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameEqualTo(String value) {
            addCriterion("infocome_name =", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameNotEqualTo(String value) {
            addCriterion("infocome_name <>", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameGreaterThan(String value) {
            addCriterion("infocome_name >", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameGreaterThanOrEqualTo(String value) {
            addCriterion("infocome_name >=", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameLessThan(String value) {
            addCriterion("infocome_name <", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameLessThanOrEqualTo(String value) {
            addCriterion("infocome_name <=", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameLike(String value) {
            addCriterion("infocome_name like", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameNotLike(String value) {
            addCriterion("infocome_name not like", value, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameIn(List<String> values) {
            addCriterion("infocome_name in", values, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameNotIn(List<String> values) {
            addCriterion("infocome_name not in", values, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameBetween(String value1, String value2) {
            addCriterion("infocome_name between", value1, value2, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeNameNotBetween(String value1, String value2) {
            addCriterion("infocome_name not between", value1, value2, "infocomeName");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeIsNull() {
            addCriterion("infocome_time is null");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeIsNotNull() {
            addCriterion("infocome_time is not null");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeEqualTo(String value) {
            addCriterion("infocome_time =", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeNotEqualTo(String value) {
            addCriterion("infocome_time <>", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeGreaterThan(String value) {
            addCriterion("infocome_time >", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("infocome_time >=", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeLessThan(String value) {
            addCriterion("infocome_time <", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeLessThanOrEqualTo(String value) {
            addCriterion("infocome_time <=", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeLike(String value) {
            addCriterion("infocome_time like", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeNotLike(String value) {
            addCriterion("infocome_time not like", value, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeIn(List<String> values) {
            addCriterion("infocome_time in", values, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeNotIn(List<String> values) {
            addCriterion("infocome_time not in", values, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeBetween(String value1, String value2) {
            addCriterion("infocome_time between", value1, value2, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andInfocomeTimeNotBetween(String value1, String value2) {
            addCriterion("infocome_time not between", value1, value2, "infocomeTime");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostTitleIsNull() {
            addCriterion("post_title is null");
            return (Criteria) this;
        }

        public Criteria andPostTitleIsNotNull() {
            addCriterion("post_title is not null");
            return (Criteria) this;
        }

        public Criteria andPostTitleEqualTo(String value) {
            addCriterion("post_title =", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotEqualTo(String value) {
            addCriterion("post_title <>", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleGreaterThan(String value) {
            addCriterion("post_title >", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleGreaterThanOrEqualTo(String value) {
            addCriterion("post_title >=", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLessThan(String value) {
            addCriterion("post_title <", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLessThanOrEqualTo(String value) {
            addCriterion("post_title <=", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLike(String value) {
            addCriterion("post_title like", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotLike(String value) {
            addCriterion("post_title not like", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleIn(List<String> values) {
            addCriterion("post_title in", values, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotIn(List<String> values) {
            addCriterion("post_title not in", values, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleBetween(String value1, String value2) {
            addCriterion("post_title between", value1, value2, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotBetween(String value1, String value2) {
            addCriterion("post_title not between", value1, value2, "postTitle");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Integer value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Integer value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Integer value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Integer value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Integer> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Integer> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
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