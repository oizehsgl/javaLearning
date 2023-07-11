package com.example.openapi.controller;

import com.example.openapi.domain.OpenapiDemo;
import com.example.openapi.service.OpenapiDemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oizehsgl
 * @since 7/10/23
 */
@Tag(name = "openapiDemo", description = "openapiDemo controller template")
@RestController
@RequestMapping("/openapi")
public class OpenapiDemoController {

    @Autowired
    OpenapiDemoService openapiDemoService;

    @Operation(summary = "create openapiDemo", tags = {"openapiDemo", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = OpenapiDemo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping
    public ResponseEntity<OpenapiDemo> createOpenapiDemo(@RequestBody OpenapiDemo openapiDemo) {
        // TODO: controller中可以统一处理异常
        try {
            openapiDemo.setKey1("11");
            // TODO: 后期使用mp h2
            return ResponseEntity.ok().body(openapiDemo);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }


    @Operation(summary = "get all openapiDemo", tags = {"openapiDemo", "get", "filter"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = OpenapiDemo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "no openapiDemo", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/listAll")
    public ResponseEntity<List<OpenapiDemo>> getOpenapiDemo(@RequestParam(required = false) String key1) {
        try {
            List<OpenapiDemo> openapiDemoList = new ArrayList<>();
            if (key1 == null) {
                //openapiDemoService.findAll().forEach(openapiDemoList::add);
            } else {
                //OpenapiDemoService.findByTitleContaining(key1).forEach(openapiDemoList::add);
            }
            if (openapiDemoList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok().body(openapiDemoList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @Operation(summary = "get openapiDemo by id", description = "get by id", tags = {"openapiDemo", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = OpenapiDemo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/{id}")
    public ResponseEntity<OpenapiDemo> getOpenapiDemoById(@PathVariable("id") long id) {
        OpenapiDemo openapiDemo = new OpenapiDemo();
        if (openapiDemo != null) {
            return ResponseEntity.ok().body(openapiDemo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
