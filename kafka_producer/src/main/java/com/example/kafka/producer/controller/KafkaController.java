/*
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: KafkaController.java
 * Author:   88395515
 * Date:     2019/12/24  11:29
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.example.kafka.producer.controller;

import com.example.kafka.producer.kafka.KafkaUtil;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * 〈〉<br>
 * 〈功能详细描述〉
 *
 * @author 88395515
 * @date: Created in 11:29 2019/12/24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaUtil kafkaUtil;

    @GetMapping("/message/send")
    public Boolean send(String message){
        kafkaUtil.send("testTopic",message);

        return Boolean.TRUE;
    }


    @GetMapping("/message/group")
    public Boolean group(String message){
        kafkaUtil.send("groupTest",message);

        return Boolean.TRUE;
    }


}
