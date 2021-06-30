package UASPBO.DataMahasiswa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import UASPBO.DataMahasiswa.entity.Mahasiswa;
import UASPBO.DataMahasiswa.repository.MahasiswaRepository;

@Controller
@RequestMapping("/mahasiswa_/")
public class MahasiswaController {

	@Autowired
	private MahasiswaRepository mahasiswaRepository;	
	
	@GetMapping("showForm")
	public String showMahasiswaForm(Mahasiswa mahasiswa) {
		return "add-mahasiswa";
	}
	
	@GetMapping("list")
	public String mahasiswa_(Model model) {
		model.addAttribute("mahasiswa_", this.mahasiswaRepository.findAll());
		return "index";
	}
	
	@PostMapping("add")
	public String addMahasiswa(@Valid Mahasiswa mahasiswa, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-mahasiswa";
		}
		
		this.mahasiswaRepository.save(mahasiswa);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Mahasiswa mahasiswa = this.mahasiswaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid mahasiswa id : " + id));
		
		model.addAttribute("mahasiswa", mahasiswa);
		return "update-mahasiswa";
	}
	
	@PostMapping("update/{id}")
	public String updateMahasiswa(@PathVariable("id") long id, @Valid Mahasiswa mahasiswa, BindingResult result, Model model) {
		if(result.hasErrors()) {
			mahasiswa.setId(id);
			return "update-mahasiswa";
		}
		
		// update mahasiswa
		mahasiswaRepository.save(mahasiswa);
		
		// get all mahasiswa ( with update)
		model.addAttribute("mahasiswa_", this.mahasiswaRepository.findAll());
		return "index";
	}
	
	@GetMapping("delete/{id}")
	public String deleteMahasiswa(@PathVariable ("id") long id, Model model) {
		
		Mahasiswa mahasiswa = this.mahasiswaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid mahasiswa id : " + id));
		
		this.mahasiswaRepository.delete(mahasiswa);
		model.addAttribute("mahasiswa_", this.mahasiswaRepository.findAll());
		return "index";
		
	}
}
