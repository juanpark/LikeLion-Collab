package com.todo.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.todo.app.entity.Todo;

@Mapper
public interface TodoMapper {
	public List<Todo> selectAll();
	public void add(Todo todo);
	public void update(Todo todo);
	public List<Todo> selectIncomplete();
	public List<Todo> selectComplete();
	public void delete(Todo todo);
}
