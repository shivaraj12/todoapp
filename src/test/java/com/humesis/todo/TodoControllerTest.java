package com.humesis.todo;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.humesis.todo.request.TodoRequest;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
public class TodoControllerTest {

private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	
	@Test
	public void createTodoTest() throws Exception {
		
		TodoRequest todoRequest =  new TodoRequest();
		todoRequest.setTodo("todo 1");
		Gson gson = new Gson();
		String request = gson.toJson(todoRequest);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/todo")
				.content(request)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").exists())
		.andDo(print());
	}
	
	@Test
	public void getTodoByIdTest() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/1")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		.andDo(print());
	}
	
	@Test
	public void getTodoTest() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders.get("/todo")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andDo(print());
	}
	
	/*@Test
	public void updateTodoTest() throws Exception {
		
		TodoRequest todoRequest =  new TodoRequest();
		todoRequest.setTodo("todo 1 edited");
		Gson gson = new Gson();
		String request = gson.toJson(todoRequest);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/todo/1")
				.content(request)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		
		.andDo(print());
	}
	*/
}
