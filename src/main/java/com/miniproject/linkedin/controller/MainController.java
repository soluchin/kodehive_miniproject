package com.miniproject.linkedin.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.linkedin.model.SkripsiModel;
import com.miniproject.linkedin.service.ISkripsiService;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	ISkripsiService skripsiservice;
	
	@PostMapping("/insert")
	public String beranda(@RequestBody SkripsiModel model) {
		skripsiservice.insert(model);
		return "success";
	}
	
	@GetMapping("/readall")
	public List<SkripsiModel> getAllData(){
		return skripsiservice.readAllData();
	}
	
	@GetMapping("geteqtahun")
	public List<SkripsiModel> getEqTahun(@RequestParam Integer tahun){
		return skripsiservice.getEqTahun(tahun);
	}
	
	@GetMapping("getgttahun")
	public List<SkripsiModel> getGTTahun(@RequestParam Integer tahun){
		return skripsiservice.getGtTahun(tahun);
	}
	
	@GetMapping("getlttahun")
	public List<SkripsiModel> getLTTahun(@RequestParam Integer tahun){
		return skripsiservice.getLtTahun(tahun);
	}
	
	@GetMapping("getlikeword")
	public List<SkripsiModel> getLikeWord(@RequestParam String word){
		return skripsiservice.getLikeWord(word);
	}
	
	@GetMapping("getbytahunnilai")
	public List<SkripsiModel> getByNilaiTahun(@RequestParam int tahun, int nilai){
		return skripsiservice.getByNilaiTahun(tahun, nilai);
	}
	
	@GetMapping("getnetahun")
	public List<SkripsiModel> getNeTahun(@RequestParam Integer tahun){
		return skripsiservice.getNeTahun(tahun);
	}
	
	@GetMapping("getascexcptfirst/{key}")
	public List<SkripsiModel> getAscExcptFirst(@PathVariable String key){
		return skripsiservice.getAscExcptFirst(key);
	}
	
	@GetMapping("deletebyid")
	public String deleteById(@RequestParam int id) {
		return "update success "+ skripsiservice.deleteById(id);
	}
	
	@PutMapping("gantinilai")
	public String putNilai(@RequestParam int id, int nilai) {
		return "update success "+ skripsiservice.gantiNilai(id, nilai);
	}
}
