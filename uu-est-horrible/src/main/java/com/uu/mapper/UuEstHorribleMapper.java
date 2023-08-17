package com.uu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.uu.entity.UuEstHorrible;
import com.uu.entity.UuEstHorribleDetail;
import com.uu.entity.UuEstHorribleEditDetail;

/**
 * 
 * @author uuEstHorrible
 *
 */
public interface UuEstHorribleMapper {
	@Select("select * from UuEstHorrible where id = #{id}")
	UuEstHorrible queryUuEstHorribleById(@Param(value = "id") int id);

	@Select("select * from UuEstHorribleDetail where detailId = #{detailId}")
	List<UuEstHorribleDetail> queryUuEstHorribleDetailById(@Param(value = "detailId") int detailId);
	
	@Select("select *, case when number is null then 0 else number end as number_order from UuEstHorribleEditDetail where editDetailId = #{editDetailId} order by number_order, editTimes" )
	List<UuEstHorribleEditDetail> queryUuEstHorribleEditDetailById(@Param(value = "editDetailId") int editDetailId);
	
	@Insert("insert into UuEstHorribleEditDetail(editDetailId,increaseNumber,editTimes,number,editPlace,beforeEdit,afterEdit) "
			+ "values(#{editDetailId},"
			+ "#{increaseNumber},#{editTimes},"
			+ "#{number},#{editPlace},#{beforeEdit},#{afterEdit})")
    void insertUuEstHorribleEditDetail(UuEstHorribleEditDetail UuEstHorribleEditDetail);
	
//	@Select("select MAX(increaseNumber) + 1 increaseNumber, MAX(editTimes) + 1 editTimes from UuEstHorribleEditDetail where editDetailId = #{editDetailId}")
	UuEstHorribleEditDetail queryUuEstHorribleEditDetailMaxValue(UuEstHorribleEditDetail UuEstHorribleEditDetail);
}
