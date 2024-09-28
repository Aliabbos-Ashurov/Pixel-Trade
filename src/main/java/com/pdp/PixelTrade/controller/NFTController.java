package com.pdp.PixelTrade.controller;

import com.pdp.PixelTrade.entity.NFT;
import com.pdp.PixelTrade.exception.ResourceNotFoundException;
import com.pdp.PixelTrade.repository.NFTRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get-all")
    public ResponseEntity<List<NFT>> getNFTs() {
        List<NFT> nfts = nftRepository.findAll();
        if (nfts.isEmpty()) throw new ResourceNotFoundException("The request was successful, but NFTs not found");
        return ResponseEntity.ok(nfts);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NFT> getNFTById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(nftRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The request was successful, but NFT not found")
        ));
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<List<NFT>> getNFTByName(@PathVariable("name") String name) {
        List<NFT> nfts = nftRepository.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(nfts);
    }
}
