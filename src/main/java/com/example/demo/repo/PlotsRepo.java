package com.example.demo.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Plot;

@Repository
public interface PlotsRepo extends JpaRepository<Plot, Long>{

	
//	@Autowired
//	void deletePlotById(long id);

//	Plot findBy(long plotId);

//	Plot updatePlot(long plotId);

//	Plot updatePlotById(String id);

//	Object save(Optional<Plot> newPlot);
//	public Plot findOne(long plotId);
}
