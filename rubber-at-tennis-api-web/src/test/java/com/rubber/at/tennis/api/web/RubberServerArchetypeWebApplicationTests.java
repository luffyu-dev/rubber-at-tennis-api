package com.rubber.at.tennis.api.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rubber.at.tennis.atp.dao.condition.RankSearchCondition;
import com.rubber.at.tennis.atp.dao.dal.IPlayerRankInfoDal;
import com.rubber.at.tennis.atp.dao.entity.PlayerRankInfoEntity;
import com.rubber.user.api.service.GlobalFieldQueryService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;


@SpringBootTest
@ComponentScan("com.rubber.at.tennis.*")
@MapperScan("com.rubber.at.tennis.**.dao.mapper")
class RubberServerArchetypeWebApplicationTests {



    @Autowired
    private IPlayerRankInfoDal iPlayerRankInfoDal;

    @Test
    public void queryTourMatchInfo(){
        IPage<PlayerRankInfoEntity> page = new Page<>();
        page.setSize(1);
        page.setCurrent(1);
        page.setTotal(0);

        RankSearchCondition condition = new RankSearchCondition();
        condition.setDataVersion("20241122");
        condition.setPlayerType("atp");
//        condition.setSearchValue("中国");
        IPage<PlayerRankInfoEntity> playerRankInfoEntities = iPlayerRankInfoDal.selectPlayerRank(page,condition);
        System.out.println(playerRankInfoEntities);
    }


}
