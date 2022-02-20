package com.ab180.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ab180.demo.domain.LncsMng;

@Repository
@Mapper
public interface MvcMapper {
	public List<LncsMng> getList();
}
