package model;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.NejikoOnlineDAO;

public class NejikoLogic {

	NejikoOnlineDAO dao = new NejikoOnlineDAO();

	public String findMileage() throws JsonProcessingException{

		List<NejikoMileage> mileage = dao.findNejikoMileage();

		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(mileage);
	}

	public boolean registMileage(NejikoMileage record){
		return dao.registNejikoMileage(record);
	}

}
