package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.entity.NFT;
import com.pdp.PixelTrade.exception.ResourceNotFoundException;
import com.pdp.PixelTrade.repository.NFTRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:20
 **/
@RestController
@RequestMapping("/api/v1/nft")
@AllArgsConstructor
public class NFTController {

    private final NFTRepository nftRepository;

    @Operation(
            summary = "GET all NFTs",
            description = "Retrieves a list of all NFTs from the database. If no NFTs are found, a ResourceNotFoundException is thrown.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful retrieval of NFTs",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = NFT.class))),
                    @ApiResponse(responseCode = "404", description = "if NFTs are not available",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @GetMapping("/get-all")
    public ResponseEntity<List<NFT>> getNFTs() {
        List<NFT> nfts = nftRepository.findAll();
        if (nfts.isEmpty()) throw new ResourceNotFoundException("The request was successful, but NFTs not found");
        return ResponseEntity.ok(nfts);
    }

    @Operation(
            summary = "Get NFT by ID",
            description = "Retrieves a specific NFT by its ID. Throws an exception if the NFT is not found."
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<NFT> getNFTById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(nftRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The request was successful, but NFT not found")
        ));
    }

    @Operation(
            summary = "Get NFTs by name",
            description = "Retrieves a specific NFTs by their name. Throws an exception if no NFT is found with the provided name."
    )
    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<List<NFT>> getNFTByName(@PathVariable("name") String name) {
        List<NFT> nfts = nftRepository.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(nfts);
    }
}
