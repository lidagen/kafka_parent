/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: ConsumerListener.java
 * Author:   88395515
 * Date:     2019/12/24  11:33
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.example.kafka.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 〈〉<br>
 * 〈功能详细描述〉
 *
 * @author 88395515
 * @date: Created in 11:33 2019/12/24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = {"testTopic"})
    public void onMessage(String message){
        System.out.println(message);
    }

}
