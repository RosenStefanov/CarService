package com.project.CarService.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.CarService.data.entity.Brand;
import com.project.CarService.dto.carservice.CreateCarServiceDTO;
import com.project.CarService.services.implementations.CarServiceServiceImpl;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarServiceApiController.class)
public class CarServiceApiController {


    @MockBean
    private CarServiceServiceImpl carServiceService;

    @SpyBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @WithMockUser(username = "admin", authorities = {"MECHANIC", "ADMIN"})
    void createCarServiceTest() throws Exception {
        CreateCarServiceDTO carServiceDTO = new CreateCarServiceDTO();
        carServiceDTO.setName("Pri Gosho");
        carServiceDTO.setBrand(Brand.VW);
        carServiceDTO.setWorksWithAllBrands(false);

        given(carServiceService.create(any(CreateCarServiceDTO.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/carservice")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carServiceDTO)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(carServiceDTO.getName())))
                .andExpect(jsonPath("$.brand", is(carServiceDTO.getBrand().toString())));


    }

}
