/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: KafkaUtil.java
 * Author:   88395515
 * Date:     2019/12/24  14:05
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.example.kafka.producer.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * 〈〉<br>
 * 〈功能详细描述〉
 *
 * @author 88395515
 * @date: Created in 14:05 2019/12/24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class KafkaUtil {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void send(String topic,String message){
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic,message);
        RecordMetadata recordMetadata = null;
        try {
            recordMetadata = future.get().getRecordMetadata();
        } catch (InterruptedException| ExecutionException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
        System.out.println("发送成功");
        System.out.println("partition:"+recordMetadata.partition());
        System.out.println("offset:"+recordMetadata.offset());
        System.out.println("topic:"+recordMetadata.topic());
    }
}
