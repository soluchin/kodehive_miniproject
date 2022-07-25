package com.miniproject.linkedin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.linkedin.model.SkripsiModel;
import com.miniproject.linkedin.repository.ISkripsiRepository;
import com.miniproject.linkedin.service.ISkripsiService;

@Service
public class SkripsiService implements ISkripsiService{
	
	@Autowired
	ISkripsiRepository skripsirepository;
	
	@Override
	public int insert(SkripsiModel model) {
		var result= skripsirepository.insert(model);
		return result;
	}

	@Override
	public List<SkripsiModel> readAllData() {
		var result = skripsirepository.readAllData();
		System.out.println("select success");
		return result;
	}

	@Override
	public List<SkripsiModel> readCustom() {
		var result = skripsirepository.readCustom();
		return null;
	}

	@Override
	public List<SkripsiModel> getEqTahun(Integer tahun) {
		var result = skripsirepository.getEqTahun(tahun);
		return result;
	}

	@Override
	public List<SkripsiModel> getGtTahun(Integer tahun) {
		var result = skripsirepository.getGtTahun(tahun);
		return result;
	}

	@Override
	public List<SkripsiModel> getLtTahun(Integer tahun) {
		var result = skripsirepository.getLtTahun(tahun);
		return result;
	}
	
	@Override
	public List<SkripsiModel> getNeTahun(Integer tahun) {
		var result = skripsirepository.getNeTahun(tahun);
		return result;
	}

	@Override
	public List<SkripsiModel> getLikeWord(String word) {
		var result = skripsirepository.getLikeWord(word);
		return result;
	}

	@Override
	public List<SkripsiModel> getByNilaiTahun(int tahun, int nilai) {
		var result = skripsirepository.getByNilaiTahun(tahun, nilai);
		return result;
	}

	@Override
	public List<SkripsiModel> getAscExcptFirst(String key) {
		var result = skripsirepository.getAscExcptFirst(key);
		return result;
	}

	@Override
	public int gantiNilai(Integer id,Integer nilai) {
		return skripsirepository.gantinilai(id,nilai);
	}

	@Override
	public int deleteById(int id) {
		return skripsirepository.deleteById(id);
	}





}
