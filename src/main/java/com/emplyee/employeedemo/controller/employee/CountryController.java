package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.dto.request.post.CountryCreateDTO;
import com.emplyee.employeedemo.dto.request.put.CountryUpdateDTO;
import com.emplyee.employeedemo.dto.resposce.CountryListDTO;
import com.emplyee.employeedemo.dto.resposce.CountryResponseDTO;
import com.emplyee.employeedemo.model.employee.Countries;
import com.emplyee.employeedemo.service.employee.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@Tag(name = "Country API", description = "Operations related to countries")
public class CountryController {

  @Autowired
  private CountryService countryService;

  @GetMapping
  @Operation(summary = "Get all countries")
  @ApiResponse(responseCode = "200", description = "List of countries",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = Countries.class)))
  public ResponseEntity<List<CountryListDTO>> getAllCountries() {
    List<CountryListDTO> countries = countryService.getAllCountries().stream()
        .map(CountryListDTO::new)
        .toList();
    return ResponseEntity.ok(countries);

  }

  @GetMapping("/{id}")
  @Operation(summary = "Get country by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Country found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Countries.class))),
      @ApiResponse(responseCode = "404", description = "Country not found")
  })
  public ResponseEntity<CountryResponseDTO> getCountry(@PathVariable int id) {
    Countries country = countryService.getCountryById(id);
    if (country != null) {
      return ResponseEntity.ok(new CountryResponseDTO(country));
    }
    return ResponseEntity.notFound().build();

  }

  @PostMapping
  @Operation(summary = "Create a new country")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Country created",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Countries.class))),
      @ApiResponse(responseCode = "400", description = "Invalid input")
  })
  public ResponseEntity<CountryResponseDTO> createCountry(@RequestBody @Valid CountryCreateDTO dto) {
    Countries createCountry = countryService.createCountry(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(new CountryResponseDTO(createCountry));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update country by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Country updated",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Countries.class))),
      @ApiResponse(responseCode = "404", description = "Country not found")
  })
  public ResponseEntity<CountryResponseDTO> updateCountry(@PathVariable int id, @RequestBody @Valid CountryUpdateDTO dto) {
    Countries updateCountry = countryService.updateCountry(id, dto);

    if (updateCountry != null) {
      return ResponseEntity.ok(new CountryResponseDTO(updateCountry));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete country by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Country deleted"),
      @ApiResponse(responseCode = "404", description = "Country not found")
  })
  public ResponseEntity<Void> deleteCountry(@PathVariable("id") int id) {
    if (countryService.deleteCountry(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
