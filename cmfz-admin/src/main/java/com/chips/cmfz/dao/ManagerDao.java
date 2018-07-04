package com.chips.cmfz.dao;

import com.chips.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 16576 on 2018/7/4.
 */
public interface ManagerDao {

    public List<Manager> selectAllManager();

    public Manager selectManagerByName(@Param("mgrName") String mgrName);

}
