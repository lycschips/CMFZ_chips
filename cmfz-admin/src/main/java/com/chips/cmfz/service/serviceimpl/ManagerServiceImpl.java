package com.chips.cmfz.service.serviceimpl;


import com.chips.cmfz.dao.ManagerDao;
import com.chips.cmfz.entity.Manager;
import com.chips.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 16576 on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Manager> selectAllManager() {
        List<Manager> managers = managerDao.selectAllManager();
        return managers;
    }
}
