package com.sec01;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travels")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService travelService;

    // [1] 전체 여행지 목록 조회
    @GetMapping
    public List<Travel> getAll() {
        return travelService.getAll();
    }

    // [2] 여행지 추가
    @PostMapping
    public Travel save(@RequestBody Travel travel) {
        return travelService.save(travel);
    }

    // [3] 여행지 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        travelService.delete(id);
    }
}