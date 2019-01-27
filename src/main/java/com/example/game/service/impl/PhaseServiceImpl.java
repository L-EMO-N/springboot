package com.example.game.service.impl;

import com.example.datasource.DataSourceType;
import com.example.datasource.MyDataSource;
import com.example.game.domain.mapper.PhaseMapper;
import com.example.game.domain.pojo.Phase;
import com.example.game.service.PhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2019/1/27
 */
@Service
public class PhaseServiceImpl  implements PhaseService{

    @Autowired
    private PhaseMapper phaseMapper;
    @Override
    @MyDataSource(DataSourceType.Read)
    public Phase readGetPhase() {
        return phaseMapper.readGetPhase();
    }

    @Override
    @MyDataSource(DataSourceType.Write)
    public Phase writeGetPahse() {
        return phaseMapper.writeGetPahse();
    }
}
