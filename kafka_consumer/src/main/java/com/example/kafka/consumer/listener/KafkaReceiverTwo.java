/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: KafkaReceiverTwo.java
 * Author:   88395515
 * Date:     2019/12/24  15:08
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.example.kafka.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 〈〉<br>
 * 〈功能详细描述〉
 *
 * @author 88395515
 * @date: Created in 15:08 2019/12/24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class KafkaReceiverTwo {

    @KafkaListener(id = "2",topics = {"groupTest"}, containerFactory="kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("Two:"+message.toString());
        }
    }
}
