package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.Util;
import com.example.demo.core.WebUtiles;
import com.example.demo.entity.IrrigationDate;
import com.example.demo.entity.IrrigationTimesOfMonth;
import com.example.demo.entity.LandQuality;
import com.example.demo.entity.LandType;
import com.example.demo.entity.Plot;
import com.example.demo.entity.agriculturalSeason;
import com.example.demo.enums.DashboardErrorCode;
import com.example.demo.repo.PlotsRepo;
import com.example.demo.service.PlotsService;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class PlotsController {

	@Autowired
	private PlotsService plotsService;
	@Autowired
	private PlotsRepo plotsRepo;

	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addPlot")
	public Plot addPlot(@RequestBody Plot plot, Exception ex) throws Exception {

		try {
			log.info("success to save new plot in PlotsController  ");

			return plotsService.addPlot(plot);

		} catch (Exception handlerException) {
			log.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);

		} finally {
			return plotsService.addPlot(plot);
		}
	}

	
	// get all static values with specific key  
	@GetMapping("/getPlotsEnums/{key}")
	public Object getPlotsEnums(@PathVariable String key) throws Exception {
		List<Object> plotsValues = new ArrayList<>();

		try {
			if (key.equals("date")) {
				log.info("success to get IrrigationDate value in PlotsController  ");

				plotsValues.add(IrrigationDate.DAY);
				plotsValues.add(IrrigationDate.NIGHT);

				return plotsValues;
			} else if (key.equals("quility")) {
				log.info("success to get LandQuality value in PlotsController  ");

				plotsValues.add(LandQuality.GOOD);
				plotsValues.add(LandQuality.VERYGOOD);
				plotsValues.add(LandQuality.BAD);
				return plotsValues;

			} else if (key.equals("times")) {
				log.info("success to get IrrigationTimesOfMonth value in PlotsController  ");

				plotsValues.add(IrrigationTimesOfMonth.ONE);
				plotsValues.add(IrrigationTimesOfMonth.TWO);
				plotsValues.add(IrrigationTimesOfMonth.THREE);
				return plotsValues;

			} else if (key.equals("landType")) {
				log.info("success to get LandType value in PlotsController  ");

				plotsValues.add(LandType.SANDY);
				plotsValues.add(LandType.MUDDY);
				plotsValues.add(LandType.ELSE);
				return plotsValues;

			} else if (key.equals("season")) {
				log.info("success to get agriculturalSeason value in PlotsController  ");

				plotsValues.add(agriculturalSeason.SUMMER);
				plotsValues.add(agriculturalSeason.WINTTER);
				return plotsValues;

			}

		} catch (Exception e) {
			log.warn(e.getMessage());
		}

		return plotsValues;
	}

	   @CrossOrigin(origins = "http://localhost:4200")
//	  @PutMapping("/updatePlot/{id}")
		@RequestMapping(method = RequestMethod.PUT, value = "updatePlot/{id}")
	    public ResponseEntity<Plot> updatePlot(@PathVariable("id") long id, @RequestBody Plot plot) {
			log.info("updatePlot get started ");

	        //check if employee exist in database
	        Plot newPlot = getPlotObj(id);
			log.info("success to save new plot in PlotsController  ");

	        if (newPlot != null) {
				log.info(" started to set values newPlot in PlotsController  ");
	        	newPlot.setCropName(plot.getCropName());
				newPlot.setCropName(plot.getCropName());
				newPlot.setAreaInAcres(plot.getAreaInAcres());
				newPlot.setAgriculturalSeason(plot.getAgriculturalSeason());
				newPlot.setIrrigationTimes(plot.getIrrigationTimes());
				newPlot.setLandQuality(plot.getLandQuality());
				newPlot.setPlotOwner(plot.getPlotOwner());
				newPlot.setIrrigationDate(plot.getIrrigationDate());
	            return new ResponseEntity<>(plotsService.save(newPlot), HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

		
	   private Plot getPlotObj(long id) {
	        Optional<Plot> plotObj = plotsService.findById(id);

	        if (plotObj.isPresent()) {
	            return plotObj.get();
	        }
	        return null;
	    }
	   
	   

	   @CrossOrigin(origins = "http://localhost:4200")
	    @DeleteMapping("/deletePlot/{id}")
	    public ResponseEntity<?> deletePlot(@PathVariable("id") long id) {
	        try {
	            //check if employee exist in database
	            Plot plot = getPlotObj(id);

	            if (plot != null) {
	            	plotsService.deleteById(id);
	                return new ResponseEntity<>(HttpStatus.OK);
	            }

	            return WebUtiles.prepareErrorResponse(HttpStatus.BAD_REQUEST, DashboardErrorCode.OBJECT_NOT_FOUND);


	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	  
	    
	// get specific  plot by id   
	   @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/getPlotById/{id}")
	    public ResponseEntity<Plot> getPlotById(@PathVariable("id") long id) {
	        try {
	            //check if employee exist in database
	        	Plot plot = getPlotObj(id);

	            if (plot != null) {
	                return new ResponseEntity<>(plot, HttpStatus.OK);
	            }

	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	    }
	  
	    
	    
	    
	    
	    // get all plots
	   @CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/getAllPlots")
	    public ResponseEntity<List<Plot>> getEmployees() {
	        try {
	            return new ResponseEntity<>(plotsService.findAll(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   
	   
	   
	// get all static values with specific key  
		@GetMapping("/plotStatus/{key}")
		public ResponseEntity<?> plotStatus(@PathVariable String key) throws Exception {
//			List<Object> plotsValues = new ArrayList<>();

			try {
				String newKey = key.toUpperCase();
				if(newKey.equals("ACTIVE")) {
	                return new ResponseEntity<>("Your plot is Irrigation now", HttpStatus.OK);


				}else {
	                return new ResponseEntity<>("Your plot need to Irrigation ASAP !", HttpStatus.OK);

				}
			}catch(Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

			}finally {

			}
		}
}


