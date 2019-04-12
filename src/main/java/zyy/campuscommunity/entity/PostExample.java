package zyy.campuscommunity.entity;

import java.util.ArrayList;
import java.util.List;

public class PostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostExample() {
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

        public Criteria andPostUserNameIsNull() {
            addCriterion("post_user_name is null");
            return (Criteria) this;
        }

        public Criteria andPostUserNameIsNotNull() {
            addCriterion("post_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andPostUserNameEqualTo(String value) {
            addCriterion("post_user_name =", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameNotEqualTo(String value) {
            addCriterion("post_user_name <>", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameGreaterThan(String value) {
            addCriterion("post_user_name >", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("post_user_name >=", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameLessThan(String value) {
            addCriterion("post_user_name <", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameLessThanOrEqualTo(String value) {
            addCriterion("post_user_name <=", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameLike(String value) {
            addCriterion("post_user_name like", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameNotLike(String value) {
            addCriterion("post_user_name not like", value, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameIn(List<String> values) {
            addCriterion("post_user_name in", values, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameNotIn(List<String> values) {
            addCriterion("post_user_name not in", values, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameBetween(String value1, String value2) {
            addCriterion("post_user_name between", value1, value2, "postUserName");
            return (Criteria) this;
        }

        public Criteria andPostUserNameNotBetween(String value1, String value2) {
            addCriterion("post_user_name not between", value1, value2, "postUserName");
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

        public Criteria andPostTabIdIsNull() {
            addCriterion("post_tab_id is null");
            return (Criteria) this;
        }

        public Criteria andPostTabIdIsNotNull() {
            addCriterion("post_tab_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostTabIdEqualTo(Integer value) {
            addCriterion("post_tab_id =", value, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdNotEqualTo(Integer value) {
            addCriterion("post_tab_id <>", value, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdGreaterThan(Integer value) {
            addCriterion("post_tab_id >", value, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_tab_id >=", value, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdLessThan(Integer value) {
            addCriterion("post_tab_id <", value, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdLessThanOrEqualTo(Integer value) {
            addCriterion("post_tab_id <=", value, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdIn(List<Integer> values) {
            addCriterion("post_tab_id in", values, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdNotIn(List<Integer> values) {
            addCriterion("post_tab_id not in", values, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdBetween(Integer value1, Integer value2) {
            addCriterion("post_tab_id between", value1, value2, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("post_tab_id not between", value1, value2, "postTabId");
            return (Criteria) this;
        }

        public Criteria andPostTabNameIsNull() {
            addCriterion("post_tab_name is null");
            return (Criteria) this;
        }

        public Criteria andPostTabNameIsNotNull() {
            addCriterion("post_tab_name is not null");
            return (Criteria) this;
        }

        public Criteria andPostTabNameEqualTo(String value) {
            addCriterion("post_tab_name =", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameNotEqualTo(String value) {
            addCriterion("post_tab_name <>", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameGreaterThan(String value) {
            addCriterion("post_tab_name >", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameGreaterThanOrEqualTo(String value) {
            addCriterion("post_tab_name >=", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameLessThan(String value) {
            addCriterion("post_tab_name <", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameLessThanOrEqualTo(String value) {
            addCriterion("post_tab_name <=", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameLike(String value) {
            addCriterion("post_tab_name like", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameNotLike(String value) {
            addCriterion("post_tab_name not like", value, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameIn(List<String> values) {
            addCriterion("post_tab_name in", values, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameNotIn(List<String> values) {
            addCriterion("post_tab_name not in", values, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameBetween(String value1, String value2) {
            addCriterion("post_tab_name between", value1, value2, "postTabName");
            return (Criteria) this;
        }

        public Criteria andPostTabNameNotBetween(String value1, String value2) {
            addCriterion("post_tab_name not between", value1, value2, "postTabName");
            return (Criteria) this;
        }

        public Criteria andTabParentidIsNull() {
            addCriterion("tab_parentid is null");
            return (Criteria) this;
        }

        public Criteria andTabParentidIsNotNull() {
            addCriterion("tab_parentid is not null");
            return (Criteria) this;
        }

        public Criteria andTabParentidEqualTo(Integer value) {
            addCriterion("tab_parentid =", value, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidNotEqualTo(Integer value) {
            addCriterion("tab_parentid <>", value, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidGreaterThan(Integer value) {
            addCriterion("tab_parentid >", value, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tab_parentid >=", value, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidLessThan(Integer value) {
            addCriterion("tab_parentid <", value, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidLessThanOrEqualTo(Integer value) {
            addCriterion("tab_parentid <=", value, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidIn(List<Integer> values) {
            addCriterion("tab_parentid in", values, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidNotIn(List<Integer> values) {
            addCriterion("tab_parentid not in", values, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidBetween(Integer value1, Integer value2) {
            addCriterion("tab_parentid between", value1, value2, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andTabParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("tab_parentid not between", value1, value2, "tabParentid");
            return (Criteria) this;
        }

        public Criteria andPostContentIsNull() {
            addCriterion("post_content is null");
            return (Criteria) this;
        }

        public Criteria andPostContentIsNotNull() {
            addCriterion("post_content is not null");
            return (Criteria) this;
        }

        public Criteria andPostContentEqualTo(String value) {
            addCriterion("post_content =", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotEqualTo(String value) {
            addCriterion("post_content <>", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentGreaterThan(String value) {
            addCriterion("post_content >", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentGreaterThanOrEqualTo(String value) {
            addCriterion("post_content >=", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentLessThan(String value) {
            addCriterion("post_content <", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentLessThanOrEqualTo(String value) {
            addCriterion("post_content <=", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentLike(String value) {
            addCriterion("post_content like", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotLike(String value) {
            addCriterion("post_content not like", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentIn(List<String> values) {
            addCriterion("post_content in", values, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotIn(List<String> values) {
            addCriterion("post_content not in", values, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentBetween(String value1, String value2) {
            addCriterion("post_content between", value1, value2, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotBetween(String value1, String value2) {
            addCriterion("post_content not between", value1, value2, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNull() {
            addCriterion("post_time is null");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNotNull() {
            addCriterion("post_time is not null");
            return (Criteria) this;
        }

        public Criteria andPostTimeEqualTo(String value) {
            addCriterion("post_time =", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotEqualTo(String value) {
            addCriterion("post_time <>", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThan(String value) {
            addCriterion("post_time >", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThanOrEqualTo(String value) {
            addCriterion("post_time >=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThan(String value) {
            addCriterion("post_time <", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThanOrEqualTo(String value) {
            addCriterion("post_time <=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLike(String value) {
            addCriterion("post_time like", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotLike(String value) {
            addCriterion("post_time not like", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeIn(List<String> values) {
            addCriterion("post_time in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotIn(List<String> values) {
            addCriterion("post_time not in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeBetween(String value1, String value2) {
            addCriterion("post_time between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotBetween(String value1, String value2) {
            addCriterion("post_time not between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostContentImgIsNull() {
            addCriterion("post_content_img is null");
            return (Criteria) this;
        }

        public Criteria andPostContentImgIsNotNull() {
            addCriterion("post_content_img is not null");
            return (Criteria) this;
        }

        public Criteria andPostContentImgEqualTo(String value) {
            addCriterion("post_content_img =", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgNotEqualTo(String value) {
            addCriterion("post_content_img <>", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgGreaterThan(String value) {
            addCriterion("post_content_img >", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgGreaterThanOrEqualTo(String value) {
            addCriterion("post_content_img >=", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgLessThan(String value) {
            addCriterion("post_content_img <", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgLessThanOrEqualTo(String value) {
            addCriterion("post_content_img <=", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgLike(String value) {
            addCriterion("post_content_img like", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgNotLike(String value) {
            addCriterion("post_content_img not like", value, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgIn(List<String> values) {
            addCriterion("post_content_img in", values, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgNotIn(List<String> values) {
            addCriterion("post_content_img not in", values, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgBetween(String value1, String value2) {
            addCriterion("post_content_img between", value1, value2, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostContentImgNotBetween(String value1, String value2) {
            addCriterion("post_content_img not between", value1, value2, "postContentImg");
            return (Criteria) this;
        }

        public Criteria andPostUserIconIsNull() {
            addCriterion("post_user_icon is null");
            return (Criteria) this;
        }

        public Criteria andPostUserIconIsNotNull() {
            addCriterion("post_user_icon is not null");
            return (Criteria) this;
        }

        public Criteria andPostUserIconEqualTo(String value) {
            addCriterion("post_user_icon =", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconNotEqualTo(String value) {
            addCriterion("post_user_icon <>", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconGreaterThan(String value) {
            addCriterion("post_user_icon >", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconGreaterThanOrEqualTo(String value) {
            addCriterion("post_user_icon >=", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconLessThan(String value) {
            addCriterion("post_user_icon <", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconLessThanOrEqualTo(String value) {
            addCriterion("post_user_icon <=", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconLike(String value) {
            addCriterion("post_user_icon like", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconNotLike(String value) {
            addCriterion("post_user_icon not like", value, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconIn(List<String> values) {
            addCriterion("post_user_icon in", values, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconNotIn(List<String> values) {
            addCriterion("post_user_icon not in", values, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconBetween(String value1, String value2) {
            addCriterion("post_user_icon between", value1, value2, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostUserIconNotBetween(String value1, String value2) {
            addCriterion("post_user_icon not between", value1, value2, "postUserIcon");
            return (Criteria) this;
        }

        public Criteria andPostClickCountIsNull() {
            addCriterion("post_click_count is null");
            return (Criteria) this;
        }

        public Criteria andPostClickCountIsNotNull() {
            addCriterion("post_click_count is not null");
            return (Criteria) this;
        }

        public Criteria andPostClickCountEqualTo(Integer value) {
            addCriterion("post_click_count =", value, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountNotEqualTo(Integer value) {
            addCriterion("post_click_count <>", value, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountGreaterThan(Integer value) {
            addCriterion("post_click_count >", value, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_click_count >=", value, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountLessThan(Integer value) {
            addCriterion("post_click_count <", value, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("post_click_count <=", value, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountIn(List<Integer> values) {
            addCriterion("post_click_count in", values, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountNotIn(List<Integer> values) {
            addCriterion("post_click_count not in", values, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountBetween(Integer value1, Integer value2) {
            addCriterion("post_click_count between", value1, value2, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("post_click_count not between", value1, value2, "postClickCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountIsNull() {
            addCriterion("post_reply_count is null");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountIsNotNull() {
            addCriterion("post_reply_count is not null");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountEqualTo(Integer value) {
            addCriterion("post_reply_count =", value, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountNotEqualTo(Integer value) {
            addCriterion("post_reply_count <>", value, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountGreaterThan(Integer value) {
            addCriterion("post_reply_count >", value, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_reply_count >=", value, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountLessThan(Integer value) {
            addCriterion("post_reply_count <", value, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("post_reply_count <=", value, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountIn(List<Integer> values) {
            addCriterion("post_reply_count in", values, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountNotIn(List<Integer> values) {
            addCriterion("post_reply_count not in", values, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("post_reply_count between", value1, value2, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("post_reply_count not between", value1, value2, "postReplyCount");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyIsNull() {
            addCriterion("post_last_reply is null");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyIsNotNull() {
            addCriterion("post_last_reply is not null");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyEqualTo(String value) {
            addCriterion("post_last_reply =", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyNotEqualTo(String value) {
            addCriterion("post_last_reply <>", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyGreaterThan(String value) {
            addCriterion("post_last_reply >", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyGreaterThanOrEqualTo(String value) {
            addCriterion("post_last_reply >=", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyLessThan(String value) {
            addCriterion("post_last_reply <", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyLessThanOrEqualTo(String value) {
            addCriterion("post_last_reply <=", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyLike(String value) {
            addCriterion("post_last_reply like", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyNotLike(String value) {
            addCriterion("post_last_reply not like", value, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyIn(List<String> values) {
            addCriterion("post_last_reply in", values, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyNotIn(List<String> values) {
            addCriterion("post_last_reply not in", values, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyBetween(String value1, String value2) {
            addCriterion("post_last_reply between", value1, value2, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyNotBetween(String value1, String value2) {
            addCriterion("post_last_reply not between", value1, value2, "postLastReply");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeIsNull() {
            addCriterion("post_last_reply_time is null");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeIsNotNull() {
            addCriterion("post_last_reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeEqualTo(String value) {
            addCriterion("post_last_reply_time =", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeNotEqualTo(String value) {
            addCriterion("post_last_reply_time <>", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeGreaterThan(String value) {
            addCriterion("post_last_reply_time >", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("post_last_reply_time >=", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeLessThan(String value) {
            addCriterion("post_last_reply_time <", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeLessThanOrEqualTo(String value) {
            addCriterion("post_last_reply_time <=", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeLike(String value) {
            addCriterion("post_last_reply_time like", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeNotLike(String value) {
            addCriterion("post_last_reply_time not like", value, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeIn(List<String> values) {
            addCriterion("post_last_reply_time in", values, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeNotIn(List<String> values) {
            addCriterion("post_last_reply_time not in", values, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeBetween(String value1, String value2) {
            addCriterion("post_last_reply_time between", value1, value2, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeNotBetween(String value1, String value2) {
            addCriterion("post_last_reply_time not between", value1, value2, "postLastReplyTime");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleIsNull() {
            addCriterion("post_last_reply_time_simple is null");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleIsNotNull() {
            addCriterion("post_last_reply_time_simple is not null");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleEqualTo(String value) {
            addCriterion("post_last_reply_time_simple =", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleNotEqualTo(String value) {
            addCriterion("post_last_reply_time_simple <>", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleGreaterThan(String value) {
            addCriterion("post_last_reply_time_simple >", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleGreaterThanOrEqualTo(String value) {
            addCriterion("post_last_reply_time_simple >=", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleLessThan(String value) {
            addCriterion("post_last_reply_time_simple <", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleLessThanOrEqualTo(String value) {
            addCriterion("post_last_reply_time_simple <=", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleLike(String value) {
            addCriterion("post_last_reply_time_simple like", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleNotLike(String value) {
            addCriterion("post_last_reply_time_simple not like", value, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleIn(List<String> values) {
            addCriterion("post_last_reply_time_simple in", values, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleNotIn(List<String> values) {
            addCriterion("post_last_reply_time_simple not in", values, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleBetween(String value1, String value2) {
            addCriterion("post_last_reply_time_simple between", value1, value2, "postLastReplyTimeSimple");
            return (Criteria) this;
        }

        public Criteria andPostLastReplyTimeSimpleNotBetween(String value1, String value2) {
            addCriterion("post_last_reply_time_simple not between", value1, value2, "postLastReplyTimeSimple");
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