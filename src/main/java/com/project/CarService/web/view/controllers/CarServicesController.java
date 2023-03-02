package com.project.CarService.web.view.controllers;

import com.project.CarService.data.entity.Brand;
import com.project.CarService.dto.carservice.CarServiceDTO;
import com.project.CarService.dto.carservice.CreateCarServiceDTO;
import com.project.CarService.services.CarServiceService;
import com.project.CarService.web.view.model.CarServiceViewModel;
import com.project.CarService.web.view.model.CreateCarServiceViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/carservices")

public class CarServicesController {

        private final CarServiceService carServiceService;
        private final ModelMapper modelMapper;

        @GetMapping
        public String getCarServices(Model model) {
            final List<CarServiceViewModel> carServices = carServiceService.getCarServices()
                    .stream()
                    .map(this::convertToCarServiceViewModel)
                    .collect(Collectors.toList());
            model.addAttribute("carservices", carServices);
            return "/carservice/carservices";
        }

    @GetMapping("/create-carservice")
    public String showCreateCarServiceForm(Model model) {
        model.addAttribute("brands", Brand.values());
        model.addAttribute("carservice", new CreateCarServiceViewModel());
        return "/carservice/create-carservice";
    }
    @PostMapping("/create")
    public String createCarService(@Valid @ModelAttribute("carservice") CreateCarServiceViewModel carService,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/carservice/create-carservice";
        }
        carServiceService.create(modelMapper.map(carService, CreateCarServiceDTO.class));
        return "redirect:/carservices";
    }

        private CarServiceViewModel convertToCarServiceViewModel(CarServiceDTO carServiceDTO) {
            return modelMapper.map(carServiceDTO, CarServiceViewModel.class);
        }

    @GetMapping("/search-carservices")
    public String processSearchCarServiceForm() {
        return "/carservice/search-carservices";
    }


    @GetMapping("/names-workswithall")
    public String getCarServiceByNameAndWorksWithAll(Model model, @RequestParam String name, @RequestParam(defaultValue = "false") boolean worksWithAllBrands) {
        List<CarServiceViewModel> carServiceViewModels = carServiceService
                .getCarServicesByNameAndWorksWithAllBrands(name, worksWithAllBrands)
                .stream()
                .map(this::convertToCarServiceViewModel)
                .collect(Collectors.toList());

        model.addAttribute("carservices", carServiceViewModels);
        return "/carservice/carservices";
    }



    }

