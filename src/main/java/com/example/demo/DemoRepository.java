package com.example.demo;

import org.springframework.data.repository.CrudRepository;

// 只要继承接口就好用Demo是你定义的VO名称，Long 是你定义要查询的Id的类型
public interface DemoRepository extends CrudRepository<Demo, Long>{

}
