package com.cjw.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andJoinWorkIsNull() {
            addCriterion("join_work is null");
            return (Criteria) this;
        }

        public Criteria andJoinWorkIsNotNull() {
            addCriterion("join_work is not null");
            return (Criteria) this;
        }

        public Criteria andJoinWorkEqualTo(Date value) {
            addCriterionForJDBCDate("join_work =", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkNotEqualTo(Date value) {
            addCriterionForJDBCDate("join_work <>", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkGreaterThan(Date value) {
            addCriterionForJDBCDate("join_work >", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_work >=", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkLessThan(Date value) {
            addCriterionForJDBCDate("join_work <", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_work <=", value, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkIn(List<Date> values) {
            addCriterionForJDBCDate("join_work in", values, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkNotIn(List<Date> values) {
            addCriterionForJDBCDate("join_work not in", values, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_work between", value1, value2, "joinWork");
            return (Criteria) this;
        }

        public Criteria andJoinWorkNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_work not between", value1, value2, "joinWork");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIsNull() {
            addCriterion("session_key is null");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIsNotNull() {
            addCriterion("session_key is not null");
            return (Criteria) this;
        }

        public Criteria andSessionKeyEqualTo(String value) {
            addCriterion("session_key =", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotEqualTo(String value) {
            addCriterion("session_key <>", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyGreaterThan(String value) {
            addCriterion("session_key >", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("session_key >=", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLessThan(String value) {
            addCriterion("session_key <", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLessThanOrEqualTo(String value) {
            addCriterion("session_key <=", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyLike(String value) {
            addCriterion("session_key like", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotLike(String value) {
            addCriterion("session_key not like", value, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyIn(List<String> values) {
            addCriterion("session_key in", values, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotIn(List<String> values) {
            addCriterion("session_key not in", values, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyBetween(String value1, String value2) {
            addCriterion("session_key between", value1, value2, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andSessionKeyNotBetween(String value1, String value2) {
            addCriterion("session_key not between", value1, value2, "sessionKey");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageIsNull() {
            addCriterion("my_advantage is null");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageIsNotNull() {
            addCriterion("my_advantage is not null");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageEqualTo(String value) {
            addCriterion("my_advantage =", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageNotEqualTo(String value) {
            addCriterion("my_advantage <>", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageGreaterThan(String value) {
            addCriterion("my_advantage >", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageGreaterThanOrEqualTo(String value) {
            addCriterion("my_advantage >=", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageLessThan(String value) {
            addCriterion("my_advantage <", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageLessThanOrEqualTo(String value) {
            addCriterion("my_advantage <=", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageLike(String value) {
            addCriterion("my_advantage like", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageNotLike(String value) {
            addCriterion("my_advantage not like", value, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageIn(List<String> values) {
            addCriterion("my_advantage in", values, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageNotIn(List<String> values) {
            addCriterion("my_advantage not in", values, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageBetween(String value1, String value2) {
            addCriterion("my_advantage between", value1, value2, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAdvantageNotBetween(String value1, String value2) {
            addCriterion("my_advantage not between", value1, value2, "myAdvantage");
            return (Criteria) this;
        }

        public Criteria andMyAnswerIsNull() {
            addCriterion("my_answer is null");
            return (Criteria) this;
        }

        public Criteria andMyAnswerIsNotNull() {
            addCriterion("my_answer is not null");
            return (Criteria) this;
        }

        public Criteria andMyAnswerEqualTo(String value) {
            addCriterion("my_answer =", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerNotEqualTo(String value) {
            addCriterion("my_answer <>", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerGreaterThan(String value) {
            addCriterion("my_answer >", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("my_answer >=", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerLessThan(String value) {
            addCriterion("my_answer <", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerLessThanOrEqualTo(String value) {
            addCriterion("my_answer <=", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerLike(String value) {
            addCriterion("my_answer like", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerNotLike(String value) {
            addCriterion("my_answer not like", value, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerIn(List<String> values) {
            addCriterion("my_answer in", values, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerNotIn(List<String> values) {
            addCriterion("my_answer not in", values, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerBetween(String value1, String value2) {
            addCriterion("my_answer between", value1, value2, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andMyAnswerNotBetween(String value1, String value2) {
            addCriterion("my_answer not between", value1, value2, "myAnswer");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNull() {
            addCriterion("work_experience is null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNotNull() {
            addCriterion("work_experience is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceEqualTo(String value) {
            addCriterion("work_experience =", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotEqualTo(String value) {
            addCriterion("work_experience <>", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThan(String value) {
            addCriterion("work_experience >", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("work_experience >=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThan(String value) {
            addCriterion("work_experience <", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThanOrEqualTo(String value) {
            addCriterion("work_experience <=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLike(String value) {
            addCriterion("work_experience like", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotLike(String value) {
            addCriterion("work_experience not like", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIn(List<String> values) {
            addCriterion("work_experience in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotIn(List<String> values) {
            addCriterion("work_experience not in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceBetween(String value1, String value2) {
            addCriterion("work_experience between", value1, value2, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotBetween(String value1, String value2) {
            addCriterion("work_experience not between", value1, value2, "workExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceIsNull() {
            addCriterion("practice_experience is null");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceIsNotNull() {
            addCriterion("practice_experience is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceEqualTo(String value) {
            addCriterion("practice_experience =", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceNotEqualTo(String value) {
            addCriterion("practice_experience <>", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceGreaterThan(String value) {
            addCriterion("practice_experience >", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("practice_experience >=", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceLessThan(String value) {
            addCriterion("practice_experience <", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceLessThanOrEqualTo(String value) {
            addCriterion("practice_experience <=", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceLike(String value) {
            addCriterion("practice_experience like", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceNotLike(String value) {
            addCriterion("practice_experience not like", value, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceIn(List<String> values) {
            addCriterion("practice_experience in", values, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceNotIn(List<String> values) {
            addCriterion("practice_experience not in", values, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceBetween(String value1, String value2) {
            addCriterion("practice_experience between", value1, value2, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andPracticeExperienceNotBetween(String value1, String value2) {
            addCriterion("practice_experience not between", value1, value2, "practiceExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceIsNull() {
            addCriterion("project_experience is null");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceIsNotNull() {
            addCriterion("project_experience is not null");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceEqualTo(String value) {
            addCriterion("project_experience =", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceNotEqualTo(String value) {
            addCriterion("project_experience <>", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceGreaterThan(String value) {
            addCriterion("project_experience >", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("project_experience >=", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceLessThan(String value) {
            addCriterion("project_experience <", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceLessThanOrEqualTo(String value) {
            addCriterion("project_experience <=", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceLike(String value) {
            addCriterion("project_experience like", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceNotLike(String value) {
            addCriterion("project_experience not like", value, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceIn(List<String> values) {
            addCriterion("project_experience in", values, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceNotIn(List<String> values) {
            addCriterion("project_experience not in", values, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceBetween(String value1, String value2) {
            addCriterion("project_experience between", value1, value2, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andProjectExperienceNotBetween(String value1, String value2) {
            addCriterion("project_experience not between", value1, value2, "projectExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceIsNull() {
            addCriterion("educational_experience is null");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceIsNotNull() {
            addCriterion("educational_experience is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceEqualTo(String value) {
            addCriterion("educational_experience =", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceNotEqualTo(String value) {
            addCriterion("educational_experience <>", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceGreaterThan(String value) {
            addCriterion("educational_experience >", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("educational_experience >=", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceLessThan(String value) {
            addCriterion("educational_experience <", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceLessThanOrEqualTo(String value) {
            addCriterion("educational_experience <=", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceLike(String value) {
            addCriterion("educational_experience like", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceNotLike(String value) {
            addCriterion("educational_experience not like", value, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceIn(List<String> values) {
            addCriterion("educational_experience in", values, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceNotIn(List<String> values) {
            addCriterion("educational_experience not in", values, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceBetween(String value1, String value2) {
            addCriterion("educational_experience between", value1, value2, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andEducationalExperienceNotBetween(String value1, String value2) {
            addCriterion("educational_experience not between", value1, value2, "educationalExperience");
            return (Criteria) this;
        }

        public Criteria andJobIntensionIsNull() {
            addCriterion("job_intension is null");
            return (Criteria) this;
        }

        public Criteria andJobIntensionIsNotNull() {
            addCriterion("job_intension is not null");
            return (Criteria) this;
        }

        public Criteria andJobIntensionEqualTo(String value) {
            addCriterion("job_intension =", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionNotEqualTo(String value) {
            addCriterion("job_intension <>", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionGreaterThan(String value) {
            addCriterion("job_intension >", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionGreaterThanOrEqualTo(String value) {
            addCriterion("job_intension >=", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionLessThan(String value) {
            addCriterion("job_intension <", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionLessThanOrEqualTo(String value) {
            addCriterion("job_intension <=", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionLike(String value) {
            addCriterion("job_intension like", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionNotLike(String value) {
            addCriterion("job_intension not like", value, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionIn(List<String> values) {
            addCriterion("job_intension in", values, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionNotIn(List<String> values) {
            addCriterion("job_intension not in", values, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionBetween(String value1, String value2) {
            addCriterion("job_intension between", value1, value2, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andJobIntensionNotBetween(String value1, String value2) {
            addCriterion("job_intension not between", value1, value2, "jobIntension");
            return (Criteria) this;
        }

        public Criteria andUserSettingIsNull() {
            addCriterion("user_setting is null");
            return (Criteria) this;
        }

        public Criteria andUserSettingIsNotNull() {
            addCriterion("user_setting is not null");
            return (Criteria) this;
        }

        public Criteria andUserSettingEqualTo(String value) {
            addCriterion("user_setting =", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingNotEqualTo(String value) {
            addCriterion("user_setting <>", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingGreaterThan(String value) {
            addCriterion("user_setting >", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingGreaterThanOrEqualTo(String value) {
            addCriterion("user_setting >=", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingLessThan(String value) {
            addCriterion("user_setting <", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingLessThanOrEqualTo(String value) {
            addCriterion("user_setting <=", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingLike(String value) {
            addCriterion("user_setting like", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingNotLike(String value) {
            addCriterion("user_setting not like", value, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingIn(List<String> values) {
            addCriterion("user_setting in", values, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingNotIn(List<String> values) {
            addCriterion("user_setting not in", values, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingBetween(String value1, String value2) {
            addCriterion("user_setting between", value1, value2, "userSetting");
            return (Criteria) this;
        }

        public Criteria andUserSettingNotBetween(String value1, String value2) {
            addCriterion("user_setting not between", value1, value2, "userSetting");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(Integer value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(Integer value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(Integer value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(Integer value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(Integer value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<Integer> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<Integer> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(Integer value1, Integer value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceIsNull() {
            addCriterion("desired_working_place is null");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceIsNotNull() {
            addCriterion("desired_working_place is not null");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceEqualTo(String value) {
            addCriterion("desired_working_place =", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceNotEqualTo(String value) {
            addCriterion("desired_working_place <>", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceGreaterThan(String value) {
            addCriterion("desired_working_place >", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("desired_working_place >=", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceLessThan(String value) {
            addCriterion("desired_working_place <", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceLessThanOrEqualTo(String value) {
            addCriterion("desired_working_place <=", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceLike(String value) {
            addCriterion("desired_working_place like", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceNotLike(String value) {
            addCriterion("desired_working_place not like", value, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceIn(List<String> values) {
            addCriterion("desired_working_place in", values, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceNotIn(List<String> values) {
            addCriterion("desired_working_place not in", values, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceBetween(String value1, String value2) {
            addCriterion("desired_working_place between", value1, value2, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andDesiredWorkingPlaceNotBetween(String value1, String value2) {
            addCriterion("desired_working_place not between", value1, value2, "desiredWorkingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceIsNull() {
            addCriterion("living_place is null");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceIsNotNull() {
            addCriterion("living_place is not null");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceEqualTo(String value) {
            addCriterion("living_place =", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceNotEqualTo(String value) {
            addCriterion("living_place <>", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceGreaterThan(String value) {
            addCriterion("living_place >", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("living_place >=", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceLessThan(String value) {
            addCriterion("living_place <", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceLessThanOrEqualTo(String value) {
            addCriterion("living_place <=", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceLike(String value) {
            addCriterion("living_place like", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceNotLike(String value) {
            addCriterion("living_place not like", value, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceIn(List<String> values) {
            addCriterion("living_place in", values, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceNotIn(List<String> values) {
            addCriterion("living_place not in", values, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceBetween(String value1, String value2) {
            addCriterion("living_place between", value1, value2, "livingPlace");
            return (Criteria) this;
        }

        public Criteria andLivingPlaceNotBetween(String value1, String value2) {
            addCriterion("living_place not between", value1, value2, "livingPlace");
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