package com.example.demo.service;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Optional;

import org.hibernate.jdbc.Expectations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Plot;
import com.example.demo.repo.PlotsRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PlotsService {

	@Autowired
	private PlotsRepo plotsRepo;

	public Plot addPlot(Plot plot) throws Exception {

		try {
			log.info("success to save new plot in PlotsService  ");
			return plotsRepo.save(plot);
		} catch (Exception handlerException) {
			log.warn("an error acured when save new plot in PlotsService  ", handlerException);

		} finally {
			return plotsRepo.save(plot);

		}

	}

	public Plot updatePlot(Plot plot) {
		// TODO Auto-generated method stub
		try {
			log.info("success to save new plot in PlotsService  ");
			return plotsRepo.save(plot);
		} catch (Exception handlerException) {
			log.warn("an error acured when save new plot in PlotsService  ", handlerException);

		} finally {
			return plotsRepo.save(plot);

		}
	}





	public Optional<Plot> findById(long id) {
		// TODO Auto-generated method stub
		return plotsRepo.findById(id);
	}

	public Plot save(Plot newPlot) {
		// TODO Auto-generated method stub
		return plotsRepo.save(newPlot);
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		plotsRepo.deleteById(id);
	}

	public List<Plot> findAll() {
		// TODO Auto-generated method stub
		return plotsRepo.findAll();
	}

	public void deletePlotById(long id) {
		// TODO Auto-generated method stub
//		plotsRepo.deletePlotById(id);
	}



}
