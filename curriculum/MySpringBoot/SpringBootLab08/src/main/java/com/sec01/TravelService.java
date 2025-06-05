package com.sec01;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;

    // [1] 전체 목록 조회
    public List<Travel> getAll() {
        return travelRepository.findAll();
    }

    // [2] 저장
    public Travel save(Travel travel) {
        return travelRepository.save(travel);
    }


    // [5] 여행지 삭제
    public void delete(Integer id) {
        travelRepository.deleteById(id);
    }
}