package com.citichma.mapper;

import com.citichma.common.vo.ProductPlanDetailVo;
import com.citichma.common.vo.ProductPlanWithTimeNode;
import com.citichma.pojo.ProductPlan;
import com.citichma.pojo.ProductPlanExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPlanMapper {
    int countByExample(ProductPlanExample example);

    int deleteByExample(ProductPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductPlan record);

    int insertSelective(ProductPlan record);

    List<ProductPlan> selectByExample(ProductPlanExample example);

    ProductPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductPlan record, @Param("example") ProductPlanExample example);

    int updateByExample(@Param("record") ProductPlan record, @Param("example") ProductPlanExample example);

    int updateByPrimaryKeySelective(ProductPlan record);

    int updateByPrimaryKey(ProductPlan record);
    
    ProductPlanDetailVo findProductPlanDetailById(Integer id);
    /*查询所有生产计划*/
    List<ProductPlanWithTimeNode> findProductPlanWithNodeAll();
}