package com.pdp.PixelTrade.repository;

import com.pdp.PixelTrade.enums.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  13:58
 **/
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByUserId(Long userId);

    List<Card> findByCardType(CardType cardType);
}
