package com.cjw.Dao.Entity;

import java.util.ArrayList;
import java.util.List;

public class PositionTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionTypeExample() {
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

        public Criteria andPositionTypeIdIsNull() {
            addCriterion("position_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdIsNotNull() {
            addCriterion("position_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdEqualTo(Integer value) {
            addCriterion("position_type_id =", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdNotEqualTo(Integer value) {
            addCriterion("position_type_id <>", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdGreaterThan(Integer value) {
            addCriterion("position_type_id >", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_type_id >=", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdLessThan(Integer value) {
            addCriterion("position_type_id <", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("position_type_id <=", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdIn(List<Integer> values) {
            addCriterion("position_type_id in", values, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdNotIn(List<Integer> values) {
            addCriterion("position_type_id not in", values, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("position_type_id between", value1, value2, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("position_type_id not between", value1, value2, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIsNull() {
            addCriterion("position_type_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIsNotNull() {
            addCriterion("position_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameEqualTo(String value) {
            addCriterion("position_type_name =", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotEqualTo(String value) {
            addCriterion("position_type_name <>", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameGreaterThan(String value) {
            addCriterion("position_type_name >", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_type_name >=", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLessThan(String value) {
            addCriterion("position_type_name <", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLessThanOrEqualTo(String value) {
            addCriterion("position_type_name <=", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLike(String value) {
            addCriterion("position_type_name like", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotLike(String value) {
            addCriterion("position_type_name not like", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIn(List<String> values) {
            addCriterion("position_type_name in", values, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotIn(List<String> values) {
            addCriterion("position_type_name not in", values, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameBetween(String value1, String value2) {
            addCriterion("position_type_name between", value1, value2, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotBetween(String value1, String value2) {
            addCriterion("position_type_name not between", value1, value2, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(Integer value) {
            addCriterion("parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(Integer value) {
            addCriterion("parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(Integer value) {
            addCriterion("parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(Integer value) {
            addCriterion("parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(Integer value) {
            addCriterion("parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<Integer> values) {
            addCriterion("parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<Integer> values) {
            addCriterion("parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(Integer value1, Integer value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(Integer value1, Integer value2) {
            addCriterion("parent not between", value1, value2, "parent");
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