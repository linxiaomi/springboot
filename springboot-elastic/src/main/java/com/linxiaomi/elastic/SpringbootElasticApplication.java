package com.linxiaomi.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术来和ES交互
 * 1、Jest(默认不生效)
 *    需要导入jest的工具包(io.searchbox.client.JestClient)
 * 2、SpringData ElasticSearch(ES版本有可能不合适 看spring-data官网(https://github.com/spring-projects/spring-data-elasticsearch))
 *    3.1.4
 *    如果版本不适配 6.4.3
 *       1、升级springboot版本
 *       2、安装对应版本的es
 *    spring data elasticsearch	elasticsearch
                3.2.x	            6.5.0
                3.1.x	            6.2.2
                3.0.x	            5.5.0
                2.1.x	            2.4.0
                2.0.x	            2.2.0
                1.3.x	            1.5.2
 *    1、Client节点信息clusterNodes、clusterName
 *    2、ElasticsearchTemplate操作es
 *    3、编写一个ElasticsearchRepository的子接口来操作es
 *  两种用法:https://github.com/spring-projects/spring-data-elasticsearch
 *  1、编写一个ElasticSearchRepository
 */
@SpringBootApplication
public class SpringbootElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootElasticApplication.class, args);
	}

}

