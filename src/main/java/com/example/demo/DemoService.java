package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

	@Resource
	private DemoRepository demoRepository; // hibernate

	@Resource
	private SpringJDBCDao dao; // springjdbc

	@Transactional
	public void save(Demo demo) {
		demoRepository.save(demo);
	}

	@Transactional
	public void deleteById(Long id) {
		demoRepository.deleteById(id);
	}

	@Transactional
	public void update(Demo demo) {
		// 改和查调用同一个方法
		demoRepository.save(demo);

		// 先根据要修改的对象id查询出对应的持久化对象

		// User sessionUser = userRepository.findOne(user.getId());

		// 直接调用持久化对象的set方法修改对象的数据

		// sessionUser.setUserName(user.getUserName());

		// sessionUser.setLoginName(user.getLoginName());
	}

	public Demo findById(Long id) {
		// jdk8新增Optional
		Optional<Demo> o = demoRepository.findById(id);

		// 如果不为空就返回，否则new一个新对象后再返回
		return o.orElse(new Demo());
	}

	public List<Demo> findAll() {
		List<Demo> list = new ArrayList<Demo>();
		Iterable<Demo> it = demoRepository.findAll();
		
		// jdk8新增forEach
		it.forEach(demo -> {
			list.add(demo);
		});
		return list;
	}
	
	// 用springjdbc获取值
	public Demo getByIdSpringJdbc(Long id) {
		return dao.getById(id);
	}

}
