package com.lushangyan.shardingsphere;

import groovy.util.logging.Slf4j;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;

@Slf4j
public class MyDatasourceRoutingAlgorithm implements HintShardingAlgorithm<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyDatasourceRoutingAlgorithm.class);


    /**
     * 订单数据源
     */
    private static final String DS_ORDER = "db0";

    /**
     * 店铺数据源
     */
    private static final String DS_SHOP = "db1";


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        Collection<String> result = new HashSet<>();
        for (String value : shardingValue.getValues()) {
            if (DatasourceType.DATASOURCE_ORDER.toString().equals(value)) {
                if (availableTargetNames.contains(DS_ORDER)) {
                    result.add(DS_ORDER);
                }
            } else {
                if (availableTargetNames.contains(DS_SHOP)) {
                    result.add(DS_SHOP);
                }
            }
        }
        LOGGER.info("availableTargetNames:{},shardingValue:{},返回的数据源:{}", new Object[]{availableTargetNames, shardingValue, result});
        return result;
    }


}
