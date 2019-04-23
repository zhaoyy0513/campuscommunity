package zyy.campuscommunity.entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(Integer value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(Integer value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(Integer value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(Integer value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(Integer value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<Integer> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<Integer> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(Integer value1, Integer value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserCollegeIsNull() {
            addCriterion("user_college is null");
            return (Criteria) this;
        }

        public Criteria andUserCollegeIsNotNull() {
            addCriterion("user_college is not null");
            return (Criteria) this;
        }

        public Criteria andUserCollegeEqualTo(String value) {
            addCriterion("user_college =", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeNotEqualTo(String value) {
            addCriterion("user_college <>", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeGreaterThan(String value) {
            addCriterion("user_college >", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("user_college >=", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeLessThan(String value) {
            addCriterion("user_college <", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeLessThanOrEqualTo(String value) {
            addCriterion("user_college <=", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeLike(String value) {
            addCriterion("user_college like", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeNotLike(String value) {
            addCriterion("user_college not like", value, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeIn(List<String> values) {
            addCriterion("user_college in", values, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeNotIn(List<String> values) {
            addCriterion("user_college not in", values, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeBetween(String value1, String value2) {
            addCriterion("user_college between", value1, value2, "userCollege");
            return (Criteria) this;
        }

        public Criteria andUserCollegeNotBetween(String value1, String value2) {
            addCriterion("user_college not between", value1, value2, "userCollege");
            return (Criteria) this;
        }

        public Criteria andProblemIdIsNull() {
            addCriterion("problem_id is null");
            return (Criteria) this;
        }

        public Criteria andProblemIdIsNotNull() {
            addCriterion("problem_id is not null");
            return (Criteria) this;
        }

        public Criteria andProblemIdEqualTo(Integer value) {
            addCriterion("problem_id =", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotEqualTo(Integer value) {
            addCriterion("problem_id <>", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdGreaterThan(Integer value) {
            addCriterion("problem_id >", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem_id >=", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdLessThan(Integer value) {
            addCriterion("problem_id <", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdLessThanOrEqualTo(Integer value) {
            addCriterion("problem_id <=", value, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdIn(List<Integer> values) {
            addCriterion("problem_id in", values, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotIn(List<Integer> values) {
            addCriterion("problem_id not in", values, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdBetween(Integer value1, Integer value2) {
            addCriterion("problem_id between", value1, value2, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("problem_id not between", value1, value2, "problemId");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerIsNull() {
            addCriterion("problem_answer is null");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerIsNotNull() {
            addCriterion("problem_answer is not null");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerEqualTo(String value) {
            addCriterion("problem_answer =", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerNotEqualTo(String value) {
            addCriterion("problem_answer <>", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerGreaterThan(String value) {
            addCriterion("problem_answer >", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("problem_answer >=", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerLessThan(String value) {
            addCriterion("problem_answer <", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerLessThanOrEqualTo(String value) {
            addCriterion("problem_answer <=", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerLike(String value) {
            addCriterion("problem_answer like", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerNotLike(String value) {
            addCriterion("problem_answer not like", value, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerIn(List<String> values) {
            addCriterion("problem_answer in", values, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerNotIn(List<String> values) {
            addCriterion("problem_answer not in", values, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerBetween(String value1, String value2) {
            addCriterion("problem_answer between", value1, value2, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andProblemAnswerNotBetween(String value1, String value2) {
            addCriterion("problem_answer not between", value1, value2, "problemAnswer");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNull() {
            addCriterion("user_img is null");
            return (Criteria) this;
        }

        public Criteria andUserImgIsNotNull() {
            addCriterion("user_img is not null");
            return (Criteria) this;
        }

        public Criteria andUserImgEqualTo(String value) {
            addCriterion("user_img =", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotEqualTo(String value) {
            addCriterion("user_img <>", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThan(String value) {
            addCriterion("user_img >", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgGreaterThanOrEqualTo(String value) {
            addCriterion("user_img >=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThan(String value) {
            addCriterion("user_img <", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLessThanOrEqualTo(String value) {
            addCriterion("user_img <=", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgLike(String value) {
            addCriterion("user_img like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotLike(String value) {
            addCriterion("user_img not like", value, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgIn(List<String> values) {
            addCriterion("user_img in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotIn(List<String> values) {
            addCriterion("user_img not in", values, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgBetween(String value1, String value2) {
            addCriterion("user_img between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andUserImgNotBetween(String value1, String value2) {
            addCriterion("user_img not between", value1, value2, "userImg");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageIsNull() {
            addCriterion("unread_message is null");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageIsNotNull() {
            addCriterion("unread_message is not null");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageEqualTo(Integer value) {
            addCriterion("unread_message =", value, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageNotEqualTo(Integer value) {
            addCriterion("unread_message <>", value, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageGreaterThan(Integer value) {
            addCriterion("unread_message >", value, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageGreaterThanOrEqualTo(Integer value) {
            addCriterion("unread_message >=", value, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageLessThan(Integer value) {
            addCriterion("unread_message <", value, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageLessThanOrEqualTo(Integer value) {
            addCriterion("unread_message <=", value, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageIn(List<Integer> values) {
            addCriterion("unread_message in", values, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageNotIn(List<Integer> values) {
            addCriterion("unread_message not in", values, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageBetween(Integer value1, Integer value2) {
            addCriterion("unread_message between", value1, value2, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andUnreadMessageNotBetween(Integer value1, Integer value2) {
            addCriterion("unread_message not between", value1, value2, "unreadMessage");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumIsNull() {
            addCriterion("post_collection_num is null");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumIsNotNull() {
            addCriterion("post_collection_num is not null");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumEqualTo(Integer value) {
            addCriterion("post_collection_num =", value, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumNotEqualTo(Integer value) {
            addCriterion("post_collection_num <>", value, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumGreaterThan(Integer value) {
            addCriterion("post_collection_num >", value, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_collection_num >=", value, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumLessThan(Integer value) {
            addCriterion("post_collection_num <", value, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumLessThanOrEqualTo(Integer value) {
            addCriterion("post_collection_num <=", value, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumIn(List<Integer> values) {
            addCriterion("post_collection_num in", values, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumNotIn(List<Integer> values) {
            addCriterion("post_collection_num not in", values, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumBetween(Integer value1, Integer value2) {
            addCriterion("post_collection_num between", value1, value2, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andPostCollectionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("post_collection_num not between", value1, value2, "postCollectionNum");
            return (Criteria) this;
        }

        public Criteria andFocusNumberIsNull() {
            addCriterion("focus_number is null");
            return (Criteria) this;
        }

        public Criteria andFocusNumberIsNotNull() {
            addCriterion("focus_number is not null");
            return (Criteria) this;
        }

        public Criteria andFocusNumberEqualTo(Integer value) {
            addCriterion("focus_number =", value, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberNotEqualTo(Integer value) {
            addCriterion("focus_number <>", value, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberGreaterThan(Integer value) {
            addCriterion("focus_number >", value, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("focus_number >=", value, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberLessThan(Integer value) {
            addCriterion("focus_number <", value, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberLessThanOrEqualTo(Integer value) {
            addCriterion("focus_number <=", value, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberIn(List<Integer> values) {
            addCriterion("focus_number in", values, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberNotIn(List<Integer> values) {
            addCriterion("focus_number not in", values, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberBetween(Integer value1, Integer value2) {
            addCriterion("focus_number between", value1, value2, "focusNumber");
            return (Criteria) this;
        }

        public Criteria andFocusNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("focus_number not between", value1, value2, "focusNumber");
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