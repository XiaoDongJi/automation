package com.citichma.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductPlanExample() {
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

    /**
     * 电控产品生产计划表
     */
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

        public Criteria andWorkSnIsNull() {
            addCriterion("work_sn is null");
            return (Criteria) this;
        }

        public Criteria andWorkSnIsNotNull() {
            addCriterion("work_sn is not null");
            return (Criteria) this;
        }

        public Criteria andWorkSnEqualTo(String value) {
            addCriterion("work_sn =", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnNotEqualTo(String value) {
            addCriterion("work_sn <>", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnGreaterThan(String value) {
            addCriterion("work_sn >", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnGreaterThanOrEqualTo(String value) {
            addCriterion("work_sn >=", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnLessThan(String value) {
            addCriterion("work_sn <", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnLessThanOrEqualTo(String value) {
            addCriterion("work_sn <=", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnLike(String value) {
            addCriterion("work_sn like", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnNotLike(String value) {
            addCriterion("work_sn not like", value, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnIn(List<String> values) {
            addCriterion("work_sn in", values, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnNotIn(List<String> values) {
            addCriterion("work_sn not in", values, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnBetween(String value1, String value2) {
            addCriterion("work_sn between", value1, value2, "workSn");
            return (Criteria) this;
        }

        public Criteria andWorkSnNotBetween(String value1, String value2) {
            addCriterion("work_sn not between", value1, value2, "workSn");
            return (Criteria) this;
        }

        public Criteria andContractSnIsNull() {
            addCriterion("contract_sn is null");
            return (Criteria) this;
        }

        public Criteria andContractSnIsNotNull() {
            addCriterion("contract_sn is not null");
            return (Criteria) this;
        }

        public Criteria andContractSnEqualTo(String value) {
            addCriterion("contract_sn =", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnNotEqualTo(String value) {
            addCriterion("contract_sn <>", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnGreaterThan(String value) {
            addCriterion("contract_sn >", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnGreaterThanOrEqualTo(String value) {
            addCriterion("contract_sn >=", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnLessThan(String value) {
            addCriterion("contract_sn <", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnLessThanOrEqualTo(String value) {
            addCriterion("contract_sn <=", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnLike(String value) {
            addCriterion("contract_sn like", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnNotLike(String value) {
            addCriterion("contract_sn not like", value, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnIn(List<String> values) {
            addCriterion("contract_sn in", values, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnNotIn(List<String> values) {
            addCriterion("contract_sn not in", values, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnBetween(String value1, String value2) {
            addCriterion("contract_sn between", value1, value2, "contractSn");
            return (Criteria) this;
        }

        public Criteria andContractSnNotBetween(String value1, String value2) {
            addCriterion("contract_sn not between", value1, value2, "contractSn");
            return (Criteria) this;
        }

        public Criteria andChartSnIsNull() {
            addCriterion("chart_sn is null");
            return (Criteria) this;
        }

        public Criteria andChartSnIsNotNull() {
            addCriterion("chart_sn is not null");
            return (Criteria) this;
        }

        public Criteria andChartSnEqualTo(String value) {
            addCriterion("chart_sn =", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnNotEqualTo(String value) {
            addCriterion("chart_sn <>", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnGreaterThan(String value) {
            addCriterion("chart_sn >", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnGreaterThanOrEqualTo(String value) {
            addCriterion("chart_sn >=", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnLessThan(String value) {
            addCriterion("chart_sn <", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnLessThanOrEqualTo(String value) {
            addCriterion("chart_sn <=", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnLike(String value) {
            addCriterion("chart_sn like", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnNotLike(String value) {
            addCriterion("chart_sn not like", value, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnIn(List<String> values) {
            addCriterion("chart_sn in", values, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnNotIn(List<String> values) {
            addCriterion("chart_sn not in", values, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnBetween(String value1, String value2) {
            addCriterion("chart_sn between", value1, value2, "chartSn");
            return (Criteria) this;
        }

        public Criteria andChartSnNotBetween(String value1, String value2) {
            addCriterion("chart_sn not between", value1, value2, "chartSn");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNull() {
            addCriterion("product_num is null");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNotNull() {
            addCriterion("product_num is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumEqualTo(Integer value) {
            addCriterion("product_num =", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotEqualTo(Integer value) {
            addCriterion("product_num <>", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThan(Integer value) {
            addCriterion("product_num >", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_num >=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThan(Integer value) {
            addCriterion("product_num <", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThanOrEqualTo(Integer value) {
            addCriterion("product_num <=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumIn(List<Integer> values) {
            addCriterion("product_num in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotIn(List<Integer> values) {
            addCriterion("product_num not in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumBetween(Integer value1, Integer value2) {
            addCriterion("product_num between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotBetween(Integer value1, Integer value2) {
            addCriterion("product_num not between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(Date value) {
            addCriterion("delivery_date =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(Date value) {
            addCriterion("delivery_date <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(Date value) {
            addCriterion("delivery_date >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_date >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(Date value) {
            addCriterion("delivery_date <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("delivery_date <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<Date> values) {
            addCriterion("delivery_date in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<Date> values) {
            addCriterion("delivery_date not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("delivery_date between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("delivery_date not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateIsNull() {
            addCriterion("trycar_date is null");
            return (Criteria) this;
        }

        public Criteria andTrycarDateIsNotNull() {
            addCriterion("trycar_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrycarDateEqualTo(Date value) {
            addCriterion("trycar_date =", value, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateNotEqualTo(Date value) {
            addCriterion("trycar_date <>", value, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateGreaterThan(Date value) {
            addCriterion("trycar_date >", value, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateGreaterThanOrEqualTo(Date value) {
            addCriterion("trycar_date >=", value, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateLessThan(Date value) {
            addCriterion("trycar_date <", value, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateLessThanOrEqualTo(Date value) {
            addCriterion("trycar_date <=", value, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateIn(List<Date> values) {
            addCriterion("trycar_date in", values, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateNotIn(List<Date> values) {
            addCriterion("trycar_date not in", values, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateBetween(Date value1, Date value2) {
            addCriterion("trycar_date between", value1, value2, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andTrycarDateNotBetween(Date value1, Date value2) {
            addCriterion("trycar_date not between", value1, value2, "trycarDate");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(Integer value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(Integer value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(Integer value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(Integer value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(Integer value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<Integer> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<Integer> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(Integer value1, Integer value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyIsNull() {
            addCriterion("order_company is null");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyIsNotNull() {
            addCriterion("order_company is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyEqualTo(Integer value) {
            addCriterion("order_company =", value, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyNotEqualTo(Integer value) {
            addCriterion("order_company <>", value, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyGreaterThan(Integer value) {
            addCriterion("order_company >", value, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_company >=", value, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyLessThan(Integer value) {
            addCriterion("order_company <", value, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyLessThanOrEqualTo(Integer value) {
            addCriterion("order_company <=", value, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyIn(List<Integer> values) {
            addCriterion("order_company in", values, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyNotIn(List<Integer> values) {
            addCriterion("order_company not in", values, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyBetween(Integer value1, Integer value2) {
            addCriterion("order_company between", value1, value2, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderCompanyNotBetween(Integer value1, Integer value2) {
            addCriterion("order_company not between", value1, value2, "orderCompany");
            return (Criteria) this;
        }

        public Criteria andOrderUserIsNull() {
            addCriterion("order_user is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIsNotNull() {
            addCriterion("order_user is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserEqualTo(String value) {
            addCriterion("order_user =", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotEqualTo(String value) {
            addCriterion("order_user <>", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserGreaterThan(String value) {
            addCriterion("order_user >", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserGreaterThanOrEqualTo(String value) {
            addCriterion("order_user >=", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserLessThan(String value) {
            addCriterion("order_user <", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserLessThanOrEqualTo(String value) {
            addCriterion("order_user <=", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserLike(String value) {
            addCriterion("order_user like", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotLike(String value) {
            addCriterion("order_user not like", value, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserIn(List<String> values) {
            addCriterion("order_user in", values, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotIn(List<String> values) {
            addCriterion("order_user not in", values, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserBetween(String value1, String value2) {
            addCriterion("order_user between", value1, value2, "orderUser");
            return (Criteria) this;
        }

        public Criteria andOrderUserNotBetween(String value1, String value2) {
            addCriterion("order_user not between", value1, value2, "orderUser");
            return (Criteria) this;
        }

        public Criteria andDesignerIsNull() {
            addCriterion("designer is null");
            return (Criteria) this;
        }

        public Criteria andDesignerIsNotNull() {
            addCriterion("designer is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerEqualTo(String value) {
            addCriterion("designer =", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotEqualTo(String value) {
            addCriterion("designer <>", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerGreaterThan(String value) {
            addCriterion("designer >", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerGreaterThanOrEqualTo(String value) {
            addCriterion("designer >=", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerLessThan(String value) {
            addCriterion("designer <", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerLessThanOrEqualTo(String value) {
            addCriterion("designer <=", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerLike(String value) {
            addCriterion("designer like", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotLike(String value) {
            addCriterion("designer not like", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerIn(List<String> values) {
            addCriterion("designer in", values, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotIn(List<String> values) {
            addCriterion("designer not in", values, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerBetween(String value1, String value2) {
            addCriterion("designer between", value1, value2, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotBetween(String value1, String value2) {
            addCriterion("designer not between", value1, value2, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyIsNull() {
            addCriterion("design_company is null");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyIsNotNull() {
            addCriterion("design_company is not null");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyEqualTo(Integer value) {
            addCriterion("design_company =", value, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyNotEqualTo(Integer value) {
            addCriterion("design_company <>", value, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyGreaterThan(Integer value) {
            addCriterion("design_company >", value, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyGreaterThanOrEqualTo(Integer value) {
            addCriterion("design_company >=", value, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyLessThan(Integer value) {
            addCriterion("design_company <", value, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyLessThanOrEqualTo(Integer value) {
            addCriterion("design_company <=", value, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyIn(List<Integer> values) {
            addCriterion("design_company in", values, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyNotIn(List<Integer> values) {
            addCriterion("design_company not in", values, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyBetween(Integer value1, Integer value2) {
            addCriterion("design_company between", value1, value2, "designCompany");
            return (Criteria) this;
        }

        public Criteria andDesignCompanyNotBetween(Integer value1, Integer value2) {
            addCriterion("design_company not between", value1, value2, "designCompany");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNull() {
            addCriterion("organizer is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNotNull() {
            addCriterion("organizer is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerEqualTo(String value) {
            addCriterion("organizer =", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotEqualTo(String value) {
            addCriterion("organizer <>", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThan(String value) {
            addCriterion("organizer >", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("organizer >=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThan(String value) {
            addCriterion("organizer <", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThanOrEqualTo(String value) {
            addCriterion("organizer <=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLike(String value) {
            addCriterion("organizer like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotLike(String value) {
            addCriterion("organizer not like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerIn(List<String> values) {
            addCriterion("organizer in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotIn(List<String> values) {
            addCriterion("organizer not in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerBetween(String value1, String value2) {
            addCriterion("organizer between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotBetween(String value1, String value2) {
            addCriterion("organizer not between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andApproverIsNull() {
            addCriterion("approver is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsNotNull() {
            addCriterion("approver is not null");
            return (Criteria) this;
        }

        public Criteria andApproverEqualTo(String value) {
            addCriterion("approver =", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotEqualTo(String value) {
            addCriterion("approver <>", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThan(String value) {
            addCriterion("approver >", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThanOrEqualTo(String value) {
            addCriterion("approver >=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThan(String value) {
            addCriterion("approver <", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThanOrEqualTo(String value) {
            addCriterion("approver <=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLike(String value) {
            addCriterion("approver like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotLike(String value) {
            addCriterion("approver not like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverIn(List<String> values) {
            addCriterion("approver in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotIn(List<String> values) {
            addCriterion("approver not in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverBetween(String value1, String value2) {
            addCriterion("approver between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotBetween(String value1, String value2) {
            addCriterion("approver not between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNull() {
            addCriterion("order_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("order_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(Date value) {
            addCriterion("order_date =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(Date value) {
            addCriterion("order_date <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(Date value) {
            addCriterion("order_date >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_date >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(Date value) {
            addCriterion("order_date <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(Date value) {
            addCriterion("order_date <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<Date> values) {
            addCriterion("order_date in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<Date> values) {
            addCriterion("order_date not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(Date value1, Date value2) {
            addCriterion("order_date between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(Date value1, Date value2) {
            addCriterion("order_date not between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateIsNull() {
            addCriterion("adjust_deliver_date is null");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateIsNotNull() {
            addCriterion("adjust_deliver_date is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateEqualTo(Date value) {
            addCriterion("adjust_deliver_date =", value, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateNotEqualTo(Date value) {
            addCriterion("adjust_deliver_date <>", value, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateGreaterThan(Date value) {
            addCriterion("adjust_deliver_date >", value, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateGreaterThanOrEqualTo(Date value) {
            addCriterion("adjust_deliver_date >=", value, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateLessThan(Date value) {
            addCriterion("adjust_deliver_date <", value, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateLessThanOrEqualTo(Date value) {
            addCriterion("adjust_deliver_date <=", value, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateIn(List<Date> values) {
            addCriterion("adjust_deliver_date in", values, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateNotIn(List<Date> values) {
            addCriterion("adjust_deliver_date not in", values, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateBetween(Date value1, Date value2) {
            addCriterion("adjust_deliver_date between", value1, value2, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andAdjustDeliverDateNotBetween(Date value1, Date value2) {
            addCriterion("adjust_deliver_date not between", value1, value2, "adjustDeliverDate");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNull() {
            addCriterion("project_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNotNull() {
            addCriterion("project_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEqualTo(String value) {
            addCriterion("project_leader =", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotEqualTo(String value) {
            addCriterion("project_leader <>", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThan(String value) {
            addCriterion("project_leader >", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader >=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThan(String value) {
            addCriterion("project_leader <", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThanOrEqualTo(String value) {
            addCriterion("project_leader <=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLike(String value) {
            addCriterion("project_leader like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotLike(String value) {
            addCriterion("project_leader not like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIn(List<String> values) {
            addCriterion("project_leader in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotIn(List<String> values) {
            addCriterion("project_leader not in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderBetween(String value1, String value2) {
            addCriterion("project_leader between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotBetween(String value1, String value2) {
            addCriterion("project_leader not between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeIsNull() {
            addCriterion("importance_degree is null");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeIsNotNull() {
            addCriterion("importance_degree is not null");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeEqualTo(Integer value) {
            addCriterion("importance_degree =", value, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeNotEqualTo(Integer value) {
            addCriterion("importance_degree <>", value, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeGreaterThan(Integer value) {
            addCriterion("importance_degree >", value, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("importance_degree >=", value, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeLessThan(Integer value) {
            addCriterion("importance_degree <", value, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("importance_degree <=", value, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeIn(List<Integer> values) {
            addCriterion("importance_degree in", values, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeNotIn(List<Integer> values) {
            addCriterion("importance_degree not in", values, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeBetween(Integer value1, Integer value2) {
            addCriterion("importance_degree between", value1, value2, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andImportanceDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("importance_degree not between", value1, value2, "importanceDegree");
            return (Criteria) this;
        }

        public Criteria andCupboardNumIsNull() {
            addCriterion("cupboard_num is null");
            return (Criteria) this;
        }

        public Criteria andCupboardNumIsNotNull() {
            addCriterion("cupboard_num is not null");
            return (Criteria) this;
        }

        public Criteria andCupboardNumEqualTo(Integer value) {
            addCriterion("cupboard_num =", value, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumNotEqualTo(Integer value) {
            addCriterion("cupboard_num <>", value, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumGreaterThan(Integer value) {
            addCriterion("cupboard_num >", value, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cupboard_num >=", value, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumLessThan(Integer value) {
            addCriterion("cupboard_num <", value, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumLessThanOrEqualTo(Integer value) {
            addCriterion("cupboard_num <=", value, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumIn(List<Integer> values) {
            addCriterion("cupboard_num in", values, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumNotIn(List<Integer> values) {
            addCriterion("cupboard_num not in", values, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumBetween(Integer value1, Integer value2) {
            addCriterion("cupboard_num between", value1, value2, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andCupboardNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cupboard_num not between", value1, value2, "cupboardNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumIsNull() {
            addCriterion("box_num is null");
            return (Criteria) this;
        }

        public Criteria andBoxNumIsNotNull() {
            addCriterion("box_num is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNumEqualTo(Integer value) {
            addCriterion("box_num =", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotEqualTo(Integer value) {
            addCriterion("box_num <>", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumGreaterThan(Integer value) {
            addCriterion("box_num >", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("box_num >=", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumLessThan(Integer value) {
            addCriterion("box_num <", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumLessThanOrEqualTo(Integer value) {
            addCriterion("box_num <=", value, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumIn(List<Integer> values) {
            addCriterion("box_num in", values, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotIn(List<Integer> values) {
            addCriterion("box_num not in", values, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumBetween(Integer value1, Integer value2) {
            addCriterion("box_num between", value1, value2, "boxNum");
            return (Criteria) this;
        }

        public Criteria andBoxNumNotBetween(Integer value1, Integer value2) {
            addCriterion("box_num not between", value1, value2, "boxNum");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNull() {
            addCriterion("project_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNotNull() {
            addCriterion("project_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusEqualTo(Integer value) {
            addCriterion("project_status =", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotEqualTo(Integer value) {
            addCriterion("project_status <>", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThan(Integer value) {
            addCriterion("project_status >", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_status >=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThan(Integer value) {
            addCriterion("project_status <", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project_status <=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIn(List<Integer> values) {
            addCriterion("project_status in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotIn(List<Integer> values) {
            addCriterion("project_status not in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusBetween(Integer value1, Integer value2) {
            addCriterion("project_status between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project_status not between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateIsNull() {
            addCriterion("zfj_finish_date is null");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateIsNotNull() {
            addCriterion("zfj_finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateEqualTo(Date value) {
            addCriterion("zfj_finish_date =", value, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateNotEqualTo(Date value) {
            addCriterion("zfj_finish_date <>", value, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateGreaterThan(Date value) {
            addCriterion("zfj_finish_date >", value, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("zfj_finish_date >=", value, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateLessThan(Date value) {
            addCriterion("zfj_finish_date <", value, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateLessThanOrEqualTo(Date value) {
            addCriterion("zfj_finish_date <=", value, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateIn(List<Date> values) {
            addCriterion("zfj_finish_date in", values, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateNotIn(List<Date> values) {
            addCriterion("zfj_finish_date not in", values, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateBetween(Date value1, Date value2) {
            addCriterion("zfj_finish_date between", value1, value2, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishDateNotBetween(Date value1, Date value2) {
            addCriterion("zfj_finish_date not between", value1, value2, "zfjFinishDate");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumIsNull() {
            addCriterion("zfj_finish_num is null");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumIsNotNull() {
            addCriterion("zfj_finish_num is not null");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumEqualTo(Integer value) {
            addCriterion("zfj_finish_num =", value, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumNotEqualTo(Integer value) {
            addCriterion("zfj_finish_num <>", value, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumGreaterThan(Integer value) {
            addCriterion("zfj_finish_num >", value, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("zfj_finish_num >=", value, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumLessThan(Integer value) {
            addCriterion("zfj_finish_num <", value, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumLessThanOrEqualTo(Integer value) {
            addCriterion("zfj_finish_num <=", value, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumIn(List<Integer> values) {
            addCriterion("zfj_finish_num in", values, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumNotIn(List<Integer> values) {
            addCriterion("zfj_finish_num not in", values, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumBetween(Integer value1, Integer value2) {
            addCriterion("zfj_finish_num between", value1, value2, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjFinishNumNotBetween(Integer value1, Integer value2) {
            addCriterion("zfj_finish_num not between", value1, value2, "zfjFinishNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumIsNull() {
            addCriterion("zfj_num is null");
            return (Criteria) this;
        }

        public Criteria andZfjNumIsNotNull() {
            addCriterion("zfj_num is not null");
            return (Criteria) this;
        }

        public Criteria andZfjNumEqualTo(Integer value) {
            addCriterion("zfj_num =", value, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumNotEqualTo(Integer value) {
            addCriterion("zfj_num <>", value, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumGreaterThan(Integer value) {
            addCriterion("zfj_num >", value, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("zfj_num >=", value, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumLessThan(Integer value) {
            addCriterion("zfj_num <", value, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumLessThanOrEqualTo(Integer value) {
            addCriterion("zfj_num <=", value, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumIn(List<Integer> values) {
            addCriterion("zfj_num in", values, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumNotIn(List<Integer> values) {
            addCriterion("zfj_num not in", values, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumBetween(Integer value1, Integer value2) {
            addCriterion("zfj_num between", value1, value2, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andZfjNumNotBetween(Integer value1, Integer value2) {
            addCriterion("zfj_num not between", value1, value2, "zfjNum");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNull() {
            addCriterion("out_date is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNotNull() {
            addCriterion("out_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateEqualTo(Date value) {
            addCriterion("out_date =", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotEqualTo(Date value) {
            addCriterion("out_date <>", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThan(Date value) {
            addCriterion("out_date >", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_date >=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThan(Date value) {
            addCriterion("out_date <", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThanOrEqualTo(Date value) {
            addCriterion("out_date <=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIn(List<Date> values) {
            addCriterion("out_date in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotIn(List<Date> values) {
            addCriterion("out_date not in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateBetween(Date value1, Date value2) {
            addCriterion("out_date between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotBetween(Date value1, Date value2) {
            addCriterion("out_date not between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportIsNull() {
            addCriterion("delivery_report is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportIsNotNull() {
            addCriterion("delivery_report is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportEqualTo(Date value) {
            addCriterion("delivery_report =", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportNotEqualTo(Date value) {
            addCriterion("delivery_report <>", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportGreaterThan(Date value) {
            addCriterion("delivery_report >", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_report >=", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportLessThan(Date value) {
            addCriterion("delivery_report <", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportLessThanOrEqualTo(Date value) {
            addCriterion("delivery_report <=", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportLike(Date value) {
            addCriterion("delivery_report like", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportNotLike(Date value) {
            addCriterion("delivery_report not like", value, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportIn(List<Date> values) {
            addCriterion("delivery_report in", values, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportNotIn(List<Date> values) {
            addCriterion("delivery_report not in", values, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportBetween(Date value1, Date value2) {
            addCriterion("delivery_report between", value1, value2, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andDeliveryReportNotBetween(Date value1, Date value2) {
            addCriterion("delivery_report not between", value1, value2, "deliveryReport");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("remark3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("remark3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("remark3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("remark3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("remark3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("remark3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("remark3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("remark3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("remark3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("remark3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("remark3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("remark3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark4IsNull() {
            addCriterion("remark4 is null");
            return (Criteria) this;
        }

        public Criteria andRemark4IsNotNull() {
            addCriterion("remark4 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark4EqualTo(String value) {
            addCriterion("remark4 =", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotEqualTo(String value) {
            addCriterion("remark4 <>", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4GreaterThan(String value) {
            addCriterion("remark4 >", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            addCriterion("remark4 >=", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4LessThan(String value) {
            addCriterion("remark4 <", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            addCriterion("remark4 <=", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4Like(String value) {
            addCriterion("remark4 like", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotLike(String value) {
            addCriterion("remark4 not like", value, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4In(List<String> values) {
            addCriterion("remark4 in", values, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotIn(List<String> values) {
            addCriterion("remark4 not in", values, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4Between(String value1, String value2) {
            addCriterion("remark4 between", value1, value2, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            addCriterion("remark4 not between", value1, value2, "remark4");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("last_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("last_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterion("last_modify_time =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterion("last_modify_time >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterion("last_modify_time <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterion("last_modify_time in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyIdIsNull() {
            addCriterion("modify_id is null");
            return (Criteria) this;
        }

        public Criteria andModifyIdIsNotNull() {
            addCriterion("modify_id is not null");
            return (Criteria) this;
        }

        public Criteria andModifyIdEqualTo(Integer value) {
            addCriterion("modify_id =", value, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdNotEqualTo(Integer value) {
            addCriterion("modify_id <>", value, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdGreaterThan(Integer value) {
            addCriterion("modify_id >", value, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("modify_id >=", value, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdLessThan(Integer value) {
            addCriterion("modify_id <", value, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("modify_id <=", value, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdIn(List<Integer> values) {
            addCriterion("modify_id in", values, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdNotIn(List<Integer> values) {
            addCriterion("modify_id not in", values, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdBetween(Integer value1, Integer value2) {
            addCriterion("modify_id between", value1, value2, "modifyId");
            return (Criteria) this;
        }

        public Criteria andModifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("modify_id not between", value1, value2, "modifyId");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 电控产品生产计划表
     */
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