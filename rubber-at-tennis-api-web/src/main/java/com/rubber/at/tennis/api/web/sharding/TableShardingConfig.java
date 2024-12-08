package com.rubber.at.tennis.api.web.sharding;

import com.rubber.base.components.mysql.plugins.sharding.config.RubberShardingConfig;
import com.rubber.base.components.mysql.plugins.sharding.strategy.RubberYearMonthShardingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luffyu
 * Created on 2024/11/17
 */
@Configuration
public class TableShardingConfig {


    @Bean
    public RubberShardingConfig shardingConfig(){
        RubberShardingConfig rubberShardingConfig = new RubberShardingConfig();
        rubberShardingConfig.table("t_player_rank_info")
                .logicDb("at_tennis")
                .strategy(new RubberYearMonthShardingStrategy())
                .end()
                .table("t_user_basic_info")
                .realDb("user_db")
                .realTable("t_user_basic_info")
                .end()
                .table("t_user_account_info")
                .realDb("user_db")
                .realTable("t_user_account_info")
                .end()
                .table("t_global_uid_generator")
                .realDb("user_db")
                .realTable("t_global_uid_generator")
                .end()
                .table("t_global_field_dict")
                .realDb("user_db")
                .realTable("t_global_field_dict");
        return rubberShardingConfig;
    }

}
